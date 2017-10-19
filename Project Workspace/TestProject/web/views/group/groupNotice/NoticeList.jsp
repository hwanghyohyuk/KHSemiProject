<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.studyhub.common.vo.GNotice"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹공지 게시판 리스트 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%
	ArrayList<GNotice> list = (ArrayList<GNotice>) request.getAttribute("list");
%>

<!-- 초기화 블럭(변수선언 및 초기화) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>GNoticeList</title>
<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js">
	function insertPage() {
		location.href = "/views/groupNotice/NoticeWriteForm.jsp";
	}
</script>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<!-- 그룹 네비게이션바 -->
<%@ include file = "/views/include/group/nav.jsp" %>
<style type="text/css">

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
	margin: 5px 5px 5px 0px;
	background-color: skyblue;
}

div#name {
	width: 1180px;
	height: 40px;
	float: right;
	margin: 5px 10px 5px 5px;
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
</head>
<!-- 메인 컨텐츠 -->
<body>
	<div id="full"></div>
	<div id="name">
		<strong>공지사항</strong>
	</div>	
	<table class="table table-bordered table-hover">
		<tr align="center" height="20">
			<td width="60">번호</td>
			<td width="470">제목</td>
			<td width="80">작성자</td>
			<td width="50">날짜</td>
			<td width="30">조회수</td>
		</tr>

		<%
			for (GNotice gNotice : list) {
		%>
		<tr height="30">
			<td align="center"><%= gNotice.getNoticeNo()%></td>
			<td align="center"><%= gNotice.getTitle() %></td>
			<td align="center"><%= gNotice.getUploader()%></td>
			<td align="center"><%= gNotice.getUploadDate() %></td>
			<td align="center"><%= gNotice.getReadCount() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<!-- /메인 컨텐츠 -->
	<div id="bottom" align="right">
      <center><input type="submit" value="이전" > <input type="submit" value="1"> <input type="submit" value="다음" ></center>
      <input type="submit" value="글쓰기" onclick="insertPage()">
  	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
</body>
</html>