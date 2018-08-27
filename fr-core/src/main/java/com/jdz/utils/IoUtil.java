package com.jdz.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description
 * @Author lixiao
 * @Date 2018/8/27 08:33
 */
public class IoUtil {


    /**
     * 获取文件的后缀
     * @param multipartFile
     * @return  文件类型。没有.
     */
    public static String getFileSuffix(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        return StringUtils.substringAfter(originalFilename, ".");
    }
}
