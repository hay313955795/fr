package com.jdz.properties;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author lixiao
 * @Date 2018/8/27 15:43
 */
@Data
public class Email implements Serializable {

    private String sendTo;
}
