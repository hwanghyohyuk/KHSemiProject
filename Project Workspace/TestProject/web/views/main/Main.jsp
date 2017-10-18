<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	int countgroup = ((Integer)request.getAttribute("countgroup")).intValue();
%>

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
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<style type="text/css">
* {
   margin: 0px;
   padding: 0px;
}

/* 레이아웃 */
.my_group {
   height: 40vh;
   margin: -30px 15vw;
   background-color: #4dbbbf;
}

.recruit {
   height: 40vh;
   margin: 0 15vw;
   background-color: lightgray;
}

.head {
   margin-bottom: 2vh;
}

.images{
   display: flex;
   flex-direction: row;
   justify-content: space-around;
}

.groupimages{
   display: flex;
   flex-direction: row;
   justify-content: space-around;
}


/* 세부요소 */
#groupimg {
   float: left;
   width: 16vw;
   height: 30vh;
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
#groupname{
   margin-left: 6vw;
}

#r_groupname{
   margin-left: 4vw;
}

#more {
   font-weight: bold;
   color: #0789a3;
   position: absolute;
   right: 20vw;
   
}
</style>

<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
</head>
<body>
	<!-- 메인 컨텐츠 -->
	<!-- 나의 그룹 부분 -->
	<% if(countgroup > 0){ %>
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
						<!-- ajax 코드가 li 태그를 생성함 -->
					</ul>
				</div>
			</div>
			<div class="slider-btn">
				<a href="#"><img id="group-slider-right"
					src="/studyhub/images/slider.png"></a>
			</div>
		</div>
	</div>
   <% } %>
   
   <!-- 모집게시판 부분 -->
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
	
<script type="text/javascript">
	$(function(){
		var user_no = <%= user.getUserNo() %>;
		$.ajax({
			url: "/studyhub/mygrouppreview",
			data:  { userno: user_no },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){				         
				    values +=  "<li class='slide'><a href='/studyhub/gmainpreview?group_no=" + json.list[i].group_no + "'>" +
				    		   "<img id='groupimg' src='/studyhub/images/groupimg/" + decodeURIComponent(json.list[i].renameimg) +"'></a>" + 
				    		   "<div class='cover'><p id='groupname'>" + decodeURIComponent(json.list[i].group_name) + "</p></div></li>";
				}
				$(".group-slides").html(values);
			}
		});
	});
</script>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>
<!-- /미향 -->