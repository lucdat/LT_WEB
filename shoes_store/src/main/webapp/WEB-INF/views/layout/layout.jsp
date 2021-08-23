<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">

<head>

<title>Flash Able - Most Trusted Admin Template</title>
<!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 11]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
<!-- Meta -->
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
</head>

<body class="">
	<!-- [ Pre-loader ] start -->
	<div class="loader-bg">
		<div class="loader-track">
			<div class="loader-fill"></div>
		</div>
	</div>
	<!-- [ Pre-loader ] End -->

	<!-- [ navigation menu ] start -->
	<tiles:insertAttribute name="menu" />
	<!-- [ navigation menu ] end -->

	<!-- [ Header ] start -->
	<tiles:insertAttribute name="header" />
	<!-- [ Header ] end -->

	<!-- [ Main Content ] start -->
	<div class="pcoded-main-container">
		<div class="pcoded-wrapper">
			<div class="pcoded-content">
				<div class="pcoded-inner-content">
					<div class="main-body">
						<div class="page-wrapper">
							<!-- [ Main Content ] start -->
							<tiles:insertAttribute name="body" />
							<!-- [ Main Content ] end -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<!-- Required Js -->
	<script src="<c:url value="resources/js/vendor-all.min.js"/>"></script>
	<script
		src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="resources/js/pcoded.min.js"/>"></script>

</body>

</html>
