package com.hugeyurt.service;

public interface Score 
{
	 public abstract Object select(String stuid,String coursename);
	 public abstract int addScore(String coursename,String stuid,String  basescore,String testscore,String finalscore,String note );
}
