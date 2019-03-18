package com.wqz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/mytest")
	public String test() {
		
		return "hello";
	}
}
