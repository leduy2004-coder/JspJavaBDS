<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<c:forEach var="item" items="${list}">
	<div class="comment"> 
	        <img src="<c:url value='/img/${model.thumbnail}' />" alt="ảnh đại diện" class="cmt-thumbnail">
	        
	        <div class="cmt">
	            <div class="cmt-name">${model.fullName}
	            	 <span>${item.createdDate}</span>
	            </div>
	           
	            <P>${item.content}</P>
	        </div>
	        
	    </div>
	</c:forEach>

</body>
</html>