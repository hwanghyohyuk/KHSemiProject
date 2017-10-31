<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.studyhub.common.vo.*"%>
<%

%>

<div id="nav_menu">
<ul class="nav nav-stacked" id="nav_ul">
	<li id="nav_li"><a href="/studyhub/views/admin/MainDashBoard.jsp" id="nav_text">대시보드</a></li>
	<li id="nav_li"><a href="/studyhub/usermanagementlist" id="nav_text">회원관리</a></li>
	<li id="nav_li"><a href="/studyhub/groupmanagementlist" id="nav_text">그룹관리</a></li>
	<li id="nav_li"><a href="/studyhub/noticeview" id="nav_text">FAQ관리</a></li>
	<li id="nav_li"><a href="/studyhub/qnalistmanagement" id="nav_text">Q&A관리</a></li>
	<li id="nav_li"><a href="/studyhub/views/admin/MainBoardManagement.jsp" id="nav_text">모집게시판</a></li>
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