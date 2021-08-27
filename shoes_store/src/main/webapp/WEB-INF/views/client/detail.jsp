<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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



    <!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                    	<img  height="500px" class="card-img " src="data:image/jpeg;base64,${product.image}">
                    </div>
                   
                </div>
                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body" data-id="${product.id}">
                            <h1 class="h2">${product.name }</h1>
                            <p class="h3 py-2">${product.price } VND</p>
                            <p class="py-2">
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-secondary"></i>
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Brand:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>Easy Wear</strong></p>
                                </li>
                            </ul>

                            <h6>Description:</h6>
                            <p>${product.description }</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Avaliable Color :</h6>
                                </li>
                                <li class="list-inline-item">
                                	<c:forEach var="detailProduct" items="${product.getImports()}" varStatus="loop">
                                		<span class="text-muted">
                                			<input type="radio" class="form-check-input product-color" name="color" value="${detailProduct.getColor()}">${detailProduct.getColor()}
                                	  </span>
                                	</c:forEach>
                                </li>
                            </ul>
                            <form action="" method="GET">
                                <input type="hidden" name="product-title" value="Activewear">
                                <div class="row">
                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                        	<li class="list-inline-item">Size :
                                                <input type="hidden" name="product-size" id="product-size" value="S">
                                            </li>
                                        	<c:forEach var="detailProduct" items="${product.getImports()}" varStatus="loop">
                                        		<label class="form-check-label list-inline-item">
											    	<input type="radio" class="form-check-input product-size" name="size" value="${detailProduct.getSize() }">${detailProduct.getSize() }
											  </label>
		                                		
		                                	</c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="row pb-3" >
                                    <div class="col d-grid"  data-id="${product.id}">
                                        <button type="submit" class="btn btn-success btn-lg add-to-card" name="submit" value="addtocard">Add To Cart</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Close Content -->

	<div class="container">
        <div class="detailBox justify-content-center">
            <div class="commentBox text-center">
                
                <p class="taskDescription">Phản Hồi Từ Những Khách Đã Mua Sản Phẩm</p>
            </div>
            <div class="actionBox">
                <ul class="commentList">
                		<c:forEach var="feedback" items="${feedbacks}" varStatus="loop">
                        	<li>
		                        <div class="commenterImage">
		                        	<img src="data:image/jpeg;base64,${feedback.getUser().getImage()}">
		                        </div>
		                        <div class="commentText">
		                            <p class="">${feedback.content}.</p> <span class="date sub-text">${feedback.date}</span>
		        
		                        </div>
		                    </li>       		
		                 </c:forEach>
                </ul>
                <form class="form-inline cc" role="form"  method="post" action="post/${product.id }">
                    <div class="form-group justify-content-center">
                        <input class="form-control" type="text" placeholder="Your comments" name="content"  />
                    </div>
                    <div class="form-group">
                        <input type="submit"  class="btn btn-info" value="post"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
	
    <!-- Start Article -->
    <section class="py-5">
        <div class="container">
            <div class="row text-left p-2 pb-3">
                <h4>Related Products</h4>
            </div>

            <!--Start Carousel Wrapper-->
            <div id="carousel-related-product" >
				<c:forEach var ="relate" items="${products}">
                <div class="p-2 pb-3" data-relate="${relate.id}">
                    <div class="product-wap card rounded-0">
                        <div class="card rounded-0">
                            <img class="card-img rounded-0 img-fluid" src="data:image/jpeg;base64,${relate.image}" />
                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center" data-id ="${relate.id}">
                                <ul class="list-unstyled">
                                    <li><button class="btn btn-success text-white"><i class="far fa-heart"></i> </button></li>
                                    <li><button class="detail btn btn-success text-white mt-2"><i class="far fa-eye"></i> </button></li>
                                    <li><button class="add-to-card-relate btn btn-success text-white mt-2"><i class="fas fa-cart-plus"></i> </button></li>
         
                                </ul>
                            </div>
                        </div>
                        <div class="card-body" data-info="40">
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                <c:forEach var="detailProduct" items="${relate.getImports()}" varStatus="loop">
                                        		<label class="form-check-label list-inline-item">
											    	<input type="radio" class="form-check-input product-size" name="size" value="${detailProduct.getSize()}">${detailProduct.getSize()}
											   </label>
		                                		
		                         </c:forEach>
                            </ul>
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                <c:forEach var="detailProduct" items="${relate.getImports()}" varStatus="loop">
                                		<span class="text-muted"><label class="form-check-label list-inline-item">
									    	<input type="radio" class="form-check-input product-color" name="color" value="${detailProduct.getColor()}">${detailProduct.getColor()}
									   </label></span>
                                </c:forEach>
                            </ul>
                            <p class="text-center mb-0">${relate.price}VND</p>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <!-- End Article -->
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script src="<c:url value="resources/assets/js/slick.min.js" />" ></script>
 <script type="text/javascript">
$(document).ready(function(){
	 $(".add-to-card").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var color =  $("div[data-id]").find("input[name='color']:checked").val();
		 var size =  $("div[data-id]").find("input[name='size']:checked").val();
		 var url = "/shoes_store/card/add/"+id+"/size/"+size+"/color/"+color;
		 $.ajax({
				url:url,
				type: "GET",
				success: function( response ){
					$("#amt").html(response[1]);
					$("#cnt").html(response[0]);
					alert("Đã thêm vào giỏ hàng!");
				}
		});
	 });
	 $(".add-to-card-relate").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var color =  $("div[data-relate]").find("input[name='color']:checked").val();
		 var size =  $("div[data-relate]").find("input[name='size']:checked").val();
		 var url = "/shoes_store/card/add/"+id+"/size/"+size+"/color/"+color;
		 $.ajax({
				url:url,
				type: "GET",
				success: function( response ){
					$("#amt").html(response[1]);
					$("#cnt").html(response[0]);
					alert("Đã thêm vào giỏ hàng!");
				}
		});
	 });
	 $(".detail").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var url = "/shoes_store/detail/"+id;
		 top.location.href=url;
	 });
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
});
</script>
    