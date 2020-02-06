package com.hugeyurt.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hugeyurt.po.Student;
import com.hugeyurt.service.StudentService;

@Controller
public class LoginController 
{
  
	@Resource
	private StudentService studentService;//=new StudentServiceImpl();
	
     @RequestMapping("query.do")
     @ResponseBody
	  public List<Object> test() 
      {
		return studentService.getAllStudent();
	 }
     
     
     @RequestMapping("login.do")
     @ResponseBody
	  public Student login(String sno,String pwd) 
      {
		return studentService.login(sno, pwd);
	 }

     
     @RequestMapping("save.do")
     @ResponseBody
	  public boolean save(Student stu) 
      {
		return studentService.insertStudent(stu);
	 }

}
