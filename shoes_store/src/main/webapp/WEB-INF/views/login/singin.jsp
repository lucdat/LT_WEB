<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<title>Flash Able - Most Trusted Admin Template</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description"
	content="Flash Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
<meta name="keywords"
	content="admin templates, bootstrap admin templates, bootstrap 4, dashboard, dashboard templets, sass admin templets, html admin templates, responsive, bootstrap admin templates free download,premium bootstrap admin templates, Flash Able, Flash Able bootstrap admin template">
<meta name="author" content="Codedthemes" />

<!-- Favicon icon -->
<link rel="icon" href="<c:url value="resources/images/favicon.ico"/>"
	type="image/x-icon">
<!-- fontawesome icon -->
<link rel="stylesheet"
	href="<c:url value="resources/fonts/fontawesome/css/fontawesome-all.min.css"/>">
<!-- animation css -->
<link rel="stylesheet"
	href="<c:url value="resources/plugins/animation/css/animate.min.css"/>">

<!-- vendor css -->
<link rel="stylesheet" href="<c:url value="resources/css/style.css"/>">
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>

<!-- [ auth-signin ] start -->
<div class="auth-wrapper">
	<div class="auth-content container">
		<div class="card">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="card-body">
						<img src="<c:url value="resources/images/logo-dark.png"/>" alt=""
							class="img-fluid mb-4">
						<h4 class="mb-3 f-w-400">Login into your account</h4>
						<form:form action="login" method="post" modelAttribute="account">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="feather icon-mail"></i></span>
								</div>
									<form:input path="email" cssClass="form-control"/> <form:errors path="email" cssClass="error"/>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="feather icon-lock"></i></span>
								</div>
									<form:input path="password" cssClass="form-control"/><form:errors path="password" cssClass="error"/>
							</div>
							<button class="btn btn-primary mb-4">Login</button>
						</form:form>
						<p class="mb-2 text-muted">
							Forgot password? <a href="auth-reset-password.html"
								class="f-w-400">Reset</a>
						</p>
						<p class="mb-0 text-muted">
							Don't have an account? <a href="auth-signup.html" class="f-w-400">Signup</a>
						</p>
					</div>
				</div>
				<div class="col-md-6 d-none d-md-block">
					<img src="<c:url value="resources/images/auth-bg.jpg"/>" alt=""
						class="img-fluid">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- [ auth-signin ] end -->

<!-- Required Js -->
<script src="<c:url value="resources/js/vendor-all.min.js"/>"></script>
<script
	src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script>


<div class="footer-fab">
	<div class="b-bg">
		<i class="fas fa-question"></i>
	</div>
	<div class="fab-hover">
		<ul class="list-unstyled">
			<li><a href="../doc/index-bc-package.html" target="_blank"
				data-text="UI Kit" class="btn btn-icon btn-rounded btn-info m-0"><i
					class="feather icon-layers"></i></a></li>
			<li><a href="../doc/index.html" target="_blank"
				data-text="Document"
				class="btn btn-icon btn-rounded btn-primary m-0"><i
					class="feather icon feather icon-book"></i></a></li>
		</ul>
	</div>
</div>


</body>

</html>
