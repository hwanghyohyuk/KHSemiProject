<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 
작성자 : 윤찬호
내용 : 그룹공지 게시판 리스트 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%@ page import="java.util.*, com.studyhub.common.vo.GNotice, com.studyhub.group.main.controller.GNoticePreviewServlet"%>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	ArrayList<GNotice> list = (ArrayList<GNotice>) request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%>

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>


<script type="text/javascript">
	function insertPage() {
		location.href = "/studyhub/views/group/groupNotice/NoticeWriteForm.jsp";
	}
</script>
<link rel="stylesheet" type="text/css" href="/studyhub/css/board_list.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">

<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="container">
	<div class="row" id="list-layout">
		<div class="col-md-8 col-md-offset-1 col-lg-8 col-lg-offset-1 col-sm-10 col-xs-9 col-xs-offset-1">
			<h2>공지사항</h2>
			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr id="attr">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
					</tr>

					<%
						for (GNotice gnotice : list) {
					%>
					<tr align="center">
						<td><%=gnotice.getRownum()%></td>
						<td id="title_text">
						<a href="/studyhub/gnoticeview?no=<%=gnotice.getNoticeNo()%>"><%=gnotice.getTitle()%></a></td>
						<td><%=gnotice.getUploader_name() %></td>
						<td><%=gnotice.getUploadDate()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<br>
				<%-- 페이지 번호처리 --%>
				<div align = "center">
				<%-- 이전 페이지 있을 경우에 대한 처리 --%>
				<% if(currentPage <=1){ %>
					<a class="btn btn-default" href="#" disabled><span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
				<% }else{ %>
					<a class="btn btn-default" href="/studyhub/gnoticepreview?groupno=<%=currentPage - 1 %>"><span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
				<% } %>
				<%-- 현재 페이지 숫자 보여주기 --%>
				<% for(int p = startPage; p<= endPage; p++){ 
						if(p == currentPage){
				%>
					<a class="btn btn-default"><%=p %></a>
				
				<% }else{ %> 
					<a class="btn btn-default" href="/studyhub/gnoticepreview?groupno=<%= p %>"><%=p %></a>
				<% }} %>
				<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
				<% if(currentPage >= maxPage){ %>
					<a class="btn btn-default" href="#" disabled><span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
				<% }else{ %>
					<a class="btn btn-default" href="/studyhub/gnoticepreview?groupno=<%=currentPage + 1 %>"><span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
				<% } %>
				</div>
				<!-- /메인 컨텐츠 -->
				<button onclick="insertPage();" class="btn btn-info" id="btns">글쓰기</button>
			</div>
		</div>
	</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>
	