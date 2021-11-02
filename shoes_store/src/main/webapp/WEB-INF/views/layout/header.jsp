<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="navbar pcoded-header navbar-expand-lg navbar-light headerpos-fixed">
		<div class="m-header">
			<a class="mobile-menu" id="mobile-collapse1" href="#!"><span></span></a>
			<a href="index.html" class="b-brand">
				<img src="<%=request.getContextPath() %>/resources/images/logo.svg" alt="" class="logo images">
				<img src="<%=request.getContextPath() %>/resources/images/logo-icon.svg" alt="" class="logo-thumb images">
			</a>
		</div>
		<a class="mobile-menu" id="mobile-header" href="#!">
			<i class="feather icon-more-horizontal"></i>
		</a>
		<div class="collapse navbar-collapse">
			
			<ul class="navbar-nav ml-auto">
				<li>
					
				</li>
				<li>
					<div class="dropdown drp-user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon feather icon-settings"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right profile-notification">
							<div class="pro-head">
								<img src="data:image/jpeg;base64,${sessionScope.usernameAdmin.image}" class="img-radius" alt="User-Profile-Image">
								<span>${sessionScope.usernameAdmin.name }</span>
								<a href="<c:url value="/logoutadmin" />" class="dud-logout">
									<i class="feather icon-log-out"></i>
								</a>
							</div>
							
						</div>
					</div>
				</li>
			</ul>
		</div>
	</header>