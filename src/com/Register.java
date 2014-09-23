package com;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.Account;
import model.Service;




/**
 *  implementation class Register
 */
@WebServlet("/register.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("mpassword");
		Account account = new Account(name,password,email);
		Service service = (Service)getServletContext().getAttribute("Service");
		
		boolean reg = true;
		
		if(password.length()<6){
			request.setAttribute("passwordWrong", "密码太短啦，不能少于6位");
			reg = false;
		}
		
		if(email == null || !email.matches("^[_a-z0-9-]+([.]" + "[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")){
			request.setAttribute("emailWrong", "email格式不对哦");
			reg = false;
		}

		if(service.isUserExisted(account)){
			reg = false;
			request.setAttribute("nameWrong", "f");
		}
		
		if(password.equals(cpassword)){
			reg = false;
			request.setAttribute("cWrong", "ff");
		}
				
		if(reg){
					service.addAccount(account);
					response.sendRedirect("index.jsp");
				}
		else{
			request.getRequestDispatcher("Register.jsp").forward(request, response);;
		}
		
		
		
	}}

