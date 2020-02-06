package com.hugeyurt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hugeyurt.po.Point;

@Controller
public class LoginController
{
	@RequestMapping("/login.do")
	public ModelAndView test(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "i like china");
		mv.setViewName("hello");
		return mv;
	} 
	
	@RequestMapping("/login2.do")
	public String test2(Model model,HttpSession session) 
    {
		// TODO Auto-generated method stub
	    model.addAttribute("message", "i like hugeyurt!");
		
		return "hello";
	} 

	@RequestMapping("/login3.do")
	@ResponseBody
	public Point test3(Model model,HttpSession session) 
    {
				
		return new Point(3,6);
	} 
	
	@RequestMapping("/login4.do")
	@ResponseBody
	public Point test4(Point point) 
    {
				
		return point;
	} 

}
