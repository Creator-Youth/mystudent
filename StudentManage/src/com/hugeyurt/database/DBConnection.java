package com.hugeyurt.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DBConnection
{
	private  String url=Config.url;//"jdbc:mysql://localhost:3306/db201903f?characterEncoding=UTF-8";
	private  String user=Config.user;//"root";
	private  String pwd=Config.pwd;//"";	
	static
	{
		try
		{			
		   	Class.forName(Config.driver);//"com.mysql.jdbc.Driver"
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public DBConnection()
	{
		
	}
		
	public int executeUpdate(String sql)
	{
		Statement stmt=null;
		Connection con=null;
		int res=0;
		try{
			con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
			res= stmt.executeUpdate(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
			   if(stmt!=null) stmt.close();
			   if(con!=null)   con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}

	public int executeUpdate(String sql,Object[] params) throws SQLException
	{
		
		PreparedStatement stmt=null;
		int res=0;
		Connection con=null;
		con=DriverManager.getConnection(url, user, pwd);		
		if(con==null){ return 0;}
		try{
			
			con=DriverManager.getConnection(url, user, pwd);
	    	stmt=con.prepareStatement(sql);
			if(params!=null)
			{
				for(int i=0;i<params.length;i++)
				{
				    stmt.setObject(i+1, params[i]);
				}
			}
			res=stmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
			   if(stmt!=null)   stmt.close();
			   if(con!=null)   con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}
	public ResultSet executeQuery(String sql,Object[] params) 
	{
	ResultSet rs=null;
	PreparedStatement stmt=null;
	Connection con=null;
    try
    {
    	con=DriverManager.getConnection(url, user, pwd);
    	stmt=con.prepareStatement(sql);
		if(params!=null)
		{
			for(int i=0;i<params.length;i++)
			    {stmt.setObject(i+1, params[i]);}
		}
		rs=stmt.executeQuery();	
	}
    catch(Exception e)
	{
		e.printStackTrace();
	}	   
	return rs;
}

	public List<Object> executeQuery(String sql)
	{
		ResultSet rs=null;
		Statement stmt=null;
		Connection con=null;		
		List<Object> lists=new ArrayList<Object>();
	    try{
	    	con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			int cols=rs.getMetaData().getColumnCount();
			while(rs.next())
			{
				Object[] temp=new Object[cols];
				for(int i=0;i<cols;i++)
					temp[i]=rs.getObject(i+1);
				lists.add(temp);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null) rs.close();
				   if(stmt!=null) stmt.close();
				   if(con!=null)con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	public List<Object> executeQuery(String sql,DBIO dbobj)
	{
		ResultSet rs=null;
		Statement stmt=null;
		Connection con=null;
		List<Object> lists=new ArrayList<Object>();
	    try{
	    	con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				lists.add(dbobj.toObject(rs));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null)    rs.close();
				   if(stmt!=null) stmt.close();
				   
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	

	public List<Object> executeQuery(String sql,Object[] params,DBIO dbio) throws SQLException
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		List<Object> lists=new ArrayList<Object>();
		Connection con=null;
		con=DriverManager.getConnection(url, user, pwd);
		if(con==null) return lists;
	    try{
			
			stmt=con.prepareStatement(sql);
			if(params!=null)
			{
				for(int i=0;i<params.length;i++)
				   stmt.setObject(i+1, params[i]);
			}
			rs=stmt.executeQuery();
			while(rs.next())
			{
				lists.add(dbio.toObject(rs));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null)   rs.close();
				   if(stmt!=null) stmt.close();
				   if(con!=null)   con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	
   public boolean save(Object object) throws SQLException
   {
	   if(object==null) return false;
	   StringBuffer stf=new StringBuffer(100);
	   Object[] params=ORMUtil.toInsert(stf, object);
	   return executeUpdate(stf.toString(), params)>0;
   }
	
}
