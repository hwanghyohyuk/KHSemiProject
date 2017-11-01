<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.QnA" %>
<!-- 
작성자 : 구미향
내용 : 관리자 도움말 관리페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->
<% ArrayList<QnA> qlist = (ArrayList<QnA>)request.getAttribute("qlist"); %>
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
<div class="container">
	<div class="row" id="list-layout">
		<div
			class="col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-sm-10 col-xs-10 col-xs-offset-1">
			<h2>QnA게시판 관리</h2>
			
			<div class="top-area">
					<form action="/studyhub/qnasearch" method="post" class="admin-search">
						<select id="search-by" name="search-by">
							<option value="user_name">제목</option>
							<option value="email">작성자</option>
						</select> <input type="search" autocomplete name="keyword" length="50"
							id="search-input"> &nbsp; <input type="submit" value="검색"
							id="search-btn">
					</form>
	
				</div>
	
			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr id="attr">
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성날짜</th>
						<th>조회수</th>
						<th>삭제</th>
					</tr>
					<%
						 for (QnA qna : qlist) { 
					%>
					<tr>
						<td><%=qna.getQnaNo() %></td>
						<td id="title_text"><a href="#"><%=qna.getTitle() %></a></td>
						<td><%=qna.getWriter() %></td>
						<td><%=qna.getUploadDate() %></td>
						<td><%=qna.getReadCount() %></td>
						<td><button onclick="deleteQna(<%= qna.getQnaNo() %>, '<%=qna.getTitle() %>');" id="delete-btn">삭제</button></td>
					</tr>
					<%
						 } 
					%>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /메인 컨텐츠 -->
<script type="text/javascript">
	function deleteQna(param, name){
		var userno = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/qnadeletemanagement",
			data: { qnano: param },
			type: "get",
			dataType: "json",
			async: false
		});
		location.href = "/studyhub/qnalistmanagement";
		alert(name + " 글이 삭제되었습니다..");
	}
	
</script>

<!--푸터 부분-->

<%@ include file="/views/include/common/tail.jsp"%>