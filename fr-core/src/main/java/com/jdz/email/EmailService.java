package com.jdz.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @Description
 * @Author lixiao
 * @Date 2018/8/27 17:19
 */
@Component("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSimpleMail(String sendTo,String message){
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("apple123908@163.com");
            helper.setTo(sendTo);
            helper.setSubject("标题标题部分");

            StringBuffer sb = new StringBuffer();
            sb.append(message);
            helper.setText(sb.toString(), true);
//            FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\76678.pdf"));
//            helper.addAttachment("电子发票"，fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取邮件模版并修改参数并渲染成String发送
     * @param SendTo
     */
    public void HtmlConverStringAndSend(String SendTo){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            //获取模板html文档
            String path = this.getClass().getClassLoader().getResource("templates/mail/ftl/mail.html").getPath();
            System.out.println(path);
            document = reader.read(path);

            Element root = document.getRootElement();

            //分别获取id为address、user的节点。
            Element address = getNodes(root,"id","address");
            Element user = getNodes(root,"id","user");

            //插入数据
            address.setText("龙湾");
            user.setText("背景");
        this.sendSimpleMail(SendTo,document.asXML());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Element getNodes(Element node, String attrName, String attrValue) {

        /**
         * 当前节点的所有属性
         */
        final List<Attribute> listAttr = node.attributes();
        /**
         * 遍历当前节点的所有属性
         */
        for (final Attribute attr : listAttr) {
            /**
             * 属性名称
             */
            final String name = attr.getName();
            /**
             * 属性的值
             */
            final String value = attr.getValue();

            if(attrName.equals(name) && attrValue.equals(value)){
                return node;
            }
        }
        /**
         * 递归遍历当前节点所有的子节点
         * 所有一级子节点的list
          */
        final List<Element> listElement = node.elements();
        /**
         * 遍历所有一级子节点
         */
        for (Element e : listElement) {
            Element temp = getNodes(e,attrName,attrValue);
            // 递归
            if(temp != null){
                return temp;
            }
        }

        return null;
    }




}
