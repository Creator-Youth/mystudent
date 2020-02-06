package com.hugeyurt.service;

import java.sql.ResultSet;

public interface course
{
	public  abstract int addStudentScore(String stuID,String scorename);
	public abstract int addTeacherScore(String stuID,String scorename);
	public  abstract ResultSet studentAllScore(String stuID);
	public abstract ResultSet teacherAllScore(String stuID);

}
