package com.csuf;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class BlogRowMapper implements RowMapper {

	public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
		Blog blogentry = new Blog();

		blogentry.setUserName(rs.getString("Username"));
		blogentry.setTitle(rs.getString("Title"));
		blogentry.setDescription(rs.getString("Description"));
		blogentry.setDate(rs.getTimestamp("Cur_time"));
		return blogentry;
	}
}
