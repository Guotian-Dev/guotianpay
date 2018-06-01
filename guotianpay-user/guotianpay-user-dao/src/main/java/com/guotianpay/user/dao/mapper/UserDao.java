package com.guotianpay.user.dao.mapper;

import com.guotianpay.user.dao.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 查询用户 By 用户ID
     * @param uid
     * @return
     */
    User selectByUID(@Param("uid") String uid);

    /**
     * 插入一条用户记录
     * @param record
     * @return
     */
    int insert(@Param("record") User record);
}
