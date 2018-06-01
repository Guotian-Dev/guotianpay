package com.guotianpay.guotianchain.sdk.entity;

/**
 * Token 新增、销毁交易
 */
public class TokenIssueTran {

    /**
     * 交易地址
     */
    private String address;

    /**
     * 交易类型 1:新增 2:销毁
     */
    private int type;

    /**
     * 金额
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
