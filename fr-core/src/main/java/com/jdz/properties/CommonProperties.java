package com.jdz.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 19:40 2018/8/26
 * @ Description：
 * @ Modified By：
 */
@ConfigurationProperties(prefix = "com.jdz")
@Data
public class CommonProperties {

    private Oss oss;

}
