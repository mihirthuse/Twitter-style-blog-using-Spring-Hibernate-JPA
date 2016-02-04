package com.csuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/*import java.util.LinkedHashMap;*/
import java.util.List;
/*import java.util.Map;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
*/
/**
 * Servlet implementation class BlogServlet
 */
public class BlogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2303173327148045006L;
	private volatile int BLOG_ID_SEQUENCE = 1;
/*
	ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

	BloggerDao blogdao = (BloggerDao) context.getBean("blogDao");
	UserDao userdao = (UserDao) context.getBean("userDao");*/

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	BloggerDao blogdao = new BloggerDao();
	UserDao userdao = new UserDao();
	public BlogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// to know what to perform, if no action is specified then display
		// public home page

		String action = request.getParameter("action");
		int total = BLOG_ID_SEQUENCE;
		total--;
		for (int i = total; i > 0; i--) {
			// Blog display = blogDatabase.get(i);
			// List<Blog> display=new
			// ArrayList<Blog>(blogDatabase.get(request.getSession().getAttribute("username")));
			/*
			 * System.out.println(display.getUserName()+" ");
			 * System.out.println(display.getTitle()+"  "+display.getDate());
			 */
		}
		// System.out.println("end of db");
		List<Blog> bloglist = new ArrayList<Blog>();
		if (request.getSession().getAttribute("username") != null) {
			action = "userhome";

			request.setAttribute("username", request.getSession().getAttribute("username"));
			bloglist = new ArrayList<Blog>(blogdao.listBlogs(request.getSession().getAttribute("username").toString()));

			System.out.println("Getting Blogs");

			System.out.println("This session's username is " + request.getSession().getAttribute("username"));
		}

		if (action == null) {
			action = "publichome";
			bloglist = new ArrayList<Blog>(blogdao.listBlogs());
		}
		request.setAttribute("blogDatabase", bloglist);
		request.setAttribute("total", bloglist.size());
		switch (action) {
		case "write":
			this.writeblog(request, response);
			break;
		case "login":

			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			break;

		case "userhome":

			request.getRequestDispatcher("/WEB-INF/jsp/userhome.jsp").forward(request, response);
			break;

		case "publichome":
		default:
			this.blogs(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ArrayList<Blog> blogList = new ArrayList<Blog>();*/
		String action = request.getParameter("submit");
		String username = (String) request.getSession().getAttribute("username");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Date date = new Date();
		// String dd=date.toString();
		System.out.println(date);
		// System.out.println(dd);
		System.out.println(username + " " + title + "  " + description + " ");
		if (action.equalsIgnoreCase("Upload"))

		{
			Blog newblog = new Blog();
			newblog.setUserName(username);
			newblog.setTitle(title);
			newblog.setDescription(description);
			newblog.setDate(date);

			int id;
			synchronized (this) {
				id = this.BLOG_ID_SEQUENCE++;
				System.out.println("the blog id sequence is " + id);
				blogdao.create(newblog);
			}
			response.sendRedirect("blog");
		}

	}

	// functions defined in do get

	// public home page
	private void blogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("blogDatabase", blogdao.listBlogs());

		request.getRequestDispatcher("/WEB-INF/jsp/publichome.jsp").forward(request, response);
	}

	// write blog

	private void writeblog(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
