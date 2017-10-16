<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹메인 페이지
작성일자 17.10.16
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<style type="text/css">
	div#nav_menu {
		float:left;
		width: 250px;
		height: 100%;
	}
</style>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<div id="nav_menu">
<%@ include file="/views/include/group/nav.jsp" %>
</div>
<!-- 메인 컨텐츠 -->






<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
