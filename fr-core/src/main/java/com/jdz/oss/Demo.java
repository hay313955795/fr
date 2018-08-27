package com.jdz.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {

        String endpoint = "http://oss-cn-hongkong.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAIdCfUaCod4okJ";
        String accessKeySecret = "vtOHJWF5ZZWo7pn0I9BuCv7nAxb8ez";
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流。
        File file = new File("/Users/three/Downloads/docker-happy-french-bastille-day-2016.jpg");
        InputStream inputStream = new FileInputStream(file);
        PutObjectResult fastener = ossClient.putObject("fastener", "dokcer.jpg", inputStream);

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        URL fastener1 = ossClient.generatePresignedUrl("fastener", "dokcer.jpg", expiration);
        System.out.println(fastener1.toString());
        System.out.println(fastener.getETag());
// 关闭OSSClient。
        ossClient.shutdown();
    }
}
