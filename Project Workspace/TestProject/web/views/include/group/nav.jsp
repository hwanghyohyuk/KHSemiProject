<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.studyhub.common.vo.Group"%>
<%
	Group group = (Group)session.getAttribute("group");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studyHub</title>
<style type="text/css">
	ul {  list-style:none;	}
	
	ul li #nav_text {
		color: white;
		font-weight: bold;
		padding-right: 40px;
	
	}
	
	ul li {
		text-align: center;
		margin-top: 30px;		
	}
	
	div#nav_menu {
		background-color: #004157;
		font-size: 15pt;
		float:left;
		position: relative;
		left: 0%; 
		top: 13%; 
		text-align:center; 
	}
</style>

</head>
<body>
<div class="col-cd-3" id="nav_menu">
<ul>
	<li><a id="nav_text">[<%= group.getGroupName() %>]</a></li>
	<li><a href=# id="nav_text">공지사항</a></li>
	<li><a href=# id="nav_text">스터디일정</a></li>
	<li><a href=# id="nav_text">파일공유</a></li>
	<li><a href="/studyhub/gboardpreview?groupno=<%= group.getGroupNo() %>" id="nav_text">자유게시판</a></li>
	<li><a href="/studyhub/gqnapreview" id="nav_text">Q&A</a></li>
</ul>
</div>

</body>
</html>    