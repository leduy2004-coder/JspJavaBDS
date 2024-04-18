<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<c:url var ="FileURL" value="/api-file-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>

<div class="main-content">
	
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <form id="formSubmit">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="categoryCode" name="categoryCode">
                                        <c:if test="${empty model.categoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.categoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}" <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                                </div>
                            </div>
    						<br/>
    						<br>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Diện tích</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="area" name="area" value="${model.area}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Giá</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="price" name="price" value="${model.price}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="content" name="content" style="width: 820px;height: 175px;">${model.content}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Địa chỉ</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="address" name="address" value="${model.address}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Link video</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="video" name="video" value="${model.video}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Trạng thái</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="statusCode" name=statusCode >
                                        <c:if test="${empty model.statusCode}">
                                            <option value="">Chọn trạng thái</option>
                                            <c:forEach var="item" items="${status}">
                                                <option value="${item.code}">${item.name}</option>
                                            </c:forEach>
                         
                                        </c:if>
                                        <c:if test="${not empty model.statusCode}">
                                            <option value="0">Chọn trạng thái</option>
                                            <c:forEach var="item" items="${status}">
                                                <option value="${item.code}" <c:if test="${item.code == model.statusCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                 
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>                 
                            <input type="hidden" class="form-control" id="thumbnail" name="thumbnail" value="1"/>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>
                        </form>
                        <br/>
                        <br/>
                                 		
        
                </div>
            </div>
             <form action="${FileURL}" method="POST" enctype="multipart/form-data">
      				        
                 			<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <input type="file" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}"/>
                                </div>
                            </div>
   							<br/>
                     	    <br/>
                     	    <input type="hidden" value="${model.id}" id="id" name="id"/>  
                             <div class="form-group">
                                <div class="col-sm-12">
                                     <input type="submit" name="submit" id="submit" class="btn btn-white btn-warning btn-bold" value="Thêm ảnh"/>
                                </div>
                            </div>   
                                       
              </form> 
        </div>
    </div>
</div>
<script>
	var editor = '';
	$(document).ready(function(){ //chay dau tien
		editor = CKEDITOR.replace('content');
	});
	
	
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault(); //submit dung url
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        data["content"] = editor.getData();
  
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
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
            	window.location.href = "${NewURL}?type=edit&id="+result.id+"&toastTitle=title_success"
				+ "&toastColor=success&toastIcon=icon_success&toastMess=add_success&toast=toast";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&toastTitle=title_error"
					+ "&toastColor=danger&toastIcon=icon_error&toastMess=add_error&toast=toast";
            }
        });
    }
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json', //du lieu tra toi server
            data: JSON.stringify(data),
            dataType: 'json', //du lieu nhan tu server
            success: function (result) {
            	window.location.href = "${NewURL}?type=edit&id="+result.id+"&toastTitle=title_success"
				+ "&toastColor=success&toastIcon=icon_success&toastMess=update_success&toast=toast";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&toastTitle=title_error"
					+ "&toastColor=danger&toastIcon=icon_error&toastMess=update_error&toast=toast";
            }
        });
    }
    <%-- <%String type = request.getParameter("type");
		if(type=="edit") {
	%>
		let submit = document.getElementById('submit');
		submit.click();
	<%}%> --%>
</script>
</body>
</html> 