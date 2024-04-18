<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="">
	  
            <div class="news">
                <h1>Tin tức bất động sản mới nhất</h1>
                <span>Thông tin mới, đầy đủ, hấp dẫn về thị trường bất động sản Việt Nam thông qua dữ liệu lớn về giá, giao dịch, nguồn cung - cầu và khảo sát thực tế của đội ngũ phóng viên, biên tập của BatdongsanLD.com.vn.</span>
                <div class="news-content">
                <c:forEach var="item" items="${listNew}">    
                        <div class="news-content-list">
                            <img src="<c:url value='/img/${item.thumbnail}' />" alt="">
                            <div class="news-title">
                                <div class="news-head">
                                    <a href="">${item.title}</a>
                                    
                                </div>
                                <div class="news-short">
                                   ${item.shortDescription}
                                </div>
                            </div>
                        </div>
                  </c:forEach>
                </div>
            </div>
             
        </form>
</body>
</html>