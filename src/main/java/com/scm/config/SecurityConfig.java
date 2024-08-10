package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {
     // user create and login java code with in memory service

     // @Bean
     // public UserDetailsService userDetailsService(){
     // UserDetails user1= User
     // .withDefaultPasswordEncoder().username("admin123").password("admin123")
     // .build();
     //
     // UserDetails user2=
     // User.withDefaultPasswordEncoder().username("user123").password("password")
     // .roles("ADMIN","USER").build();
     // return new InMemoryUserDetailsManager(user1,user2);
     // }

      @Autowired
     private SecurityCustomUserDetailService userDetailService;



@Bean
     public DaoAuthenticationProvider authenticationProvider() {



          
          DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
          //user detail service ka object
          daoAuthenticationProvider.setUserDetailsService(userDetailService);

          //password encoder ka object
          daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
          return daoAuthenticationProvider;

     
     }

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

           httpSecurity.authorizeHttpRequests(authorize->{
               // authorize.requestMatchers("/home","/register","/services").permitAll();

               authorize.requestMatchers("/user/**").authenticated();
               authorize.anyRequest().permitAll();
           });
           httpSecurity.formLogin(Customizer.withDefaults());
   return httpSecurity.build();
   

     }

     @Bean
     public PasswordEncoder passwordEncoder(){

          return new BCryptPasswordEncoder();
     }

}
