package com.hugeyurt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class DBConnection
{
	private String url=Config.url;//"jdbc:mysql://localhost:3306/db201903f?characterEncoding=UTF-8";
	private String user=Config.user;//"root";
	private String pwd=Config.pwd;//"";

	private static ArrayStack3<Connection> conns=new ArrayStack3<Connection>(8);
	
	static{
		try{
			//"com.mysql.jdbc.Driver"
		   	Class.forName(Config.driver);
		   	for(int i=0;i<8;i++)
		   conns.push(DriverManager.getConnection(Config.url, Config.user, Config.pwd));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public DBConnection()// throws ArithmeticException
	{
		//this.conn=DriverManager.getConnection(url, user, pwd);
		
	}
	
	//synchronized
	private Connection getConnection()
	{
		return conns.pop();
	   ///return	pools.getConnection();
	}
	
	synchronized
	private void  backConnection(Connection conn)
	{
		if(conn==null) return ;
	    conns.push(conn);
	}
	
	
	/*public int executeUpdate(String sql)
	{
		Statement stmt=null;
		int res=0;
		try{
			stmt=this.conn.createStatement();
			res= stmt.executeUpdate(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
			   if(stmt!=null) stmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}
	*/
	public int executeUpdate(String sql,Object[] params)
	{
		PreparedStatement stmt=null;
		int res=0;
		Connection conn=null;
		conn=getConnection();
		if(conn==null) return 0;
		try{
			stmt=conn.prepareStatement(sql);
			if(params!=null)
			{
				for(int i=0;i<params.length;i++)
				   stmt.setObject(i+1, params[i]);
			}
			res= stmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
			   if(stmt!=null) stmt.close();
			   if(conn!=null) backConnection(conn);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
 /*	public ResultSet executeQuery2(String sql)
	{
		ResultSet rs=null;
		Statement stmt=null;
		try{
			
			stmt=this.conn.createStatement();
			rs=stmt.executeQuery(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null) rs.close();
				   if(stmt!=null) stmt.close();
				   
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return rs;
	}
	
	public List<Object> executeQuery(String sql)
	{
		ResultSet rs=null;
		Statement stmt=null;
		List<Object> lists=new ArrayList<Object>();
	    try{
			
			stmt=this.conn.createStatement();
			rs=stmt.executeQuery(sql);
			int cols=rs.getMetaData().getColumnCount();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷卸锟斤拷锟斤拷锟�
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
		List<Object> lists=new ArrayList<Object>();
	    try{
			
			stmt=this.conn.createStatement();
			rs=stmt.executeQuery(sql);
			//int cols=rs.getMetaData().getColumnCount();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷卸锟斤拷锟斤拷锟�
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
				   if(rs!=null) rs.close();
				   if(stmt!=null) stmt.close();
				   
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	
	*/
	public List<Object> executeQuery(String sql,Object[] params,DBIO dbio)
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		List<Object> lists=new ArrayList<Object>();
		Connection conn=null;
		conn=getConnection();
		if(conn==null) return lists;
	    try{
			
			stmt=conn.prepareStatement(sql);
			if(params!=null)
			{
				for(int i=0;i<params.length;i++)
				   stmt.setObject(i+1, params[i]);
			}
			rs=stmt.executeQuery();
			//int cols=rs.getMetaData().getColumnCount();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷卸锟斤拷锟斤拷锟�
			while(rs.next())
			{
				//Object[] temp=new Object[cols];
				//for(int i=0;i<cols;i++)
				//	temp[i]=rs.getObject(i+1);
				lists.add(dbio.toObject(rs));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null) rs.close();
				   if(stmt!=null) stmt.close();
				   if(conn!=null) backConnection(conn);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	
  // 鍙嶅皠鏈哄埗ORM
	
	@SuppressWarnings("rawtypes")
	public List<Object> executeQuery(String sql,Object[] params,Object dbobj)
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		List<Object> lists=new ArrayList<Object>();
		Class clz=dbobj.getClass();//锟矫碉拷锟街斤拷锟斤拷锟斤拷锟�
		Connection conn=null;
		conn=getConnection();
		if(conn==null) return lists;
	    try{
			
			stmt=conn.prepareStatement(sql);
			if(params!=null)
				for(int i=0;i<params.length;i++)
					stmt.setObject(i+1, params[i]);
			rs=stmt.executeQuery();
			//int cols=rs.getMetaData().getColumnCount();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷卸锟斤拷锟斤拷锟�
			while(rs.next())
			{
				lists.add(ORMUtil.toObject(rs, clz));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				   if(rs!=null) rs.close();
				   if(stmt!=null) stmt.close();
				   if(conn!=null) backConnection(conn);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		return lists;
	}
	
   public boolean save(Object object)
   {
	   if(object==null) return false;
	   StringBuffer stf=new StringBuffer(100);
	   Object[] params=ORMUtil.toInsert(stf, object);
	   return executeUpdate(stf.toString(), params)>0;
   }
	
}
