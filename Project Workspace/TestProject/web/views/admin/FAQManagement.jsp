<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : 관리자 도움말 관리페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<link rel="stylesheet" href="/studyhub/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="/studyhub/css/board_list.css">

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/admin/adminNav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="row" id="list-layout">
	<div
		class="col-md-8 col-md-offset-1 col-lg-8 col-lg-offset-1 col-sm-10 col-xs-9 col-xs-offset-1">
		<h2>FAQ관리</h2>

		<div class="top-area">
			<form action="/studyhub/faqmanagementlist" method="post" class="admin-search">
				<label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio1" value="option1">
					회원가입
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio2" value="option2">
					스터디찾기
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio3" value="option3">
					그룹페이지
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio4" value="option4">
					파일공유 
				</label> 
			</form>

		</div>

		<div class="table-area">
			<table class="table table-striped" align="center" width="600">
				<tr id="attr">
					<th>선택</th>
					<th>번호</th>
					<th>질문</th>
					<th>답변</th>
					<th>질문카테고리</th>
				</tr>
				<%
					/* for (QnA qna : list) { */
				%>
				<tr>
					<td><input type="checkbox" id="member-check"></td>
					<td>ㅇㅇ</td>
					<td id="title_text"><a href="#">ㅇ</a></td>
					<td>ㅇ</td>
					<td>ㅇ</td>
					<td>ㅇ</td>
				</tr>
				<%
					/* } */
				%>
			</table>
		</div>
	</div>
</div>



<!-- /메인 컨텐츠 -->

<!--푸터 부분-->

<%@ include file="/views/include/common/tail.jsp"%>