package com.hugeyurt.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hugeyurt.po.teacherinfo;
import com.hugeyurt.service.studentChange;
import com.hugeyurt.service.teacher;
import com.hugeyurt.service.impl.findScoreImpl;
import com.hugeyurt.service.impl.pageImpl;

@Controller
public class TeacherController
{
	@Resource
	teacher  te;
	@Resource
	teacherinfo ti;
	@Resource
	studentChange sc;
	@Resource
	pageImpl pa;
	
	@RequestMapping("/teacherview.do")
	@ResponseBody
	public teacherinfo teacherview(HttpServletRequest request, HttpServletResponse response, HttpSession session) //固定总成绩
	{		
		teacherinfo  st=null;
		try 
		{		
			String ss=(String) session.getAttribute("UserID");
		    st=(teacherinfo)te.view(ss, ti);						
		} 
		catch ( Exception e)
		{			
		}
		return st;
	}
	
	@RequestMapping("/addstudent.do")
	@ResponseBody
	public String addstudent(HttpServletRequest request, HttpServletResponse response) //固定总成绩
	{			   	  		
		String stuID      =request.getParameter("stuID");
		String stuName    =request.getParameter("stuName");
		String profession =request.getParameter("profession");
		String data       =request.getParameter("data");
		String ID         =request.getParameter("ID");
		String sex        =request.getParameter("sex");
		String totalScore =request.getParameter("totalScore");
		String note       =request.getParameter("note");
		String ss=null;
		ss=sc.teacherAddStudent(stuID, stuName, profession, data, ID, sex, totalScore, note);
	    return ss;
	}
	
	@RequestMapping("/seeAll.do")
	@ResponseBody
	public  ArrayList<Object> seeAll(HttpServletRequest request, HttpServletResponse response) 
	{	
		int startpage=Integer.valueOf(request.getParameter("page"));
	    int j=3;		
		return pa.viewSomeStudent(startpage, j);
	}
	
	@RequestMapping("/changeInfo.do")
	@ResponseBody
	public  String changeInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException //固定总成绩
	{ 				    		   	
			String stuID      =request.getParameter("stuID");
			findScoreImpl score=new findScoreImpl();		
			String totalScore =score.findTotalScore(stuID);
			String stuName    =request.getParameter("stuName");
			String profession =request.getParameter("profession");
			String data       =request.getParameter("data");
			String ID         =request.getParameter("ID");
			String sex        =request.getParameter("sex");			
			String note       =request.getParameter("note");
			String ss=null;
			ss=sc.changeInformation(stuID, stuName, profession, data, ID, sex, totalScore, note);
		    return ss;
	}
	
	@RequestMapping("/changeStuProf.do")
	@ResponseBody
	public String changeStuProf(HttpServletRequest request, HttpServletResponse response) //固定总成绩
	{			   	  		
		String stuID      =request.getParameter("stuID");
		String profession =request.getParameter("profession");
	    int i=0;
		i=sc.changeStuProfession(stuID,profession);
		if(i!=0){return "yes";}
	    return "no";
	}
	
	
	@RequestMapping("/findByProf.do")
	@ResponseBody
	public  ArrayList<Object> findByProf(HttpServletRequest request, HttpServletResponse response) //固定总成绩
	{	
		String profession =request.getParameter("profession");	
		return te.findByProf(profession);
	}
	
	@RequestMapping("/findByName.do")
	@ResponseBody
	public  ArrayList<Object> findByName(HttpServletRequest request, HttpServletResponse response) //固定总成绩
	{	
		String stuName =request.getParameter("stuName");
		return te.findByName(stuName);
	}
	
	
	@RequestMapping("/changeTeaSou.do")
	@ResponseBody
	public  String  changeTeaSou(HttpServletRequest request, HttpServletResponse response,HttpSession session) //固定总成绩
	{	
		String scorename =request.getParameter("scorename");		
		String teacher=(String) session.getAttribute("UserID");
		return te.changeTeaSou(scorename, teacher);
	}
	
	@RequestMapping("/teacherChange.do")
	@ResponseBody
	public  String  teacherCha(HttpServletRequest request, HttpServletResponse response,HttpSession session) //固定总成绩
	{	
		String teachername =request.getParameter("teachername1");
		String sex  =request.getParameter("sex1");	
		String ID   =request.getParameter("ID1");	
		String age  =request.getParameter("age1");	
		String note =request.getParameter("note1");	
		String teacher=(String) session.getAttribute("UserID");
		te.teachChag(teachername, sex, ID, age, note, teacher);
		return "yes";
	}
	
	

}


