package com.example.domain;

public class Register {
	
	/** ID */
	private Integer id;
	/** 登録者名 */
	private String name;
	/** パスワード */
	private String password;
	
	private Integer authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", password=" + password + ", authority=" + authority + "]";
	}
	
	

}
