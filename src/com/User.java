package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Blah;
import model.Service;

/**
 * Servlet implementation class User
 */
@WebServlet(urlPatterns = {"/user/*"})
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = (Service) getServletContext().getAttribute("Service");
		
		String name = request.getPathInfo().substring(1);
		Account account =null;
		account = new Account();
		account.setName(name);
		if(service.isUserExisted(account)) {
			Blah blah =new Blah();
			blah.setName(name);
			List<Blah> blahs = service.getBlahs(blah);
			request.setAttribute("blahs", blahs);
			
		}
		request.setAttribute("name", name);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
