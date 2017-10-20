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
<title>그룹공지::StudyHub</title>
<script type="text/javascript">
	function insertPage() {
		location.href = "/studyhub/views/group/groupNotice/NoticeWriteForm.jsp";
	}
</script>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<!-- 그룹 네비게이션바 -->
<%@ include file="/views/include/group/nav.jsp"%>
<style>
#btns {
	float: right;
}
</style>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>
</head>
<!-- 메인 컨텐츠 -->
<body>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<h2>공지사항</h2>
			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr align="center">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
					</tr>

					<%
						for (GNotice gnotice : list) {
					%>
					<tr>
						<td><%=gnotice.getNoticeNo()%></td>
						<td id="title_text">
						<a href="/studyhub/gnoticeview?no=<%=gnotice.getNoticeNo()%>"><%=gnotice.getTitle()%></a></td>
						<td><%=gnotice.getUploader()%></td>
						<td><%=gnotice.getUploadDate()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<!-- /메인 컨텐츠 -->
				<button onclick="insertPage();" class="btn btn-info">글쓰기</button>
			</div>
		</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
</body>
</html>