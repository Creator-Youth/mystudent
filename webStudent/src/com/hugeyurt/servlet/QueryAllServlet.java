package com.hugeyurt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hugeyurt.service.StudentService;
import com.hugeyurt.service.StudentServiceImpl;

/**
 * Servlet implementation class QueryAllServlet
 */
@WebServlet("/view")
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService=new StudentServiceImpl();
		List<Object> stus=studentService.queryAll();
		HttpSession session=request.getSession();
		session.setAttribute("stus",stus);
		//response.sendRedirect("viewall.jsp");
		request.getRequestDispatcher("viewall.jsp").forward(request, response);
	}

}
