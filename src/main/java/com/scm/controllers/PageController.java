package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
     @Autowired
    private UserService userService;

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

  @GetMapping("/register")
  public String register(Model model) {

    UserForm userForm = new UserForm();
   
    model.addAttribute("userForm", userForm);
    return "register";
  }

  //proccessing register 
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session, Model model) {
  
      System.out.println("Processing registration");
  
      // Check if there are any validation errors
      if (rBindingResult.hasErrors()) {
          model.addAttribute("userForm", userForm);
          return "register";
      }
  
      // Proceed with registration logic if no errors
      User user = new User();
      user.setName(userForm.getName());
      user.setEmail(userForm.getEmail());
      user.setPassword(userForm.getPassword());
      user.setAbout(userForm.getAbout());
      user.setPhoneNumber(userForm.getPhoneNumber());
      user.setProfilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?w=740&t=st=1723140620~exp=1723141220~hmac=747a6c4e99252915c8fb925169e89a42bcc03a6d378e053dee52678308aba8eb");
  
      User savedUser = userService.saveUser(user);
      System.out.println("User saved successfully");
  
      // Add the success message
      Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
      session.setAttribute("message", message);
  
      return "redirect:/register";
  }
  @PostMapping("/authenticate")
public String authenticateUser(@RequestParam String email, @RequestParam String password) {
    // Authentication logic
    return "redirect:/user/profile"; // or the appropriate redirect URL
}
  @RequestMapping("/")
  public String index(){

    return "redirect:/home";
  }

}
