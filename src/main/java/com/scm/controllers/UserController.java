package com.scm.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    // user dashboard

      @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String userDashboard() {
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile(Model model, Authentication authentication) {

        return "user/profile";
    }
    // user add contact
    // user view contact
    // user delete contact

    // user search contact

}
