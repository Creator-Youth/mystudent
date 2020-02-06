package com.hugeyurt.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hugeyurt.database.DBConnection;
import com.hugeyurt.po.studentandcoursename;
import com.hugeyurt.service.findScore;
@Service
public class findScoreImpl implements findScore
{
	@Resource
	private  DBConnection db;
    public String findTotalScore(String stuID)
    {
    	String totalscore=null;
    	String sql="select TotalScore from studentmanage.studentinfo where StuId=?";
    	Object[] parms={stuID};
    	ResultSet set=db.executeQuery(sql, parms);
    	try {
			while(set.next())
			{
				totalscore=set.getString("TotalScore");
			}
		} catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return totalscore;
    	
    }
	public ArrayList<studentandcoursename> findAllScore(String teacher)
    
    {
		
    	ArrayList<String> list1=new ArrayList<String>();
    	ArrayList<studentandcoursename> list2=new ArrayList<studentandcoursename>();
    	String sql1="select scorename from studentmanage.teacherandscore where teacher=?";
    	String sql2="select stuid     from studentmanage.studentscore    where scorename=?";
    	Object[] parms1={teacher};    	
    	try 
    	{
			ResultSet set1=db.executeQuery(sql1, parms1);			
			while (set1.next())
			{
				list1.clear();
				String scorename=set1.getString("scorename");
				Object[]  parms2={scorename};
				ResultSet set2=db.executeQuery(sql2, parms2);
				{
					while (set2.next())
					{
						String stuid=set2.getString("stuid");					
						list1.add(stuid);
					}
					studentandcoursename sc=new studentandcoursename();
					sc.setCoursename(scorename);
					sc.setList(list1);
					list2.add(sc);
				}								
			}
		}
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}   	
    	return list2;
    }
}
