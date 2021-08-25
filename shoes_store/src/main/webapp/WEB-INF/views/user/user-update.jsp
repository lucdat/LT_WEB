<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div
			class="offset-lg-2 col-lg-8 col-sm-8 col-8 border rounded main-section">
			<h3 class="text-center text-inverse">UPDATE USER</h3>
			<hr>
			<form:form action="${url}" method="post" modelAttribute="user"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-12">
						<div class="form-group">
							<label class="text-inverse" for="validationCustom01">Name</label>
							<form:input path="name" class="form-control"
								id="validationCustom01" placeholder="Name" />
						</div>
					</div>
					<div class="col-lg-6 col-sm-6 col-12">
						<div class="form-group">
							<label class="text-inverse" for="validationCustom02">Email</label>
							<form:input path="email" class="form-control"
								id="validationCustom02" placeholder="Email" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-12 col-12">
						<div class="form-group">
							<label class="text-inverse" for="inputEmail4">Phone</label>
							<form:input path="phone" class="form-control"
								id="validationCustom02" placeholder="Phone" />
						</div>
					</div>
					<div class="col-lg-6 col-sm-6 col-12">
						<div class="form-group">
							<label class="text-inverse" for="select-menu">ROLE</label> <select
								class="custom-select d-block form-control" name="role.id">
								<option value="">SELECT ROLE</option>


								<c:forEach items="${roles}" var="role">
									<option value="${role.id}">${role.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-12">
						<img width="30%" height="30%"
							src="data:image/jpeg;base64,${user.image}">
						<div class="form-group">
							<label class="custom-file"> <form:input type="file"
									id="file" class="form-control custom-file-input" path="file" />
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-camera" viewBox="0 0 16 16">
  						<path
										d="M15 12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V6a1 1 0 0 1 1-1h1.172a3 3 0 0 0 2.12-.879l.83-.828A1 1 0 0 1 6.827 3h2.344a1 1 0 0 1 .707.293l.828.828A3 3 0 0 0 12.828 5H14a1 1 0 0 1 1 1v6zM2 4a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2h-1.172a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 9.172 2H6.828a2 2 0 0 0-1.414.586l-.828.828A2 2 0 0 1 3.172 4H2z" />
 					    <path
										d="M8 11a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zm0 1a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM3 6.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z" />
					</svg> <span class="custom-file-control">Avatar</span>
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-sm-12 col-12 text-center">
						<button class="btn btn-info" type="submit">Submit form</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<script
	src="<%=request.getContextPath()%>/resources/js/products/validate-form.js"></script>