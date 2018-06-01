package com.guotianpay.core.blockchain.rpc.api;

import java.math.BigInteger;

/**
 * 以太币ETH交易服务接口声明类,与Go-Ethereum区块链RPC通信的接口封装
 * @auth Longxing QIU
 * @since 2018-01-29 15:28
 **/
public interface BlockChainEthTradeService {

    /**
     * ETH交易接口
     * @param from 发送人地址
     * @param formPassword 发送人密码
     * @param to 接收人地址
     * @param amount ETH数量
     */
    public void trasfer(String from, String formPassword, String to, BigInteger amount);

}
