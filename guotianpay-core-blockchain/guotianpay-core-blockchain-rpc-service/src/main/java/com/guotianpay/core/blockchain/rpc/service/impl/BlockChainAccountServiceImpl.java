package com.guotianpay.core.blockchain.rpc.service.impl;

import com.guotianpay.core.blockchain.dao.model.BlockChainAccount;
import com.guotianpay.core.blockchain.rpc.api.BlockChainAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 以太坊账户体系服务实现类,与Go-Ethereum区块链RPC通信的接口封装
 *
 * @auth Longxing QIU
 * @since 2018-02-01 18:01
 **/
@Service
public class BlockChainAccountServiceImpl implements BlockChainAccountService {

    @Autowired
    private Web3j web3j;
    @Autowired
    private Admin admin;

    @Override
    public List<String> queryAccountList() {
        //调用Geth下的所有账户
        List<String> accounts = new ArrayList<String>();
        try {
            accounts = admin.ethAccounts().send().getAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public String newAccount(String password) {
        String address = null;
        try {
            address = admin.personalNewAccount(password).send().getAccountId();
            //logger.info("newAccount method success password={"+password+"} address={"+address+"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public BigInteger queryAccountBalance(String address) {
        //在哪个块上的状态
        //DefaultBlockParameter defaultBlockParameter = new DefaultBlockParameterNumber(58);
        BigInteger balance = null;
        try {
            balance = admin.ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }

    @Override
    public BlockChainAccount queryAccount(String address) {
        BlockChainAccount account = new BlockChainAccount();
        account.setAddress(address);
        account.setEthCoin(queryAccountBalance(address));
        return account;
    }
}
