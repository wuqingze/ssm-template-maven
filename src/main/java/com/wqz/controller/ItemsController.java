package com.wqz.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ItemsController {
	
	@RequestMapping("/list")
	public void itemsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.getWriter().write("hello world");
		
	}
	
}
