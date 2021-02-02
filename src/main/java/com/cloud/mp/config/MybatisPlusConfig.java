
package com.cloud.mp.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.cloud.mp.handler.MetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wxj
 * @Date: 2020/5/14 0011 11:23
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    /**
     * 自动填充
     */
    @Bean
    public com.baomidou.mybatisplus.core.handlers.MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler();
    }

}
