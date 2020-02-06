package com.hugeyurt.service.impl;
import java.util.List;

import javax.annotation.Resource;

import com.hugeyurt.mapper.StudentServiceMapper;
import com.hugeyurt.po.Student;
import com.hugeyurt.service.StudentService;

  //@Component   @Repository
public  class StudentServiceImpl implements StudentService
{
	@Resource
    private StudentServiceMapper  studentServiceMapper;//=new DBConnection();
    
	@Override
	public Student login(String sno, String pwd) {
		// TODO Auto-generated method stub
       /*String sql="select * from student where sno=? and pwd=?";
       Object[] params={sno,pwd};
     //  studentServiceMapper.
	   List<Object> list=dbcon.executeQueryORM(sql,params,new Student());
	   if(list.size()>0) return (Student)list.get(0);
	   return null;*/
		Student stu=new Student();
		stu.setSno(sno);
		stu.setPwd(pwd);
		return studentServiceMapper.loginStu(stu);
	     
	}

	@Override
	public List<Object> getAllStudent() {
		// TODO Auto-generated method stub
		 /// String sql="select * from student ";
	     return studentServiceMapper.getAllStudent();
	}

	@Override
	public boolean deleteStudent(String sno) {
		// TODO Auto-generated method stub
	//	String sql="delete from student where sno =?";
		//Object[] params={sno};
		return false;//dbcon.executeUpdate(sql, params)>0;
		
	}

	@Override
	public boolean insertStudent(Student stu) {
		// TODO Auto-generated method stub
		return studentServiceMapper.saveStu(stu);
	}

}
