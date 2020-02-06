package com.hugeyurt.po;

import org.springframework.stereotype.Repository;

@Repository
public class studentandscorename 
{
  public String studentid;
  public String scorename;
  
  public  studentandscorename ()
  {
	 
  }

public String getStudentid() {
	return studentid;
}

public void setStudentid(String studentid) {
	this.studentid = studentid;
}

public String getScorename() {
	return scorename;
}

public void setScorename(String scorename) {
	this.scorename = scorename;
}
  
  
}
