package com.ap.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;


public class TestController {
	

		@PostMapping("/test")
	 public String getTest(HttpServletRequest request) {

		            String msg = "I am Running... " ;
		            return msg;
		       
		}
}
