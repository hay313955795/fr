package com.jdz.web;

import com.jdz.dto.ImageDto;
import com.jdz.oss.OssCli;
import com.jdz.properties.CommonProperties;
import com.jdz.utils.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.IOException;
import java.io.InputStream;

/**
 * @ Author     ：lixiao.
 * @ Date       ：Created in 19:45 2018/8/26
 * @ Description：
 * @ Modified By：
 */
@RestController
@Slf4j
public class ConController {

    @Autowired
    private CommonProperties commonProperties;

    @Autowired
    private OssCli ossCli;

    @GetMapping("getCon")
    public String get(){
        System.out.println(commonProperties);
        return "1";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("image")MultipartFile file, ImageDto imageDto) throws IOException {

        InputStream is = file.getInputStream();

        String fileSuffix = IoUtil.getFileSuffix(file);
        String url = ossCli.upload2Oss(is, imageDto.getImageName()+"."+fileSuffix);

        log.info("测试返回的url:{},图片名称：{}",url,imageDto.getImageName());

        return "upload";
    }
}
