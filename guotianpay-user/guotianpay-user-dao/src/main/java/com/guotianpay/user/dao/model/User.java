package com.guotianpay.user.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户数据模型
 */
public class User implements Serializable{

    /**
     * 用户ID/布比账户ID
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nickName;

    private String password;

    /**
     * 支付密码
     */
    private String paymentCode;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 布比账户地址/区块链账户地址
     */
    private String bubiAddress;

    /**
     * 账户类型 1:平台总账户 2:企业账户 3:vip账户 4:普通账户
     */
    private int type;

    /**
     * 状态 1:启用 2:禁用
     */
    private int status;

    /**
     * 用户银行卡
     */
    private String card;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBubiAddress() {
        return bubiAddress;
    }

    public void setBubiAddress(String bubiAddress) {
        this.bubiAddress = bubiAddress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
