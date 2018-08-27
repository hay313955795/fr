package com.jdz.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description
 * @Author lixiao
 * @Date 2018/8/27 17:19
 */
@Component("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSimpleMail(String sendTo,String aa){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("apple123908@163.com");
            helper.setTo(sendTo);
            helper.setSubject("标题标题部分");

            StringBuffer sb = new StringBuffer();
            sb.append(aa);
            helper.setText(sb.toString(), true);
//            FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\76678.pdf"));
//            helper.addAttachment("电子发票"，fileSystemResource);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
