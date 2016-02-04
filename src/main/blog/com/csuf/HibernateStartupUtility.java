package com.csuf;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.hibernate.SessionFactory;

public class HibernateStartupUtility extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7946741720491834186L;

	public void init(ServletConfig config) {
		@SuppressWarnings("unused")
		SessionFactory factory = ConnectionClass.getFactory();
	}
}
