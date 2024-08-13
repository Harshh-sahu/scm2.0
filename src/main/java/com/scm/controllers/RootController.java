package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@ControllerAdvice
public class RootController {


    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService  userService;
  @ModelAttribute
    public void addLoginUserInformation(Model model, Authentication authentication) {

        if(authentication == null){
            return ;
        }

        System.out.println("ADDING LOGGED IN USER INFORMATION TO THE MODEL");
        String username = Helper.getEmailOfLoggedInUser(authentication);

        User user = userService.getUserByEmail(username);
        System.out.println(user);
      
            System.out.println(user.getName());
            System.out.println(user.getEmail());
    
            model.addAttribute("loggedInUser", user);
           

        logger.info("user loggerd in  " + username + " No user");

    }


  

}
