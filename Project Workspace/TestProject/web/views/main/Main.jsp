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
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src='/studyhub/js/main.js' ></script>
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
</head>
<body>
	<!-- 메인 컨텐츠 -->
	<div class="row">
		<div class="col-md-10 col-sm-5 col-md-offset-2">
			<div class="slider-btn">
				<a href="#"><img id="group-slider-left"
					src="/studyhub/images/slider.png"></a>
			</div>
			<div class="head">
				<a href="#" id="more">더보기</a><span id="title">나의 그룹</span>
			</div>
			<div class="col-md-8 col-lg-6">
				<div id="slider">
					<ul class="group-slides">
						<li class="slide">
							<div class="img">
								<a href="#"><img id="groupimg"
									src="/studyhub/images/studygroup.jpg"></a>
							</div>
							<div class="cover">
								<p id="groupname">그룹이름1</p>
							</div>
						</li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/studygroup.jpg"></a>
							<div class="cover">
								<p id="groupname">그룹이름2</p>
							</div></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/studygroup.jpg"></a>
							<div class="cover">
								<p id="groupname">그룹이름3</p>
							</div></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/studygroup.jpg"></a>
							<div class="cover">
								<p id="groupname">그룹이름4</p>
							</div></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<div class="cover">
								<p id="groupname">그룹이름5</p>
							</div></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/studygroup.jpg"></a>
							<div class="cover">
								<p id="groupname">그룹이름6</p>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="slider-btn">
				<a href="#"><img id="group-slider-right"
					src="/studyhub/images/slider.png"></a>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-10 col-sm-5 col-md-offset-2">
			<div class="slider-btn">
				<a href="#"><img id="slider-left"
					src="/studyhub/images/slider.png"></a>
			</div>
			<div class="head">
				<a href="#" id="more">더보기</a><span id="title">모집게시판</span>
			</div>
			<div class="col-md-8 col-lg-6">
				<div id="slider">
					<ul class="slides">
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">kh스터디 |IT|강남</p></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">토익800|영어|신촌</p></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">HSK5급준비|중국어|대구</p></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">독서모임 |독서|강남</p></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">jQuery정복!|IT|강남</p></li>
						<li class="slide"><a href="#"><img id="groupimg"
								src="/studyhub/images/recruit.jpg"></a>
							<p id="r_groupname">HSK6급준비|중국어|대전</p></li>
					</ul>
				</div>
			</div>
			<div class="slider-btn">
				<a href="#"><img id="slider-right"
					src="/studyhub/images/slider.png"></a>
			</div>
		</div>
	</div>
	
	

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>
</body>
</html>