package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Login;

@Repository
public class LoginRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Login> LOGIN_ROW_MAPPER = (rs,i) -> {
		Login login = new Login();
		login.setId(rs.getInt("id"));
		login.setMailAddress(rs.getString("mail_address"));
		login.setPassword(rs.getString("password"));
		return login;
	};
	
	/**
	 * ログインするためのリポジトリ.
	 * @param id
	 * @return
	 */
	public Login findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT id, mail_address, password FROM users WHERE mail_address = :mailAddress AND password = :password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		Login login = template.queryForObject(sql, param, LOGIN_ROW_MAPPER);
		return login;
	}

}
