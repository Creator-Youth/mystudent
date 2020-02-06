package com.hugeyurt.po;

import org.springframework.stereotype.Repository;

@Repository
public class teacherinfo 
{
  public String teacher;
  public String teachername;
  public String age;
  public String ID;
  public String sex;
 
  public String note;
  
  public teacherinfo()
  {
	  
  }

public String getTeacher() {
	return teacher;
}

public void setTeacher(String teacher) {
	this.teacher = teacher;
}

public String getTeachername() {
	return teachername;
}

public void setTeachername(String teachername) {
	this.teachername = teachername;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getID() {
	return ID;
}

public void setID(String iD) {
	ID = iD;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}
  
}
