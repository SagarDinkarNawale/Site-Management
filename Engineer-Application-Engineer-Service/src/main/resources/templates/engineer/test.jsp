<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import java.util%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String) request.getAttribute("k");
/* List<String> plans= request.getAttribute("plans"); */
%>
Name is = <%=name %>
</body>
</html>