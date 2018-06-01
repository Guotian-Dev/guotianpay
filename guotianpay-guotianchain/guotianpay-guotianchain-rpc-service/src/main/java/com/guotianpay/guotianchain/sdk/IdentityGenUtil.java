package com.guotianpay.guotianchain.sdk;

import java.util.UUID;

/**
 * ID生成器
 */
public class IdentityGenUtil {
    // 构建唯一会话Id
    public static String genAddress(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        //System.out.println("uuid="+uuid);
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }
}
