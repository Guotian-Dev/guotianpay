package com.guotianpay.guotianchain.rpc.service;

import com.guotianpay.guotianchain.sdk.ChainClient;
import com.guotianpay.guotianchain.sdk.entity.Account;
import com.guotianpay.guotianchain.sdk.entity.Transaction;
import org.springframework.stereotype.Service;

@Service("chainService")
public class ChainServiceImpl implements ChainService {

    @Override
    public ChainRespon<Account> newAccount(String userNo, String userName, String roleCode) {
        //获取Token
        String token = ChainClient.getToken();
        System.out.println("token="+token);

        //创建资金账户
        //ChainRespon<Account> respon = ChainClient.regAccount(token, userNo,userName,roleCode);
        return ChainClient.regAccount(token, userNo,userName,roleCode);
    }

    @Override
    public Transaction issueToken(int amount) {
        return null;
    }

    @Override
    public Transaction destroyToken(int amount) {
        return null;
    }

    @Override
    public Transaction transfer() {
        return null;
    }
}
