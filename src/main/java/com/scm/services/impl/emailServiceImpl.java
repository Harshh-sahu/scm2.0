package com.scm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.scm.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;


@Service
public class emailServiceImpl implements EmailService{


    @Autowired
    private JavaMailSender eMailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {
                

        
        SimpleMailMessage message = new SimpleMailMessage();
message.setTo(to);
message.setSubject(subject);
message.setText(body);


eMailSender.send(message);


    }
  @Override
    public void sendEmailWithHtml(String to, String subject, String htmlBody) {
        MimeMessage mimeMessage = eMailSender.createMimeMessage();
        try {
            // Use MimeMessageHelper for sending HTML content
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);  // Set 'true' for HTML content
            eMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception (log it or rethrow it)
            e.printStackTrace();
        }
    }


    @Override
    public void sendEmailWithAttachment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmailWithAttachment'");
    }

    
} 