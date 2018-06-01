package com.guotianpay.core.blockchain.dao.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 区块链账户（以太坊GETH）
 * @auth Longxing QIU
 * @since 2018-02-02 22:05
 **/
public class BlockChainAccount implements Serializable{

    /**
     * 账户地址
     */
    private String address;
//    /**
//     * 账户密码
//     */
//    private String passphrase;

    /**
     * GPay积分数量
     */
    private BigInteger gpayCoin;

    /**
     * 以太币数量
     */
    private BigInteger ethCoin;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getPassphrase() {
//        return passphrase;
//    }
//
//    public void setPassphrase(String passphrase) {
//        this.passphrase = passphrase;
//    }

    public BigInteger getGpayCoin() {
        return gpayCoin;
    }

    public void setGpayCoin(BigInteger gpayCoin) {
        this.gpayCoin = gpayCoin;
    }

    public BigInteger getEthCoin() {
        return ethCoin;
    }

    public void setEthCoin(BigInteger ethCoin) {
        this.ethCoin = ethCoin;
    }
}
