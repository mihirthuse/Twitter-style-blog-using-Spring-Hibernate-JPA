package com.csuf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFirstName(rs.getString("Firstname"));
		user.setLastName(rs.getString("Lastname"));
		user.setUserName(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
		return user;
	}
}
