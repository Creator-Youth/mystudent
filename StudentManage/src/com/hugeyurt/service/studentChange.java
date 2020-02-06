package com.hugeyurt.service;

import com.hugeyurt.po.StudentInfo;
import com.hugeyurt.po.enter;

public interface studentChange 
{
	public abstract Object Find(String name,String sno,enter en) ;
	public abstract int changeStuProfession(String stuID,String profession);
	public abstract void Change(String sno,String name);
	public abstract Object view (String sno,StudentInfo en) ;
	public abstract String changeInformation(String stuID,String stuName,String profession,String data,String ID,String sex,String totalScore,String note);
	public abstract String teacherAddStudent(String stuID,String stuName,String profession,String data,String ID,String sex,String totalScore,String note);

}
