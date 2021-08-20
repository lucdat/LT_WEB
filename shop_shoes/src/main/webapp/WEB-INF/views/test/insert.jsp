<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="insert"  method="POST" modelAttribute="test">
		<form:input  path="description"/>
		<br><br>  
		<form:input  path="activeFlag"/>
		<br><br>  
        <input type="submit" value="Submit" />      
	</form:form>
</body>
</html>