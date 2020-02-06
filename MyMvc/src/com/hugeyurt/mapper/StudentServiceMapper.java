package com.hugeyurt.mapper;

import java.util.List;

import com.hugeyurt.po.Student;

public interface StudentServiceMapper 
{
	public abstract  List<Object> getAllStudent();
	public abstract  Student loginStu(Student stu);
	public abstract  boolean saveStu(Student stu);

}
