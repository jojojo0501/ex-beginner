package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam3/exam03";
	}
	
	@RequestMapping("/calc-total-price")
	public String calcTotalPrice(Integer price1,Integer price2,Integer price3) {
		int subTotalPrice = price1 + price2 + price2;
		int tax = (int)(subTotalPrice * 0.1);
		int totalPrice = subTotalPrice + tax;
		application.setAttribute("subTotalPrice", subTotalPrice);
		application.setAttribute("totalPrice", totalPrice);
		return "exam3/exam03-result";
	}
}
