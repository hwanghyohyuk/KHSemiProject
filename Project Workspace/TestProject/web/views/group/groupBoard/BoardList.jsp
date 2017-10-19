<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studyhub.common.vo.GBoard, java.util.*, java.sql.*, 
com.studyhub.common.vo.Group"%>

<%
	ArrayList<GBoard> list = (ArrayList<GBoard>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	
	Group group = (Group)session.getAttribute("group");

%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!-- 메인 컨텐츠 -->
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>

<!--헤더 부분-->

	<%@ include file="/views/include/common/head.jsp"%>
	<%@ include file="/views/include/main/header.jsp"%>
</head>
<style>
div#full {
	width: 1480px;
	height: 630px;
	float: top;
	margin: 0px 0px -10px 0px;
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
<body>
	<div id="full">
		<hr>
		<div id="name">
			<strong>자유게시판</strong>
		</div>

		<div id="board">

			<table id="table" align="center" cellspacing="0" cellpadding="10"
				border="1" width="1100">
				<tr align="center" height="20">
					<td width="60">번호</td>
					<td width="470">제목</td>
					<td width="80">작성자</td>
					<td width="50">날짜</td>
					<td width="80">조회수</td>
					
					<% for(GBoard gb :list){%>
				<tr height="30">
					<td align="center"><%=gb.getgBoardNo()%></td>
					<td align="center"><%=gb.getTitle()%></td>
					<td align="center"><%=gb.getUploader()%></td>
					<td align="center"><%=gb.getUploadDate()%></td>
					<td align="center"><%=gb.getAccessNo()%></td>
				</tr>
				<%} %>
			</table>
			<div id="bottom" align="right">
			<center>
				<%
					if (currentPage <= 1) {
				%>
				<input type="button" value="이전" onclick=""> &nbsp;
				<%
					} else {
				%>
				<a href="/Studyhub/studyhub?page=<%=currentPage - 1%>"> <input
					type="button" value="이전" onclick=""></a>
				<%
					}
				%>


				<%
					for (int p = startPage; p <= endPage; p++) {
						if (p == currentPage) {
				%>
				<b><font size="4" color="red">[<%=p%>]
				</font></b>
				<%
					} else {
				%>
				<a href="/Studyhub/studyhub?page=<%=p%>"><%=p%></a>
				<%
					}
					}
				%>


				<%
					if (currentPage >= maxPage) {
				%>
				<input type="button" value="다음" onclick="">
				<%
					} else {
				%>
				<a href="/Studyhub/studyhub?page=<%=currentPage + 1%>"> <input
					type="button" value="다음" onclick=""></a>
				<%
					}
				%>
				</center>
				<input type="submit" value="글쓰기">
			</div>
		</div>

		<footer>
			<%@ include file="/views/include/main/footer.jsp"%>
		</footer>
</body>
</html>