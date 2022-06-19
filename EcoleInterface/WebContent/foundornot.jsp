<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Research result</title>
</head>
<body>

<%
String result = (String)request.getAttribute("txtresult");
out.println(result);
%>

</body>
</html>