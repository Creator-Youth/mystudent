package com.hugeyurt.po;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
@Repository
public class studentandcoursename 
{
	String coursename;
	ArrayList<String> list;
	
	public studentandcoursename()
	{
		
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
