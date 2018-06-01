package com.guotianpay.guotianchain.controller;

import com.guotianpay.guotianchain.model.GcAccount;
import com.guotianpay.guotianchain.model.GcAccountRecord;
import com.guotianpay.guotianchain.rpc.service.ChainService;
import com.guotianpay.guotianchain.sdk.entity.Account;
import com.guotianpay.guotianchain.service.GcAccountRecordService;
import com.guotianpay.guotianchain.service.GcAccountService;
import com.guotianpay.guotianchain.service.GuotianPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GcAccountController {

    @Autowired
    private GuotianPayService guotianPayService;

    @Autowired
    private GcAccountService gcAccountService;

    @Autowired
    private ChainService chainService;


    @Autowired
    private GcAccountRecordService gcAccountRecordService;



    @RequestMapping(value = "/api/account/findAccountByUserNo", method = RequestMethod.GET)
    public GcAccount findAccountByUserNo(@RequestParam(value = "userNo", required = true) String userNo) {
        return gcAccountService.findAccountByUserNo(userNo);
    }

    @RequestMapping(value = "/api/account/findAccountByAddress", method = RequestMethod.GET)
    public GcAccount findAccountByAddress(@RequestParam(value = "address", required = true) String address) {
        return gcAccountService.findAccountByAddress(address);
    }

    @RequestMapping(value = "/api/account/saveAccount", method = RequestMethod.GET)
    public GcAccount saveAccount(@RequestParam(value = "address", required = true) String address) {

        GcAccount account = new GcAccount();
        account.setUserNo("124454545");
        account.setUserName("zhangsan");
        account.setAddress("0x1212133");
        account.setAmount(0);
        account.setCardNo("1234343434344334");
        account.setCardName("张三链子");
        account.setIsCardAuth(1);
        account.setIsCompanyAuth(1);
        account.setBlockNum(10);
        account.setRoleCode("13");
        account.setCreateTime(new Date());

        gcAccountService.saveAccount(account);

        return account;
    }

    @RequestMapping(value = "/api/account/updateAccount", method = RequestMethod.GET)
    public GcAccount updateAccount(@RequestParam(value = "userNo", required = true) String userNo) {
        GcAccount account = gcAccountService.findAccountByUserNo(userNo);

        //GcAccount account = new GcAccount();
        //account.setUserNo("124454545");
        account.setUserName("zhangsan");
        account.setAddress("0x12121331111");
        account.setAmount(10);
        account.setCardNo("1234343434344334");
        account.setCardName("张链子");
        account.setCompanyNo("99999999999999");
        account.setCompanyName("huobiA");
        account.setIsCardAuth(2);
        account.setIsCompanyAuth(2);
        account.setBlockNum(11);
        account.setRoleCode("11");
        account.setCreateTime(new Date());
        account.setTxHash("0x12312345555556565656jlgldfljfgksg");

        gcAccountService.updateAccount(account);

        return account;
    }

    @RequestMapping(value = "/api/account/deleteAccount", method = RequestMethod.GET)
    public GcAccount deleteAccount(@RequestParam(value = "userNo", required = true) String userNo) {
        boolean result = gcAccountService.deleteAccount(userNo);
        System.out.println("result="+result);

        GcAccount account = new GcAccount();
        return account;
    }

    @RequestMapping(value = "/api/account/newAccount", method = RequestMethod.GET)
    public GcAccount newAccount(@RequestParam(value = "userNo", required = true) String userNo) {

        return guotianPayService.newAccount(userNo, "TestA", "13");

    }

    @RequestMapping(value = "/api/bill/getBill", method = RequestMethod.GET)
    public GcAccountRecord findGcAccountRecordByBillNo(@RequestParam(value = "billNo", required = true) String billNo) {

        return gcAccountRecordService.findGcAccountRecordByBillNo(billNo);

    }

}
