package com.hugeyurt.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hugeyurt.po.studentandcoursename;
import com.hugeyurt.service.Score;
import com.hugeyurt.service.course;
import com.hugeyurt.service.findScore;

@Controller
public class ScoreController
{

	@Resource
	findScore findscore;
	@Resource
	Score score;
	@Resource
	course co;
	@RequestMapping("/findTotalScore.do")
	@ResponseBody
	public void enter(HttpServletRequest request, HttpServletResponse response,HttpSession session) //固定总成绩
	{
		
		
		String stuid=(String) session.getAttribute("UserID");
		
		String total =findscore.findTotalScore(stuid);
		session.setAttribute("TotalScore",total);
		System.out.println(total);

	}
	
	@RequestMapping("/see.do")
	@ResponseBody
	public Object see(HttpServletRequest request, HttpServletResponse response) 
	{		
		
		String studentid =request.getParameter("studentid");
		String coursename=request.getParameter("coursename");		
		return  score.select(studentid, coursename);		
	}
	

	@RequestMapping("/addScore.do")
	@ResponseBody
	public String  studentAddScore(HttpServletRequest request, HttpServletResponse response,HttpSession session) //固定总成绩
	{						
		String ss=null;
		try 
		{	       		
			String stuID     =(String) session.getAttribute("UserID");	
			char []user=stuID.toCharArray();
			String scorename =request.getParameter("scorename");
			if((user[0])==(char)'n')
			    {
				   ss=String.valueOf(co.addStudentScore(stuID, scorename));
			    }
			else
			   {
				   ss=String.valueOf(co.addTeacherScore(stuID, scorename));
			   }			
		} 
		catch ( Exception e)
		{			
		}
		return ss;
	}
	

	@RequestMapping("/changescore.do")
	@ResponseBody
	public String  changescore(HttpServletRequest request, HttpServletResponse response) //固定总成绩
	{				
		String testscore     =request.getParameter("testscore");
		String note          =request.getParameter("note");		
		String basescore     =request.getParameter("basescore");
		int ts=Integer.parseInt(testscore);
		int bs=Integer.parseInt(basescore);
		double fs=0.7*ts+0.3*bs;
		String finalscore =String.valueOf(fs);		
		String stuid      =request.getParameter("studentid");		
		String coursename =request.getParameter("coursename");		
	
		int i=0;
		i=score.addScore(coursename, stuid, basescore, testscore, finalscore, note);
		if (i!=0)
		{return "yes";}
		return "no";

	}

	@RequestMapping("/findscore.do")
	@ResponseBody
	public ArrayList<studentandcoursename> findscore(HttpServletRequest request, HttpServletResponse response,HttpSession session) //固定总成绩
	{
		String teacher=(String) session.getAttribute("UserID");
		
		ArrayList<studentandcoursename> list=findscore.findAllScore(teacher);
		return list;
	}
	
	
	@RequestMapping("/Allcourse.do")
	@ResponseBody
	public ArrayList<String> Allcourse(HttpServletRequest request, HttpServletResponse response,HttpSession  session) throws SQLException //登录界面
	{	ArrayList<String> list=new	ArrayList<String> ();		   
		String stuID  =(String) session.getAttribute("UserID");
		char []user=stuID.toCharArray();
		
		ResultSet set=null;
		if((user[0])==(char)'n')
		    {
			set=co.studentAllScore(stuID);
		    }
		else
		   {
			set=co.teacherAllScore(stuID);
		   }			
		while(set.next())
		{
			list.add(set.getString("scorename"));						
		}
	   return list;		
	}
	
	@RequestMapping("/stopSelectScore.do")
	@ResponseBody
	public String stopSelectScore(HttpServletRequest request, HttpServletResponse response,HttpSession session) //登录界面
	{
		String ss=null;	
		String userID=(String)session.getAttribute("UserID");
		char []user=userID.toCharArray();	
		if((user[0])==(char)'t')
		{
		    ss="0";
		}
		else {ss="1";}		
		return ss;
	}

	

}


