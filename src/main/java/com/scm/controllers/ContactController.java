package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.forms.ContactForm;
import com.scm.helper.Helper;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.ContactService;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller

@RequestMapping("/user/contacts")
public class ContactController {

    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;

    // add contact page Handler
    @RequestMapping("/add")
    public String addContactView(Model model) {
        ContactForm contactForm = new ContactForm();
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";

    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm, 
                              BindingResult result, 
                              Authentication authentication, 
                              Model model,HttpSession httpSession) {


        if (result.hasErrors()) {
            model.addAttribute("contactForm", contactForm);
            model.addAttribute("org.springframework.validation.BindingResult.contactForm", result);
 
            httpSession.setAttribute("message", Message.builder().content("please correct the following error").type(MessageType.red)
            .build());

            return "user/add_contact";  // Return to the same view if there are errors
        }
    
        // Proceed with saving the contact if there are no errors
        String username = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(username);
    
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setFavorite(contactForm.isFavorite());
        contact.setEmail(contactForm.getEmail());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setUser(user);
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setLinkedInLink(contactForm.getLinkedInLink());
        contact.setWebsiteLink(contactForm.getWebsiteLink());
    
        contactService.save(contact);
        httpSession.setAttribute("message", Message.builder().content("You have successfully add a new contact").type(MessageType.green)
        .build());
        
        return "redirect:/user/contacts/add";
    }
    

}