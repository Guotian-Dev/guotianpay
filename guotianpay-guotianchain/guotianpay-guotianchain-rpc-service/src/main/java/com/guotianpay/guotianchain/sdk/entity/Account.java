package com.guotianpay.guotianchain.sdk.entity;

/**
 * /**
 * 账户
type Account struct {
        Address     string  `json:"address"`       //账户地址（唯一ID）
        UserNo      string  `json:"userNo"`        //账户ID(唯一ID，不可修改)
        UserName    string  `json:"userName"`      //账户名称
        CardNo      string  `json:"cardNo"`        //身份证号码
        CardName    string  `json:"cardName"`      //身份证名称
        IsCardAuth  int     `json:"isCardAuth"`    //是否实名制认证（1-已认证 2-未认证）
        CompanyCode string  `json:"companyCode"`   //统一社会信用代码
        CompanyName string  `json:"companyName"`   //企业名称
        IsCompanyAuth  int  `json:"isCompanyAuth"` //是否企业认证（1-已认证 2-未认证）
        Amount      int     `json:"amount"`        //账户余额（持有Token数量）
        RoleCode    string  `json:"roleCode"`      //账户类型代码（发行商-10 运营商-11 企业-12 普通-13）
        Time        string  `json:"time"`          //创建时间
        }
 */

/**
 * 资金账户（区块链）
 */
public class Account {

    /**
     * 账户地址（唯一ID）
     */
    private String address;

    /**
     * 账户ID(唯一ID，不可修改)
     */
    private String userNo;

    /**
     * 账户名称
     */
    private String userName;

    /**
     * 身份证号码
     */
    private String cardNo;

    /**
     * 身份证名称
     */
    private String cardName;

    /**
     * 是否实名制认证（1-已认证 2-未认证）
     */
    private int isCardAuth;

    /**
     * 统一社会信用代码
     */
    private String companyCode;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 是否企业认证（1-已认证 2-未认证）
     */
    private int isCompanyAuth;

    /**
     * 账户余额（持有Token数量）
     */
    private int amount;

    /**
     * 账户类型代码（发行商-10 运营商-11 企业-12 普通-13）
     */
    private String roleCode;

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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getIsCardAuth() {
        return isCardAuth;
    }

    public void setIsCardAuth(int isCardAuth) {
        this.isCardAuth = isCardAuth;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getIsCompanyAuth() {
        return isCompanyAuth;
    }

    public void setIsCompanyAuth(int isCompanyAuth) {
        this.isCompanyAuth = isCompanyAuth;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
