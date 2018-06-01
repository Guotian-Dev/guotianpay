package com.guotianpay.guotianchain.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.guotianpay.guotianchain.rpc.service.ChainRespon;
import com.guotianpay.guotianchain.sdk.entity.*;

/**
 *
 */
public class ChainClient {

    private static String CENTER_BANK_ADDRESS = "48d877acf2a04e63b5c2cdaffda97427";

    public static String getToken(){
        //获取Token
        String token_json = ChainHttpClient.getEnrollToken();
        System.out.println("token_json="+token_json);

        //JSONObject json = JSONObject.fromObject(jsonString);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(token_json);  //创建jsonObject对象

        boolean code = json.get("success").getAsBoolean();
        if(code){
            String token = json.get("token").getAsString();
            return token;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public static GoldToken getGoldTokenInfo(String token){

        // 查询数字黄金信息
        String jsonStr = ChainHttpClient.queryGoldToken(token);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),GoldToken.class);
        }

        return null;
    }





    /**
     * 查询TOKEN新增和销毁交易
     *
     * @param token
     * @param address 交易地址
     * @return
     */
    public static TokenIssueTran getTokenIssueTran(String token, String address){

        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),TokenIssueTran.class);
        }

        return null;
    }


    /**
     *
     * @return
     */
    public static User getUserInfo(String token, String address){

        // 查询数字黄金信息
        String jsonStr = ChainHttpClient.queryUserByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),User.class);
        }

        return null;
    }

    /**
     * 注册会员
     * @param token
     * @param name
     * @param mobile
     * @return
     */
    public static User regUser(String token, String name, String mobile){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.createUser(token, address, name, mobile);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),User.class);

        }

        return null;
    }

    /**
     * 会员身份证认证
     *
     * @param token
     * @param address
     * @param cardName
     * @param cardNo
     * @return
     */
    public static User oauthUserCard(String token, String address, String cardName, String cardNo){

        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.oauthUserCard(token, address, cardName, cardNo);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),User.class);

        }

        return null;
    }

    //--------------华丽的分割线--------------//

    /**
     *
     * 查询中央银行的信息
     * @return
     */
    public static CenterBank getCenterBankInfo(String token){

        String address = CENTER_BANK_ADDRESS; //央行地址
        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),CenterBank.class);
        }

        return null;
    }

    //---------------------------------华丽的分割线-----------------------------------//

    /**
     * 注册企业
     * @param token
     * @param name
     * @param id
     * @return
     */
    public static Company regCompany(String token, String id, String name){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.createCompany(token, address, id, name);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Company.class);

        }

        return null;
    }

    /**
     * 查询企业账号信息
     *
     * @param token
     * @param address
     * @return
     */
    public static Company getCompanyInfo(String token, String address){

        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),Company.class);
        }

        return null;
    }


    //---------------------------------华丽的分割线-----------------------------------//

    /**
     * 注册银行账号
     * @param token
     * @param name
     * @param id
     * @return
     */
    public static Bank regBank(String token, String id, String name){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.createBank(token, address, id, name);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Bank.class);

        }

        return null;
    }

    /**
     * 查询银行账号信息
     *
     * @param token
     * @param address
     * @return
     */
    public static Bank getBankInfo(String token, String address){

        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),Bank.class);
        }

        return null;
    }

    //---------------------------------华丽的分割线-----------------------------------//

    /**
     * Token转账
     *
     * 过程: [中央银行] --> [商业银行]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址
     * @param toAddress 接收方地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferCb2Bank(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferCb2Bank(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }


    /**
     * Token转账
     *
     * 过程: [商业银行] --> [中央银行]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [银行地址]
     * @param toAddress 接收方地址 [中央银行]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferBank2Cb(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferBank2Cb(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [商业银行]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [商业银行地址]
     * @param toAddress 接收方地址 [商业银行地址]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferBank2Bank(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferBank2Bank(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [企业商家]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [商业银行地址]
     * @param toAddress 接收方地址 [企业商家地址]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferBank2Cp(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferBank2Cp(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [企业商家] --> [商业银行]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [企业商家地址]
     * @param toAddress 接收方地址 [商业银行地址]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferCp2Bank(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferCp2Bank(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [商业银行] --> [普通用户]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [商业银行]
     * @param toAddress 接收方地址 [普通用户]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferBank2User(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferBank2User(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }


    /**
     * Token转账
     *
     * 过程: [普通用户] --> [商业银行]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [普通用户]
     * @param toAddress 接收方地址 [商业银行]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferUser2Bank(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferUser2Bank(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [企业商家] --> [普通用户]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [企业商家]
     * @param toAddress 接收方地址 [普通用户]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferCp2User(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferCp2User(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }

    /**
     * Token转账
     *
     * 过程: [普通用户] --> [企业商家]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址 [普通用户]
     * @param toAddress 接收方地址 [企业商家]
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transferUser2Cp(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transferUser2Cp(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }

        return null;
    }


    //---------------华丽的分割线----------------------------------------------//
    /**
     * Token转账
     *
     * 过程: [账户] --> [账户]
     *
     * @param token
     * @param orderNo 订单编号
     * @param fromAddress 发送方地址
     * @param toAddress 接收方地址
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction transfer(String token, String orderNo, String fromAddress, String toAddress,String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.transfer(token, address, orderNo, fromAddress, toAddress, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);

        }
        return null;
    }

    /**
     * 注册账户
     * @param token
     * @param userNo
     * @param userName
     * @param roleCode
     * @return
     */
    public static ChainRespon<Account> regAccount(String token, String userNo, String userName, String roleCode){

        ChainRespon<Account> respon = new ChainRespon<>();
        respon.setCode("500");

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.createAccount(token, address, userNo, userName, roleCode);
        System.out.println("jsonStr="+jsonStr);


        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            String txId = data.get("txId").getAsString();
            int blockNum = data.get("blockNum").getAsInt();

            JsonObject userData = data.getAsJsonObject("metada");
            //System.out.println("userData.toString()="+userData.toString());

            Account account = new Gson().fromJson(userData.toString(),Account.class);

            respon.setCode("200");
            respon.setBlockNum(blockNum);
            respon.setTxHash(txId);
            respon.setMeta(account);

            return respon;

        }

        return respon;
    }

    /**
     * 查询账户信息
     *
     * @param token
     * @param address
     * @return
     */
    public static Account getAccount(String token, String address){

        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),Account.class);
        }

        return null;
    }

    /**
     * 查询交易信息
     *
     * @param token
     * @param address
     * @return
     */
    public static Transaction getTransaction(String token, String address){

        String jsonStr = ChainHttpClient.queryByAddress(token, address);
        System.out.println("jsonStr="+jsonStr);
        JsonParser parse =new JsonParser();  //创建json解析器

        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        String code = json.get("code").getAsString();
        if(code.endsWith("200")){

            JsonObject data = json.getAsJsonObject("data");
            //data.
            System.out.println("data.toString()="+data.toString());
            return new Gson().fromJson(data.toString(),Transaction.class);
        }

        return null;
    }


    /**
     * 新增TOKEN数量
     *
     * @param token
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction issueGoldToken(String token, String orderNo, String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.issueGoldToken(token, address, orderNo, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);
        }
        return null;
    }

    /**
     * 销毁TOKEN数量
     *
     * @param token
     * @param amount 数量
     * @param remarke 备注说明
     * @return
     */
    public static Transaction destroyGoldToken(String token, String orderNo, String amount, String remarke){

        String address = IdentityGenUtil.genAddress();
        System.out.println("address="+address);

        String jsonStr = ChainHttpClient.destroyGoldToken(token, address, orderNo, amount, remarke);
        System.out.println("jsonStr="+jsonStr);

        JsonParser parse =new JsonParser();  //创建json解析器
        JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象

        int code = json.get("code").getAsInt();
        if(code == 200){

            JsonObject data = json.getAsJsonObject("data");

            JsonObject userData = data.getAsJsonObject("metada");
            System.out.println("userData.toString()="+userData.toString());
            return new Gson().fromJson(userData.toString(),Transaction.class);
        }
        return null;
    }

}
