<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 모집게시판 오류 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--자바스크립트 및 CSS-->

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container text-center" style="display: table; height:80vh">
	<div style="display: table-cell; vertical-align: middle">
		<div class="jumbotron">
			<h3>모집게시판 불러오기 오류</h3>
			<p>
				Error :
				<%=request.getAttribute("message")%></p>
			<p>
				<a class="btn btn-default" href="/studyhub/boardlist">모집 게시판으로
					이동</a>
			</p>
		</div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>