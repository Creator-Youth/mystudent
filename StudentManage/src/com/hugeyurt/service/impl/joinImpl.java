package com.hugeyurt.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hugeyurt.database.DBConnection;
import com.hugeyurt.service.join;
@Service
public class joinImpl implements join
{
	@Resource
	private  DBConnection db;
    public int  creatToCheck(String StuID,String stuName,String profession,String ID,	String sex)
    {   
   	 int i=0;  
   	 String stuName1=null;
	 String profession1=null;
	 String ID1=null;
	 String sex1=null;
   	 Object []param1={StuID};  	 
   	 String sql1="select sno from studentmanage.enter where sno=?";
   	 ResultSet set1=db.executeQuery(sql1, param1);
   	 try {
		if(!set1.next())
		 {
			 i=1;//账号已注册，请找回密码  		 
		 }
		 else
		 {
			 String sql2="select StuID from studentmanage.studentinfo where StuID=?";
			 ResultSet set2=db.executeQuery(sql2, param1);
			 if(!set2.next())
			 {
				 i=2;//未查到你的信息无法注册
			 }
			 else
			 {
				 String sql3="select stuName, profession,ID, sex  from studentmanage.studentinfo where StuID=?"; 
				 ResultSet set3=db.executeQuery(sql3, param1); 
				 while (set3.next())
				 {
					 stuName1=set3.getString("stuName");
					 profession1=set3.getString("profession");
					 ID1=set3.getString("ID");
					 sex1=set3.getString("sex");
				 }
				 if(stuName1.equals(stuName)&&profession.equals(profession1)&&ID1.equals(ID)&& sex1.equals(sex))
				 {
					 i=3;//信息正确，可以注册
				 }
				 else
				 {
					 i=4;//信息错误
				 }
			 }
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	return i;
    }
	
	public int creatUser(String StuID,String passname)
	{
		int i=0;
		 Object []param={StuID,passname};
		 String sql3="insert into studentmanage.enter values (?,?)";
		 try {
			i=db.executeUpdate(sql3, param);
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}		
		return i;
	}
}
