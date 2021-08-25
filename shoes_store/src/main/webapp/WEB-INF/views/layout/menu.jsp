<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="pcoded-navbar menupos-fixed menu-light brand-blue ">
	<div class="navbar-wrapper ">
		<div class="navbar-brand header-logo">
			<a href="index.html" class="b-brand"> <img
				src="<%=request.getContextPath() %>/resources/images/logo.svg" alt=""
				class="logo images"> <img
				src="<%=request.getContextPath() %>/resources/images/logo-icon.svg" alt=""
				class="logo-thumb images">
			</a> <a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>
		</div>
		<div class="navbar-content scroll-div">
			<ul class="nav pcoded-inner-navbar">
				<li class="nav-item pcoded-menu-caption"><label>Navigation</label>
				</li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/"
					class="nav-link"><span class="pcoded-micon"><i
							class="feather icon-home"></i></span><span class="pcoded-mtext">Dashboard</span></a></li>
				<li class="nav-item pcoded-hasmenu">
					<p class="nav-link">
						<span class="pcoded-micon"> <i class="feather icon-box">
						</i></span> <span class="pcoded-mtext">Quản hệ thống</span>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>/user/list"
								class="">Quản lí user</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>/role/list"
								class="">Quản lí role</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>/action/list"
								class="">Quản lí action</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí category</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí product</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí invoice</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí order</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí orderDetails</a></li>
						</ul>
						<ul class="pcoded-submenu">
							<li class=""><a href="<%=request.getContextPath() %>//user/list"
								class="">Quản lí feedback</a></li>
						</ul>
				</li>
			</ul>

		</div>
	</div>
</nav>