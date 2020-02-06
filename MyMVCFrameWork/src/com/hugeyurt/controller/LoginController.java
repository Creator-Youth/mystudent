package com.hugeyurt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hugeyurt.mvc.MyController;

public class LoginController implements MyController{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("message", "hello world!");
		try{
		 request.getRequestDispatcher("success.jsp").forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


}
