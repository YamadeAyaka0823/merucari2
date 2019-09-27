package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.form.RegisterForm;
import com.example.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("")
	public String index() {
		return "register";
	}
	
	/**
	 * ユーザー登録.
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(RegisterForm form, Model model) {
		registerService.insert(form);
		return "login";
	}

}
