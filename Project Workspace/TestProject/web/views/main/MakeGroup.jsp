<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--CSS 및 자바스크립트-->
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
</style>

<script type="text/javascript">
	var InputImage = (function loadImageFile() {
		if (window.FileReader) {
			var ImagePre;
			var ImgReader = new window.FileReader();
			var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;
			ImgReader.onload = function(Event) {
				if (!ImagePre) {
					var newPreview = document.getElementById("imagePreview");
					ImagePre = new Image();
					ImagePre.style.width = "40%";
					ImagePre.style.height = "40%";
					newPreview.appendChild(ImagePre);
				}
				ImagePre.src = Event.target.result;
			};
			return function() {
				var img = document.getElementById("image").files;
				if (!fileType.test(img[0].type)) {
					alert("이미지 파일을 업로드 하세요");
					return;
				}
				ImgReader.readAsDataURL(img[0]);
			}
		}
		document.getElementById("imagePreview").src = document
				.getElementById("image").value;
	})();
</script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<!-- 메인 컨텐츠 -->
<form action="/studyhub/gcreate" method="post"
	enctype="multipart/form-data">
	<div id="imagePreview"></div>
	<br> <input id="image" type="file" onchange="InputImage();"
		name="groupimg">
	<div class="content">
		<div class="form-group">
			스터디 그룹 이름<br> <input type="text" class="group_name"
				name="group_name">
		</div>
		<div class="form-group">
			카테고리<br> <select class="selectpicker" data-style="btn-primary"
				name="group_category">
				<option>토익</option>
				<option>영어회화</option>
				<option>중국어</option>
				<option>제2외국어</option>
				<option>IT/컴퓨터</option>
				<option>독서모임</option>
				<option>취업스터디</option>
				<option>기타</option>
			</select>
		</div>
		<div>
			<br>스터디 형식<br>- <input type="checkbox" checked
				data-toggle="toggle" data-size="large" name="group_on" value="on">
			<br>
		</div>
		<div>
			<br>지역<br> <select class="selectpicker"
				data-style="btn-primary" name="group_location">
				<option>서울</option>
				<option>경기</option>
				<option>강원</option>
				<option>충북</option>
				<option>충남</option>
				<option>전북</option>
				<option>전남</option>
				<option>경북</option>
				<option>경남</option>
				<option>제주</option>
			</select>
		</div>
		<div class="form-group">
			<br>한줄소개<br> <input type="text" class="group_description"
				name="group_description">
		</div>
		<div>
			<input type="hidden" name=user_no value="<%=user.getUserNo()%>">
			<input type="hidden" name=user_email value="<%=user.getEmail()%>">
		</div>
		<button type="submit" class="btn btn-primary pull-right">그룹
			생성</button>
	</div>
</form>
<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>