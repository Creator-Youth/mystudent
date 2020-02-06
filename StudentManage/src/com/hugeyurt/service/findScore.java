package com.hugeyurt.service;

import java.util.ArrayList;

import com.hugeyurt.po.studentandcoursename;

public interface findScore
{
	public abstract String findTotalScore(String stuID);
	public abstract ArrayList<studentandcoursename> findAllScore(String teacher);

}
