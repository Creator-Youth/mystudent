package com.hugeyurt.database;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0
{
 public static void main(String[] args)
 {
		// TODO Auto-generated method stub
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try 
		{
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/my2018");
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setInitialPoolSize(20); 
			dataSource.setMinPoolSize(10); 
			dataSource.setMaxPoolSize(30);
			dataSource.setAutoCommitOnClose(false);
			dataSource.setMaxIdleTime(60);
			dataSource.setIdleConnectionTestPeriod(60);
		
		} catch (PropertyVetoException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			conn = dataSource.getConnection();		
			st = conn.createStatement();	
			rs = st.executeQuery("SELECT sno, sname FROM student");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t" + rs.getString(2));
				System.out.println();	
			}
		}
		 catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
 }
}
