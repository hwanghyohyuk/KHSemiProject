<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<style type="text/css">
	#imagePreview {
		margin-top: 10%;
		margin-left: 10%;
	}
	
	#image {
		position: absolute;
		margin-left: 20%;
		top: 70%;
	}
	
	.content {
		position: absolute;
		margin-left: 60%;
		top: 15%;
	}
}
</style>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
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
	                ImagePre.style.width = "40%";
	                ImagePre.style.height = "40%";
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

<!-- 메인 컨텐츠 -->
<form action="/studyhub/gcreate" method="get" enctype="multipart/form-data">
	<div id="imagePreview"></div>
		<br>
		<input id="image" type="file" onchange="InputImage();">
	<div class="content">
		<div class="form-group">
			스터디 그룹 이름<br>
			<input type="text" class="group_name">
		</div>
		<div class="form-group">
			카테고리<br>
			<input type="text" class="group_name">
		</div>
		<div class="form-group">
			<input type="button" class="btn btn-default pull-right" id="on" value="OFF">
			<input type="button" class="btn btn-default pull-right" id="off" value="ON">
		</div>
		<div class="form-group">
			주요지역<br>
			<input type="text" class="group_name">
		</div>
		<div class="form-group">
			한줄소개<br>
			<input type="text" class="group_name">
		</div>
		<button type="submit" class="btn btn-primary pull-right">그룹 생성</button>
	</div>

</form>

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp" %>