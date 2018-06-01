package com.guotianpay.guotianchain.rpc.service;

public class ChainRespon<T> {

    /**
     * 错误编码
     */
    private String code;

    /**
     * 响应描述
     */
    private String msg;

    /**
     * 交易Hash值
     */
    private String txHash;

    /**
     * 区块链高度
     */
    private int blockNum;

    /**
     * 数据部分
     */
    private T meta;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getMeta() {
        return meta;
    }

    public void setMeta(T meta) {
        this.meta = meta;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }
}
