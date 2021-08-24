<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

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
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/images/favicon.ico"
	type="image/x-icon">
<!-- fontawesome icon -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/fonts/fontawesome/css/fontawesome-all.min.css">
<!-- animation css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/plugins/animation/css/animate.min.css">

<!-- vendor css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">


</head>

<!-- [ auth-signup ] start -->
<div class="auth-wrapper">
	<div class="auth-content container">
		<div class="card">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="card-body">
						<h4 class="mb-3 f-w-400">Sign up into your account</h4>
						<form:form modelAttribute="user" method="post">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="feather icon-user"></i></span>
								</div>
								<form:input path="name" cssClass="form-control" placeholder="Name"/>
							</div>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fa fa-phone"></i></span>
								</div>
								<form:input path="phone" cssClass="form-control" placeholder="Phone"/>
							</div>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="feather icon-mail"></i></span>
								</div>
									<form:input path="email" type="email" cssClass="form-control" placeholder="Email address"/>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="feather icon-lock"></i></span>
								</div>
									<form:input path="password" type="password" cssClass="form-control" placeholder="Password"/>
							</div>
							<div class="form-group text-left mt-2"></div>
							<button class="btn btn-primary mb-4">Sign up</button>
						</form:form>
						<p class="mb-2">
							Already have an account? <a href="auth-signin.html"
								class="f-w-400">Log in</a>
						</p>
					</div>
				</div>
				<div class="col-md-6 d-none d-md-block">
					<img
						src="<%=request.getContextPath()%>/resources/images/auth-bg.jpg"
						alt="" class="img-fluid">

				</div>
			</div>
		</div>
	</div>
</div>
<!-- [ auth-signup ] end -->

<!-- Required Js -->
<script
	src="<%=request.getContextPath()%>/resources/js/vendor-all.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
