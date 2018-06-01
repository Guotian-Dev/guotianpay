package com.guotianpay.guotianchain.httpclient;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQyNDI4ODMsInVzZXJuYW1lIjoiSmltIiwib3JnTmFtZSI6Ik9yZzEiLCJpYXQiOjE1MjQyMDY4ODN9.4F6AapAKlPLzQCAfFYh3ICUKn5UZPDMLFkwVAsdRgko");
        headerMap.put("content-type", "application/json");

        String result = HttpClientUtil.doGet("http://localhost:4000/channels/mychannel/chaincodes/mycc?peer=peer0.org1.guotianchain.com&fcn=query&args=%5b%22u_qiulongxing%22%5d", "UTF-8", headerMap);

        System.out.println( "result="+result );
    }
}
