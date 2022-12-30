package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/AboutServlet")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletConfig config=getServletConfig();
    public AboutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=config.getInitParameter("username"); //for confing
		String pwd = config.getInitParameter("password");
		ServletContext context = config.getServletContext(); //for context
		String value = context.getInitParameter("value1");
		String v = context.getInitParameter("value2");
		
		response.setContentType("text/html");
		PrintWriter output=response.getWriter();
		output.println("<h1>"+v+value+" "+"</h1>");
		
		String usrname = request.getParameter("uname");
		String pswd = request.getParameter("pw");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		
		if(usrname.equalsIgnoreCase(username) && pwd.equals(pswd)) {
			out.println("Log in successful");
			out.println("your user name is: "+usrname);
		}else {
			output.println("wrong credentials!!");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
