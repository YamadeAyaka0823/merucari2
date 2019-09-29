package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Register;

@Repository
public class RegisterRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Register> REGISTER_ROW_MAPPER = (rs,i) -> {
		Register register = new Register();
		register.setId(rs.getInt("id"));
		register.setMailAddress(rs.getString("mail_address"));
		register.setPassword(rs.getString("password"));
		return register;
	};
	
	/**
	 * ユーザー登録のリポジトリ.
	 * @param register
	 */
	public void insert(String mailAddress, String password) {
		String sql = "INSERT INTO users(mail_address, password) VALUES(:mailAddress, :password)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		template.update(sql, param);
	}

}
