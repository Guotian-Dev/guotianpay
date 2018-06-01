package com.guotianpay.core.blockchain.rpc.api;

import java.math.BigInteger;

/**
 * GPayCoin积分代币服务接口声明
 * @auth Longxing QIU
 * @since 2018-02-01 17:31
 */
public interface GPayCoinService {

    /**
     * 获取合约名称
     * @return 合约名称
     */
    public String getContractName() throws Exception;

    /**
     * 获取合约单位符合,例如:以太币-ETH
     * @return 合约单位符号
     */
    public String getContractSymbol() throws Exception;

    /**
     * 获取合约小数点位数
     * @return
     */
    public BigInteger getContractDecimals() throws Exception;

    /**
     * 获取代币总量
     * @return
     */
    public BigInteger getTotalSupply() throws Exception;

    /**
     * 获取合约持有者的代币数量
     * @param address 持有者的账户地址
     * @return 代币数量
     */
    public BigInteger balanceOf(String address) throws Exception;

    /**
     * 代币onwer(发行者)转账给接收者
     * @param toAddress 接收者账户地址
     * @param amount 代币数量
     * @return 转账是否成功
     */
    public boolean transfer(String toAddress, BigInteger amount) throws Exception;

    /**
     * 代币转账从A账户转账到B账户
     * @param fromAddress 发起方地址
     * @param formPassword 发起方密码
     * @param toAddress 接收方地址
     * @param amount 代币数量（即转账金额）
     * @return 转账是否成功
     */
    public boolean transferFrom(String fromAddress, String formPassword, String toAddress, BigInteger amount);

    public void deployContract();
}
