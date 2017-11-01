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
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<script type="text/javascript">
	function insertPage() {
		location.href = "/studyhub/views/group/groupBoard/BoardWriteForm.jsp"
	}
</script>
<link rel="stylesheet" type="text/css" href="/studyhub/css/board_list.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->
<body>
	<div class="container">
		<div class="row" id="list-layout">
			<div class="col-md-8 col-md-offset-2 col-sm-10 col-xs-9 col-xs-offset-1">
				<h2>자유게시판</h2>
				<div class="table-area">
					<table class="table table-striped" align="center" width="600">
						<tr id="attr">
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>날짜</td>
							<td>조회수</td>
						</tr>

						<%
							for (GBoard gboard : list) {
						%>
						<tr>
							<td><%=gboard.getgBoardNo()%></td>
							<td id="title_text"><a
								href="/studyhub/gboardview?no=<%=gboard.getgBoardNo()%>"><%=gboard.getTitle()%></a></td>
							<td><%=gboard.getUploaderName()%></td>
							<td><%=gboard.getUploadDate()%></td>
							<td><%=gboard.getReadCount()%></td>
						</tr>
						<%
							}
						%>
					</table>
					<div align="center">
						<div class="btn-group" role="group" aria-label="paging">
							<%-- 이전 페이지 있을 경우에 대한 처리 --%>
							<%
								if (currentPage <= 1) {
							%>
							<a class="btn btn-default" href="#"><span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
							<%
								} else {
							%>
							<a class="btn btn-default"
								href="/studyhub/gboardpreview?groupno=<%=currentPage - 1%>"><span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
							<%
								}
							%>
							<%-- 현재 페이지 숫자 보여주기 --%>
							<%
								for (int p = startPage; p <= endPage; p++) {
									if (p == currentPage) {
							%>
							<a class="btn btn-default" href="#"><%=p%></a>
							<%
								} else {
							%>
							<a class="btn btn-default"
								href="/studyhub/gboardpreview?groupno=<%=p%>"><%=p%></a>
							<%
								}
								}
							%>
							<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
							<%
								if (currentPage >= maxPage) {
							%>
							<a class="btn btn-default" href="#"><span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
							<%
								} else {
							%>
							<a class="btn btn-default"
								href="/studyhub/gboardpreview?groupno=<%=currentPage + 1%>"><span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
							<%
								}
							%>
						</div>
					</div>
					<!-- /메인 컨텐츠 -->
					<button onclick="insertPage();" class="btn btn-info" id="btns">글쓰기</button>
				</div>
			</div>
		</div>
	</div>


	<!-- /메인 컨텐츠 -->

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>