package com.csuf;

import java.util.ArrayList;
import java.util.List;
/*import java.util.List;
import java.util.Map;
import javax.sql.DataSource;*/
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;*/
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	public static SessionFactory factory = ConnectionClass.getFactory();

/*	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;*/

/*	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}*/

	public void create(User user) {

		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public boolean isValidUser(String username, String password) {
/*		setDataSource(dataSource);*/
		Session session = factory.openSession();
		try {
			Criteria logincr = session.createCriteria(User.class);
			logincr.add(Restrictions.eq("username", username));
			logincr.add(Restrictions.eq("password", password));
			List<User> resultlist = new ArrayList<User>(logincr.list());
			if (!resultlist.isEmpty()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}

		/*
		 * // String SQL = "Select count(*) from usertable where username = '" +
		 * username + "' and password = '" + password // + "'"; // /* // *
		 * List<Map<String, Object>> lPersonMaps = // *
		 * jdbcTemplateObject.queryForList(SQL); //
		 */
		// // jdbcTemplateObject.queryForInt(SQL,new
		// Object[]{username,password},
		// // new UserMapper());
		// int i = jdbcTemplateObject.queryForInt(SQL);
		// if (i != 1)
		// return false;
		// else
		// return true;
		// /*
		/*
		 * * String uname = (String)getJdbcTemplate().queryForObject( SQL, new
		 * Object[] { userId, passId }, boolean.class);
		 * 
		 * return uname; PreparedStatement pstmt; try { pstmt =
		 * dataSource.getConnection().prepareStatement(SQL); pstmt.setString(1,
		 * username); pstmt.setString(2, password); ResultSet resultSet =
		 * pstmt.executeQuery(); if(resultSet.next()){ resultSet.next(); String
		 * fname = resultSet.getString("Firstname"); String lname =
		 * resultSet.getString("Lastname"); return (resultSet.getInt(1) > 0); }
		 * else return false; } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); return false; }
		 */
	}

	@SuppressWarnings("unchecked")
	public boolean verifyUser(String username) {
		/*setDataSource(dataSource);*/
		Session session = factory.openSession();
		try {
			Criteria logincr = session.createCriteria(User.class);
			logincr.add(Restrictions.eq("username", username));
			List<User> resultlist = new ArrayList<User>(logincr.list());
			if (resultlist.size() != 1) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return true;
		} finally {
			session.close();
		}

		/*
		 * String SQL = "Select count(*) from usertable where username = '" +
		 * username + "'";
		 * 
		 * List<Map<String, Object>> lPersonMaps =
		 * jdbcTemplateObject.queryForList(SQL);
		 * 
		 * // jdbcTemplateObject.queryForInt(SQL,new
		 * Object[]{username,password}, // new UserMapper()); int i =
		 * jdbcTemplateObject.queryForInt(SQL); if (i != 1) return false; else
		 * return true;
		 * 
		 * }
		 */
	}
}
