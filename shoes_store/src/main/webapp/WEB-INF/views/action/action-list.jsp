<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<a href="<c:url value="/action/add" />" class="btn btn-info mx-auto"
			role="button">ADD NEW ACTION</a>
	</div>
	<div class="row">
		<div class="col-12">
			<table class="table table-bordered">
				<thead class="text-center">
					<tr>
						<th scope="col">STT</th>
						<th scope="col" class="text-center">NAME</th>
						<th scope="col" class="text-center">URL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="action" items="${actions}" varStatus="loop">
						<tr>
							<th scope="row">${loop.index +1}</th>
							<td>${action.name}</td>
							<td>${action.url}</td>
							<td class="text-center">

								<button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button> 
								<a href="<c:url value="/action/edit/${action.id }"/>" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
								<a href="<c:url value="/action/delete/${action.id }"/>" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>