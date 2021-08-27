<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="apple-touch-icon" href="assets/img/zin.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/zin.png">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/login.css">
</head>
<body>
    
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    REGISTER CUSTOMER
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form:form method="post" modelAttribute="customer" action="register" enctype="multipart/form-data">
                            <div class="form-group">
                                <label class="form-control-label">NAME</label>
								<form:input path="name" class="form-control" id="names" placeholder="Enter Name" />                            
							</div>
                            <div class="form-group">
                                <label class="form-control-label">USERNAME</label>
								<form:input path="email" class="form-control" id="emails" placeholder="Enter Email" />                            
							</div>
                            <div class="form-group">
                                <label class="form-control-label">PASSWORD</label>
                                <form:input path="password" type="password" class="form-control" id="passwords" placeholder="Enter Password" />                            
                             </div>
                             <div class="form-group">
                                <label class="form-control-label">PHONE</label>
								<form:input path="phone" class="form-control" id="phones" placeholder="Enter Phone" />                            
							</div>
							<div class="form-group">
                                <label class="form-control-label">IMAGE</label>
								<form:input type="file" id="file" class="form-control custom-file-input"  path="file" />							</div>
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                    <!-- Error Message -->
                                    <label>${message }</label>
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                	<a href="<c:url value="/" />" class="btn btn-outline-success" role="button">HOME</a>
                                    <button type="submit" class="btn btn-outline-primary" value="login">REGISTER</button>
                                </div>
                            </div>
                        </form:form>
                        
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
         </div>

</body>
<script src="<%=request.getContextPath() %>/resources/js/products/validate-form.js"></script>

</html>
