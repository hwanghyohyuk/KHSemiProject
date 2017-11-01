<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap2-toggle.min.css">
<script type="text/javascript" src="/studyhub/js/bootstrap2-toggle.js"></script>

<!-- 초기화 블럭(변수선언 및 초기화) -->
<style type="text/css">
#image {
	display: none;
}

#container {
	margin-bottom: 30px;
}

h2 {
	margin-left: 30px;
	margin-bottom: 20px;
}

#btn {
	width: 250px;
	height: 50px;
	background-color: #004157;
	color: white;
	margin-top: 20px;
}

#submit {
	background-color: #004157;
	color: white;
	margin-top: 20px;
}

#btn:hover, #submit:hover{
	background-color: #337ab7;
}

#imagePreview{
	width: 100%;
	height: 350px;
}

#category, #categoryname, #onoff, #onoffname, #onoffdiv {
	padding-left: 0px;
	padding-right: 0px;
}

#onoffbtn.active {
	background-color: #004157;
	color: white;
}

#categoryname, #location, #description, #onoffname {
	margin-top: 20px;
}
</style>

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container col-lg-12 col-md-12 col-sm-12 col-xs-12" id="container">
	<h2>그룹 생성   <small><%= user.getUserName() %>님 그룹을 만들어보세요!</small></h2>
	<form action="/studyhub/gcreate" method="post" enctype="multipart/form-data">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div id="imagePreview" class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3 col-xs-offset-3">
					<button type="button" id="btn" class="btn img-rounded" >대표 사진 등록</button>
					<input id="image" name="groupimg" type="file" onchange="InputImage();">
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
		<div class="content">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="">
				스터디 그룹 이름
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<input type="text" class="form-control" name="group_name">
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="categoryname">
				카테고리
				</div>
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12" id="category">
					<select class="selectpicker form-control" data-style="btn-primary" name="group_category">
					      <option >토익</option>
					      <option >영어회화</option>
					      <option >중국어</option>
					      <option >제2외국어</option>
					      <option >IT/컴퓨터</option>
					      <option >독서모임</option>
					      <option >취업스터디</option>
					      <option >기타</option>
					  </select>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12" id="onoffname">
				스터디 형식
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="onoff">
					<div class="btn-group col-lg-12 col-md-12 col-sm-12 col-xs-12" data-toggle="buttons" id="onoffdiv">
					  <label class="btn  img-rounded active col-lg-6 col-md-6 col-sm-6 col-xs-6"  id="onoffbtn">
					    <input type="radio" name="group_no" value="on" autocomplete="off" checked> ON
					  </label>
					  <label class="btn img-rounded col-lg-6 col-md-6 col-sm-6 col-xs-6" id="onoffbtn">
					    <input type="radio" name="group_no" value="off" autocomplete="off"> OFF
					  </label>
					</div>
				</div>
			</div>
			<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12" id="location">
				지역
			</div>
			<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<select class="selectpicker form-control" data-style="btn-primary" name="group_location">
				      <option >서울</option>
				      <option >경기</option>
				      <option >강원</option>
				      <option >충북</option>
				      <option >충남</option>
				      <option >전북</option>
				      <option >전남</option>
				      <option >경북</option>
				      <option >경남</option>
				      <option >제주</option>
				  </select>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="description">
				한줄소개
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<input type="text" class="form-control" name="group_description">
			</div>
			<input type="hidden" name=user_no value="<%= user.getUserNo() %>">
			<input type="hidden" name=user_email value="<%= user.getEmail() %>">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<button type="submit" class="btn img-rounded col-lg-6 col-md-6 col-sm-6 col-xs-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3 col-xs-offset-3" id="submit">그룹 생성</button>
			</div>
		</div>
		</div>
	
	</form>
</div>

<script type="text/javascript">
$(function () {
	$('#btn').click(function (e) {
		e.preventDefault();
		$('#image').click();
	});
});

var InputImage = 
	 (function loadImageFile() {
	    if (window.FileReader) {
	    	var ImagePre; 
	        var ImgReader = new window.FileReader();
	        var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i; 
	        ImgReader.onload = function (Event) {
	            if (!ImagePre) {
	                var newPreview = document.getElementById("imagePreview");
	                ImagePre = new Image();
	                ImagePre.style.width = "100%";
	                ImagePre.style.height = "100%";
	                newPreview.appendChild(ImagePre);
	            }
	            ImagePre.src = Event.target.result;
	        };
	 
	        return function () {
	            var img = document.getElementById("image").files;
	           
	            if (!fileType.test(img[0].type)) { 
	             alert("이미지 파일을 업로드 하세요"); 
	             return; 
	            }
	            ImgReader.readAsDataURL(img[0]);
	        }
	    }
	    document.getElementById("imagePreview").src = document.getElementById("image").value;

	})();
</script>

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp" %>