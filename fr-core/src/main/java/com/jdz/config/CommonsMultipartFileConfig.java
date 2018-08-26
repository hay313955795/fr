package com.jdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 20:13 2018/8/26
 * @ Description：
 * @ Modified By：
 */
@Configuration
public class CommonsMultipartFileConfig {

    private static final Long MAX_UPLOAD_SIZE = 20971520l;

    private static final Integer MAX_INMEMORY_SIZE = 1048576;

    /**
     * 配置用于 springmvn 中 CommonsMultipartFile 对象转换
     * @return
     */
//    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new  CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(1048576);
//        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }
}
