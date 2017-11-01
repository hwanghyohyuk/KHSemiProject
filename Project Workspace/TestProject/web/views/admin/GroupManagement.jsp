<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.Group" %>
<!-- 
작성자 : 구미향
내용 : 관리자 group관리페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->
<% ArrayList<Group> glist = (ArrayList<Group>)request.getAttribute("glist"); %>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<link rel="stylesheet" href="/studyhub/css/admin.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/board_list.css">

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/admin/adminNav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="row" id="list-layout">
		<div
			class="col-md-10 col-md-offset-2 col-lg-10 col-lg-offset-1 col-sm-10 col-xs-10 col-xs-offset-1">
			<h2>그룹관리</h2>			
			
			<div class="top-area">
				<form action="/studyhub/qnasearch" method="post" class="admin-search">
					<select id="groupsearch-by" name="search-by">
						<option value="group_name">그룹명</option>
						<option value="g_category">카테고리</option>
					</select> <input type="search" autocomplete name="keyword" length="50"
						id="search-input"> &nbsp; <input type="submit" value="검색"
						id="search-btn">
				</form>

			</div>

			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr id="attr">
						<th>번호</th>
						<th>그룹명</th>
						<th>카테고리</th>
						<th>지역</th>
						<th>on/offline</th>
						<th>그룹장</th>
						<th>삭제</th>
					</tr>
					<%
						for(Group g : glist){
					%>
					<tr>
						<td><%=g.getGroupNo() %></td>
						<td><%=g.getGroupName() %></td>
						<td><%=g.getCategoryName() %></td>
						<td><%=g.getLocation() %></td>
						<td><%=g.getAttributeName() %></td>
						<td><%=g.getUserName() %></td>
						<td><button onclick='deleteGroup(<%= g.getGroupNo() %>, "<%= g.getGroupName() %>");' id='delete-btn'>삭제</button></td>
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
	function deleteGroup(param, name){
		var userno = "<%= user.getUserNo() %>";
		var name = name;
		$.ajax({
			url: "/studyhub/groupmanagementdelete",
			data: { groupno: param, userno: userno },
			type: "get",
			dataType: "json",
			async: false
		});
		location.href = "/studyhub/groupmanagementlist";
		alert(name + " 그룹이 삭제되었습니다.");
	}
	
</script>



<!--푸터 부분-->

<%@ include file="/views/include/common/tail.jsp"%>