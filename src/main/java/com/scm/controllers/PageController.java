package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
      model.addAttribute("name", "substring technologies");
      model.addAttribute("youtubeChannel", "Code with harsh");

        System.out.println("HOME PAGE HANDLER");
        return "home";

    }

}
