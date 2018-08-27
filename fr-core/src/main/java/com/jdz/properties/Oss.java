package com.jdz.properties;

import lombok.Data;

/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 19:43 2018/8/26
 * @ Description：application.yml中oss对应的属性
 * @ Modified By：
 */
@Data
public class Oss {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;


}
