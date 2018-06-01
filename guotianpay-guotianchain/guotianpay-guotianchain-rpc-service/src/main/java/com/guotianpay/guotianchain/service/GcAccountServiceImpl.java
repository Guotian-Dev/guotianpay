package com.guotianpay.guotianchain.service;

import com.guotianpay.guotianchain.dao.GcAccountDao;
import com.guotianpay.guotianchain.model.GcAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gcAccountService")
public class GcAccountServiceImpl implements GcAccountService {

    @Autowired
    private GcAccountDao gcAccountDao;

    @Override
    public GcAccount findAccountByUserNo(String userNo) {
        return gcAccountDao.selectByUserNo(userNo);
    }

    @Override
    public GcAccount findAccountByAddress(String address) {
        return gcAccountDao.selectByAddress(address);
    }

    @Override
    public boolean saveAccount(GcAccount account) {
        int result = gcAccountDao.insert(account);
        if(result == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAccount(GcAccount account) {

        int result = gcAccountDao.updateByPrimaryKey(account);
        if(result == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String userNo) {
        int result = gcAccountDao.deleteByPrimaryKey(userNo);
        if(result == 1){
            return true;
        }
        return false;
    }
}
