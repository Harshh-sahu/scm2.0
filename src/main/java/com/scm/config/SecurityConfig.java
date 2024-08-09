package com.scm.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
     //user create and login java code with in memory service

//     @Bean
//     public UserDetailsService userDetailsService(){
//     UserDetails user1= User
//             .withDefaultPasswordEncoder().username("admin123").password("admin123")
//           .build();
//
//         UserDetails user2= User.withDefaultPasswordEncoder().username("user123").password("password")
//                 .roles("ADMIN","USER").build();
//         return new InMemoryUserDetailsManager(user1,user2);
//     }

}
