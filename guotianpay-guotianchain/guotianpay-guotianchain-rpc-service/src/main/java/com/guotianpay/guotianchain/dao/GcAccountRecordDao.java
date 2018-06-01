package com.guotianpay.guotianchain.dao;

import com.guotianpay.guotianchain.model.GcAccountRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GcAccountRecordDao {

    /**
     * 查询流水记录 by 流水号
     * @param billNo 流水号
     * @return
     */
    public GcAccountRecord selectByBillNo(@Param("billNo") String billNo);


    /**
     * 插入单条数据
     * @param record
     * @return
     */
    int insert(GcAccountRecord record);

    /**
     * 更新单条数据 By 主键
     * @param record
     * @return
     */
    int updateByPrimaryKey(GcAccountRecord record);


    /**
     * 删除单条数据 By 主键
     * @param billNo 流水号
     * @return
     */
    int deleteByPrimaryKey(@Param("billNo") String billNo);
}
