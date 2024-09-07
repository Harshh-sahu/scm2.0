package com.scm.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.scm.forms.EmailRequest;
import com.scm.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmailController {
  

@Autowired
    private EmailService emailService;






@PostMapping("/send-email")
public String postMethodName(@RequestBody EmailRequest emailRequest) {
    //TODO: process POST request
  
    



    String to = "harshsahu1143@gmail.com";  // Your email
    String subject = "Contact Form Submission from " + emailRequest.getName();
    String body = "You have received a new message from " + emailRequest.getName() +
            " (" + emailRequest.getEmail() + "):\n\n" +
            emailRequest.getMessage();

    emailService.sendEmail(to, subject, body);
    return "Email sent successfully";
}





}
