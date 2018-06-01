package com.guotianpay.guotianchain.sdk.entity;

/**
 * 银行账户
 *
 */
public class Bank {

    /**
     * 银行地址（唯一ID）
     */
    private String address;

    /**
     * 银行ID(唯一ID，不可修改)
     */
    private String id;

    /**
     * 银行名称(中文名称)
     */
    private String nameCn;

    /**
     * 银行名称(英文名称)
     */
    private String nameEn;

    /**
     * 银行名称(英文名称)
     */
    private String companyCode;

    /**
     * 账户余额（数字黄金持有数量）
     */
    private int amount;

    /**
     * 账户冻结余额（数字黄金持有数量）
     */
    private int frozenAmount;

    /**
     * 创建时间
     */
    private String time;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(int frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
