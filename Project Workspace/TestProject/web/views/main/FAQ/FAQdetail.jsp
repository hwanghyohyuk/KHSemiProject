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

<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<style>
/* layout */

/*detail*/
#main-text{
	color: #001429;
}

#move{
	text-align: center;
}
#btn{
	background-color: #001429;
	width: 6vw;
}
</style>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>

</head>
<!-- 메인 컨텐츠 -->
<body>
	<div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3">
	<h2 id="main-text">회원가입/로그인</h1>
	<hr>
	<p>아이디가 기억나지 않아요 </p>
	<p>회원가입 할 때 페이지가 넘어가지 않아요 </p>
	<p>아이디를 해킹당한 것 같아요</p>
	<p>비밀번호를 잊어버렸어요 </p>
	
	<span id="move">질문이 해결되지 않는다면? → </span>
	<button id="btn">질문게시판으로 이동</button>
	
	</div>
	
	
	
	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>