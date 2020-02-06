package com.hugeyurt.service;

import java.util.List;

import com.hugeyurt.database.DBConnection;
import com.hugeyurt.po.Student;

public class StudentServiceImpl implements StudentService
{
     private DBConnection dbcon=new DBConnection();
	@Override
	public Student login(String sno, String pwd) {
		// TODO Auto-generated method stub
		//StudentVO studentVo=new StudentVO();
		String sql="select sno,sname,pwd from student where sno=?";
		Object[] params={sno};
		List<Object> lists=dbcon.executeQuery(sql, params,new Student());
		if(lists.size()==0) return null;
		
		return (Student)lists.get(0);
	}

	@Override
	public List<Object> queryAll() {
		// TODO Auto-generated method stub
		String sql="select sno,sname,pwd from student";
		 return dbcon.executeQuery(sql,null,new Student());
		/*if(lists.size()==0) return null;
		List<Student> students=new ArrayList<Student>();
		for(int i=0;i<lists.size();i++)
		{
			Student stu=new Student();
			Object object[]=(Object[])lists.get(i);
			stu.setSno(object[0].toString());
			stu.setSname(object[1].toString());
			stu.setSage(Integer.valueOf(object[2].toString()));
			stu.setPwd(object[5].toString());
			stu.setCount(Integer.parseInt(object[3].toString()));
			stu.setLogintime(object[4].toString());
			students.add(stu);
			
		}
		return students;*/
	}

	@Override
	public boolean saveStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql="insert into student(sno,sname,sage,count,logintime,pwd)"
				+ "values(?,?,?,?,?,?)";
		Object[] params={stu.getSno(),stu.getSname(),stu.getSage(),"0","0",stu.getPwd()};
				
		return dbcon.executeUpdate(sql, params)>0;
	}

	@Override
	public boolean clearCount(String sno,String count, String logintime) {
		// TODO Auto-generated method stub
		String sql="update student set count=?,logintime=? where sno=?";
		Object[] params={count,logintime,sno};
	    return dbcon.executeUpdate(sql, params)>0;
	}

	@Override
	public boolean deleteStu(String sno) {
		// TODO Auto-generated method stub
		
		String sql="delete from student where sno=?";
		Object[] params={sno};
		
		return dbcon.executeUpdate(sql, params)>0;
	}

}
