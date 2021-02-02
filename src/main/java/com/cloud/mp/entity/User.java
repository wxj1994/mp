package com.cloud.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: wxj
 * @Date: 2021-02-02 14:02
 */


/****表名
 *  @TableName----  value(表名)
 * ***/
@TableName(value = "user")
@Data
public class User {

    /****主键字段
     *  在配置文件统一了配置这里不需要再配置
     *  另一种写法：@TableId(type=IdType.ASSIGN_ID)               # ASSIGN_ID 雪花算法生成的ID   #AUTO 数据库ID自增   #ASSIGN_UUID  uuid           #INPUT 自行设置ID
     * ***/
    @TableId
    private Long  id;


    private String name;

    private String username;

    private String password;

    /****是否为数据库表字段
     *
     * ***/
    @TableField(exist = false)
    private String roleName;

    /****逻辑删除
     *  在配置文件统一了配置这里不需要再配置
     *  另一种写法：  @TableLogic(value = "0",delval = "1")
     * ***/
    @TableLogic
    private int flag;

    /****自动填充
     *  插入填充
     * ***/
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /****自动填充
     *  修改填充
     * ***/
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
