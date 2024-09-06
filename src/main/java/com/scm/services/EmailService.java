package com.scm.services;

public interface EmailService {



    void sendEmail(String to, String subject, String body);

    void sendEmailWithHtml(String to, String subject, String htmlBody);

void sendEmailWithAttachment();

    
} 