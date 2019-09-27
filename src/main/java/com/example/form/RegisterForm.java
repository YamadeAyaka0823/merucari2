package com.example.form;

public class RegisterForm {
	
	/** 登録者名 */
	private String name;
	/** パスワード */
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "RegisterForm [name=" + name + ", password=" + password + "]";
	}
	
	
	
	

}
