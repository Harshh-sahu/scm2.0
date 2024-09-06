package com.scm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scm.services.EmailService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private EmailService kk;

	@Test
	void contextLoads() {
         
	}


	// @Autowired
	// private EmailService service;

	// @Test
	// void sendEmail(){
	// 	service.sendEmail("harshsahu1143@gmail.com", "Testing purpose", "this is scm project working on email service");
	// }




}
