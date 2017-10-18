<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : FAQ 메인 페이지(메인에서 도움말 클릭했을 때의 화면)
작성일자 17.10.17
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub::FAQ</title>
<style>
/* layout */
.head-text {
	margin-top: 4vh;
}
.search{
	height: 3vh;
}
.service{
	display: block;
	width: 80vw;
	height: 60vh;
	margin: 0 auto;
	margin-top: 7vh;
}

.service li {
	height: 40vh;
}
/* detail */
#head-text {
	text-align: center;
}
#service-text{
	text-align: center;
}
.notice {
	height: 5vh;
	margin: 0 auto;
	background-color: #f7f7f7;
	text-align: center;
	line-height: 6vh;
	margin-bottom: 3vh;
}

.services{
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

#img {
	width: 27vh;
	margin: 1vh 1vh;
	-webkit-transition: all 0.5s ease;
     -moz-transition: all 0.5s ease;
       -o-transition: all 0.5s ease;
      -ms-transition: all 0.5s ease;
          transition: all 0.5s ease;
}
#img:hover {
	width: 27vh;
	margin: 1vh 1vh;
	border: 3px solid #4dbbbf;
	border-radius: 10%;
}
#service{
	text-align: center;
	color: #001429;
	font-weight: bold;
}


</style>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

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
	<div class="notice">
		<p id="notice">[공지] 공지사항은 여기에 ㅎㅎㅎㅎㅎㅎ</p>
	</div>
	<div class="head-text">
	<h1 id="head-text">무엇이 궁금하신가요?</h1>
	</div>
	
	<div class="search">
		<div class="col-md-4 col-sm-4 col-sm-offset-4 col-md-offset-4">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="키워드를 입력하세요...">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">검색</button>
				</span>
			</div>
		</div>
	</div>
	<div class="service">
	<div class="col-md-6 col-md-offset-3">
	<h2 id="service-text">필요하신 서비스를 선택해주세요.</h2>
	
	<div class="col-md-6 col-lg-6 col-md-offset-3">
				<div id="services">
					<ul class="services">
						<li class="service"><a href="/studyhub/views/main/FAQ/FAQdetail.jsp"><img id="img"
								src="/studyhub/images/example.jpg"></a>
							<p id="service">회원가입</p></li>
						<li class="service"><a href="/studyhub/views/main/FAQ/FAQdetail.jsp"><img id="img"
								src="/studyhub/images/example.jpg"></a>
							<p id="service">스터디찾기</p></li>
						<li class="service"><a href="/studyhub/views/main/FAQ/FAQdetail.jsp"><img id="img"
								src="/studyhub/images/example.jpg"></a>
							<p id="service">그룹페이지</p></li>
						<li class="service"><a href="/studyhub/views/main/FAQ/FAQdetail.jsp"><img id="img"
								src="/studyhub/images/example.jpg"></a>
							<p id="service">파일공유</p></li>
					</ul>
				</div>
			</div>
	
	</div>
	</div>
	
	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>