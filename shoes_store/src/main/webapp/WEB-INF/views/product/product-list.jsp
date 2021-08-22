<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Product List</h1>
<a href="<%=request.getContextPath() %>/product/add">Add New product</a>
<br/>
<br/>
<br/>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Code</th>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Sale</th>
		<th>Image</th>
		<th>Description</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.id}</td>
			<td>${product.code}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.sale}</td>
			<td><img width="30%" height="30%" src="data:image/jpeg;base64,${product.image}"></td>
			<td>${product.description}</td>
			<td><a href="<%=request.getContextPath() %>/product/edit?id=${product.id}">Edit</a></td>
			<td><a href="<%=request.getContextPath() %>/product/delete?id=${product.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${paging.totalPages}">
		<a href="<%=request.getContextPath() %>/product/list/${i}">| ${i} |</a>
	</c:forEach>
