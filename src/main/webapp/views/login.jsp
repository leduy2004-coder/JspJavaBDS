<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	
	<!-- login -->
	<a class="modal-input" href='<c:url value="/thoat?action=logout"/>'></a>
	<c:if test="${not empty toastMess }" > 
		<div id="${toast}">
            <div class="toast toast-${toastColor}">
                <div class="toast-icon"><i class="${toastIcon}"></i></div>
                <div class="toast-body">
                    <h3 class="toast-title">${toastTitle}</h3>
                    <p class="toast-mess">${toastMess}</p>
                    
                </div>
                <div class="toast-close"><i class="fa-solid fa-xmark"></i></div>
            </div>
      	</div>
     </c:if> 
  	<form action="<c:url value='/dang-nhap'/>" class="login-register form-login" method="post">
		<div class="auth--header">
			<h3 class="auth--header-login">Đăng nhập</h3>
			<a class="auth--header-btn open-register"
				href='<c:url value="/dang-ki?action=register"/>'>Đăng kí</a>
		</div>
		<div class="auth--form">
			<div class="auth--form-group">
				<input type="text" class="auth--form-input" name="userName"
					id="userName" placeholder="Tên đăng nhập">
			</div>
			<div class="auth--form-group">
				<input type="text" name="password" id="password"
					class="auth--form-input" placeholder="Mật khẩu">
			</div>

		</div>

		<div class="auth--controls">
			<a class="back-link" href='<c:url value="/thoat?action=logout"/>'><span>Trở	lại</span></a> 
			<input type="hidden" value="login" name="action" />
			<button type="submit" class="auth--control-btn">Đăng nhập</button>
			
		</div>
		
		<div class="auth--form-connect">
			<div class="auth--form-text">BĐS LD an toàn uy tín bảo mật</div>
		</div>

	</form>

	<!-- login -->

	
	
</body>
</html>