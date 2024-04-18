<%@page import="com.laptrinhjava.model.FavoriteModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<form action="<c:url value='/user-new'/>"  method="get" id="myForm" name="myForm">
<header class="header">
	<div class="header__img">
		<img src="<c:url value='/img/hinhnen.jpeg' />" alt="">
	</div>
	<div class="header__content">
		<div class="header__search">
			<div class="header__search-wrap">
		
				<input class="header__search-input" type="text" onkeyup="Search()" name="search"
					placeholder="Tìm kiếm">
				<div class="header__choose">
					<div id="mysearch"></div>
				</div>
				<button class="header__search-button">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</div>
		<div class="header__text">
			<p>An toàn, uy tín, bảo mật</p>
		</div>
	</div>
</header>"
	
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
	<div class="introduce">
		<div class="grid wide">
			<div class="row">
				<div class="col l-5 m-5 c-12">
					<div class="introduce__text animated slideInLeft">giới thiệu</div>

				</div>
				<div class="col l-7 m-7 c-12">
					<div class="introduce__title animated slideInRight">
						<div class="nav__logo">
							<a href="#">
								<p>bđs</p> <span>ld</span>

							</a>
							<div>là trang web thông tin bất động sản hàng đầu tại Việt
								Nam, đem đến cho người dùng trải nghiệm tìm kiếm thông tin nhà
								đất nhanh chóng và hiệu quả.</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="grid wide">
		<a href="#"><img
			src="<c:url value='/img/hinhmoi.jpg' />" alt=""
			class="img-recruit"></a>
	</div>
	<div id="new" class="new">
		<div class="grid wide">
			<h2 class="new__content-title">Tin tức bất động sản</h2>
			<div class="row">
				<div class="col l-7 m-12 c-12">
				<c:forEach items="${listNew}" var="newItem">
					<div class="new__content" type="${newItem.id}">
					  <a class="new__content-top">
							<div class="top-highlight">
							
								<img src="<c:url value='/img/${newItem.thumbnail}' />" alt="">
								<div class="top-highlights">
									<h3 class="top-highlights-title">${newItem.title}</h3>
									<div class="top-highlights-desc">${newItem.shortDescription}</div>
								</div>
							
							</div>
						</a>
					</div>
				</c:forEach>
				</div>
				<div class="col l-5 m-12 c-12">
					<ul class="new__list">
					<c:forEach items="${listNew}" var="newItem">
						<li class="new__list-item" type="${newItem.id}"><a href='<c:url value="/user-top-new"/>'>${newItem.title}</a></li>
					</c:forEach>
						<li class="new__list-item-all"><a href='<c:url value="/user-top-new"/>'>Xem tất cả</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="outstanding">

		<div class="grid wide arrow">
			<h2 class="outstanding__title">Dự án nổi bật</h2>
			<div class="next">
				<i class="fa-solid fa-chevron-right"></i>
			</div>
			<div class="prev">
				<i class="fa-solid fa-chevron-left"></i>
			</div>

			<div class="out-wrapper">
				<div class="product-arrow">
				<c:forEach items="${list}" var="item">
					<c:if test="${item.statusId==1 || item.statusId == 2}">
						<div class="product-arrow-item">
							<a href='<c:url value="/user-detail?id=${item.id}"/>' class="home-product-out">
							<img src="<c:url value='/img/${item.thumbnail}' />" alt="" class="home-product-out__img">
								<div class="home-product-out__item">
						
									<c:forEach items="${status}" var="statusItem">
										<c:if test="${item.statusId == statusItem.id && statusItem.code == 1}">
											<div class="home-product-out__status on-sale">${statusItem.name}</div>
										</c:if>
										<c:if test="${item.statusId == statusItem.id && statusItem.code == 2}">
											<div class="home-product-out__status about-sale">${statusItem.name}</div>
										</c:if>
									</c:forEach>
									<h4 class="home-product-out__name">${item.title}</h4>
									<div class="home-product__out-origin">
										<div class="home-product-out__desc">${item.area}
											
										</div>
										<div class="origin__price">${item.price}</div>
									</div>
									<div class="home-product__out-address">${item.address}</div>
								</div>
							</a>
						</div>
					</c:if>
				</c:forEach>

				</div>
			</div>
		</div>

	</div>
	<div id="projects" class="project">
		<div class="grid wide center">
			<h2 class="project-title">Bất động sản đang bán và thuê</h2>
			<div class="row">
				<div class="project__nav">
					<div type="all" class="project__nav-button active">Tổng hợp</div>
					<div type="1" class="project__nav-button">Căn hộ</div>
					<div type="2" class="project__nav-button">Nhà</div>
					<div type="3" class="project__nav-button">Đất</div>
				</div>

			</div>
		</div>
		<div class="grid wide">
			<div class="row">
				<c:forEach items="${list}" var="item">
					<c:if test="${item.statusId==3}">
						<div type="${item.categoryId}" class="col l-3 m-4 c-6 filter">
						<a href='<c:url value="/user-detail?id=${item.id}"/>' class="home-product">
							 <img
								src="<c:url value='/img/${item.thumbnail}' />" alt=""
								class="home-product__img">
								<div class="home-product__item">
									<h4 class="home-product__name">${item.shortDescription}</h4>
									<div class="home-product__desc">${item.area}
	
										  <c:forEach items="${favoriteNone}" var="none"> 
											 	
											<c:if test="${not empty USERMODEL && none.id == item.id}"> 
													<form action="" method="post">		
													 </form>
													<form action="<c:url value='/api-web-favorite?userid=${USERMODEL.id}&newid=${item.id}&title=${item.title}&thumbnail=${item.thumbnail}&price=${item.price}'/>" method="post">
												 
													<input type="submit" value="Yêu thích" class="home-product-input"> 
												 </form>
													
											</c:if>
												
										   </c:forEach>  
										
									 	<c:forEach items="${favorite}" var="fa">
												<c:if test="${not empty USERMODEL && fa.new_id==item.id}">
													<div style="color: red;">Yêu thích</div>
												</c:if>	
										</c:forEach>
												
									</div>
									<div class="home-product__origin">
										<div class="origin__price">${item.price}</div>
										<div class="origin__logo">BĐS LD</div>
									</div>
								</div>
							</a>
						</div>
						</c:if>
					</c:forEach>
			</div>
	
			<ul class="pagination home-product__pagination ">
			</ul>
		</div>
	</div>
	<input type="submit" name="submit" id="Insubmit" style="display:none;"/> 
	</form>
	
<script>
var exit = document.querySelector('.header__img');

function Search() {
	var xhttp;
	var name = document.myForm.search.value;	
		var url = "api-web-search?action=search&name="+name;
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
				document.getElementById("mysearch").innerHTML = data;
			}
			
			
		}
		
		xhttp.open("POST",url,true);
		xhttp.send();
		
}
exit.addEventListener('click', function(e){
	document.myForm.search.value = "";
	var xhttp;
	var name = document.myForm.search.value;	
		var url = "api-web-search?action=search&name="+name;
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
				document.getElementById("mysearch").innerHTML = data;
			}
			
			
		}
		
		xhttp.open("POST",url,true);
		xhttp.send();
})	
		 <%String submit = request.getParameter("submit");
			if(submit==null) {
		%>
	    let submit = document.getElementById('Insubmit');
	    submit.click();
		<%}%> 
</script>
	

</body>
</html>

