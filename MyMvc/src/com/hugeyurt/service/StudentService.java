package com.hugeyurt.service;

import java.util.List;

import com.hugeyurt.po.Student;

public interface StudentService 
{
	public abstract  Student login(String sno,String pwd);
	
	public abstract  List<Object> getAllStudent();
	
	public abstract  boolean deleteStudent(String sno);

	public abstract boolean insertStudent(Student stu);

}
