<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
 <title>Zay Shop </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="<%=request.getContextPath() %>/resources/assets/img/zin.png">
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/resources/assets/img/zin.png">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/custom.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/fontawesome.min.css">
      <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/assets/css/slick-theme.css">
<!--
</head>

<body class="">
	<!-- [ navigation menu ] start -->
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />	
	<!-- Start Script -->
    <script src="<%=request.getContextPath() %>/resources/assets/js/jquery-1.11.0.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/templatemo.js"></script>
    <script src="<%=request.getContextPath() %>/resources/assets/js/custom.js"></script>
     <script src="<%=request.getContextPath() %>/resources/assets/js/slick.min.js"></script>
<script>
        $('#carousel-related-product').slick({
            infinite: true,
            arrows: false,
            slidesToShow: 4,
            slidesToScroll: 3,
            dots: true,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                }
            ]
        });
    </script>
    <!-- End Script -->
</body>

</html>
