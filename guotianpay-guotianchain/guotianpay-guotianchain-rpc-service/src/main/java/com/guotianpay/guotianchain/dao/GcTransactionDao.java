package com.guotianpay.guotianchain.dao;

import com.guotianpay.guotianchain.model.GcTransaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GcTransactionDao {

    public GcTransaction selectByTradeNo(@Param("tradeNo") String tradeNo);

    public int insert(GcTransaction record);

    public int updateByPrimaryKey(GcTransaction record);

    public int deleteByPrimaryKey(@Param("tradeNo") String tradeNo);

}
