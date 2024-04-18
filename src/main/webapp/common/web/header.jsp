<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav class="nav">
	<div class="nav__width">
		<div class="nav__logo">
			<a href="#">
				<p>bđs</p> <span>ld</span>
			</a>
		</div>
		<div class="menu-icon">
			<i class="fa-solid fa-list"></i>
		</div>
		<div class="modal"></div>
		<div class="menu">
			<ul class="menu__list">
			
				<li><a href='<c:url value="/trang-chu"/>'>trang chủ</a></li>
				<c:if test="${USERMODEL.roleid ==1}">
					<li><a href='<c:url value="/user-product"/>'>Bài đăng</a></li>
				</c:if>
				<c:if test="${USERMODEL.roleid ==2 }">
					<li><a href='<c:url value="/user-product"/>'>Yêu thích</a></li>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li><a href="#projects">Dự án</a></li>
				</c:if> 	
				<li><a href='<c:url value="/user-top-new"/>'>tin tức</a></li>
				<li><a href="https://leduy2004-coder.github.io/profile/"
					target="_blank">liên hệ</a></li>
			</ul>
			<div class="menu__login">
				 <c:if test="${not empty USERMODEL}">
					<li><a href='#'>Wellcome, ${USERMODEL.fullName}</a></li>
					<li><a href='<c:url value="/thoat?action=logout"/>'>Thoát</a></li>
				</c:if>  
				
				<c:if test="${empty USERMODEL}">
					<li><a href='<c:url value="/dang-ki?action=register"/>'>đăng kí</a></li>
					<li><a  href='<c:url value="/dang-nhap?action=login"/>'>đăng nhập</a></li>
				</c:if> 			
				
			</div>
		</div>
	</div>
</nav>


