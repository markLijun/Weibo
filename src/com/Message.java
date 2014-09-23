package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blah;
import model.Service;

/**
 * Servlet implementation class Message
 */
@WebServlet("/blaNew.do")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	Service service = (Service)getServletContext().getAttribute("Service");
    	String name = (String)request.getSession().getAttribute("login");
    	Blah blah = new Blah();
    	String blahs = null;
    	blahs = request.getParameter("blabla");
    	blah.setName(name);
    	List<Blah> blahss =new ArrayList<Blah>();
    	
    	if(blahs.length()>140){
    		request.setAttribute("more", blahs);
    	}
    	else{
    	
    	
    		blah.setDate(new Date());
    		
    		blah.setTxt(blahs);
    		//blah.setTxt(blahs);
    		service.addBlah(blah);
    		
   
    
    		blahss = service.getBlahs(blah);
    		request.setAttribute("blahs", blahss);
    	}
    	    request.getRequestDispatcher("Member.jsp").forward(request, response);
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
    	
    	
		// TODO Auto-generated method stub
	}

}
