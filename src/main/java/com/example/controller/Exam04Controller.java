package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam4/exam04";
	}

	@RequestMapping("/user-registration")
	public String userRegister(@Validated UserForm userForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return index();
		}

		User user = new User();
		user.setName(userForm.getName());
		user.setAge(userForm.getIntAge());
		user.setComment(userForm.getComment());
		System.out.println(user);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/exam04/toresult";
	}

	@RequestMapping("/toresult")
	public String toResult() {
		return "exam4/exam04-result";
	}
}
