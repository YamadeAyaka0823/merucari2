package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Register;
import com.example.form.RegisterForm;
import com.example.repository.RegisterRepository;

@Service
@Transactional
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	/**
	 * ユーザー登録のサービス.
	 * @param register
	 */
	public void insert(RegisterForm form) {
		registerRepository.insert(form.getName(), form.getPassword());
	}

}