package com.guotianpay.guotianchain.service;

import com.guotianpay.guotianchain.model.GcAccountRecord;

public interface GcAccountRecordService {

    /**
     * 获取账户流水记录 By 流水号
     * @param billNo 流水号
     * @return
     */
    public GcAccountRecord findGcAccountRecordByBillNo(String billNo);

}
