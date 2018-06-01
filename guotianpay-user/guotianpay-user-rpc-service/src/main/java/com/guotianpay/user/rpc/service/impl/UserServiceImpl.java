package com.guotianpay.user.rpc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guotianpay.user.dao.mapper.UserCardDao;
import com.guotianpay.user.dao.mapper.UserDao;
import com.guotianpay.user.dao.model.User;
import com.guotianpay.user.dao.model.UserCard;
import com.guotianpay.user.rpc.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserService Dubbo RPC服务提供者实现类
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCardDao userCardDao;

    @Override
    public User findUserByUID(String uid) {
        return userDao.selectByUID(uid);
    }

    @Override
    public UserCard findUserCardById(String id) {
        return userCardDao.selectById(id);
    }

    @Override
    public int createUser(User user) {
        return userDao.insert(user);
    }
}
