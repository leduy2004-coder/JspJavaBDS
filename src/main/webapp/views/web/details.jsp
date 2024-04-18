<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style>
		
	</style>
</head>
	
<body>
	<div id="details">
		<div class="content-detail">
			<div class="title-detail">${list.shortDescription}</div>
			<img src="<c:url value='/img/${list.thumbnail}' />" alt="">
			<div class="content-detail-main">${list.content}</div>	
		 	<iframe width="600" height="355" src="${list.video}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		</div>
		<div class="menu-detail">
			<div class="user-detail">
		
					<img src="<c:url value='/img/${user.thumbnail}' />" alt="">
		
				<span>Được đăng bởi</span>
				<h2>${user.fullName}</h2>
			</div>
			<div class="info-detail">
				<ul>
					<li>0987654321</li>
					<li><a href='<c:url value=""/>' >Chat qua Zalo</a></li>
					<li><a href='<c:url value=""/>' >Gửi Email</a></li>
					<li><a href='<c:url value=""/>' >Yêu cầu liên hệ lại</a></li>
				</ul>
			</div>
		</div>	
		
	</div>
	<div class="comment-detail">
	
		<form name="myform" id="form-cmt">
			<input type="text" name="comment" onkeydown="handleEnter(event)" class="myinput" placeholder="Viết bình luận">
			<br/>
			
			<input type="button" value="Bình luận" id="Insubmit" onclick="Comment()" >
		</form>
		<div id="mycomment"></div>
	</div>
	<script type="text/javascript">
	
		 function handleEnter(event) {
	         if (event.key === "Enter") {
	             event.preventDefault(); // Ngăn chặn hành vi mặc định của Enter (như thêm dòng mới trong input)
	             document.getElementById("Insubmit").click(); // Kích hoạt sự kiện click trên nút
	         }
	     }
		function Comment() {
			var xhttp;
			var content = document.myform.comment.value;
				var id = ${user.id};
				var newId = ${list.id};
				var url = "api-web-comment?action=comment&userId="+id+"&content="+content+"&newId="+newId;
				if(window.XMLHttpRequest)
					{
						xhttp = new XMLHttpRequest();
					}
				else
					{
						xhttp = new ActiveXObject("Microsoft.XMLHTTP");
					}
				xhttp.onreadystatechange = function(){
					if(xhttp.readyState == 4){
						var data = xhttp.responseText;
						document.getElementById("mycomment").innerHTML = data;
					}
					
					
				}
				document.myform.comment.value="";
				xhttp.open("POST",url,true);
				xhttp.send();
			
		
		}
		<%String submit = request.getParameter("action");
		if(submit==null) {
		%>
   	 	let submit = document.getElementById('Insubmit');
    	submit.click();
		<%}%>
		
	</script>
</body>

</html>