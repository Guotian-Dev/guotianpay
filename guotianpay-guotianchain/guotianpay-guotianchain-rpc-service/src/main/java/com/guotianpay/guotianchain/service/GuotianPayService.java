package com.guotianpay.guotianchain.service;

import com.guotianpay.guotianchain.model.GcAccount;

/**
 * 国天支付 Service
 */
public interface GuotianPayService {

    public GcAccount newAccount(String userNo, String userName, String roleCode);

}
