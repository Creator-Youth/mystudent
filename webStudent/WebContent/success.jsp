<%@page import="com.hugeyurt.po.Student"%>
<%@page import="com.hugeyurt.po.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% Student stuvo=(Student)session.getAttribute("stuvo");
      //if(stuvo==null) response.sendRedirect("login.html");
   %>
   <h1>欢迎您：<% if(stuvo!=null) out.write(stuvo.getSname()); %></h1>
   <a href="view">查看所有学生信息</a>
</body>
</html>