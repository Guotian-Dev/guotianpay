package com.guotianpay.guotianchain.httpclient;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 网络访问工具类
 *
 * @author  sunshine
 * @since 2017年06月10日16:07:05
 */
public class HttpClientUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    //默认编码UTF8
    private static String CHARSET = "UTF-8";

    // 连接上一个url，获取response的返回等待时间
    public static final int SOCKET_TIMEOUT = 20 * 1000;

    // 连接一个url的连接等待时间
    public static final int CONNECT_TIMEOUT = 10 * 1000;


    /**
     * post请求，并使用body传输数据
     *
     * @see org.apache.http.entity.ContentType
     */
    public static String doPost(String url, String body) {
        return doPost(url, null, body, CHARSET, null);
    }

    /**
     * post请求，并使用body传输数据
     *
     * @see org.apache.http.entity.ContentType
     */
    public static String doPost(String url, String mimeType, String body) {
        return doPost(url, mimeType, body, CHARSET, null);
    }

    /**
     * post请求，并使用body传输数据
     *
     * @see org.apache.http.entity.ContentType
     */
    public static String doPost(String url, String mimeType, String body, String charset, SSLContext sslcontext) {
        String logId = "";
        FileInputStream instream = null;
        CloseableHttpClient httpClient = null;
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            //SSL 证书
            if (sslcontext != null) {
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
                builder.setSSLSocketFactory(sslsf);
            }
            httpClient = builder.build();

            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).build();
            httpPost.setConfig(requestConfig);

            ContentType contentType = ContentType.create(mimeType, charset);
            StringEntity entity = new StringEntity(body, contentType);
            entity.setContentType(mimeType);
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                //网络异常处理
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() != 200) {
                    LOGGER.error(logId, "请求异常，POST >>>> url:{}", url);
                    LOGGER.error(logId, "请求异常，POST <<<< [{}],[{}]", statusLine.getStatusCode(), statusLine.getReasonPhrase());
                    return null;
                }
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    return EntityUtils.toString(resEntity, charset);
                }
            }
            return null;
        } catch (IOException | RuntimeException e) {
            LOGGER.error(logId, "网络请求异常,url:{},charset:{},message:{}", url, charset, e.getMessage(), e);
            return null;
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException | RuntimeException e) {
                LOGGER.error(logId, "关闭失败", e);
            }
        }
    }

    /**
     * post请求
     *
     * @return String
     *
     * @since 1.0.0
     */
    public static String doPost(String url, Map<String, String> map, Map<String, String> headerMap, String charset) {
        String logId = "";
        CloseableHttpClient httpClient = null;
        String result = null;
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            httpClient = builder.build();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).build();
            httpPost.setConfig(requestConfig);

            //设置请求头部
            Iterator<Entry<String, String>> iteratorH = headerMap.entrySet().iterator();
            while (iteratorH.hasNext()) {
                Entry<String, String> elem = iteratorH.next();
                httpPost.setHeader(elem.getKey(), elem.getValue());
            }

            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (IOException | RuntimeException e) {
            LOGGER.error(logId, "网络请求异常,url:{},charset:{},message:{}", url, charset, e.getMessage(), e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException | RuntimeException e) {
                LOGGER.error(logId, "关闭失败", e);
            }
        }
        return result;
    }

    /**
     * UTF8编码
     *
     * @return String
     *
     * @since 1.0.0
     */
    public static String doPost(String url, Map<String, String> map, String charset) {
        Map<String, String> headerMap = new HashMap<String, String>();
        return doPost(url, map, headerMap, CHARSET);
    }

    /**
     * UTF8编码
     *
     * @return String
     *
     * @since 1.0.0
     */
    public static String doPost(String url, Map<String, String> map) {
        return doPost(url, map, CHARSET);
    }

    public static String doGet(String url, String charset) {
        Map<String, String> headerMap = new HashMap<String, String>();
        return doGet(url, CHARSET, headerMap);
    }

    /**
     * Get请求
     *
     * @return String
     *
     * @since 1.0.0
     */
    public static String doGet(String url, String charset, Map<String, String> headerMap) {
        String logId = "";
        CloseableHttpClient httpClient = null;
        String result = null;
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            httpClient = builder.build();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    // 连接上一个url，获取response的返回等待时间
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    // 连接一个url的连接等待时间
                    .setConnectTimeout(CONNECT_TIMEOUT).build();
            httpGet.setConfig(requestConfig);

            //设置请求头部
            System.out.println("get header=====");
            Iterator<Entry<String, String>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = iterator.next();
                //list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
                System.out.println("header=====KEY="+elem.getKey()+" Value="+elem.getValue());
                httpGet.setHeader(elem.getKey(), elem.getValue());
            }

            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (IOException | RuntimeException e) {
            LOGGER.error(logId, "网络请求异常,url:{},charset:{},message:{}", url, charset, e.getMessage(), e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException | RuntimeException e) {
                LOGGER.error(logId, "关闭失败", e);
            }
        }
        return result;
    }

    public static String doGet(String url) {
        return doGet(url, CHARSET);
    }

    public static String doPostJson(String url, Map<String, String> headerMap, String json) {
        CloseableHttpClient httpClient = null;
        String result = null;
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            httpClient = builder.build();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).build();
            httpPost.setConfig(requestConfig);

            //设置请求头部
            Iterator<Entry<String, String>> iteratorH = headerMap.entrySet().iterator();
            while (iteratorH.hasNext()) {
                Entry<String, String> elem = iteratorH.next();
                httpPost.setHeader(elem.getKey(), elem.getValue());
            }

            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json, "UTF-8");
            //stringEntity.setContentEncoding("UTF-8");

            httpPost.setEntity(stringEntity);

            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "UTF-8");
                }
            }
        } catch (IOException | RuntimeException e) {
            //LOGGER.error(logId, "网络请求异常,url:{},charset:{},message:{}", url, charset, e.getMessage(), e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException | RuntimeException e) {
                //LOGGER.error(logId, "关闭失败", e);
            }
        }
        return result;
    }



    public static SSLContext getPkcs12SSLContext(String certPath, char[] password) {
        String logId = "SSLContext";
        FileInputStream instream = null;
        try {
            //读取证书
            LOGGER.info(logId, "读取SSL证书:{}", certPath);
            instream = new FileInputStream(new File(certPath));
            //加载证书
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(instream, password);
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password).build();
            return sslcontext;
        } catch (KeyStoreException | IOException | KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | CertificateException e) {
            LOGGER.error(logId, "SSL证书加载失败,message:{}", e.getMessage(), e);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                LOGGER.error(logId, "流关闭失败");
            }
        }
        return null;
    }

    // 构建唯一会话Id
    public static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }
}
