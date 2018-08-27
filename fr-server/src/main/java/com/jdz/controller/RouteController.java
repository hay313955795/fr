package com.jdz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 路由，通过请求返回页面
 * @Author lixiao
 * @Date 2018/8/27 13:22
 */
@Controller
@RequestMapping("/manage")
@Slf4j
public class RouteController {


    @GetMapping("/index")
    public String index(){
        log.info("index");
        return "model/index";
    }
}
