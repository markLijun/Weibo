package com;

import javax.naming.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import DAO.AccountDAOJdbcImpl;
import DAO.BlahDAOJdbcImpl;
import model.Blah;
import model.Service;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce){
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/demo");
			ServletContext context = sce.getServletContext();
			context.setAttribute("Service", new Service(new AccountDAOJdbcImpl(dataSource),new BlahDAOJdbcImpl(dataSource)));
		}catch(NamingException ex){
			throw new RuntimeException(ex);
		}
	}
	Blah blah = new Blah();
	
	

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
	
}
