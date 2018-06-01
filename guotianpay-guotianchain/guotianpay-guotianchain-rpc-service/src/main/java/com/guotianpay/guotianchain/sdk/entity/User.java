package com.guotianpay.guotianchain.sdk.entity;

/**
 * 会员
 * Address     string   `json:"address"`     //用户地址（唯一ID）
 Name        string   `json:"name"`        //用户名称
 Mobile      string   `json:"mobile"`      //手机号码
 Amount      int      `json:"amount"`      //账户余额
 CardName    string   `json:"cardName"`    //身份证姓名
 CardNo      string   `json:"cardNo"`      //身份证号码
 Time        string   `json:"time"`        //创建时间
 */
public class User {

    //用户地址（唯一ID）
    public String address;

    //用户名称
    public String name;

    //手机号码
    public String mobile;

    //账户余额
    public int amount;

    //身份证姓名
    public String cardName;

    //身份证号码
    public String cardNo;

    //是否身份证实名制认证
    public int isCardOauth;

    //创建时间
    public String time;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getIsCardOauth() {
        return isCardOauth;
    }

    public void setIsCardOauth(int isCardOauth) {
        this.isCardOauth = isCardOauth;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
