package com.hugeyurt.service;

import java.util.List;

import com.hugeyurt.po.Student;

public interface StudentService
{
	public Student login(String sno,String pwd);
	public List<Object> queryAll();
	public boolean saveStudent(Student stu);
	public boolean clearCount(String sno,String count,String logintime);
	public boolean deleteStu(String sno);
}
