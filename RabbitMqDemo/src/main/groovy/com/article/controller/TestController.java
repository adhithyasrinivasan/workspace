package com.article.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.article.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(method={RequestMethod.GET},value={"/test"})
	public String testMethod(){
		
			 return testService.testMethod();
		
	}
	@RequestMapping(method={RequestMethod.GET},value={"/jwt/test"})
	public String testJWT(HttpServletRequest request, @RequestHeader Map<String,String> headers){
		String remote=request.getRemoteUser();
		String head=headers.get("REMOTE_USER");
		System.out.println(headers);
		System.out.println("Head "+head);
		System.out.println("Header remote "+remote);
			 return testService.testJWT();
	}
	
	@GetMapping("/sso")
	public String test(HttpServletRequest request, @RequestHeader Map<String, String> headers) {
		System.out.println("-- testing ctrl");
		System.out.println(headers);
		
		
		String u1=request.getRemoteUser();
		
		
		return "--"+u1+"--"+headers.toString();
	}
	
}
