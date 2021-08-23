<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>New Customer</h2>

		<form:form action="add" method="post" modelAttribute="product"  enctype="multipart/form-data">
			<table border="0" cellpadding="5">
				
				<tr>
					<td>Code:</td>
					<td><form:input path="code" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><form:input path="quantity" /></td>
				</tr>
				<tr>
					<td>Sale:</td>
					<td><form:input path="sale" /></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><form:input path="file" type="file" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>