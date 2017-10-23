<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 이메일 찾기 페이지
작성일자 17.10.05
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--CSS 및 자바스크립트-->

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!-- 메인 컨텐츠 -->
<div class="container">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="https://dummyimage.com/600x400/ffffff/004157&text=Logo+600*400"></a>
	<hr />
	<div class="row" style="height: 40px"></div>
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
			<p>이메일을 찾을 수 없습니다.</p>
			<br>
			<hr>
			<br>
			<a class="btn btn-primary pull-left main-back" href="/studyhub/signup">회원가입</a>
			<a class="btn btn-default pull-right" href="/studyhub/findemail">재시도</a>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>