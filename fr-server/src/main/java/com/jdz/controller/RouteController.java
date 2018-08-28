package com.jdz.controller;

import com.jdz.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private EmailService emailService;


    @GetMapping("/index")
    public String index(){
        log.info("index");
        emailService.HtmlConverStringAndSend("13736715200@163.com");
        return "model/index";
    }







}
