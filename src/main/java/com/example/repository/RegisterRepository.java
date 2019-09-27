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
		register.setName(rs.getString("name"));
		register.setPassword(rs.getString("password"));
		register.setAuthority(rs.getInt("authority"));
		return register;
	};
	
	/**
	 * ユーザー登録のリポジトリ.
	 * @param register
	 */
	public void insert(String name, String password) {
		String sql = "INSERT INTO users(name, password, authority) VALUES(:name, :password, :authority)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name).addValue("password", password);
		template.update(sql, param);
	}

}
