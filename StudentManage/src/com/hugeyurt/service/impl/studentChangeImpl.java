package com.hugeyurt.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hugeyurt.database.DBConnection;
import com.hugeyurt.database.ORMUtil;
import com.hugeyurt.po.StudentInfo;
import com.hugeyurt.po.enter;
import com.hugeyurt.service.studentChange;
@Service
public class studentChangeImpl implements studentChange

{   @Resource
	private DBConnection db;
    @Resource
	private ORMUtil ormutil;
	public Object Find(String name,String sno,enter en) 
	{
		
		Object []parms1={sno};
		String sql="select * from studentmanage.enter where "+name+"=?";
		ResultSet re;
		Object ob=null;
		try 
		{
			re = db.executeQuery(sql, parms1);
			re.next();
			ob=ormutil.toObject(re,en.getClass());
		} 
		catch (SQLException e) 
		{
		}
		return ob;
	}
		
	public int changeStuProfession(String stuID,String profession)
	{
		int i=0;
		Object []parms={ profession,stuID};
		String sql="update studentmanage.studentinfo set profession=? where StuID=? ";
		try {
			i=db.executeUpdate(sql, parms);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
		
	public void Change(String sno,String name)
	{
		
		Object []parms1={sno};
		Object []parms2={sno,name};
		String sql1="delete  from studentmanage.enter where sno=?";
		String sql2="insert into studentmanage.enter (sno,passname,count,time) values (?,?,?,?)";		
		try
		{
			db.executeUpdate(sql1, parms1);
			db.executeUpdate(sql2, parms2);
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}		
	}
	
	public Object view (String sno,StudentInfo en) 
	{		
		Object []parms1={sno};
		String sql="select * from studentmanage.studentinfo where StuID=?";
		ResultSet re=null;
		Object ob=null;
		try
		{
			re = db.executeQuery(sql, parms1);
			re.next();
			ob=ormutil.toObject(re,en.getClass());
		}
		catch (SQLException e) 
		{			
		}
		return ob;		
	}
	
	public String changeInformation(String stuID,String stuName,String profession,String data,String ID,String sex,String totalScore,String note)
	{
		int i=0;
		int j=0;
		Object []parms1={stuID};
		Object []parms2={stuID,stuName,profession,data,sex,ID,totalScore,note};
		String sql1="delete  from studentmanage.studentinfo where StuID=?";
		String sql2="insert  into studentmanage.studentinfo (StuID, StuName, profession, data ,sex, ID, TotalScore,note) values (?,?,?,?,?,?,?,?)";
		try 
		{
			i=db.executeUpdate(sql1, parms1);
			System.out.println("i="+i);
			j=db.executeUpdate(sql2, parms2);
			System.out.println("j="+j);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(i!=0&&j!=0)
		{
			return "yes";
		}		
		return "no";		
	}
	
	public String teacherAddStudent(String stuID,String stuName,String profession,String data,String ID,String sex,String totalScore,String note)
	{
		int i=0;				
		Object []parms2={stuID,stuName,profession,data,sex,ID,totalScore,note};
		
		String sql2="insert  into studentmanage.studentinfo (StuID, StuName, profession, data ,sex, ID, TotalScore,note) values (?,?,?,?,?,?,?,?)";
		try {
			
			i=db.executeUpdate(sql2, parms2);		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(i!=0)
		{	
			return "yes";
		}
		else
		{ 
			return "no";
		}		
	}
}
