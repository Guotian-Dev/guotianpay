package com.guotianpay.guotianchain.model;

import java.util.Date;

/**
 * 交易订单表 gc_trade_order
 *
 */
public class GcTradeOrder {

    /**
     * 交易订单号
     */
    private String orderNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 订单总金额
     */
    private Integer orderAmount;

    /**
     * 状态，参考状态码表
     */
    private String status;

    /**
     * 交易类型编号
     */
    private String tradeTypeCode;

    /**
     * 交易类型名称
     */
    private String tradeTypeName;

    /**
     * 实付金额
     */
    private Integer tradeAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 付款人地址
     */
    private String formAddress;

    /**
     * 付款人账号
     */
    private String formUserNo;

    /**
     * 交易主体账户名称
     */
    private String formUserName;

    /**
     * 收款人地址
     */
    private String toAddress;

    /**
     * 付款人账号
     */
    private String toUserNo;

    /**
     * 交易对手账户名称
     */
    private String toUserName;

    /**
     * 商户订单号
     */
    private String merchantOrderNo;

    /**
     * 备注说明
     */
    private String remarke;

    /**
     * 交易流水号（关联交易记录）
     */
    private String tradeNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTradeTypeCode() {
        return tradeTypeCode;
    }

    public void setTradeTypeCode(String tradeTypeCode) {
        this.tradeTypeCode = tradeTypeCode;
    }

    public String getTradeTypeName() {
        return tradeTypeName;
    }

    public void setTradeTypeName(String tradeTypeName) {
        this.tradeTypeName = tradeTypeName;
    }

    public Integer getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Integer tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getFormAddress() {
        return formAddress;
    }

    public void setFormAddress(String formAddress) {
        this.formAddress = formAddress;
    }

    public String getFormUserNo() {
        return formUserNo;
    }

    public void setFormUserNo(String formUserNo) {
        this.formUserNo = formUserNo;
    }

    public String getFormUserName() {
        return formUserName;
    }

    public void setFormUserName(String formUserName) {
        this.formUserName = formUserName;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getToUserNo() {
        return toUserNo;
    }

    public void setToUserNo(String toUserNo) {
        this.toUserNo = toUserNo;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
