package com.example.domain;

public class Register {
	
	/** ID */
	private Integer id;
	/** 登録メールアドレス */
	private String mailAddress;
	/** パスワード */
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Register [id=" + id + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	

	



	
	

}
