package com.jdz.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;
import com.jdz.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;


/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 19:52 2018/8/26
 * @ Description：
 * @ Modified By：
 */
@Component("oosCli")
public class OssCli {

    @Autowired
    private CommonProperties commonProperties;


    public String upload2Oss(InputStream is, String saveFileName) {

        String endpoint = commonProperties.getOss().getEndpoint();
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = commonProperties.getOss().getAccessKeyId();
        String accessKeySecret = commonProperties.getOss().getAccessKeySecret();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        PutObjectResult result = ossClient.putObject(commonProperties.getOss().getBucketName(), saveFileName, is);
        // 关闭OSSClient。
        ossClient.shutdown();
        ResponseMessage response = result.getResponse();
        response.getUri();
        return "";
    }

}
