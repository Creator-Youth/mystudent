package com.hugeyurt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hugeyurt.service.StudentService;
import com.hugeyurt.service.StudentServiceImpl;

@WebServlet("/deletestu")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteStudentServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String sno=request.getParameter("sno");
		if(sno==null||"".equals(sno)) return ;
		StudentService studentService=new StudentServiceImpl();
		studentService.deleteStu(sno);
		//response.sendRedirect("view");
		request.getRequestDispatcher("view").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
