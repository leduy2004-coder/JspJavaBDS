<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/base.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/responsive.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/font/fontawesome-free-6.2.0/fontawesome-free-6.2.0-web/css/all.min.css' />">
<link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title><dec:title default="Home" /></title>
</head>
<body>
	<div id="wrapper">
		<%@include file="/common/web/header.jsp"%>
		
		<main class="main">
			<dec:body />
		</main>
		<%@include file="/common/web/footer.jsp"%>
	</div>
	<script src="<c:url value='/template/web/main.js' />"></script>
</body>
</html>