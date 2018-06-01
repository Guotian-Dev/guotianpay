package com.guotianpay.guotianchain.service;


import com.guotianpay.guotianchain.model.GcAccount;
import com.guotianpay.guotianchain.rpc.service.ChainRespon;
import com.guotianpay.guotianchain.rpc.service.ChainService;
import com.guotianpay.guotianchain.sdk.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("guotianPayService")
public class GuotianPayServiceImpl implements GuotianPayService{

    //private
    @Autowired
    private GcAccountService gcAccountService;

    @Autowired
    private ChainService chainService;

    @Override
    public GcAccount newAccount(String userNo, String userName, String roleCode) {

        GcAccount account = null;

        ChainRespon<Account> respon = chainService.newAccount(userNo, userName, roleCode);
        if(respon.getCode().equals("200")){
            Account chainAccount = respon.getMeta();

            int blockNum = respon.getBlockNum();
            String txHash = respon.getTxHash();


            account = new GcAccount();
            account.setUserNo(chainAccount.getUserNo());
            account.setUserName(chainAccount.getUserName());
            account.setAddress(chainAccount.getAddress());
            account.setAmount(chainAccount.getAmount());
            account.setCardNo(chainAccount.getCardNo());
            account.setCardName(chainAccount.getCardName());
            account.setIsCardAuth(chainAccount.getIsCardAuth());
            account.setIsCompanyAuth(chainAccount.getIsCompanyAuth());
            account.setRoleCode(chainAccount.getRoleCode());
            account.setCreateTime(new Date());

            account.setTxHash(txHash);
            account.setBlockNum(blockNum);

            gcAccountService.saveAccount(account);
        }

        return account;
    }

}
