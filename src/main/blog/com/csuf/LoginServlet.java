package com.csuf;

import java.io.IOException;
/*import java.util.Hashtable;
import java.util.Map;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
*/
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/*ApplicationContext context = 
    		new ClassPathXmlApplicationContext("SpringConfig.xml");
    	 
         UserDao userdao = (UserDao) context.getBean("userDao");*/
	UserDao userdao = new UserDao();
	/**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
    
    /* Previous code
     * private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("Thilak", "kumar");
        userDatabase.put("Mohini", "ahwad");
        userDatabase.put("Lekha", "sri");
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 if(request.getParameter("logout") != null)
	        {
			 	request.getSession().invalidate();
	            response.sendRedirect("blog");
	            return;
	        }
	        else if(session.getAttribute("username") != null)
	        {
	            response.sendRedirect("blog");
	            return;
	        }
		  request.setAttribute("loginFailed", false);
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
        .forward(request, response);
		//response.getWriter().append("Served atdo get: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("im n post ");
		
		HttpSession session = request.getSession();
        String action = request.getParameter("submit");
        System.out.println("this "+action+" is");
        
        //UserDao userDao = new UserDao();
        
        if( action.equalsIgnoreCase("Log In"))
        {
        	
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");
        	
        	if(userdao.isValidUser(username, password))
        	{
        		System.out.println("In Else Block");
        		session.setAttribute("username", username);
        		request.changeSessionId();
        		response.sendRedirect("blog");
        	}
        	else
        	{
        		request.setAttribute("loginFailed", true);
        		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
        				.forward(request, response);	
        	}
        /* if(username == null || password == null ||
                !LoginServlet.userDatabase.containsKey(username) ||
                !password.equals(LoginServlet.userDatabase.get(username)))
        {
        	for (String name: userDatabase.keySet()){

                String key =name.toString();
                String value = userDatabase.get(name).toString();  
                System.out.println(key + " " + value);  
        } 
        		Previous code:
        	  request.setAttribute("loginFailed", true);
            	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                   	.forward(request, response);
        } 
        else
        {
        	/* Previous code:
        	  System.out.println("In Else Block");
        	session.setAttribute("username", username);
            request.changeSessionId();
            response.sendRedirect("blog");
        } */
        
        	}
        
        	else
        	{
        	 System.out.println("add user here");
        	 User user = new User();
        	 String fname = request.getParameter("firstname");
        	 String lname = request.getParameter("lastname");
        	 String username = request.getParameter("username");
             String password = request.getParameter("password");
             user.setFirstName(fname);
             user.setLastName(lname);
             user.setUserName(username);
             user.setPassword(password);
             if(userdao.verifyUser(username))
             {
            	 request.setAttribute("userExists", true);
             }
             else
             {
        	 userdao.create(user);
        	 request.setAttribute("userExists", false);
             }
        	 request.setAttribute("loginFailed", false);
        	 
        	  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
              .forward(request, response);
             }
        }
		
	}


