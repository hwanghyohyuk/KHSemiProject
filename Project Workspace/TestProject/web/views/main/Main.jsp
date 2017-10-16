<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : 메인 페이지
작성일자 17.10.02
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
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<div id="nav_menu">
<%@ include file="/views/include/group/nav.jsp" %>
</div>
<div id="group_main">

</div>
<!-- 메인 컨텐츠 -->






<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp" %>