<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : 관리자 모집게시판 관리페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ page
	import="com.studyhub.common.vo.Board, java.util.ArrayList, java.sql.Date"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int groupCount = ((Integer) request.getAttribute("groupCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--자바스크립트 및 CSS-->
<style>
#groupimg {
	width: 140px;
	height: 140px;
}
</style>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<%@ include file="/views/admin/adminNav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>원하는 그룹을 찾자.</small>
		</h1>
		<br>
	</div>
	<div class="row">
		<div class="col-xs-2">
			<p>
				총 게시글 수 :
				<%=listCount%></p>
		</div>
		<div class="col-xs-2">
			<p>
				모집 그룹 수 :
				<%=groupCount%></p>
		</div>
		<div class="col-xs-4"></div>
		<div class="col-xs-4">
			<form action='/studyhub/recruitmanagementlist' method='post'>
				<div id="imaginary_container">
					<div class="input-group stylish-input-group">
						<input type="text" class="form-control" placeholder="Search"
							name='keyword'> <span class="input-group-addon">
							<button type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>그룹이미지</th>
					<th>분류</th>
					<th>그룹명</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>마감일</th>
					<th>상태</th>
					<th>지역</th>
					<th>스터디방식</th>
					<th>그룹원 수</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (list.size() > 0) {
						for (Board b : list) {
				%>
				<tr>
					<td><img id="groupimg"
						src="/studyhub/images/groupimg/<%=b.getgImgRename()%>"
						class="img-rounded"></td>
					<td><%=b.getCategoryName()%></td>
					<td><%=b.getGroupName()%></td>
					<td><%=b.getTitle()%></td>
					<td><%=b.getUploaderName()%></td>
					<td><%=b.getUploadDate()%></td>
					<td><%=b.getDeadlineDate()%></td>
					<td><%=b.getStatus()%></td>
					<td><%=b.getLocation()%></td>
					<td><%=b.getAttributeName()%></td>
					<td><%=b.getMemberCount()%></td>
					<td><a class="btn btn-default"
						href="javascript:checkDelete(<%=b.getBoardNo()%>)">삭제
							</a></td>
				</tr>
				<%
					}
					} else {
				%>
				<td colspan='11' class="text-center"><a
					href="/studyhub/recruitmanagementlist">검색 조건에 맞는 결과가 없습니다.</a></td>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<hr>
	<script type="text/javascript">
		function checkDelete(bno) {
			if (confirm('해당 게시글을 삭제하시겠습니까?')) {
				location.href = "/studyhub/recruitmanagementdelete?bno=" + bno;
			}
		}
	</script>
	<div align="center">
		<div class="btn-group" role="group" aria-label="paging">
			<%-- 이전 페이지 있을 경우에 대한 처리 --%>
			<%
				if (currentPage <= 1) {
			%>
			<a class="btn btn-default" href="#" disabled><span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
			<%
				} else {
			%>
			<a class="btn btn-default"
				href="/first/blist?page=<%=currentPage - 1%>"><span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
			<%
				}
			%>
			<%-- 현재 페이지 숫자 보여주기 --%>
			<%
				for (int p = startPage; p <= endPage; p++) {
					if (p == currentPage) {
			%>
			<a class="btn btn-default" href="#" disabled><%=p%></a>
			<%
				} else {
			%>
			<a class="btn btn-default" href="/studyhub/boardlist?page=<%=p%>"><%=p%></a>
			<%
				}
				}
			%>
			<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
			<%
				if (currentPage >= maxPage) {
			%>
			<a class="btn btn-default" href="#" disabled><span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
			<%
				} else {
			%>
			<a class="btn btn-default"
				href="/studyhub/boardlist?page=<%=currentPage + 1%>"><span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
			<%
				}
			%>
		</div>
	</div>
</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->

<%@ include file="/views/include/common/tail.jsp"%>