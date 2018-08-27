package com.jdz.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;
import com.jdz.properties.CommonProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;


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


    /**
     * 是否设置图片url路径有效时间
     */
    private static final boolean IS_IMAGE_PRIVATE = false;

    /**
     * 图片url路径的有效时间
     */
    private static final Long IMAGE_VAILD_TIME = 3600L * 1000 * 24 * 365 * 10;



    public String upload2Oss(InputStream is, String saveFileName) {

        String endpoint = commonProperties.getOss().getEndpoint();
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = commonProperties.getOss().getAccessKeyId();
        String accessKeySecret = commonProperties.getOss().getAccessKeySecret();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        ossClient.putObject(commonProperties.getOss().getBucketName(), saveFileName, is);
        Date expiration = new Date(System.currentTimeMillis() + IMAGE_VAILD_TIME);

        String url = getImageUrl(ossClient.generatePresignedUrl(commonProperties.getOss().getBucketName(),saveFileName,expiration),IS_IMAGE_PRIVATE);
        // 关闭OSSClient。
        ossClient.shutdown();
        return url;
    }

    /**
     * 截取。过滤掉url的有效时间
     * @param url
     * @return
     */
    public String getImageUrl(URL url,boolean isPrivate){
        String imageUrl = url.toString();
        if(!isPrivate){
            imageUrl = StringUtils.substringBefore(imageUrl, "?");
        }


        return imageUrl;
    }

}
