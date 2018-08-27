package com.jdz.entity;

import lombok.Data;

/**
 * @Description
 * @Author lixiao
 * @Date 2018/8/27 14:27
 */
@Data
public class Image {

    private String imageName;

    private Integer height;

    private Integer width;

    private String url;

    private Long size;

    private ImageType imageType;

    /**
     * 是否弃用（记录不删除）
     */
    private boolean isUse;


}
