package com.hugeyurt.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hugeyurt.po.StudentInfo;
import com.hugeyurt.service.enterService;
import com.hugeyurt.service.join;
import com.hugeyurt.service.studentChange;


@Controller
public class EnterController 
{	
	@Resource
	enterService es;
	@Resource
	studentChange sc;	
	@Resource
	join ch;	
	
	@RequestMapping("/enter.do")
	@ResponseBody
	public String enter(HttpServletRequest request, HttpServletResponse response,HttpSession session) //登录界面
	{
		String ss=null;		
		String userID=request.getParameter("UserID");
		char []user=userID.toCharArray();
		String pwd   =request.getParameter("pwd");		
		session.setAttribute("UserID", userID);
		ss = Integer.toString(es.input(userID, pwd));
		if(ss.equals("1"))
		{
			if((user[0])==(char)'t')
			{
				ss="0";
			}
		}
		System.out.println(ss);
		return ss;
	}


	
	@RequestMapping("/viewstudent.do")
	@ResponseBody
	public Object viewstudent(HttpServletRequest request, HttpServletResponse response,HttpSession session) //登录界面
	{	
		StudentInfo st=null;
		try 
		{
	        		
			String ss=(String) session.getAttribute("UserID");				
		    st=(StudentInfo)sc.view(ss, new StudentInfo());								
		} 
		catch ( Exception e){}
		return st;
	}
	
	@RequestMapping("/changepassname.do")
	@ResponseBody
	public String changepassname(HttpServletRequest request, HttpServletResponse response, HttpSession  session) //登录界面
	{			
		String stuID  =(String) session.getAttribute("UserID");
		String passname1   =request.getParameter("passname1");
		
		int i=es.change(stuID, passname1);
		if(i!=0){return "yes";}
		return "no";
	}
	
	@RequestMapping("/create.do")
	@ResponseBody
	public String create(HttpServletRequest request, HttpServletResponse response) //登录界面
	{			
		
	    int i=0,j=0;
		String stuID      =request.getParameter("stuID");
		String stuName    =request.getParameter("stuName");
		String profession =request.getParameter("profession");			
		String ID         =request.getParameter("ID");
		String sex        =request.getParameter("sex");
		String passname1  =request.getParameter("passname1");
		
		i=ch.creatToCheck(stuID, stuName, profession, ID, sex);
		if(i==3)
		{
			j=ch.creatUser(stuID,passname1);
			if(j!=0)
			{
				i=5;
			}//成功注册
			else{i=6;}
		}
		String ss=String.valueOf(i);			
		return ss;
	}
	
	
	@RequestMapping("/change.do")
	@ResponseBody
	public String change(HttpServletRequest request, HttpServletResponse response,HttpSession session) //登录界面
	{	
			String stuID      =(String) session.getAttribute("UserID");
			String stuName    =request.getParameter("stuName");
			String profession =request.getParameter("profession");
			String data       =request.getParameter("data");
			String ID         =request.getParameter("ID");
			String sex        =request.getParameter("sex");
			String totalScore =(String) session.getAttribute("TotalScore");
			String note       =request.getParameter("note");
			String ss=null;
			ss=sc.changeInformation(stuID, stuName, profession, data, ID, sex, totalScore, note);		
		    return  ss;
	}
	
	}
