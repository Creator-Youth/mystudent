package com.hugeyurt.po;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
@Component
public class pageInfo
 {
    
     private int dataNum;     //总数据数
     private int pageSize;    //每页显示的数据条数。       
     private int startPage;   //开始页面，也就是我们在数据库中要从第几行数据开始拿               
     ArrayList<Object> list;
	
	public int getPageNum() {
		return dataNum;
	}
	public void setPageNum(int dataNum) {
		this.dataNum = dataNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public ArrayList<Object> getList() {
		return list;
	}
	public void setList(ArrayList<Object> list) {
		this.list = list;
	}
     
}
 
     
