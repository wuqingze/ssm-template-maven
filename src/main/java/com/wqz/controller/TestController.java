package com.wqz.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public void test(HttpServletResponse response) throws IOException {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("index.html");
		
//		return modelAndView;
//		InputStream in = TestController.class.getClassLoader().getResourceAsStream("index.html");
//		String s = TestController.class.getResource("").getPath();
//		response.getWriter().write("helloworld");
		String s= this.getClass().getClassLoader().getResource("").getPath();
		String path = s.substring(0,s.indexOf("classes/"));
		InputStream in = new FileInputStream(new File(path,"index.html"));
		byte[] b = new byte[in.available()];
		in.read(b);
		response.addHeader("content-type", "text/html;charset=utf-8");
		response.getOutputStream().write(b);
	}
	
	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("index.html");
		
//		return modelAndView;
//		InputStream in = TestController.class.getClassLoader().getResourceAsStream("index.html");
//		String s = TestController.class.getResource("").getPath();
//		response.getWriter().write("helloworld");
		String s= this.getClass().getClassLoader().getResource("").getPath();
		String path = s.substring(0,s.indexOf("classes/"));
		InputStream in = new FileInputStream(new File(path,"index.html"));
		byte[] b = new byte[in.available()];
		in.read(b);
		response.addHeader("content-type", "text/html;charset=utf-8");
		response.getOutputStream().write(b);
	}
}
