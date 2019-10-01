package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Login;
import com.example.form.LoginForm;
import com.example.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	

	
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}
	
	/**
	 * ログイン画面.
	 * @return
	 */
	@RequestMapping("")
	public String index() {
		return "login";
	}
	
	/**
	 * ログイン成功したら商品一覧へ.
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@Validated LoginForm form, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return index();
		}
		

			Login login = loginService.load(form);
			model.addAttribute("login", login);
			return "forward:/item/list";


	}

}
