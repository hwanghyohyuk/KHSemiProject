<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.studyhub.common.vo.Group"%>
<%
	Group group = (Group)request.getAttribute("group");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studyHub</title>
<style type="text/css">
	ul {  list-style:none;	}
	
	ul li a {
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
	}
</style>

</head>
<body>
<div id="nav_menu">
<ul>
	<li><a>[<%-- <%= group.getGroupName() %> --%>]</a></li>
	<li><a href=#>공지사항</a></li>
	<li><a href=#>스터디일정</a></li>
	<li><a href=#>파일공유</a></li>
	<li><a href=#>자유게시판</a></li>
	<li><a href=#<%-- "/studyhub/gqnapreview?groupno<%= group.getGroupNo() %> --%>">Q&A</a></li>
</ul>
</div>

</body>
</html>    