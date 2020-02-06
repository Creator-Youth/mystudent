package com.hugeyurt.test;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.hugeyurt.database.DBConnection;
import com.hugeyurt.database.ORMUtil;
import com.hugeyurt.po.StudentInfo;
import com.hugeyurt.po.studentandcoursename;

import com.hugeyurt.po.teacherinfo;
import com.hugeyurt.service.page;
import com.hugeyurt.service.teacher;
import com.hugeyurt.service.impl.courseImpl;
import com.hugeyurt.service.impl.findScoreImpl;
import com.hugeyurt.service.impl.pageImpl;
import com.hugeyurt.service.impl.scoreImpl;
import com.hugeyurt.service.impl.studentChangeImpl;
import com.hugeyurt.service.impl.teacherImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("unused")
public class APP {

	public static void main(String[] args) throws SQLException 
	{  /*
		page pa=new pageImpl();
		teacher  te=new teacherImpl();
		ArrayList<Object> list=te.seeAll();
		pa.setAllStudent(list);
		ArrayList<Object> list1=pa.viewSomeStudent(0, 2);
		JSONArray json=JSONArray.fromObject(list1);
		System.out.print(json.toString());*/
}
}
