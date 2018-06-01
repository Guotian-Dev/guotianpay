package com.guotianpay.user.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户银行卡数据模型
 * @author Longxing QIU
 * @since 2018-01-26
 */
public class UserCard implements Serializable{

    /**
     * ID
     */
    private String id;

    /**
     * 银行卡号
     */
    private String cardNo;

    /**
     * 银行卡开户名
     */
    private String cardName;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
