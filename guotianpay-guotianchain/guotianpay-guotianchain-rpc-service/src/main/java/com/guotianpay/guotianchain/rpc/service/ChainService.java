package com.guotianpay.guotianchain.rpc.service;

import com.guotianpay.guotianchain.sdk.entity.Account;
import com.guotianpay.guotianchain.sdk.entity.Transaction;

/**
 * 区块链 Service
 */
public interface ChainService {

    /**
     * 创建账户
     *
     * @param userNo 账户ID
     * @param userName 账户名称
     * @param roleCode 账户角色 发行商-10 运营商-11 企业-12 普通-13
     * @return
     */
    public ChainRespon<Account> newAccount(String userNo, String userName, String roleCode);

    /**
     * 增发Token数量
     * @return
     */
    public Transaction issueToken(int amount);

    /**
     * 销毁Token数量
     * @return
     */
    public Transaction destroyToken(int amount);

    /**
     * 交易
     * @return
     */
    public Transaction transfer();
}
