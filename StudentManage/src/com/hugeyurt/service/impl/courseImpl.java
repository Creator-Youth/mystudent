package com.hugeyurt.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hugeyurt.database.DBConnection;
import com.hugeyurt.service.course;

@Service  
public class courseImpl implements course
{
	@Resource
	private  DBConnection db;
	public int addStudentScore(String stuID,String scorename)
	{
		int i=0;
		Object parms[]={stuID,scorename};
		String sql1="select stuID from studentmanage.studentscore where stuID=? and scorename=? ";
		String sql2="insert into studentmanage.studentscore (stuID,scorename) values (?,?)";
		try {
			ResultSet set=db.executeQuery(sql1, parms);
			if (!set.next())
			{
				i=db.executeUpdate(sql2, parms);
            }
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return i;		
	}
	
	public int addTeacherScore(String stuID,String scorename)
	{
		int i=0;
		Object parms[]={stuID,scorename};
		String sql1="select teacher from studentmanage.teacherandscore where teacher=? and scorename=? ";
		String sql2="insert into studentmanage.teacherandscore (teacher,scorename) values (?,?)";
		try {
			ResultSet set=db.executeQuery(sql1, parms);
			if (!set.next())
			{
				i=db.executeUpdate(sql2, parms);
            }
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return i;		
	}
	public ResultSet studentAllScore(String stuID)
	{
		ResultSet set=null;
		Object parms[]={stuID};
		String sql1="select scorename from studentmanage.studentscore where stuID=? ";	
		set=db.executeQuery(sql1, parms);		
		return set;		
	}
	public ResultSet teacherAllScore(String stuID)
	{
		ResultSet set=null;
		Object parms[]={stuID};
		String sql1="select scorename from studentmanage.teacherandscore where teacher=? ";	
		set=db.executeQuery(sql1, parms);		
		return set;		
	}

}
