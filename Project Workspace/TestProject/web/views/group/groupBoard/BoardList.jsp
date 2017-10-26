<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 조남훈
내용 : 그룹 게시판 리스트 페이지
작성일자 17.10.25
 -->
<!-- java 구문 -->
<%@ page import="java.util.*, com.studyhub.common.vo.GBoard"%>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	ArrayList<GBoard> list = (ArrayList<GBoard>) request.getAttribute("list");

%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<style>
#btns {
	float: right;
}
</style>
<script type="text/javascript">
	function insertPage() {
		location.href = "/studyhub/views/group/groupBoard/BoardWriteForm.jsp"
	}
</script>

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->
<body>
	<%-- <div class="row">
		<div class="col-md-8 col-md-offset-2">
			<h2>자유게시판</h2>

			<div align="center">
				<form action="#" method="post">
					<input type="search" autocomplete name="keyword" length="50">
					&nbsp; <input type="submit" value="제목검색" class="btn btn-default">
				</form>

			</div>

			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
					<%
						for (GBoard gb : list) {
					%>
					<tr>
						<td><%=gb.getgBoardNo()%></td>
						<td><a href="/studyhub/gboardview?gbno=<%=gb.getgBoardNo() %>">
					<% if(gb.getTitle().length()>9){ %>
					<%=gb.getTitle().substring(0, 9) %>..
					<% }else{ %>
					<%=gb.getTitle()%>
					<% } %>
					</a></span>
					</td>
						<td><%=gb.getUploader()%></td>
						<td><%=gb.getUploadDate()%></td>
						<td><%=gb.getAccessNo()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<button onclick="insertPage();" class="btn btn-info">글쓰기</button>
			</div>
		</div>
	</div>
 --%><div class="row">
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
						for (GBoard gboard : list) {
					%>
					<tr>
						<td><%=gboard.getgBoardNo()%></td>
						<td id="title_text">
						<a href="/studyhub/gboardview?no=<%=gboard.getgBoardNo()%>"><%=gboard.getTitle()%></a></td>
						<td><%=gboard.getUploader()%></td>
						<td><%=gboard.getUploadDate()%></td>
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

	<!-- /메인 컨텐츠 -->

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>