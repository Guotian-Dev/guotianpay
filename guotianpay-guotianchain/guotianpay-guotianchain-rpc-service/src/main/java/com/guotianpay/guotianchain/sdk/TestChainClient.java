package com.guotianpay.guotianchain.sdk;


import com.guotianpay.guotianchain.sdk.entity.*;

public class TestChainClient {
    public static void main( String[] args )
    {

//        String address = IdentityGenUtil.genAddress();
//        System.out.println("address="+address);

        //获取Token
        String token = ChainClient.getToken();
        System.out.println("token="+token);
//
//
//
//        User user =ChainClient.getUserInfo(token, "u_qiulongxing");
//        System.out.println("user.address="+user.getAddress());

        //创建用户
//        User user1 = ChainClient.regUser(token, "u_qiulongxing_A","15207555425");
//        System.out.println("user.address="+user1.getAddress());
//
//        //创建用户
//        User user2 = ChainClient.oauthUserCard(token, user1.getAddress(), "蔡锦鹏", "25081672617267162162");
//        System.out.println("user.address="+user2.getAddress());



        //创建企业账户
//        Company company = ChainClient.regCompany(token, "b_10001","测试企业账号01");
//        System.out.println("company.address="+company.getAddress());

        //查询企业账户
//        Company company = ChainClient.getCompanyInfo(token, "33241e3e65804f0db2643c6ee46cdd02");
//        System.out.println("company.address="+company.getAddress());

        //创建银行账户
//        Bank bank = ChainClient.regBank(token, "bk_10001","测试银行账号A");
//        System.out.println("bank.address="+bank.getAddress());
//
//        //创建银行账户
//        Bank bank2 = ChainClient.regBank(token, "bk_10002","测试银行账号B");
//        System.out.println("bank.address="+bank2.getAddress());



        //查询银行账户
//        Bank bank = ChainClient.getBankInfo(token, "a0f75931252f48ffb479ccbca96fee10");
//        System.out.println("bank.address="+bank.getAddress());



//        //销毁token
//        TokenIssueTran tokenIssueTran2 = ChainClient.destroyGoldToken(token, "100","销毁TOKEN 1000");
//        System.out.println("tokenIssueTran2.address="+tokenIssueTran2.getAddress());

//        TokenIssueTran tokenIssueTran = ChainClient.getTokenIssueTran(token, "343a6bcd14dc4d3eb151f945f0548737");
//        System.out.println("tokenIssueTran.address="+tokenIssueTran.getAddress());

//        //查询央行信息
//        CenterBank centerBank =ChainClient.getCenterBankInfo(token);
//        System.out.println("centerBank="+centerBank.getId());

        //--------------- 测试转账-------------------------//

        //转账cb2bank
//        Transaction transaction = ChainClient.transferCb2Bank(token, "2018012122121212454661","48d877acf2a04e63b5c2cdaffda97427", "142d1d9aa63e40c4a5d2bc39c40c18de", "10", "centerbank 2 bank");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Bank2Cb
//        Transaction transaction = ChainClient.transferBank2Cb(token, "2018012122121212454663", "142d1d9aa63e40c4a5d2bc39c40c18de","48d877acf2a04e63b5c2cdaffda97427",  "1", "centerbank 2 bank");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Bank2Bank
//        Transaction transaction = ChainClient.transferBank2Bank(token, "2018012122121212454664", "57048e25175141988d82c07f4c918ad2","7439e5e2f4534e27a6174da334bdc86c",  "1", "centerbank 2 bank");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Bank2Cp
//        Transaction transaction = ChainClient.transferBank2Cp(token, "2018012122121212454665", "aca374015b4b463499d86a404a305772","047e46daa83e4ee392f5776b4014d8eb",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Cp2Bank
//        Transaction transaction = ChainClient.transferCp2Bank(token, "2018012122121212454666", "aca00a62aff740fc9d9dc6bdc81331ef","d4f45cde8e524cf5b743020d9f87362f",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Bank2User
//        Transaction transaction = ChainClient.transferBank2User(token, "2018012122121212454667", "73502da9942b4299943fa8acb42a8374","2856f487d09c45a9ac1faecb90fc9319",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账User2Bank
//        Transaction transaction = ChainClient.transferUser2Bank(token, "2018012122121212454668", "2856f487d09c45a9ac1faecb90fc9319","73502da9942b4299943fa8acb42a8374",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账Cp2User
//        Transaction transaction = ChainClient.transferCp2User(token, "2018012122121212454668", "c3297efd9a0e426da3624d3ba553378a","dc22a6174ed44ba3a446f6d0ed4de74c",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //转账User2Cp
//        Transaction transaction = ChainClient.transferUser2Cp(token, "2018012122121212454668", "dc22a6174ed44ba3a446f6d0ed4de74c","c3297efd9a0e426da3624d3ba553378a",  "1", "");
//        System.out.println("transaction.address="+transaction.getAddress());

        //查询央行信息
//        CenterBank centerBank =ChainClient.getCenterBankInfo(token);
//        System.out.println("centerBank="+centerBank.getId());
//


        //------------------华丽的分割线------------------------------------------------//

        //查询Token信息
//        GoldToken goldToken =ChainClient.getGoldTokenInfo(token);
//        System.out.println("goldToken="+goldToken.getAddress());

        //新增token
        Transaction tokenIssueTran = ChainClient.issueGoldToken(token, "2018012122121212454690","1000","新增 Token 1001");
        System.out.println("tokenIssueTran.address="+tokenIssueTran.getAddress());

        //销毁token
        Transaction tokenIssueTran2 = ChainClient.destroyGoldToken(token, "20180121221454630","100","销毁 Token 1000");
        System.out.println("tokenIssueTran.address="+tokenIssueTran2.getAddress());

//        //账户之间互相转账
        Transaction transaction = ChainClient.transfer(token, "2018012122121212454668", "48d877acf2a04e63b5c2cdaffda97427","0x1234567890",  "10", "测试转账");
        System.out.println("transaction.address="+transaction.getAddress());

        //创建资金账户
//        Account bank = ChainClient.regAccount(token, "20180521002","测试账号B","13");
//        System.out.println("bank.address="+bank.getAddress());

        //查询资金账户信息
        Account account = ChainClient.getAccount(token, "48d877acf2a04e63b5c2cdaffda97427");
        System.out.println("Account.address="+account.getAddress());

        //查询资金账户信息
//        Transaction transaction2 = ChainClient.getTransaction(token, "b12fd1a5bedd444186c28951f6a16608");
//        System.out.println("Transaction.address="+transaction2.getAddress());
    }
}
