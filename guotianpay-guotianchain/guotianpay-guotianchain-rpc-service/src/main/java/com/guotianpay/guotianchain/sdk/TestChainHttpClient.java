package com.guotianpay.guotianchain.sdk;

import com.guotianpay.guotianchain.httpclient.HttpClientUtil;

public class TestChainHttpClient {
    public static void main( String[] args )
    {
        // 获取UUID
        String sessionId = HttpClientUtil.getSessionId();
        System.out.println("sessionId="+sessionId);

        //获取Token
        String token_json = ChainHttpClient.getEnrollToken();
        System.out.println("token_json="+token_json);

        // 查询数字黄金信息
        String goldtoken_json = ChainHttpClient.queryGoldToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQ0NjA4ODIsInVzZXJuYW1lIjoiQmFycnkiLCJvcmdOYW1lIjoiT3JnMiIsImlhdCI6MTUyNDQyNDg4Mn0._ihZFA82IOKlBZ5InVSkMU8LfES0fsdkO0dgoQ6j1UI");
        System.out.println("goldtoken_json="+goldtoken_json);



        // 创建会员
        //String u_json = ChainHttpClient.createUser("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQ0NjA4ODIsInVzZXJuYW1lIjoiQmFycnkiLCJvcmdOYW1lIjoiT3JnMiIsImlhdCI6MTUyNDQyNDg4Mn0._ihZFA82IOKlBZ5InVSkMU8LfES0fsdkO0dgoQ6j1UI", "u_a01", "a01", "123456");
        //System.out.println("u_json="+u_json);

        // 查询会员信息
        //String json = ChainHttpClient.queryUserByAddress("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQ0NjA4ODIsInVzZXJuYW1lIjoiQmFycnkiLCJvcmdOYW1lIjoiT3JnMiIsImlhdCI6MTUyNDQyNDg4Mn0._ihZFA82IOKlBZ5InVSkMU8LfES0fsdkO0dgoQ6j1UI","u_a01");
        //System.out.println("json="+json);


    }
}
