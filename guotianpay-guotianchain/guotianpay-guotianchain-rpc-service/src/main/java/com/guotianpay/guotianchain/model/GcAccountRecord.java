package com.guotianpay.guotianchain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 资金账户流水表 gc_account_record
 */
public class GcAccountRecord implements Serializable {

    /**
     * 流水号
     */
   private String billNo;

    /**
     * 账户号
     */
   private String userNo;

    /**
     * 账户地址
     */
   private String address;


    /**
     * 收支类型代码（收入/支出）
     */
    private String typeCode;

    /**
     * 收支金额
     */
    private Integer amount;

    /**
     * 原余额（收支前）
     */
    private Integer orgAmount;

    /**
     * 余额（收支后）
     */
    private Integer newAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 交易流水号（关联交易记录）
     */
    private String txTradeNo;

    /**
     * 交易地址（关联交易记录）
     */
    private String txAddress;

    /**
     * 备注说明
     */
    private String txRemarke;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrgAmount() {
        return orgAmount;
    }

    public void setOrgAmount(Integer orgAmount) {
        this.orgAmount = orgAmount;
    }

    public Integer getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(Integer newAmount) {
        this.newAmount = newAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTxTradeNo() {
        return txTradeNo;
    }

    public void setTxTradeNo(String txTradeNo) {
        this.txTradeNo = txTradeNo;
    }

    public String getTxAddress() {
        return txAddress;
    }

    public void setTxAddress(String txAddress) {
        this.txAddress = txAddress;
    }

    public String getTxRemarke() {
        return txRemarke;
    }

    public void setTxRemarke(String txRemarke) {
        this.txRemarke = txRemarke;
    }
}
