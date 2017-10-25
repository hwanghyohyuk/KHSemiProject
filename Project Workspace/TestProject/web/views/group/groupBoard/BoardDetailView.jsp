<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->
<%@page import="com.studyhub.common.vo.GBoard" %>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<%GBoard gb = new GBoard(); %>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<style>
div#full {
	width: 1480px;
	height: 630px;
	float: top;
	border: 1px solid black;
	margin: 0px 0px -10px 0px;
}

div#top {
	width: 1480px;
	height: 100px;
	float: top;
	border: 1px solid black;
	margin: 0px 0px -10px 0px;
}

div#left {
	width: 200px;
	height: 500px;
	float: left;
	border: 1px solid black;
	margin: -10px 0px 5px 0px;
	background-color: #336699;
}

div#board {
	width: 1200px;
	height: 435px;
	float: right;
	border: 1px solid black;
	margin: 5px 40px 5px 0px;
	background-color: skyblue;
}

div#name {
	width: 1180px;
	height: 40px;
	float: right;
	margin: 5px 50px 5px 5px;
	font-size: 30px
}

#table {
	background-color: white;
	margin: 30px;
}

div#bottom {
	width: 1180px;
	height: 50px;
	float: right;
	margin: 5px 60px 5px 5px;
}
</style>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->
<div id="full">
		<div id="top"></div>
		<hr>
		<div id="left"></div>
		<div id="name">
			<strong>자유게시판</strong>
		</div>

		<div id="board">

			<table id="table" align="center" cellspacing="0" cellpadding="10"
				border="1" width="1100">
				<tr align="center" height="20">
					<td width="50">번호</td>
					<td width="50"><%=gb.getgBoardNo() %></td>
					<td width="50">제목</td>
					<td width="470" colspan="4"><%= gb.getTitle() %></td>
				</tr>
				<tr align="center" height="20">
					<td width="50">작성자</td>
					<td width="100" colspan="2"><%=gb.getUploader() %></td>
					<td width="50">날짜</td>
					<td width="100"><%=gb.getStrDate() %></td>
					<td width="50">조회수</td>
					<td width="100"><%=gb.getReadcount() %></td>
				</tr>
				<tr>
					<td colspan="10" width="1100" height="200"><%=gb.getContent() %></td>
				</tr>
			</table>
			<div id="bottom" align="right">
				<input type="submit" value="수정">
				 <input type="submit" value="삭제"> 
				 <input type="submit" value="목록">

			</div>
		</div>


<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>