package com.csuf;

import java.util.ArrayList;
import java.util.List;
/*import javax.sql.DataSource;
*/
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
*/
import org.springframework.stereotype.Component;

@Component
public class BloggerDao {

	public static SessionFactory factory = ConnectionClass.getFactory();
	
/*	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
*/
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	/*public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}*/

	public void create(Blog blog) {

		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(blog);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
/*		String SQL = "insert into userposts (Username, Title, Description, Cur_time) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, blog.getUserName(), blog.getTitle(), blog.getDescription(), blog.getDate());
		System.out.println("UserName= " + blog.getUserName() + " Title = " + blog.getTitle() + " Content = "
				+ blog.getDescription() + "Date = " + blog.getDate());
		return;*/

	}

	/* Code yet to be written */
	@SuppressWarnings({ "unchecked" })
	public List<Blog> listBlogs() {
		System.out.println("Getting Blogs DAO");
		
		Session session = factory.openSession();
		List<Blog> allList = new ArrayList<Blog>();
		try {
			Criteria allblogscr = session.createCriteria(Blog.class);
			allblogscr.addOrder(Order.desc("date"));
			allList = new ArrayList<Blog>(allblogscr.list());
			return allList;
		} catch (Exception e) {
				return allList;
				
		} finally {
			session.close();
		}
	/*	String SQL = "SELECT * from userposts order by Cur_time desc";
		return jdbcTemplateObject.query(SQL, new BlogRowMapper());
	*/}

	@SuppressWarnings("unchecked")
	public List<Blog> listBlogs(String username) {
		System.out.println("Getting Blogs DAO");
		
		Session session = factory.openSession();
		List<Blog> userList = new ArrayList<Blog>();
		try {
			Criteria userblogcr = session.createCriteria(Blog.class);
			userblogcr.add(Restrictions.eq("userName", username));
			userblogcr.addOrder(Order.desc("date"));
			userList = new ArrayList<Blog>(userblogcr.list());
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return userList;
		}finally {
			session.close();
		}
	/*	String SQL = "SELECT * from userposts WHERE username = '" + username + "' order by Cur_time desc ";
		return jdbcTemplateObject.query(SQL, new BlogRowMapper());
	*/}
}
