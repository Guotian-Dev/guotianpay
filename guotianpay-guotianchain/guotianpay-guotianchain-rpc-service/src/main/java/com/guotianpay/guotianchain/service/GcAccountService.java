package com.guotianpay.guotianchain.service;


import com.guotianpay.guotianchain.model.GcAccount;

public interface GcAccountService {

    /**
     * 查询账户
     * @param userNo 账户号
     * @return
     */
    public GcAccount findAccountByUserNo(String userNo);

    /**
     * 查询账户
     * @param address 账户地址
     * @return
     */
    public GcAccount findAccountByAddress(String address);

    /**
     * 插入账户数据
     * @param account 账户对象
     * @return
     */
    public boolean saveAccount(GcAccount account);

    /**
     * 更新账户
     * @param account 账户对象
     * @return
     */
    public boolean updateAccount(GcAccount account);

    /**
     * 删除账户
     * @param userNo 账户号
     * @return
     */
    public boolean deleteAccount(String userNo);

}
