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
                   <div class="row">
                        <div class="col-4">
                               <a href="#">
                                      <img width="450px" height="450px" src="data:image/jpeg;base64,${product.image}" alt="Product Image 1">
                               </a>
                        </div>                 
                    </div>
                </div>
                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2">${product.name}</h1>
                            <p class="h3 py-2">${product.price*(1-product.sale)}VND</p>
                            <p class="py-2">
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-secondary"></i>
                                <span class="list-inline-item text-dark">Rating 4.8 | 36 Comments</span>
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Brand:${product.code}</h6>
                                </li>
                            </ul>

                            <h6>Description:</h6>
                            <p>${product.description}</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Avaliable Color :</h6>
                                </li>
                                <li class="list-inline-item">
                                 	<c:forEach var="c" items="${color}">
                                              <p class="text-muted"><strong>${c}</strong></p>
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
                                            <c:forEach var="s" items="${size}">
                                            	<li class="list-inline-item"><span class="btn btn-success btn-size">${s}</span></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="row pb-3" >
                                    <div class="col d-grid" data-id="${product.id}" >
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
                	<c:forEach var="feedback" items="${feedBacks}">
                    <li>
                        <div class="commenterImage">
                          <img src="data:image/jpeg;base64,${feedBack.user.image}"/>
                        </div>
                        <div class="commentText">
                            <p class="">${feedBack.content}</p> <span class="date sub-text">${feedBack.date}</span>
        
                        </div>
                    </li>
                    </c:forEach>
                </ul>
                <form class="form-inline cc" role="form" action="/cc">
                    <div class="form-group justify-content-center">
                        <input class="form-control" type="text" placeholder="Your comments" />
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
            <div id="carousel-related-product">
				<c:forEach items="${products}"  var="relate">
                <div class="p-2 pb-3">
                    <div class="product-wap card rounded-0">
                        <div class="card rounded-0">
                            <img class="card-img rounded-0 img-fluid" src="data:image/jpeg;base64,${relate.image}" >
                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center" data-id="${relate.id}">
                                <ul class="list-unstyled">
                                    <li> <button class="btn btn-success text-white like" ><i class="far fa-heart"></i></button></li>
                                    <li> <button class="btn btn-success text-white mt-2 detail" ><i class="far fa-eye"></i></button></li>
                                    <li> <button  class="btn btn-success text-white mt-2 add-to-card" ><i class="fas fa-cart-plus"></i></button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-body">
                            <a href="shop-single.html" class="h3 text-decoration-none">Red Clothing</a>
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
                                    <i class="text-muted fa fa-star"></i>
                                </li>
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
<script src="<c:url value="resources/assets/js/slick.min.js" />" ></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
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
					alert("Đã thêm vào giỏ hàng");
				}
		});
	 });
	 $(".detail").click(function(){
		 var id = $(this).closest("div").attr("data-id"); 
		 var url = "/shoes_store/shop/detail/"+id;
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
