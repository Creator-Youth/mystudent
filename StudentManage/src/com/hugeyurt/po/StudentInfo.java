package com.hugeyurt.po;

import org.springframework.stereotype.Repository;

@Repository
public class StudentInfo
{
	public String StuID;
	public String StuName ;
	public String profession;
	public String data;
	public String sex;
	public String ID;
	public String TotalScore;
	public String note;
	
	public StudentInfo()
	{
		
	}

	public String getStuID() {
		return StuID;
	}

	public void setStuID(String stuID) {
		StuID = stuID;
	}

	public String getStuName() {
		return StuName;
	}

	public void setStuName(String stuName) {
		StuName = stuName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTotalScore() {
		return TotalScore;
	}

	public void setTotalScore(String totalScore) {
		TotalScore = totalScore;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
