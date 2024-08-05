package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
  @RequestMapping("/home")
  public String home(Model model) {
    model.addAttribute("name", "substring technologies");
    model.addAttribute("youtubeChannel", "Code with harsh");

    System.out.println("HOME PAGE HANDLER");
    return "home";

  }

  // about route
  @RequestMapping("/about")
  public String aboutPage() {
    System.out.println("ABOUT PAGE LOADING ");
    return "about";
  }

  // about route
  @RequestMapping("/services")
  public String servicePage() {
    System.out.println("SERIVCE PAGE LOADING");
    return "services";
  }

  // contact route
  @GetMapping("/contact")
  public String contact() {
    return new String("contact");
  }

  @GetMapping("login")
  public String login() {
    return new String("login");
  }

  @GetMapping("register")
  public String register() {
    return new String("register");
  }

}
