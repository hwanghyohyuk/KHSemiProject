<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.ShareFile"%>
<!-- 
작성자 : 구미향
내용 : 파일공유 detail 페이지
작성일자 17.10.13
 -->
<!-- java 구문 -->
<%
	ShareFile sf = (ShareFile) request.getAttribute("sharefile");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/board_detail.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<script src="/studyhub/js/bootstrap.min.js"></script>
<script>
	function check(){
		return confirm("정말 삭제하시겠습니까?");
	}
</script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container" style="height: 90vh;">

	<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-8 col-sm-offset-1 col-xm-8 col-xs-1" id="fswrapper">
	<h2 id="heading">Shared Files</h2>
	</div>
	<div id="inner"
		class="col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-1 col-sm-8 col-sm-offset-1 col-xm-8 col-xs-1">

		<hr id="first-line">
		<div class="head-text">
			<h3 id="title-text"><%=sf.getTitle()%></h3>
			<div id="attr-text">
				<span>다운로드수 <%=sf.getDownloadCount()%> |
				</span> <span>작성날짜 <%=sf.getUploadDate()%> |
				</span> <span>작성자 <%=sf.getUserName()%></span>
			</div>
		</div>
		<hr id="second-line">
		
		<div class="panel-body" id="content">
		<% if(sf.getContent()==null){ %>
		<% } else{ %>
		<%=sf.getContent()%>
		<% } %>
		<input type="hidden" name="sfno" id="sfno" value="<%=sf.getFileNo()%>">
		<input type="hidden" name="userno" id="userno" value="<%=user.getUserNo()%>">
		<hr>
		<% if(sf.getFileName()==null){ %>
		<span>첨부파일 없음</span>
		<% }else{ %>
		<span class="glyphicon glyphicon-paperclip"></span>
		<span>file: <a href="/studyhub/sharefiledown?ofile=<%=sf.getFileName() %>&rfile=<%=sf.getRenameFileName()%>"><%=sf.getFileName() %></a></span>
		<% } %>
		</div>
		<hr>
		<div class="sub-btns">
		<a href="/studyhub/sharedfilepreview?groupno=<%=group.getGroupNo()%>">목록으로 이동</a> 
		
		<% if(user.getUserName().equals(sf.getUserName())){ %>
		<a href="/studyhub/sharefileupdateview?no=<%=sf.getFileNo()%>">
			<button class="btn btn-default btn-sm" id="btns">수정</button></a>
		<a href="/studyhub/sharefiledelete?fileno=<%=sf.getFileNo()%>&groupno=<%=group.getGroupNo()%>"
		 onclick="return check();">
		<button class="btn btn-default btn-sm" id="btns">삭제</button></a> 
		<% } %>
		</div>
	</div>
</div>
<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>