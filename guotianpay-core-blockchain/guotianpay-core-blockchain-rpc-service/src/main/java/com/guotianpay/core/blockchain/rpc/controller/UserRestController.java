package com.guotianpay.core.blockchain.rpc.controller;

//import com.alibaba.dubbo.config.annotation.Reference;
import com.guotianpay.core.blockchain.rpc.api.BlockChainAccountService;
//import com.guotianpay.user.dao.model.User;
//import com.guotianpay.user.dao.model.UserCard;
//import com.guotianpay.user.rpc.api.UserService;
import com.guotianpay.core.blockchain.rpc.api.GPayCoinService;
import com.guotianpay.core.blockchain.rpc.config.MyGethConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

//    @Reference(version = "1.0.0")
//    CityDubboService cityDubboService;

    @Autowired
    private BlockChainAccountService blockChainAccountService;

    @Autowired
    private GPayCoinService gPayCoinService;

    @Autowired
    private MyGethConfig myGethConfig;

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
    public GPayUser findOneUserCard(@RequestParam(value = "id", required = true) String id) {
        //return userService.findUserCardById(id);
        GPayUser gPayUser = new GPayUser();
        gPayUser.setAddress("ssss");
        gPayUser.setUserName("0000000000");
//        List<String> list = gPayChainAccountService.queryAccountList();
//
//        for(String address : list){
//            System.out.println("address="+address);
//        }

        gPayCoinService.deployContract();


        return gPayUser;
    }

    @RequestMapping(value = "/api/user/pay", method = RequestMethod.POST)
    public GPayUser pay(@RequestParam(value = "from", required = true) String from,
                        @RequestParam(value = "password", required = true) String password,
                        @RequestParam(value = "to", required = true) String to,
                        @RequestParam(value = "amount", required = true) String amount) {
        //return userService.findUserCardById(id);
        System.out.println("from="+from);
        System.out.println("password="+password);
        System.out.println("to="+to);
        System.out.println("amount="+amount);

        GPayUser gPayUser = new GPayUser();
        gPayUser.setAddress("ssss");
        gPayUser.setUserName("0000000000");
//        List<String> list = gPayChainAccountService.queryAccountList();
//
//        for(String address : list){
//            System.out.println("address="+address);
//        }

        BigInteger tanAmount = new BigInteger(amount);
        //gPayCoinService.transferFrom(from,password,to,tanAmount);
        try {
            gPayCoinService.transfer(to, tanAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return gPayUser;
    }


    @RequestMapping(value = "/api/getMyGethConfig", method = RequestMethod.GET)
    public MyGethConfig getMyGethConfig() {
        return myGethConfig;
    }

    @RequestMapping(value = "/api/gpc/balanceOf", method = RequestMethod.POST)
    public GPayUser balanceOf(@RequestParam(value = "address", required = true) String address) {
        //return userService.findUserCardById(id);
        GPayUser gPayUser = new GPayUser();
        gPayUser.setAddress("ssss");
        gPayUser.setUserName("0000000000");
        try {
            BigInteger amount = gPayCoinService.balanceOf(address);
            System.out.println("address="+address+" balanceOf= "+amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gPayUser;
    }



    class GPayUser{
        private String address;
        private String userName;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }



}