package com.listenerHub;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entityHub.*;

public class DotoListener implements ServletContextListener {
	
	// This class is used for storing Data on the context while running the application.
	// Data will be cleared when the application is stopped or restarted
	// To save data permanently one should use DB

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context is ready");
		List<Doto> dotoList = new ArrayList<>();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("dotoList", dotoList);
	}

}
