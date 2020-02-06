package com.hugeyurt.service.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hugeyurt.database.DBConnection;
import com.hugeyurt.service.enterService;
@Service
public class enterServiceImpl implements enterService
{

	     @Resource
	     private  DBConnection db;
	     public int change(String account, String passname)
	     {  
	    	 int i=0;
	    	 String sql="update studentmanage.enter set passname=?  WHERE sno=?";
	    	 Object parms[]={ passname,account};
	    	 try
	    	 {
				i= db.executeUpdate(sql, parms);
			 }
	    	 catch (SQLException e)
	    	 {
				e.printStackTrace();
			 }
	    	 return i;	 
	      }
	   
		 public int input(String account, String passname)
	     {   			 
			 int i=0,count=0;
			 long Time=0;
			 String passname1=null;	    	 
	    	 String sql1="select passname from studentmanage.enter where sno=?"; 
	    	 Object parsms1[]={account};
	    	 ResultSet sett=db.executeQuery(sql1, parsms1);
	    	 
	     	 try {
				if(!sett.next()) 
				 {
				 	i=4;
				 }	     	 
				 else  
				 {	     	
				    String sql2="select passname,count,time from studentmanage.enter where sno=?";  	     	    
				    ResultSet set=db.executeQuery(sql2, parsms1);
				    while(set.next())
				    {
				        count=(int)set.getObject("count");
				        passname1=(String)set.getObject("passname");	     	        
				        Time=Long.parseLong((String)set.getObject("time"));	     	      
				    }
				        if(count<3)
						 {
				    	      
							 if(passname1.equals(passname))
				   			 {
				   				 
								 String sql3="delete  from studentmanage.enter where sno=?"; 
								 Object[] parsms2={account};	       					 
								 db.executeUpdate(sql3,parsms2);
								 String sql4="insert into studentmanage.enter(sno,passname,count,time) values (?,?,?,?)";
								 long time1=(long)System.currentTimeMillis();
								 String time=String.valueOf(time1);
								 Object parsms[]={account,passname1,0,time};
								 db.executeUpdate(sql4, parsms);         				 	           				
				   				 i=1; //密码正确
				   			 }
				   			 else
				   			 {
				   				count++;
				   				String sql3="delete  from studentmanage.enter where sno=?";  
								db.executeUpdate(sql3,parsms1);
				   				String sql4="insert into studentmanage.enter (sno,passname,count,time)values(?,?,?,?)";
				   			    long time1=(long)System.currentTimeMillis();
							    String time=String.valueOf(time1);
								Object parsms[]={account,passname1,count,time};
								db.executeUpdate(sql4, parsms); 	 
				   				i=5+count;
				   			 } 
						 }
						 else
						 {
							 if(System.currentTimeMillis()-Time<1000*10*60*24)
							 {
								 long   time1=System.currentTimeMillis();
								 double ti1=(double)((1000*60*60*24)-(time1-Time))/1000;//锟斤拷
								 int    hour=(int)(ti1/(60*60));
								 int    minute=(int)(ti1-(60*60*hour))/(60);
								 int    s=(int)(ti1-(60*60*hour+minute*60));
								 if(passname1.equals(passname))
								 {
									 System.out.println("等待"+hour+"小时"+minute+"分"+s+"S"+"再次输入");
								 }
								 else
								 {
									 System.out.println("等待"+hour+"小时"+minute+"分"+s+"S"+"再次输入");
				                 }      					 
							 }
							 else
							 {
								 String sql3="delete  from studentmanage.enter where sno=?";
								 db.executeUpdate(sql3, parsms1);
								 String sql4="insert into studentmanage.enter (sno,passname,count,time) values (?,?,?,?)";
								 long time1=(long)System.currentTimeMillis();
								 String time=String.valueOf(time1);
								 if(passname1.equals(passname))
				      			 { 
									  Object parsms[]={account,passname1,0,time};
				   					  db.executeUpdate(sql4, parsms); 
				      				  i=1;
				      			 }
							     else
				   			     {	  
					     	        ResultSet set1=db.executeQuery(sql1,parsms1);
					     	        int count1=0;
					     	        while(set1.next())
					     	        {
					     	        	count1= (int)set1.getObject("count");
					     	            count1++;
					     	        }
					     	        String sql5="delete  from studentmanage.enter where sno=?";
							        db.executeUpdate(sql5, parsms1);
				       				String sql6="insert into studentmanage.enter (sno,passname,count,time) values (?,?,?,?)";
				       			    long time2=(long)System.currentTimeMillis();
								    String time3=String.valueOf(time2);
				   					Object parsms[]={account,passname1,count1,time3};
				   					db.executeUpdate(sql6, parsms); 
				       				i=5+count;
				   			     } 
							 }
						 }
				  }
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return i;
	   }
	}
	
	

