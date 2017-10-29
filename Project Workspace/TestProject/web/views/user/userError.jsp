<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 사용자 서비스 오류 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--자바스크립트 및 CSS-->

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!-- /메인 컨텐츠 -->
<div class="container text-center">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="https://dummyimage.com/600x400/ffffff/004157&text=Logo+600*400"></a>
	<hr />
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
			<br>
			<h3><%=request.getAttribute("messageheader")%></h3>
			<br>
			<p><%=request.getAttribute("message")%></p>
			<br>
			<hr>
			<br>
			<p>
				<a class="btn btn-primary main-back pull-right" href='/studyhub/login'>확인</a>
			</p>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>