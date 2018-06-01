package com.guotianpay.core.blockchain.rpc.service.impl;

import com.guotianpay.core.blockchain.rpc.api.GPayCoinService;
import com.guotianpay.core.blockchain.rpc.config.MyGethConfig;
import com.guotianpay.core.blockchain.rpc.contract.GPayCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @auth Longxing QIU
 * @since 2018-02-01 18:08
 **/
@Service
public class GPayCoinServiceImpl implements GPayCoinService {

    @Autowired
    private Web3j web3j;

    @Autowired
    private Admin admin;

    /**
     * 私有区块链配置
     */
    @Autowired
    private MyGethConfig myGethConfig;

    /**
     * GPayCoin合约
     */
    private GPayCoin contract;

    @Override
    public String getContractName() throws Exception {
        return null;
    }

    @Override
    public String getContractSymbol() throws Exception {
        return null;
    }

    @Override
    public BigInteger getContractDecimals() throws Exception {
        return null;
    }

    @Override
    public BigInteger getTotalSupply() throws Exception {
        return null;
    }

//    @Override
//    public BigInteger balanceOf(String address) throws Exception {
//        return null;
//    }

    //private String contractAddress = "0x30d046c28daff5b0e55a05377818d1dec65d78e8";
    // GAS价格
    public static BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    // GAS上限
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000L);

    @Override
    public void deployContract() {
        try {
            //WalletUtils.getDefaultKeyDirectory();
            // 获取凭证
            Credentials credentials = WalletUtils.loadCredentials("zqxgdufe", "C:\\Geth\\chain\\keystore\\UTC--2018-01-27T05-47-22.531496600Z--11de505d548e6878a3f587ac259563120e087850");
            System.out.println("getCredentialsAddress : " + credentials.getAddress());

//            BigInteger gasPrice = new BigInteger("1200");
//            BigInteger gasLimit = new BigInteger("121000");
            // 加载合约
            //contract = GPayCoin.load("0x7844571c95586e7729BB87Da89bfa4d14539f823", web3j, credentials, gasPrice, gasLimit);
            GPayCoin contract2 = GPayCoin.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT).send();
            //String contract2Address = contract2.getContractAddress();
            System.out.println("New Contract GPayCoin hava Deployed!");
            System.out.println("GPayCoin.ContractAddress: "+contract2.getContractAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 初始化代币合约对象
     * @return
     */
    protected GPayCoin getGPayCoinContractInstance() {

        if (contract != null) {
            return contract;

        }else{
            try {
                // 获取凭证
                //Credentials credentials = WalletUtils.loadCredentials("zqxgdufe", "C:\\Geth\\chain\\keystore\\UTC--2018-01-27T05-47-22.531496600Z--11de505d548e6878a3f587ac259563120e087850");
                //System.out.println("getCredentialsAddress : " + credentials.getAddress());
                Credentials credentials = WalletUtils.loadCredentials(myGethConfig.getGpcOwnerPassphrase(), "C:\\Geth\\chain\\keystore\\UTC--2018-01-27T05-47-22.531496600Z--11de505d548e6878a3f587ac259563120e087850");
                System.out.println("getCredentialsAddress : " + credentials.getAddress());


                BigInteger gasPrice = new BigInteger("80000000000");
                BigInteger gasLimit = new BigInteger("136669");
                // 加载合约
                contract = GPayCoin.load(myGethConfig.getGpcAddress(), web3j, credentials, gasPrice, gasLimit);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CipherException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contract;
    }




//    @Override
//    public String getContractName() throws Exception {
//        BeiCoinContract contract = getGPayCoinContractInstance();
//
//        return contract.name().send();
//    }
//
//    @Override
//    public String getContractSymbol() throws Exception {
//        BeiCoinContract contract = getGPayCoinContractInstance();
//        return contract.symbol().send();
//    }
//
//    @Override
//    public BigInteger getContractDecimals() throws Exception {
//        BeiCoinContract contract = getGPayCoinContractInstance();
//        return contract.decimals().send();
//    }
//
//    @Override
//    public BigInteger getTotalSupply() throws Exception {
//        BeiCoinContract contract = getGPayCoinContractInstance();
//        return contract.totalSupply().send();
//    }
//
    @Override
    public BigInteger balanceOf(String address) throws Exception {
        GPayCoin contract = getGPayCoinContractInstance();
        return contract.balanceOf(address).send();
    }

    @Override
    public boolean transfer(String toAddress, BigInteger amount) throws Exception {
        GPayCoin contract = getGPayCoinContractInstance();
        TransactionReceipt transactionReceipt = contract.transfer(toAddress, amount).send();
        System.out.println("json="+transactionReceipt.getBlockNumber());
        return false;
    }

    @Override
    public boolean transferFrom(String fromAddress, String formPassword, String toAddress, BigInteger amount) {
        try {
            PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(fromAddress, formPassword).sendAsync().get();
            if (personalUnlockAccount.accountUnlocked()) {
                GPayCoin contract = getGPayCoinContractInstance();
                TransactionReceipt transactionReceipt = contract.transferFrom(fromAddress, toAddress, amount).send();
                System.out.println("json="+transactionReceipt.getBlockNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
