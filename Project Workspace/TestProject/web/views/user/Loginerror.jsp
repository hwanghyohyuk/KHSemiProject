<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 로그인 오류 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container text-center">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="https://dummyimage.com/600x400/ffffff/004157&text=Logo+600*400"></a>
	<hr />
	<div class="row" style="height: 40px"></div>
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8" align="center">
		<h3>로그인 오류</h3>
		<p>이메일 혹은 비밀번호를 확인해주세요.</p>
		<br>
		<br>
		<button class="btn btn-primary btn-block main-back" onclick="history.back();">이전 화면으로 이동</button>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp" %>
	
