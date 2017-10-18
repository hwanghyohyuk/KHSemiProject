<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.studyhub.common.vo.GNotice"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
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
<script type="text/javascript">
	function insertPage() {
		location.href = "";
	}
</script>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<style type="text/css">
div#full {
	width: 1430px;
	height: 630px;
	float: top;
	border: 1px solid black;
	margin: 5px 5px -10px 5px;
}

div#a {
	width: 1420px;
	height: 100px;
	float: top;
	border: 1px solid black;
	margin: 5px 5px -10px 5px;
}

div#b {
	width: 200px;
	height: 500px;
	float: left;
	border: 1px solid black;
	margin: -10px 0px 5px 5px;
	background-color: #336699;
}

div#c {
	width: 1200px;
	height: 435px;
	float: right;
	border: 1px solid black;
	margin: 5px 5px 5px 0px;
	background-color: skyblue;
}

div#d {
	width: 1180px;
	height: 40px;
	float: right;
	margin: 5px 10px 5px 5px;
	font-size: 30px
}

#e {
	background-color: white;
	margin: 30px;
}

div#aa {
	width: 1180px;
	height: 50px;
	float: right;
	margin: 5px 60px 5px 5px;
}
</style>
</head>
<!-- 메인 컨텐츠 -->
<body>
	<div id="full">
		<div id="a"></div>
		<hr>
		<div id="b"></div>
		<div id="d">
			<strong>공지사항</strong>
		</div>

		<table id="e" align="center" cellspacing="0" cellpadding="10"
			border="1" width="1100">
			<tr align="center" height="20">
				<td width="60">번호</td>
				<td width="470">제목</td>
				<td width="80">작성자</td>
				<td width="50">날짜</td>
				<td width="80">조회수</td>
			</tr>
			
			<% 
			for(GNotice gNotice : list){ 
			%>
			
			<tr height="30">
				<td align = "center"><%= GNotice.getNoticeNo() %></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			
		<%} %>
		</table>

		<!-- /메인 컨텐츠 -->



		<!--푸터 부분-->
		<%@ include file="/views/include/main/footer.jsp"%>
</body>
</html>