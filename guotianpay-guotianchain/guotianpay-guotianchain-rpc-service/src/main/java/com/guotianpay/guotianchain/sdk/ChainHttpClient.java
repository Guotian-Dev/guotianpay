package com.guotianpay.guotianchain.sdk;

import com.guotianpay.guotianchain.httpclient.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 区块链API HttpClient接口
 */
public class ChainHttpClient {

    public static String GOLDTOKEN_ADDRESS = "0x9FE166aa9cF5BbFDBAf31e429E9923D994dB5199";

    public static String API_HOST = "http://localhost:4000";

    public static String userName = "Jim";
    public static String orgName = "Org1";


    /**
     * 获取背书token
     *
     * @return token
     */
    public static String getEnrollToken(){

        Map<String, String> map = new HashMap<String, String>();
        //map.put("username","Jim");
        //map.put("orgName", "Org1");
        map.put("username", userName);
        map.put("orgName", orgName);

        return HttpClientUtil.doPost("http://localhost:4000/users", map, "UTF-8");
    }

    /**
     * 查询数据 BY 地址
     *
     * @param token 背书的TOKEN
     * @param address 地址
     * @return
     */
    public static String queryByAddress(String token, String address){
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        return  HttpClientUtil.doGet(API_HOST+"/channels/mychannel/chaincodes/mycc?peer=peer0.org1.guotianchain.com&fcn=query&args=%5b%22"+address+"%22%5d", "UTF-8", headerMap);
    }

    /**
     * 查询数字黄金信息
     * @param token
     * @return
     */
    public static String queryGoldToken(String token){
        String address = GOLDTOKEN_ADDRESS;
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        return HttpClientUtil.doGet(API_HOST+"/channels/mychannel/chaincodes/mycc?peer=peer0.org1.guotianchain.com&fcn=query&args=%5b%22"+address+"%22%5d", "UTF-8", headerMap);
    }

    /**
     * 新增TOKEN数量
     *
     * @param token
     * @param address 交易地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String issueGoldToken(String token, String address, String orderNo, String amount, String remarke){

        //String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"IssueCoin\",\"args\":[\""+address+"\",\""+orderNo+"\", \""+amount+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * 销毁TOKEN数量
     *
     * @param token
     * @param address 交易地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String destroyGoldToken(String token, String address, String orderNo, String amount, String remarke){

        //String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"DestroyCoin\",\"args\":[\""+address+"\",\""+orderNo+"\", \""+amount+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * 查询用户信息 BY 会员地址
     *
     * @param token 背书的TOKEN
     * @param address 会员地址
     * @return
     */
    public static String queryUserByAddress(String token, String address){
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String result = HttpClientUtil.doGet(API_HOST+"/channels/mychannel/chaincodes/mycc?peer=peer0.org1.guotianchain.com&fcn=query&args=%5b%22"+address+"%22%5d", "UTF-8", headerMap);
        return  result;
    }


    /**
     * 创建会员
     *
     * @return token
     */
    public static String createUser(String token, String address, String name, String mobile){

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        Map<String, String> map = new HashMap<String, String>();
        //map.put("username","Jim");
        //map.put("orgName", "Org1");
        map.put("peers", "['peer0.org1.guotianchain.com','peer1.org1.guotianchain.com']");
        map.put("fcn", "createUser");
        map.put("fcn", "['u_qiulongxing2','wx_cyhades2', '15207555425', '2018-04-20 10:10:10']");

        //return HttpClientUtil.doPost("http://localhost:4000/channels/mychannel/chaincodes/mycc", map, headerMap,"UTF-8");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"createUser\",\"args\":[\""+address+"\",\""+name+"\", \""+mobile+"\", \"2018-04-19 10:10:10\"]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * 用户身份证认证
     *
     * @return token
     */
    public static String oauthUserCard(String token, String address, String cardName, String cardNo){

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"oauthUserCard\",\"args\":[\""+address+"\",\""+cardName+"\", \""+cardNo+"\"]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }


    //----------------------------华丽的分割线---------------------------//

    /**
     * 创建企业账号
     * @param token
     * @param address 地址
     * @param id ID
     * @param nameCn 企业名称（中文）
     * @return
     */
    public static String createCompany(String token, String address, String id, String nameCn){

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"CreateCompany\",\"args\":[\""+address+"\",\""+id+"\", \""+nameCn+"\", \"2018-04-19 10:10:10\"]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * 创建银行账号
     * @param token
     * @param address 地址
     * @param id ID 银行ID
     * @param nameCn 银行名称（中文）
     * @return
     */
    public static String createBank(String token, String address, String id, String nameCn){

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"CreateBank\",\"args\":[\""+address+"\",\""+id+"\", \""+nameCn+"\", \"2018-04-19 10:10:10\"]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    //-------------------------------------华丽的分割线----------------------------------//

    /**
     * Token转账
     *
     * 过程: [中央银行] --> [商业银行]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址
     * @param toAddress 接收方地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferCb2Bank(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransCb2Bank\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [中央银行]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址
     * @param toAddress 接收方地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferBank2Cb(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransBank2Cb\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [商业银行]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址
     * @param toAddress 接收方地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferBank2Bank(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransBank2Bank\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [企业商家]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[商业银行]
     * @param toAddress 接收方地址[企业商家]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferBank2Cp(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransBank2Cp\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [企业商家]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[企业商家]
     * @param toAddress 接收方地址[商业银行]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferCp2Bank(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransCp2Bank\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }


    /**
     * Token转账
     *
     * 过程: [商业银行] --> [普通用户]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[商业银行]
     * @param toAddress 接收方地址[普通用户]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferBank2User(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransBank2User\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }


    /**
     * Token转账
     *
     * 过程: [普通用户] --> [商业银行]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[普通用户]
     * @param toAddress 接收方地址[商业银行]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferUser2Bank(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransUser2Bank\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }


    /**
     * Token转账
     *
     * 过程: [企业商家] --> [普通用户]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[企业商家]
     * @param toAddress 接收方地址[普通用户]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferCp2User(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransCp2User\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * Token转账
     *
     * 过程: [普通用户] --> [企业商家]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址[普通用户]
     * @param toAddress 接收方地址[企业商家]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transferUser2Cp(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"TransUser2Cp\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+time+"\",\""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }


    /**
     * Token转账
     *
     * 过程: [账户] --> [账户]
     *
     * @param token
     * @param address 交易地址
     * @param orderNo 订单编号
     * @param fromAddress 交易主体地址
     * @param toAddress 交易对手地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static String transfer(String token, String address, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String time = TimeUtil.getCurrentTime();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"Transaction\",\"args\":[\""+address+"\", \""+orderNo+"\", \""+fromAddress+"\", \""+toAddress+"\", \""+amount+"\", \""+remarke+"\" ]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }

    /**
     * 创建会员
     *
     * @return token
     */
    public static String createAccount(String token, String address, String userNo, String userName, String roleCode){

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer "+token);
        headerMap.put("content-type", "application/json");

        String url = "http://localhost:4000/channels/mychannel/chaincodes/mycc";
        String json = "{\"peers\": [\"peer0.org1.guotianchain.com\",\"peer1.org1.guotianchain.com\"],\"fcn\":\"CreateAccount\",\"args\":[\""+address+"\",\""+userNo+"\", \""+userName+"\", \""+roleCode+"\"]}";

        return  HttpClientUtil.doPostJson(url,headerMap, json);
    }
}
