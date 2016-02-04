package com.csuf;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionClass {
	public static SessionFactory sessionFactoryfactory = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		
		if(sessionFactoryfactory == null) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			return factory;
			}
		else
		{
			return sessionFactoryfactory;
		}
		}
		
	public static SessionFactory getFactory() {
		return sessionFactoryfactory;
	}
	
	public static void shutDown() {
		getFactory().close();
	}
}
