package com.hugeyurt.service.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hugeyurt.database.DBConnection;
import com.hugeyurt.database.ORMUtil;
import com.hugeyurt.po.StudentInfo;
import com.hugeyurt.po.teacherinfo;
import com.hugeyurt.service.teacher;
@Service
public class teacherImpl implements teacher
{	@Resource
	private DBConnection db;
    @Resource
	private ORMUtil ormutil;
    @Resource
    private StudentInfo si;
	public Object view (String teacher,teacherinfo en) 
	{
		
		Object []parms1={teacher};
		String sql="select * from studentmanage.teacherinfo where teacher=?";
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
	public ArrayList<Object> seeAll() 
	{
		
		ArrayList<Object> list=new  ArrayList<Object>();
		String sql="SELECT * FROM studentmanage.studentinfo where StuID like ?";		
		String ss="n%";
		Object []params={ss};
		ResultSet re=null;
		Object ob=null;
		try 
		{
			re = db.executeQuery(sql, params);
			while (re.next())
			{
				ob=ormutil.toObject(re,si.getClass());
				list.add(ob);
			}
		}
		catch (SQLException e) 
		{			
		}
		return list;				
	}
	public ArrayList<Object> findByName(String StuName) 
	{
		
		ArrayList<Object> list=new  ArrayList<Object>();
		String sql="SELECT * FROM studentmanage.studentinfo where stuName like ?";		
		String ss=StuName+"%";
		Object []params={ss};
		ResultSet re=null;
		Object ob=null;
		try 
		{
			re = db.executeQuery(sql, params);
			while (re.next())
			{
				ob=ormutil.toObject(re,si.getClass());
				list.add(ob);
			}
		}
		catch (SQLException e) 
		{			
		}
		return list;				
	}
	
	public ArrayList<Object> findByProf(String profession) 
	{
		
		ArrayList<Object> list=new  ArrayList<Object>();
		String sql="SELECT * FROM studentmanage.studentinfo where profession=?";		
		
		Object []params={profession};
		ResultSet re=null;
		Object ob=null;
		try 
		{
			re = db.executeQuery(sql, params);
			while (re.next())
			{
				ob=ormutil.toObject(re,si.getClass());
				list.add(ob);
			}
		}
		catch (SQLException e) 
		{			
		}
		return list;				
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
	
	public String changeTeaSou(String scorename,String teacher)
	{
		int i=0;		
		Object []parms1={scorename,teacher};	
		String sql1="delete  from studentmanage.teacherandscore where scorename=? and teacher=?";		
		try 
		{
			i=db.executeUpdate(sql1, parms1);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(i!=0)
		{
			return "yes";
		}		
		return "no";	
	}
	
	public void teachChag(String teachername,String sex,String ID ,String age,String note,String teacher )
	{
			
		String sql="update studentmanage.teacherinfo set teachername=?,sex=?,ID=?,age=?,note=? where teacher=?";
		Object []parms={teachername,sex,ID,age,note,teacher};	
		for (Object object : parms) 
		{
			System.out.println(object);
		}
		try 
		{
			db.executeUpdate(sql, parms);			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}


}
