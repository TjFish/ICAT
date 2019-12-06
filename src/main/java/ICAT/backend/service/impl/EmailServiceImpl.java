package ICAT.backend.service.impl;

import ICAT.backend.service.EmailService;
import ICAT.backend.utils.ImageBase64Util;
import ICAT.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
@Async
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private void sendMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(new InternetAddress(sender, "ICAT", "UTF-8"));
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new ServiceException("邮件发送失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private String createImageContent() {
        String img = null;
         try {
             img=ImageBase64Util.imageToBase64("logo.png");
        } catch (IOException e) {
            System.out.println("logo.png 未找到");
        }
        return "<img src=" + img + ">";
    }

    public void sendReisterEmail(String to,String verifyCode){
        String subject="欢迎注册ICAT";
        String content=createImageContent();
        content+="<p>【ICAT】您的邮箱验证码为：" + verifyCode + "</p>" +
                "<p>注册ICAT，遍览同济猫咪</p>";
        sendMail(to,subject,content);
    }

    public void senChangPWDEmali(String to,String verifyCode){

        String subject="ICAT密码修改";
        String content=createImageContent();
         content+="<p>【ICAT】您的邮箱验证码为：" + verifyCode + "</p>" +
                "<p>您的 ICAT 账号正在重置密码，若非本人操作请及时登录处理。</p>";
        sendMail(to,subject,content);
    }

}
