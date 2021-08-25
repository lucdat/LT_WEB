 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="resources/assets/img/banner_img_01.jpg" />" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-success"><b>Zin</b> Shop</h1>
                              
                                <p style="text-align: center;"><em>Đôi giày nhỏ trên phố </em></p>
                                <p style="text-align: center;"><em>Nhớ quán nhỏ bên đường </em></p>
                                <p style="text-align: center;"><em>Điệu nhạc nào thân ái</em></p>
                                <p style="text-align: center;"><em>Lòng còn mãi vấn vương </em></p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="resources/assets/img/b2.png" />" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-center">
                                <h1 style="text-align: center;" class="h1 text-success"><b>Zin</b> Shop</h1>
                                <p style="text-align: center;"><em>Nếu một mai anh mang tặng em chiếc giày </em></p>
                                <p style="text-align: center;"><em>Là lúc đó anh chọn em cùng đi cuối đời</em></p>
                                <p style="text-align: center;"><em>Chẳng mong cầu ngày sau ta giàu có</em></p>
                                <p style="text-align: center;"><em>Chỉ mong rằng lúc khốn khó ta có nhau </em></p>
                                <p style="text-align: center;"><em>———-*****———- </em></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="resources/assets/img/b3.png" />" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <div class="text-align-left">
                                    <h1 style="text-align: center;" class="h1 text-success"><b>Zin</b> Shop</h1>
                                    <p style="text-align: center;"><em>Đừng tặng em một đôi giày thủy tinh</em></p>
                                    <p style="text-align: center;"><em>Vì tình mình không lung linh như em tưởng</em></p>
                                    <p style="text-align: center;"><em>Hãy mượn gió làm cho em chiếc giày cỏ </em></p>
                                    <p style="text-align: center;"><em>Để khi khốn khó em vẫn không nỡ bỏ anh. </em></p>
                                    <p style="text-align: center;"><em>———-*****———- </em></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->
    
    
    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Các hạng mục của tháng</h1>
                <p style="text-align: center;"><em>Cần sa em đâu có thích</em></p>
                <p style="text-align: center;"><em>Vì chất kích thích ngọt nhất vẫn là đồ shop em</em></p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="<c:url value="resources/assets/img/c1.jpg" />" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">Giày Nữ</h5>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="<c:url value="resources/assets/img/c2.jpg" />" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">Bán Chạy</h2>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="<c:url value="resources/assets/img/c3.jpg" />" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">Giày Nam</h2>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
        </div>
    </section>
    <!-- End Categories of The Month -->
    
    
     <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Sản Phẩm Nổi bật</h1>
                    <p>
                        Thanh xuân như một chén trà, ghé shop không mua thì phí cả thanh xuân
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="<c:url value="resources/assets/img/f1.jpg" />" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$240.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark">Gym Weight</a>
                            <p class="card-text">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt in culpa qui officia deserunt.
                            </p>
                            <p class="text-muted">Reviews (24)</p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="<c:url value="resources/assets/img/f2.jpg" />" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$480.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark">Cloud Nike Shoes</a>
                            <p class="card-text">
                                Aenean gravida dignissim finibus. Nullam ipsum diam, posuere vitae pharetra sed, commodo ullamcorper.
                            </p>
                            <p class="text-muted">Reviews (48)</p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="<c:url value="resources/assets/img/f3.jpg" />" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$360.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark">Summer Addides Shoes</a>
                            <p class="card-text">
                                Curabitur ac mi sit amet diam luctus porta. Phasellus pulvinar sagittis diam, et scelerisque ipsum lobortis nec.
                            </p>
                            <p class="text-muted">Reviews (74)</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End Featured Product -->