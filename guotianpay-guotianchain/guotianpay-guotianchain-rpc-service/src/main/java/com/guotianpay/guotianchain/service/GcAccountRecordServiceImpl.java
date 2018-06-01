package com.guotianpay.guotianchain.service;

import com.guotianpay.guotianchain.dao.GcAccountRecordDao;
import com.guotianpay.guotianchain.model.GcAccountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户流水 Service
 */
@Service("gcAccountRecordService")
public class GcAccountRecordServiceImpl implements GcAccountRecordService{

    @Autowired
    private GcAccountRecordDao gcAccountRecordDao;

    @Override
    public GcAccountRecord findGcAccountRecordByBillNo(String billNo) {
        return gcAccountRecordDao.selectByBillNo(billNo);
    }
}
