package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.CustomerDAO;
import com.cognizant.helper.FactoryCustomerDAO;

/**
 * Servlet implementation class LoginCookieServlet
 */
@WebServlet(name = "LoginCookie", urlPatterns = { "/logincookie" })
public class LoginCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int custId=Integer.parseInt(request.getParameter("custId"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		CustomerDAO customerDAO=FactoryCustomerDAO.createCustomerDAO();
		boolean result=customerDAO.authCustomer(custId, pin);
		if(result){
			Cookie cookie=new Cookie("LoginCookie",String.valueOf(custId));
			cookie.setMaxAge(1*24*60*60);
			response.addCookie(cookie);
			response.sendRedirect("https://localhost:8083/CookiePRO/welcomeCookie");
		}
		else{
			response.getWriter().print("Login failed!!!!");
		}
		
	}

}
