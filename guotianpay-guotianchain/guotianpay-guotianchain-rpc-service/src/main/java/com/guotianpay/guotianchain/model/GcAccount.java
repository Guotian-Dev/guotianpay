package com.guotianpay.guotianchain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 资金账户表 gc_account
 *
 */
public class GcAccount implements Serializable {

    /**
     * 账户号
     */
    private String userNo;

    /**
     * 账户地址（区块链）
     */
    private String address;

    /**
     * 名称
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 余额（持有coin的数量，整数类型）
     */
    private Integer amount;

    /**
     * 身份证号码
     */
    private String cardNo;


    /**
     * 身份证姓名
     */
    private String cardName;

    /**
     * 统一社会信用代码
     */
    private String companyNo;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 是否实名制认证（1-已认证 2-未认证）
     */
    private Integer isCardAuth;

    /**
     * 是否企业认证（1-已认证 2-未认证）
     */
    private Integer isCompanyAuth;

    /**
     * 账户类型代码（央行-10 银行-11 企业-12 普通-13）
     */
    private String roleCode;

    /**
     * 交易hash
     */
    private String txHash;

    /**
     * 区块高度
     */
    private Integer blockNum;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIsCardAuth() {
        return isCardAuth;
    }

    public void setIsCardAuth(Integer isCardAuth) {
        this.isCardAuth = isCardAuth;
    }

    public Integer getIsCompanyAuth() {
        return isCompanyAuth;
    }

    public void setIsCompanyAuth(Integer isCompanyAuth) {
        this.isCompanyAuth = isCompanyAuth;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }
}
