<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<a href="<c:url value="/user/add" />" class="btn btn-info mx-auto"
			role="button">ADD NEW USER</a>
	</div>
	<div class="row">
		<div class="col-12">
			<table class="table table-bordered">
				<thead class="text-center">
					<tr>
						<th scope="col">STT</th>
						<th scope="col" class="text-center">AVATAR</th>
						<th scope="col" class="text-center">NAME</th>
						<th scope="col" class="text-center">EMAIL</th>
						<th scope="col" class="text-center">PHONE</th>
						<th scope="col" class="text-center">ROLE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}" varStatus="loop">
						<tr>
							<th scope="row">${loop.index +1}</th>
							<td><img width="30%" height="30%" src="data:image/jpeg;base64,${user.image}"></td>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td>${user.role.name}</td>
							<td class="text-center">

								<button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button> 
								<a href="<c:url value="/user/edit/${user.id }"/>" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
								<a href="<c:url value="/user/delete/${user.id }"/>" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>