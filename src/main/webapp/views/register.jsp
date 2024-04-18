<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<c:url var ="RegisterURL" value="/dang-ki"/>
<c:url var="APIurl" value="/api-admin-user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Đăng kí</title>
</head>
<body>

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

     <c:if test="${not empty authen}">
     	<form action="${RegisterURL}" method="get">
	        <div class="authen">
	            <div class="authen-content">
	                <h1>NHẬP MÃ XÁC THỰC</h1>
	                <input type="text" id="authentication" name="authentication" placeholder="Gồm 6 số" value="">
	                <span>Lấy mã xác thực tại Email của bạn</span>
	                <input type="hidden" value="authen" name="action"/>  
	                <input type="hidden" value="${authenid}" name="id"/>  
	                <button type="submit">Gửi</button>
	               
	            </div>   
	        </div>   	
     	</form>
      </c:if> 
      <c:if test="${empty authen}">
	<form id="formSubmitLogin" action="<c:url value='/dang-ki'/>"
		class="login-register form-register">
		<div class="auth--header">
			<h3 class="auth--header-login">Đăng kí</h3>
			<a class="auth--header-btn open-register" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
		</div>
		<div class="auth--form">
			<div class="auth--form-group">
				<input type="text" id="userName" class="auth--form-input" name="userName" value="" placeholder="Tên đăng nhập">
			</div>
			<div class="auth--form-group">
				<input type="text" id="password" class="auth--form-input" name="password" value="" placeholder="Mật khẩu">
			</div>
			<div class="auth--form-group">
				<input type="text" id="fullName" class="auth--form-input" name="fullName" value="" placeholder="Tên đầy đủ">
			</div>
			<div class="auth--form-group">
				<input type="text" id="email" class="auth--form-input" name="email" value="" placeholder="Email">
			</div>
			<div class="auth--form-content">Bằng việc đăng kí, bạn đã đồng
				ý về điều khoản dịch vụ và chính sách bảo mật.</div>
		</div>
		<div class="auth--controls-register ">
			<a class="back-link" href='<c:url value="/thoat?action=logout"/>'><span>Trở lại</span></a>
			<input type="hidden" value="${model.id}" name="id" />
			<button id="loginBtn" class="auth--control-btn">Đăng kí</button>

		</div>
		<div class="auth--form-connect">
			<div class="auth--form-text">BĐS LD an toàn uy tín bảo mật</div>
		</div>
			<input type="hidden" value="1" id="status" name="status"/>
			<input type="hidden" value="2" id="roleid" name="roleid"/>
			<input type="hidden" value="0" id="statusAuthen" name="statusAuthen"/>
	</form>
	</c:if> 
		<script src="<c:url value='/template/web/main.js' />"></script>
	<script src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/js/jquery-ui.min.js'/>"></script>
<script>
$('#loginBtn').click(function (e) {
    e.preventDefault(); //submit dung url
    var data = {};
    var formData = $('#formSubmitLogin').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    var userName = $('#userName').val();
    var password = $('#password').val();
    var fullName = $('#fullName').val();
    var email = $('#email').val();
    if (userName != "" && password != "" && fullName != "" && email != ""){
    	addNew(data);
    }else {
    	window.location.href = "${RegisterURL}?action=register&toastTitle=title_error"
    		+ "&toastColor=danger&toastIcon=icon_error&toastMess=register_error&toast=toast";
    } 
   
});
function addNew(data) {
    $.ajax({
        url: '${APIurl}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	window.location.href = "${RegisterURL}?action=register&authen=authen&id="+result.email+"";
        },
        error: function (error) {
        	window.location.href = "${RegisterURL}?action=register&toastTitle=title_error"
				+ "&toastColor=danger&toastIcon=icon_error&toastMess=register_error&toast=toast";
        }
    });
}
</script>
</body>
</html>