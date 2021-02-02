package com.cloud.mp.handler;

import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @Author: wxj
 *自动填充
 * @Date: 2020/5/11 0011 17:46
 */
public class MetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }



}
