package com.cloud.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.mp.dao.UserDao;
import com.cloud.mp.entity.User;
import com.cloud.mp.service.UserService;
import com.cloud.mp.utils.PageUtils;
import com.cloud.mp.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wxj
 * @Date: 2021-02-02 14:04
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, User>implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> map) {
        IPage<User> page = this.page(
                new Query<User>().getPage(map),
                new QueryWrapper<User>().select()
        );
        return  new PageUtils(page);
    }

    @Override
    public List<User> queryAll1(Map<String, Object> map) {
        String name = (String) map.get("name");
        String username = (String) map.get("username");
        List<User> users = baseMapper.selectList(new QueryWrapper<User>()
                .likeRight(StringUtils.isNotBlank(name), "name", name)
                .eq(StringUtils.isNotBlank(username), "username", username)
        );
        return users;
    }

    @Override
    public List<User> queryAll2(Map<String, Object> map) {
        String name = (String) map.get("name");
        String username = (String) map.get("username");

        List<User> users = baseMapper.selectList(new LambdaQueryWrapper<User>()
                .likeRight(StringUtils.isNotBlank(name), User::getName,name)
                .eq(StringUtils.isNotBlank(username), User::getUsername, username)
        );
        return users;
    }
}
