<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="" class="form-favorite">
            <div class="title-favorite">YÊU THÍCH</div>
            <table class="table-favorite">
                <tr>
                  <th>STT</th>
                  <th>Ảnh</th>
                  <th>Tiêu đề</th>
                  <th>Giá</th>
                  <th>Hành động</th>
                </tr>
                <%int i=1;%>
                <c:forEach var="item" items="${listFa}">        	
                	<tr>
                  		<td><%=i%></td>
                  		<td><img src="<c:url value='/img/${item.thumbnail}' />" alt=""></td>
                  		<td>${item.title}</td>
                  		<td>${item.price}</td>
                  		<td>
                        	<a style="background-color: #36373b" href='<c:url value="/user-detail?id=${item.new_id}"/>' >Xem chi tiết</a>
                    
                        	<br>
                        	<br>
                        	
                        	<a style="background-color: red" href='<c:url value="/api-web-favorite?id=${item.id}"/>' >Xóa</a>
                  		</td>
               		</tr>
               		<%i=i+1;%>
                </c:forEach>
                
               
            </table>
        </form>
</body>
</html>