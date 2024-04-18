<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/template/web/css/reset.css' />">
	<link rel="stylesheet" href="<c:url value='/template/web/css/base.css' />">
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />">
	<link rel="stylesheet" href="<c:url value='/template/web/css/responsive.css' />">
	<link rel="stylesheet" href="<c:url value='/template/web/font/fontawesome-free-6.2.0/fontawesome-free-6.2.0-web/css/all.min.css' />">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	 <script src="<c:url value='/template/admin/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
<title><dec:title default="Đăng nhập" /></title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>
	<header class="header">
	<div class="header__img">
		<img src="<c:url value='/img/hinhnen.jpeg' />" alt="">
	</div>
	<div class="header__content">
		<div class="header__search">
			<div class="header__search-wrap">
				<input class="header__search-input" type="text"
					placeholder="Tìm kiếm">
				<button class="header__search-button">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</div>
		<div class="header__text">
			<p>An toàn, uy tín, bảo mật</p>
		</div>
	</div>
</header>
	<dec:body />
	<%@include file="/common/web/footer.jsp"%>
	<script src="<c:url value='/template/web/main.js' />"></script>
</body>
</html>