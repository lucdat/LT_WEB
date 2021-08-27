 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Content -->
    <div class="container py-5">
        <div class="row">

            <div class="col-lg-3">
                <h1 class="h2 pb-4">Thể loại</h1>
                <ul class="list-unstyled templatemo-accordion">
                	<c:forEach var="category" items="${categories}" varStatus="loop">
                			<c:choose>
                				<c:when test="${category.id== id}">
                					
									      <a class="pb-3 collapsed d-flex justify-content-between h3 text-decoration-none text-danger" href="<c:url value="/shop/${category.id }" />">
					                            ${category.name }
					                        </a>

							    </c:when>    
							    <c:otherwise>
							         <a class="pb-3 collapsed d-flex justify-content-between h3 text-decoration-none active" href="<c:url value="/shop/${category.id }" />">
			                            ${category.name }
			                        </a>
							    </c:otherwise>
                			</c:choose>
		                       
	                      	
	               
                	</c:forEach>
                </ul>
            </div>

            <div class="col-lg-9">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="#">All</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="#">Nam</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none" href="#">Nữ</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-6 pb-4">
                        <div class="d-flex">
                            <select class="form-control">
                                <option>Featured</option>
                                <option>A to Z</option>
                                <option>Item</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                  <!--   vong lap for  -->
                    <c:forEach var="product" items="${list}" varStatus="loop">
		        		<div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                            	<img class="card-img rounded-0 img-fluid" src="data:image/jpeg;base64,${product.image}">
                                <div  data-id="${product.id}"  class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li> <button class="btn btn-success text-white like" ><i class="far fa-heart"></i></button></li>
                                        <li> <button class="btn btn-success text-white mt-2 detail" ><i class="far fa-eye"></i></button></li>
                                        <li> <button  class="btn btn-success text-white mt-2 add-to-card" ><i class="fas fa-cart-plus"></i></button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="<c:url value="/detail/${product.id }" />" class="h3 text-decoration-none">${product.name }</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li>M/L/X/XL</li>
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                    </li>
                                </ul>
                                <p class="text-center mb-0">${product.price }</p>
                            </div>
                        </div>
                    </div>
        			</c:forEach>
                   <!-- end for -->
                </div>
                <div div="row">
                    <ul class="pagination pagination-lg justify-content-end">
                    	<c:forEach var = "i" begin = "1" end ="${paging.getTotalPages() }">
					         <c:choose>
							    <c:when test="${paging.indexPage== i}">
								     <li class="page-item disabled">
			                            <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="<c:url value="/shop/list/${i }" />">${i }</a>
			                        </li>
							    </c:when>    
							    <c:otherwise>
							        <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="<c:url value="/shop/list/${i }" />">${i }</a>
							    </c:otherwise>
							</c:choose>
					         
					      </c:forEach>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <!-- End Content -->

    <!-- Start Brands -->
    <section class="bg-light py-5">
        <div class="container my-4">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Our Brands</h1>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        Lorem ipsum dolor sit amet.
                    </p>
                </div>
                <div class="col-lg-9 m-auto tempaltemo-carousel">
                    <div class="row d-flex flex-row">
                        <!--Controls-->
                        <div class="col-1 align-self-center">
                            <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                                <i class="text-light fas fa-chevron-left"></i>
                            </a>
                        </div>
                        <!--End Controls-->

                        <!--Carousel Wrapper-->
                        <div class="col">
                            <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example" data-bs-ride="carousel">
                                <!--Slides-->
                                <div class="carousel-inner product-links-wap" role="listbox">

                                    <!--First slide-->
                                    <div class="carousel-item active">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_01.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_02.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_03.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_04.png" />" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End First slide-->

                                    <!--Second slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_01.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_02.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_03.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_04.png" />" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Second slide-->

                                    <!--Third slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_01.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_02.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_03.png" />" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="<c:url value="resources/assets/img/brand_04.png" />" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Third slide-->

                                </div>
                                <!--End Slides-->
                            </div>
                        </div>
                        <!--End Carousel Wrapper-->

                        <!--Controls-->
                        <div class="col-1 align-self-center">
                            <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                                <i class="text-light fas fa-chevron-right"></i>
                            </a>
                        </div>
                        <!--End Controls-->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--End Brands-->
<script type="text/javascript">
$(document).ready(function(){
	 $(".add-to-card").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var url = "/shoes_store/card/add/"+id+"/size/41/color/white";
		 $.ajax({
				url:url,
				type: "GET",
				success: function( response ){
					$("#amt").html(response[1]);
					$("#cnt").html(response[0]);
					alert("Dã thêm vào giỏ hàng");
				}
		});
	 });
	 $(".detail").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var url = "/shoes_store/shop/detail/"+id;
		 top.location.href=url;
	 });
});
</script>