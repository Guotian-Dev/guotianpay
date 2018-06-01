package com.guotianpay.user.dao.mapper;

import com.guotianpay.user.dao.model.UserCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户银行卡DAO
 * @author Longxing QIU
 * @since 2018-01-26
 */
@Repository
public interface UserCardDao {

    UserCard selectById(@Param("id") String id);
}
