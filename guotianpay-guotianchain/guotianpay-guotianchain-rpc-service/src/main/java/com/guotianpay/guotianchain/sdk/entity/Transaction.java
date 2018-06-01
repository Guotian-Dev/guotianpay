package com.guotianpay.guotianchain.sdk.entity;

/**
 * TOKEN 交易记录
 *
 */
public class Transaction {

    /**
     * 交易地址
     */
    private String address;

    /**
     * 交易编号（订单交易号）
     */
    private String orderNo;


    /**
     * 发送方地址
     */
    private String fromAddress;


    /**
     * 接收方地址
     */
    private String toAddress;

    /**
     * 交易类型代码
     */
    private String typeCode;

    /**
     * 交易数量
     */
    private int amount;


    /**
     * 交易时间
     */
    private String time;

    /**
     * 备注说明
     */
    private String remarke;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }


    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }
}
