package com.cloud.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wxj
 * @Date: 2021-02-02 14:03
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
