package com.guotianpay.core.blockchain.rpc.service.impl;

import com.guotianpay.core.blockchain.rpc.api.BlockChainEthTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

import java.math.BigInteger;

/**
 * EHT以太币交易服务实现类,与Go-Ethereum区块链RPC通信的接口封装
 *
 * @auth Longxing QIU
 * @since 2018-02-01 18:06
 **/
public class BlockChainEthTradeServiceImpl implements BlockChainEthTradeService {

    @Autowired
    private Web3j web3j;
    @Autowired
    private Admin admin;

    /**
     * GAS Price
     */
    private BigInteger gasPrice = new BigInteger("21000");
    /**
     * 最大GAS
     */
    private BigInteger gasLimit = new BigInteger("121000");

    @Override
    public void trasfer(String from, String formPassword, String to, BigInteger amount) {
        try {
            Transaction transaction = Transaction.createEtherTransaction(from,null,gasPrice,gasLimit,to,amount);
            PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(from, formPassword).sendAsync().get();
            if (personalUnlockAccount.accountUnlocked()) {
                // send a transaction
                EthSendTransaction ethSendTransaction = admin.ethSendTransaction(transaction).send();
                System.out.println("ethSendTransaction="+ethSendTransaction.getTransactionHash());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
