<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.User" %>
<!-- 
작성자 : 구미향
내용 : 관리자 회원관리페이지
작성일자 17.10.30
 -->
<!-- java 구문 -->
<%
	ArrayList<User> ulist = (ArrayList<User>) request.getAttribute("ulist");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<link rel="stylesheet" href="/studyhub/css/admin.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/board_list.css">
<script type="text/javascript">
	function deleteMember(useremail){
		location.href="/studyhub/usermanagementdelete?ue="+useremail;
	}

</script>

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/admin/adminNav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="row" id="list-layout">
		<div
			class="col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-sm-10 col-xs-9 col-xs-offset-1">
			<h2>회원관리</h2>			
			
			<div class="top-area">
				<form action="/studyhub/usermanagementsearch" method="post" class="admin-search">
					<select id="user-search" name="search-by">
						<option value="user_name">이름</option>
						<option value="email">이메일</option>
					</select> <input type="search" autocomplete name="keyword" length="50"
						id="search-input"> &nbsp; <input type="submit" value="검색"
						id="search-btn">
				</form>

			</div>

			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr id="attr">
						<th>회원번호</th>
						<th>사용자이름</th>
						<th>이메일</th>
						<th>휴대전화</th>
						<th>상태</th>
						<th>탈퇴</th>
					</tr>
					<%
						 for (User u : ulist) { 
					%>
					<tr>
						<td><%=u.getUserNo() %></td>
						<td><%=u.getUserName() %></td>
						<td id="title_text"><%=u.getEmail() %></td>
						
						<td><%=u.getPhone() %></td>
						<td><%=u.getUserState() %></td>
						<td><a onclick="deleteMember('<%=u.getEmail() %>');" id="user-delete"><span class="glyphicon glyphicon-remove"></span></a></td>
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

<!--푸터 부분-->

<%@ include file="/views/include/common/tail.jsp"%>