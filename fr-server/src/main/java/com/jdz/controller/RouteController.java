package com.jdz.controller;

import com.jdz.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.xml.ws.Action;


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
        send();
        return "model/index";
    }


    public void send(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            //获取模板html文档
            String path = RouteController.class.getClassLoader().getResource("templates/mail/ftl/mail.html").getPath();
            System.out.println(path);
            document = reader.read(path);

            Element root = document.getRootElement();

            System.out.println(root);
            //分别获取id为name、message、time的节点。
            //Element name = getNodes(root,"id","name");
            //Element message = getNodes(root,"id","message");
            //Element time = getNodes(root, "id", "time");

            //设置收件人姓名，通知信息、当前时间
            /*Calendar calendar = Calendar.getInstance();
            time.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE));
            name.setText("小明");
            //随便写的
            message.setText("因为您、我有缘，所以才能共结一个圆。为进一步优化教育环境，"
                    + "加强家校互动，共同促进学生的成长和进步，本着家校共育的精神，我校决定召开高一家长会，"
                    + "希望你在百忙中抽出时间，拨冗光临，对孩子在家和在校的表现与各班主任进行深入的面对面交流，"
                    + "针对每个孩子的不同特点，与老师共同商讨教育孩子的策略，最大程度的促进您孩子的进步。");

            //保存到临时文件
            FileWriter fwriter = new FileWriter("d:/temp.html");
            XMLWriter writer = new XMLWriter(fwriter);
            writer.write(document);
            writer.flush();
            //读取临时文件，并把html数据写入到字符串str中，通过邮箱工具发送
            FileReader in = new FileReader("d:/temp.html");
            char[] buff = new char[1024*10];
            in.read(buff);
            String str = new String(buff);
            System.out.println(str.toString());
            */
           // new MailSender.Builder(document.getText();,"xxx@qq.com").send();
            System.out.println("11");
            System.out.println(document.asXML());
            emailService.sendSimpleMail("13736715200@163.com",document.asXML());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Element getNodes(Element node, String attrName, String attrValue) {

        final List<Attribute> listAttr = node.attributes();// 当前节点的所有属性
        for (final Attribute attr : listAttr) {// 遍历当前节点的所有属性
            final String name = attr.getName();// 属性名称
            final String value = attr.getValue();// 属性的值
            System.out.println("属性名称：" + name + "---->属性值：" + value);
            if(attrName.equals(name) && attrValue.equals(value)){
                return node;
            }
        }
        // 递归遍历当前节点所有的子节点
        final List<Element> listElement = node.elements();// 所有一级子节点的list
        for (Element e : listElement) {// 遍历所有一级子节点
            Element temp = getNodes(e,attrName,attrValue);
            // 递归
            if(temp != null){
                return temp;
            };
        }

        return null;
    }


}
