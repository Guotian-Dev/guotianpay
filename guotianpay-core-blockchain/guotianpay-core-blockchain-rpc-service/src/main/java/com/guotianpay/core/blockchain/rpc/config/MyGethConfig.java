package com.guotianpay.core.blockchain.rpc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * 以太坊私有链配置
 * @auth Longxing QIU
 * @since 2018-02-02 22:38
 **/
@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "mygeth")  // 配置文件中的前缀
public class MyGethConfig {

    /**
     * 矿工账户地址
     */
    private String coinBaseAddress;



    /**
     * GPayCoin合约地址
     */
    private String gpcAddress;

    /**
     * GPayCoin合约Owner账户地址
     */
    private String gpcOwnerAddress;

    /**
     * GPayCoin合约Owner账户密码
     */
    private String gpcOwnerPassphrase;

    /**
     * 每GAS的ETH以太币价格
     */
    private BigInteger gasPrice;


    /**
     * 最大GAS值
     */
    private BigInteger gasLimit;

    public String getCoinBaseAddress() {
        return coinBaseAddress;
    }

    public void setCoinBaseAddress(String coinBaseAddress) {
        this.coinBaseAddress = coinBaseAddress;
    }

    public String getGpcAddress() {
        return gpcAddress;
    }

    public void setGpcAddress(String gpcAddress) {
        this.gpcAddress = gpcAddress;
    }

    public String getGpcOwnerAddress() {
        return gpcOwnerAddress;
    }

    public void setGpcOwnerAddress(String gpcOwnerAddress) {
        this.gpcOwnerAddress = gpcOwnerAddress;
    }

    public String getGpcOwnerPassphrase() {
        return gpcOwnerPassphrase;
    }

    public void setGpcOwnerPassphrase(String gpcOwnerPassphrase) {
        this.gpcOwnerPassphrase = gpcOwnerPassphrase;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }
}
