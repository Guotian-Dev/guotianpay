package com.guotianpay.guotianchain.sdk.entity;

/**
 * 数字黄金
 *
 */
public class GoldToken {
    //ID （唯一ID）
    private String address;

    //数字黄金名称: eg Simon Bucks
    private String name;

    ////小数点位数长度.
    private int decimals;

    //标识: eg SBX
    private String symbol;

    //版本信息 eg：1.0
    private String version;

    //发起人ID地址
    private String owner;

    //数字黄金总量
    private int totalSupply;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
