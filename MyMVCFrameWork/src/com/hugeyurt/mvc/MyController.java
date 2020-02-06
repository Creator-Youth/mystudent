package com.hugeyurt.mvc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyController 
{
	/*
	 *   params:
	 *     request, response //对应的http请求和相应报文
	 *     HashMap：//存储显示结果数据；
	 *   return:
	 *     String:// 告诉控制用哪个页面去显示数据
	 */
  public abstract void doGet(HttpServletRequest request,
		  HttpServletResponse response);

  public abstract void doPost(HttpServletRequest request,
		  HttpServletResponse response);
  
}
