package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.repositories.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    // verify email
    @GetMapping("/verify-email")
    public String verifyEmail(
            @RequestParam("token") String token,HttpSession httpSession) {

        User user = userRepo.findByEmailToken(token).orElse(null);
        if (user != null) {
            // user fetch hua hai
            if (user.getEmailToken().equals(token)) {
                user.setEmailVerified(true);
                user.setEnabled(true);
                userRepo.save(user);
                httpSession.setAttribute("message", Message.builder().content("Email was verified ").type(MessageType.green).build());
                return "success_page";

            }
            return "error_page";

        }
        httpSession.setAttribute("message", Message.builder().content("Email not verified !token was not associated with user").type(MessageType.red).build());
        return "error_page";
    }

}
