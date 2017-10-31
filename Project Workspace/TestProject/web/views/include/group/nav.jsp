<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.studyhub.common.vo.*"%>
<%
	Group group = (Group)session.getAttribute("group");
	User navuser = (User)session.getAttribute("user");
%>

<div id="nav_menu">
<ul class="nav nav-stacked" id="nav_ul">
	<li id="nav_li_top"><a href="/studyhub/gmainpreview?group_no=<%= group.getGroupNo() %>&reset=0&user_no=<%=navuser.getUserNo()%>" id="nav_text">[<%= group.getGroupName() %>]</a></li>
	<li id="nav_li"><a href="/studyhub/gnoticepreview?groupno=<%=group.getGroupNo() %>" id="nav_text"> ▷ 공지사항</a></li>
	<li id="nav_li"><a href="/studyhub/schedulepreview?group_no=<%= group.getGroupNo() %>" id="nav_text"> ▷ 스터디일정</a></li>
	<li id="nav_li"><a href="/studyhub/sharedfilepreview?groupno=<%= group.getGroupNo() %>" id="nav_text"> ▷ 파일공유</a></li>
	<li id="nav_li"><a href="/studyhub/gboardpreview?groupno=<%= group.getGroupNo() %>" id="nav_text"> ▷ 자유게시판</a></li>
	<li id="nav_li"><a href="/studyhub/gqnapreview" id="nav_text"> ▷ Q&A</a></li>
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