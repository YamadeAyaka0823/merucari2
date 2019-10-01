package com.example.domain;

public class Login {
	
	/** ID */
	private Integer id;
	/** メールアドレス */
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
		return "Login [id=" + id + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	

}
