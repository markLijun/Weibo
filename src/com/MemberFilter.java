package com;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter(
urlPatterns = {"/delete.do","/logout.do",
		"/message.do","/member.view"},
		initParams = {
		@WebInitParam(name = "LOGIN_VIEW",value = "index.jsp")
})
public class MemberFilter implements Filter {

    /**
     * Default constructor. 
     */
	private String LOGIN_VIEW;

    public MemberFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		// pass the request along the filter chain
		if(req.getSession().getAttribute("login") != null){
		chain.doFilter(request, response);
		}
		else{
			HttpServletResponse rep = (HttpServletResponse)response;
			rep.sendRedirect(LOGIN_VIEW);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.LOGIN_VIEW = config.getInitParameter("LOGIN_VIEW");
		// TODO Auto-generated method stub
	}

}
