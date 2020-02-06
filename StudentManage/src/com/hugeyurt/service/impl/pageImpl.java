package com.hugeyurt.service.impl;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hugeyurt.service.teacher;

@Service
public class pageImpl 
{
	@Resource
	teacher te;
	
 
	public ArrayList<Object> viewSomeStudent(int startpage,int pagesize)
	{
		
		ArrayList<Object> list=te.seeAll();
		ArrayList<Object> list1=new ArrayList<Object>();
		int pageNum=0;
		if(list.size()%pagesize==0)
		{
			pageNum=list.size()/pagesize;
			if(startpage>=pageNum)
			{
				startpage=pageNum;
				for( int i=(pageNum-1)*pagesize,j=0;j<pagesize;i++,j++)
				{
					list1.add(list.get(i));				
				}
			    list.clear();
			}	
			
			else if(startpage<=0)
			{
				startpage=1;
				for( int i=(startpage-1)*pagesize,j=0;j<pagesize;i++,j++)
				{
					list1.add(list.get(i));				
				}	
				list.clear();
				
			}
			
			else 
			{
				for( int i=(startpage-1)*pagesize,j=0;j<pagesize;i++,j++)
				{
					list1.add(list.get(i));				
				}
			    list.clear();
			}
		}
		else
		{
			pageNum=list.size()/pagesize+1;	
			int lastpage=list.size()%pagesize;
			if(startpage>=pageNum)
			{
				startpage=pageNum;
				for( int i=(pageNum-1)*pagesize,j=0;j<lastpage;i++,j++)
				{
					list1.add(list.get(i));				
				}
			    list.clear();
			}	
			
			else if(startpage<=0)
			{
				startpage=1;
				for( int i=(startpage-1)*pagesize,j=0;j<lastpage;i++,j++)
				{
					list1.add(list.get(i));				
				}	
				list.clear();
				
			}
			
			else 
			{
				for( int i=(startpage-1)*pagesize,j=0;j<lastpage;i++,j++)
				{
					list1.add(list.get(i));				
				}
			    list.clear();
			}
		}
		
		
	
		return list1;
	}     
}
