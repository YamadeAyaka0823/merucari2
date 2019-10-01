package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Login;
import com.example.form.LoginForm;
import com.example.repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	/**
	 * ログインするためのサービス.
	 * @param form
	 * @return
	 */
	public Login load(LoginForm form) {
		Login login = loginRepository.findByMailAddressAndPassword(form.getMailAddress(), form.getPassword());
		return login;
	}

}
