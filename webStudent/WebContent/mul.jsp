<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>九九乘法表</h1>
  <hr>
  <table border="1">
   <% 
      for(int i=1;i<=9;i++)
      {
     %>
      <tr>
        <% for( int j=1;j<=i;j++)
        	{
        	%>
        	<td><%=i %>*<%=j %>=<%=i*j %></td>
        	<%} %>
       </tr>
     <%} %>
  
  </table>
</body>
</html>