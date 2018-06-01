package com.guotianpay.guotianchain.dao;

import com.guotianpay.guotianchain.model.GcAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GcAccountDao {

    /**
     * 查询账户信息 BY userNo
     * @param userNo 账户号
     * @return
     */
    GcAccount selectByUserNo(@Param("userNo") String userNo);


    /**
     * 查询账户信息 BY Address
     * @param address 账户地址
     * @return
     */
    GcAccount selectByAddress(@Param("address") String address);


    /**
     * 插入单条数据
     * @param account
     * @return
     */
    int insert(@Param("record") GcAccount account);

    /**
     * 更新单条数据 By 主键
     * @param account
     * @return
     */
    int updateByPrimaryKey(GcAccount account);

    /**
     * 删除单条数据 By 主键
     * @param userNo 账户号
     * @return
     */
    int deleteByPrimaryKey(@Param("userNo") String userNo);
}
