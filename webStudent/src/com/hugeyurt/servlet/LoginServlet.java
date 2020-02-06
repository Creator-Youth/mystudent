package com.hugeyurt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hugeyurt.po.Student;
import com.hugeyurt.service.StudentService;
import com.hugeyurt.service.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID=request.getParameter("userID");
		String pwd=request.getParameter("pwd");
		StudentService studentService=new StudentServiceImpl();
		Student stuvo=studentService.login(userID, pwd);
		if(stuvo!=null)
		{
			HttpSession session=request.getSession();
			//session.setMaxInactiveInterval();
			session.setAttribute("stuvo", stuvo);
			response.sendRedirect("success.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
