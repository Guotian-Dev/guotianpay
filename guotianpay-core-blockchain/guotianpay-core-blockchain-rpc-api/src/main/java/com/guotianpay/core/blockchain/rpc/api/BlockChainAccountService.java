package com.guotianpay.core.blockchain.rpc.api;

import com.guotianpay.core.blockchain.dao.model.BlockChainAccount;

import java.math.BigInteger;
import java.util.List;

/**
 * 以太坊账户体系服务接口声明类,与Go-Ethereum区块链RPC通信的接口封装
 *
 * @auth Longxing QIU
 * @since 2018-02-01 17:31
 **/
public interface BlockChainAccountService {
    /**
     * 查询所有的以太坊Geth账户列表
     * @return Geth账户地址列表
     */
    public List<String> queryAccountList();

    /**
     * 创建新账户
     * @param password
     * @return Geth账户地址
     */
    public String newAccount(String password);

    /**
     * 查询账户金额
     * @param address 账户地址
     * @return 账户余额
     */
    public BigInteger queryAccountBalance(String address);

    /**
     * 查询账户Info By 账户地址
     * @param address 账户地址
     * @return 账户Info
     */
    //public GethAccount queryAccountByAddress(String address);

    /**
     * 查询账户Info By 账户地址
     * @param address 账户地址
     * @return 账户Info
     */
    public BlockChainAccount queryAccount(String address);

}
