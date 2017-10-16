<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 
작성자 : 구미향
내용 : 메인 페이지
작성일자 17.10.16
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub</title>
<!-- css, javascript, jQuery -->
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

/* 레이아웃 */
.my_group {
	height: 40vh;
	margin: -30px 15vw;
}

.recruit {
	height: 40vh;
	margin: 0 15vw;
}

.head {
	margin-bottom: 2vh;
}

.images {
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

/* 세부요소 */
#slider-left {
	height: 10vh;
	margin-top: 17vh;
	float: left;
}

#slider-right {
	height: 10vh;
	margin-top: 17vh;
	float: right;
	-ms-transform: rotate(180deg); /* IE 9 */
	-webkit-transform: rotate(180deg); /* Chrome, Safari, Opera */
	transform: rotate(180deg);
}

#groupimg {
	float: left;
	width: 16vw;
	height: 30vh;
}

.cover {
	background: rgba(0, 0, 0, 0.6);
	color: white;
	box-sizing: border-box;
}

#title {
	margin-top: 10vh;
	margin-left: 3vw;
	display: block;
	color: #004157;
	width: 16vw;
	font-size: 2.3rem;
	font-weight: bold;
}

#groupname {
	margin-left: 6vw;
}

#r_groupname {
	margin-left: 4vw;
}

#more {
	font-weight: bold;
	color: #0789a3;
	position: absolute;
	right: 20vw;
}
</style>
<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
</head>
<body>
	<!-- 메인 컨텐츠 -->
	<div class="my_group">
		<img id="slider-left" src="/studyhub/images/slider.png">
		<div class="head">
			<a href="#" id="more">더보기</a><span id="title">나의 그룹</span>
		</div>
		<div class="images">
			<div class="group1">
				<div class="img">
					<a href="#"><img id="groupimg"
						src="/studyhub/images/studygroup.jpg"></a>
				</div>
				<div class="cover">
					<p id="groupname">그룹이름1</p>
				</div>
			</div>
			<div class="group2">
				<a href="#"><img id="groupimg"
					src="/studyhub/images/studygroup.jpg"></a>
				<div class="cover">
					<p id="groupname">그룹이름2</p>
				</div>
			</div>
			<div class="group3">
				<a href="#"><img id="groupimg"
					src="/studyhub/images/studygroup.jpg"></a>
				<div class="cover">
					<p id="groupname">그룹이름3</p>
				</div>
			</div>
		</div>
		<img id="slider-right" src="/studyhub/images/slider.png">
	</div>

	<div class="recruit">
	<img id="slider-left" src="/studyhub/images/slider.png">
		<div class="head">
			<a href="#" id="more">더보기</a><span id="title">모집게시판</span>
		</div>
		<div class="images">
			<div class="group1">
				<a href="#"><img id="groupimg"
					src="/studyhub/images/recruit.jpg"></a>
				<p id="r_groupname">kh스터디 |IT|강남</p>
			</div>
			<div class="group2">
				<a href="#"><img id="groupimg"
					src="/studyhub/images/recruit.jpg"></a>
				<p id="r_groupname">토익800|영어|신촌</p>
			</div>
			<div class="group3">
				<a href="#"><img id="groupimg"
					src="/studyhub/images/recruit.jpg"></a>
				<p id="r_groupname">HSK5급준비|중국어|대구</p>
			</div>
		</div>
		<img id="slider-right" src="/studyhub/images/slider.png">
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>