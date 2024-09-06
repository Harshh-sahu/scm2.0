

package com.scm.helper;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {



    public static String getEmailOfLoggedInUser(Authentication authentication)
    {


           //agar email id or pass se login kiya hai to hum email kaise nikalega 
if(authentication instanceof OAuth2AuthenticationToken){

   //sign in with google

       var aOAuth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;

        var clientid=    aOAuth2AuthenticationToken.
        getAuthorizedClientRegistrationId();
    String username="";

        var oauth2User = (OAuth2User)authentication.getPrincipal();
        if(clientid.equalsIgnoreCase("google")){


            System.out.println("GETTING EMAIL FOR GOOLE");
               username=  oauth2User.getAttribute("email").toString();


        }else if(clientid.equalsIgnoreCase("github")){


            String email = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
            : oauth2User.getAttribute("login").toString() + "@gmail.com";

            System.out.println("GETTING EMAIL FOR github"+email);

        }
   //sign in with facebook
   return username;

}else{

   System.out.println("GETTING DATA FROM SELF LOGGIN");
    return authentication.getName();
}
      
    }



    public static String getLinkedForEmailVerification(String emailToken){
        String link ="http://localhost:8081/auth/verify-email?token="+emailToken;

        return link;
    }
}
