<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : 관리자 대시보드페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<link rel="stylesheet" href="/studyhub/css/admin.css">

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/admin/adminNav.jsp"%>

<!-- 메인 컨텐츠 -->
<div
	class="col-lg-8 col-md-8 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2">
	<h3 id="notice-label">공지사항/알림 띄우기</h3>
	<form class="form-inline" action="/studyhub/noticeinsert" method="post">
		<div class="form-group">
			<textarea class="form-control" id="notice-input" name="notice"
				placeholder="사용자들에게 보여줄 공지사항을 입력하세요" rows="6"></textarea>
			<div class="submit-area">
				<!-- <div class="checkbox">
					<label> <input type="checkbox" id="popup" name="popup"> 팝업띄우기
					</label>
				</div> -->
				<button type="submit" id="notice-btn">공지하기</button>
				<a href="/studyhub/noticedelete"><button id="notice-btn">공지삭제</button></a>
			</div>
		</div>
	</form>
</div>


<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/common/tail.jsp"%>