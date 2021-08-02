package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam2/exam02";
	}
	
	@RequestMapping("/result")
	public String calc(Integer num1,Integer num2) {
		Integer ans = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num1);
		session.setAttribute("ans", ans);
		return "exam2/exam02-result";
	}
	
	@RequestMapping("/result2")
	public String result2() {
		return "exam2/exam02-result2";
	}
	
}
