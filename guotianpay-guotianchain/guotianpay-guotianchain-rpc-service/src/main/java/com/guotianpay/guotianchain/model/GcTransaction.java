package com.guotianpay.guotianchain.model;

import java.util.Date;

/**
 * 交易记录表 gc_transaction
 *
 * CREATE TABLE `gc_transaction` (
 `trade_no` varchar(64) NOT NULL DEFAULT '' COMMENT '交易流水号',
 `address` varchar(128) NOT NULL COMMENT '交易地址',
 `order_no` varchar(64) DEFAULT NULL COMMENT '交易单号（关联交易订单）',
 `from_address` varchar(128) DEFAULT NULL COMMENT '交易主体账户地址',
 `from_user_no` varchar(64) DEFAULT NULL COMMENT '交易主体账户号',
 `from_user_name` varchar(64) DEFAULT NULL COMMENT '交易主体账户名称',
 `to_address` varchar(128) DEFAULT NULL COMMENT '交易对手账户地址',
 `to_use_no` varchar(64) DEFAULT NULL COMMENT '交易对手账户号',
 `to_user_name` varchar(64) DEFAULT NULL COMMENT '交易对手账户名称',
 `amount` int(20) DEFAULT NULL COMMENT '交易数量',
 `status` varchar(10) DEFAULT NULL COMMENT '状态',
 `time` datetime DEFAULT NULL COMMENT '交易时间',
 `tx_hash` varchar(128) DEFAULT NULL COMMENT '交易hash地址',
 `block_num` int(20) DEFAULT NULL COMMENT '区块高度',
 `remarke` varchar(256) DEFAULT NULL COMMENT '备注说明',
 PRIMARY KEY (`trade_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易记录表';
 */
public class GcTransaction {

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 交易地址
     */
    private String address;

    /**
     * 交易单号（关联交易订单）
     */
    private String orderNo;

    /**
     * 交易主体账户地址
     */
    private String fromAddress;

    /**
     * 交易主体账户号
     */
    private String fromUserNo;

    /**
     * 交易主体账户名称
     */
    private String fromUserName;

    /**
     * 交易对手账户地址
     */
    private String toAddress;

    /**
     * 交易主体账户号
     */
    private String toUserNo;

    /**
     * 交易对手账户名称
     */
    private String toUserName;

    /**
     * 交易数量
     */
    private Integer amount;

    /**
     * 状态
     */
    private String status;

    /**
     * 交易时间
     */
    private Date time;

    /**
     * 交易hash地址
     */
    private String txHash;

    /**
     * 区块高度
     */
    private Integer blockNum;

    /**
     * 备注说明
     */
    private String remarke;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

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

    public String getFromUserNo() {
        return fromUserNo;
    }

    public void setFromUserNo(String fromUserNo) {
        this.fromUserNo = fromUserNo;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }
}
