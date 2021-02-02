package com.cloud.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.mp.entity.User;
import com.cloud.mp.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author: wxj
 * @Date: 2021-02-02 14:03
 */
public interface UserService extends IService<User> {


    PageUtils queryPage(Map<String,Object> map);

    List<User> queryAll1(Map<String, Object> map);

    List<User> queryAll2(Map<String, Object> map);
}
