package com.hugeyurt.po;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
@Component
public class pageInfo
 {
    
     private int dataNum;     //��������
     private int pageSize;    //ÿҳ��ʾ������������       
     private int startPage;   //��ʼҳ�棬Ҳ�������������ݿ���Ҫ�ӵڼ������ݿ�ʼ��               
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
 
     
