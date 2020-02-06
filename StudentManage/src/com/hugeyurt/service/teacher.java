package com.hugeyurt.service;

import java.util.ArrayList;

import com.hugeyurt.po.teacherinfo;

public interface teacher
{
	public abstract Object view (String teacher,teacherinfo en) ;
	public abstract ArrayList<Object> seeAll() ;
	public abstract ArrayList<Object> findByName(String StuName) ;
	public abstract ArrayList<Object> findByProf(String profession) ;
	public abstract String changeTeaSou(String scorename,String teacher);
	public abstract void teachChag(String teachername,String sex,String ID ,String age,String note,String teacher);
	public abstract String changeInformation(String stuID,String stuName,String profession,String data,String ID,String sex,String totalScore,String note);
}
