<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	Object id = session.getAttribute("id");
	Object pwd = session.getAttribute("pwd");
	Object age = session.getAttribute("age");
	
	
	%>
	
	id: <%=id %> <br>
	pwd: <%=pwd%> <br>
	age: <%=age %> <br>

</body>
</html>