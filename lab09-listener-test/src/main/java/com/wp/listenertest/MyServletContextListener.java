package com.wp.listenertest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		System.out.println(">>> ServletContext object initialized...");
		
		ServletContext context = sce.getServletContext();
		
		DBConnectionInfo dbConnInfo = new DBConnectionInfo();
		dbConnInfo.setJdbcDriverName(context.getInitParameter("oracle_jdbc_driver"));
		dbConnInfo.setUrl(context.getInitParameter("db_url"));
		dbConnInfo.setUserid(context.getInitParameter("db_userid"));
		dbConnInfo.setPassword(context.getInitParameter("db_password"));
		dbConnInfo.setTable(context.getInitParameter("db_table"));
		
		context.setAttribute("db_info", dbConnInfo);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);

		System.out.println(">>> ServletContext object destroyed...");
	}

}
