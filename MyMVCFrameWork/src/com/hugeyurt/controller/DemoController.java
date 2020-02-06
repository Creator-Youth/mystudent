package com.hugeyurt.controller;
import javax.servlet.http.HttpSession;

import com.hugeyurt.po.Student;

public class DemoController 
{
	public String test(HttpSession  session) {
		// TODO Auto-generated method stub
		
			session.setAttribute("message", "王先首");
			return "success.jsp";
	
	}
	public Student reg(Student stu) {
		// TODO Auto-generated method stub
	
			return stu;
	
	}



}
