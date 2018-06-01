package com.guotianpay.user.rpc.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guotianpay.user.dao.model.User;
import com.guotianpay.user.dao.model.UserCard;
import com.guotianpay.user.rpc.api.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

//    @Reference(version = "1.0.0")
//    CityDubboService cityDubboService;

//    @Autowired
//    private BubiConfig myConfig;
//
    //引用GoldChain Dubbo服务
    @Reference(version = "1.0.0")
    private UserService userService;

//    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
//    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
//        return cityDubboService.findCityByName(cityName);
//    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findOneUser(@RequestParam(value = "uid", required = true) String uid) {
        return userService.findUserByUID(uid);
    }

    @RequestMapping(value = "/api/user/usercard", method = RequestMethod.GET)
    public UserCard findOneUserCard(@RequestParam(value = "id", required = true) String id) {
        return userService.findUserCardById(id);
    }

    @RequestMapping(value = "/api/user/createUser", method = RequestMethod.GET)
    public User createUser(@RequestParam(value = "uid", required = true) String uid) {
        User user = new User();
        user.setUid(uid);
        user.setNickName("abc"+uid);
        user.setPassword("1234343543");
        user.setBubiAddress("21afasdfdasfdasf");
        user.setMobile("123455");
        user.setEmail("8126347@qq.com");
        user.setPaymentCode("123343434");
        user.setStatus(1);
        user.setType(4);
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userService.createUser(user);
        return userService.findUserByUID(uid);
    }
}