package com.cognizant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FundTransferCookieClass
 */
@WebServlet(name = "FundTransferCookie", urlPatterns = { "/fundtransfercookie" })
public class FundTransferCookieClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransferCookieClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int custId=0;
		Cookie cookies[]=request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("LoginCookie")){
				custId=Integer.parseInt(cookie.getValue());		
			}
		}
		
		PrintWriter out=response.getWriter();
		out.println("<b>Welcome, "+custId);
		out.println("<b>Cust Id from Cookie: "+custId);
		
	}

}
