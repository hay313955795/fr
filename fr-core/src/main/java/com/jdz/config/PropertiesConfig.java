package com.jdz.config;

import com.jdz.properties.CommonProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 19:46 2018/8/26
 * @ Description：读取配置文件中需要的配置
 * @ Modified By：
 */
@Configuration
@EnableConfigurationProperties({CommonProperties.class})
public class PropertiesConfig {
}
