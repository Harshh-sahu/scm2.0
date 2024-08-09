package com.scm.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
   public static void removeMessage(){
    try {

        System.out.println("removing message formsession");
      
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        session.removeAttribute("message");
        
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("error remove messafe in sessionHelper");
        e.printStackTrace();
    }
      
   }
}
