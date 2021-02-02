package com.cloud.mp;

import com.alibaba.fastjson.JSON;
import com.cloud.mp.entity.User;
import com.cloud.mp.service.UserService;
import com.cloud.mp.utils.Builder;
import com.cloud.mp.utils.MapUtils;
import com.cloud.mp.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wxj
 * @Date: 2021-02-02 14:06
 */
@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;
    /***
     * 新增用户
     */
    @Test
    public void  userSave(){
        User user = Builder.of(User::new)
                .with(User::setName, "隔壁老王")
                .with(User::setUsername, "wxj")
                .with(User::setPassword, "123456")
                .with(User::setFlag, 0)
                .build();
        userService.save(user);
    }
    /***
     * 通过ID修改
     */
    @Test
    public void  userUpdate(){
        User user = userService.getById(115645646449648489L);
        user.setPassword("654321");
        userService.updateById(user);
    }
    /***
     * 通过ID修改
     */
    @Test
    public void  userDel(){
        userService.removeById(115645646449648489L);
    }

    /***
     * 分页查找
     */
    @Test
    public void  userPage(){
        Map<String, Object> map = new HashMap<>();
        map.put("limit","100");
        map.put("page","1");
        PageUtils pageUtils = userService.queryPage(map);
        log.info("分页：{}", JSON.toJSONString(pageUtils));
    }


    /***
     * 多参数查找
     */
    @Test
    public void  userSelect1(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","隔壁老王");
        map.put("username","wxj");
        List<User> users = userService.queryAll1(map);
        users.stream().forEach(e->{
            log.info(e.toString());
        });
    }

    /***
     * 多参数Lambda查找
     */
    @Test
    public void  userSelect2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","隔壁老王");
        map.put("username","wxj");
        List<User> users = userService.queryAll2(map);
    }

    /**
     * map删除
     */
    @Test
    public void  usersDel(){
        userService.removeByMap(new MapUtils().put("username", "wxj").put("password","123456"));
    }


}
