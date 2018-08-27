package com.jdz.entity;

public enum ImageType {

    SLIDESHOW_IMAGE("轮播图",1),
    INTRODUCE_IMAGE("公司介绍应用图",2),
    ENVIRONMENT_IMAGE("生产环境",3);

    private String typeName;

    private int statusCode;

    ImageType(String typeName,int statusCode){
        this.typeName = typeName;
        this.statusCode = statusCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
