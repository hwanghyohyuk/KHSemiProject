<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 모집게시판 리스트 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
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
			<form action='/studyhub/boardlist' method='post'>
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
	<hr>
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
					<th>회원수</th>					
				</tr>
			</thead>
			<tbody>
			<%
				for (Board b : list) {
			%>			
				<tr>
					<td><img id="groupimg" src="/studyhub/images/groupimg/<%=b.getgImgRename()%>"></td>
					<td><%=b.getCategoryName() %></td>
					<td><%=b.getGroupName() %></td>
					<td>
						<%
							if (user != null) {
						%> <a
						href="/studyhub/boardview?bno=<%=b.getBoardNo()%>&page=<%=currentPage%>">
							<%=b.getTitle()%>
					</a> <%} else {%> <%=b.getTitle()%> <%	} %>
					</td>
					<td><%=b.getUploaderName()%></td>
					<td><%=b.getUploadDate()%></td>
					<td><%=b.getDeadlineDate() %></td>
					<td><%=b.getStatus() %></td>
					<td><%=b.getLocation() %></td>
					<td><%=b.getAttributeName() %></td>
					<td><%=b.getMemberCount() %></td>
				</tr>			
			<%}%>
			</tbody>
		</table>
	</div>
	<hr>
	<div align="right">
		<%
			if (user != null) {
		%>
		<a class="btn btn-default" href="javascript:grouplistcheck()">글쓰기</a>
		<script type="text/javascript">
			function grouplistcheck() {
				var userno =
		<%=user.getUserNo()%>
			;
				$.ajax({
					url : "/studyhub/bgrouplist",
					data : {
						userno : userno
					},
					type : "get",
					datatype : "json",
					success : function(data) {
						var json = JSON.parse(JSON.stringify(data));
						var values = "";
						if (json.list.length > 0) {
							location.href = '/studyhub/boardinsert.move';
						} else {
							alert("모집할 그룹이 없습니다.");
						}
					}
				});
			}
		</script>
		<%
			} else {
		%>
		<a class="btn btn-default" disabled>글쓰기</a>
		<%
			}
		%>
	</div>
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
<%@ include file="/views/include/main/footer.jsp"%>

<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>