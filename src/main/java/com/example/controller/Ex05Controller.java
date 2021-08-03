package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@Transactional
@RequestMapping("/exam05")
public class Ex05Controller {

	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam5/exam05";
	}

	@RequestMapping("/name-search")
	public String nameSearch(String name, Model model) {
		List<Member> memberList = new ArrayList<>();
		memberList = repository.findByName(name);
		model.addAttribute("memberList", memberList);
		return "exam5/exam05-result";
	}
}
