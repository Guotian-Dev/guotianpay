package com.guotianpay.user.rpc.api;

import com.guotianpay.user.dao.model.User;
import com.guotianpay.user.dao.model.UserCard;

/**
 * UserService Dubbo RPC服务接口声明类
 */
public interface UserService {
    /**
     * 根据会员 UID编号 查询会员信息
     *
     * @param uid 会员UID编号
     * @return 会员对象
     */
    public User findUserByUID(String uid);

    /**
     * 查询绑定的银行卡
     * @param id 银行卡ID
     * @return
     */
    public UserCard findUserCardById(String id);

    /**
     * 创建会员账户
     * @param user
     * @return
     */
    public int createUser(User user);

}
