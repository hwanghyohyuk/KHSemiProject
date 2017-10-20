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
<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>
<style type="text/css">
	ul {  
		list-style:none;
		padding-left: 0;
	}
	
	ul li #nav_text {
		color: white;
		font-weight: bold;
	
	}
	
	ul li {
		text-align: center;
		margin-top: 30px;		
	}
	
	div#nav_menu {
		background-color: #004157;
		position: relative;
		font-size: 15pt;
		float:left;
		left: 0%; 
		top: 0px;; 
		text-align:center; 
		height: 87vh;
		padding-top: 0px;
	}
</style>

</head>
<body>
<div id="nav_menu">
<ul class="nav nav-stacked">
	<li><a href="" id="nav_text">[<%= group.getGroupName() %>]</a></li>
	<li><a href=# id="nav_text">공지사항</a></li>
	<li><a href=# id="nav_text">스터디일정</a></li>
	<li><a href=# id="nav_text">파일공유</a></li>
	<li><a href=# id="nav_text">자유게시판</a></li>
	<li><a href="/studyhub/gqnapreview" id="nav_text">Q&A</a></li>
</ul>
</div>

<script type="text/javascript">
	$(function(){
		var currentPosition = parseInt($("#nav_menu").css("top"));
			$(window).scroll(function(){
				var position = $(window).scrollTop();
				$("#nav_menu").stop().animate({"top": position + currentPosition + "px"}, 300);
			});
	});
</script>

</body>
</html>    