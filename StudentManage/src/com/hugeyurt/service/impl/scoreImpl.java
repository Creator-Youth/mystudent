package com.hugeyurt.service.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hugeyurt.database.DBConnection;
import com.hugeyurt.database.ORMUtil;
import com.hugeyurt.po.stumarkInfo;
import com.hugeyurt.service.Score;
@Service
public class scoreImpl implements Score
{
	@Resource
	private DBConnection db;
	@Resource
	private stumarkInfo stumark;
	@Resource
	private ORMUtil orm;
	public Object select(String stuid,String coursename)
	{
		
		Object obj=null;
		String sql ="select * from studentmanage.stumarkinfo where stuid=? and coursename=?";
		Object parms[]={stuid,coursename};
		try 
		{
			ResultSet set=db.executeQuery(sql, parms);
			set.next();
			obj=orm.toObject(set, stumark.getClass());
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;		
	}
	
	public int addScore(String coursename,String stuid,String  basescore,String testscore,String finalscore,String note )
	{		
		int i=0;
	    long time=System.currentTimeMillis();
	    String markid=null;
	    String adddate=String.valueOf(time);
	    String sql1 ="select MAX(markid) markid from studentmanage.stumarkinfo";
	    Object []parms1={};
	    ResultSet set=db.executeQuery(sql1, parms1);
	    try {
			if(!set.next())
			{
				markid="1";
			}
			else
			{
				int j=Integer.parseInt(set.getString("markid"))+1;
				markid=String.valueOf(j);	    	
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String sql3="select markid from studentmanage.stumarkinfo where stuid=? and coursename=?";
	    Object parms3[]={stuid,coursename};
	    ResultSet set1=db.executeQuery(sql3, parms3);
	    try {
			if(!set1.next())
			{	
			   String sql2="insert into studentmanage.stumarkinfo (markid,stuid,coursename,adddate,basescore,testscore,finalscore,note) values (?,?,?,?,?,?,?,?)";
			   Object parms2[]={markid,stuid,coursename,adddate,basescore,testscore,finalscore,note};
			   try 
			    {
				     i=db.executeUpdate(sql2, parms2);
			    } 
			    catch (SQLException e) 
			    {
				    e.printStackTrace();
			    }
			 }
			else
			{
			    Object parms4[]={basescore,testscore,finalscore,note,stuid,coursename};
				String sql4="update studentmanage.stumarkinfo set basescore=?,testscore=?,finalscore=?,note=? where stuid=? and coursename=?";
			    i=db.executeUpdate(sql4, parms4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i ;			
	}
	
	
}
