<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.ShareFile"%>
<!-- 
작성자 : 구미향
내용 : 파일공유  수정 Form  페이지
작성일자 17.10.24
 -->
<!-- java 구문 -->
<% ShareFile sf = (ShareFile)request.getAttribute("sharefile"); %>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/write_form.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
	<script src="/studyhub/js/bootstrap.min.js"></script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="row" id="layout">
		<div
			class="col-lg-6 col-lg-offset-2 col-md-6 col-md-offset-2 col-sm-6 col-sm-offset-2 col-xm-6 col-xs-2" id="form-outline">
			<h2>파일 공유글 수정하기</h2>
			<br>
			<form action="/studyhub/sharefileupdate" enctype="multipart/form-data" method="post">
				<input type="hidden" name="fileno" value="<%= sf.getFileNo() %>">
				<input type="hidden" name="ofile" value="<%= sf.getFileName() %>">
				<input type="hidden" name="rfile" value="<%= sf.getRenameFileName() %>">
					<div class="form-group">
						<label for="title">제목</label> <input type="text"
							class="form-control" id="post_title" name="title"
							aria-describedby="emailHelp" value="<%=sf.getTitle()%>">
					</div>
					<div class="range">
						<label for="Content">공개범위</label> <label class="radio-inline">
							<input type="radio" name="access_no" id="inlineRadio1" value="1" checked>
							전체공개
						</label> <label class="radio-inline"> <input type="radio"
							name="access_no" id="inlineRadio2" value="2"> 회원공개
						</label>
					</div>
					<div class="upload">
						<label for="upload">파일첨부</label>
						<% if(sf.getFileName()!=null){ %>
						<%=sf.getFileName() %>
						<% } %>
						<input type="file" name="upfile">
					</div>
					<div class="form-group">
						<label for="Content">내용</label>
						<textarea class="form-control" id="Textarea" rows="8"
							name="content"><%=sf.getContent() %></textarea>
					</div>
	
					<input type="submit" value="제출하기" class="btn btn-info" id="btns">
					<a href="/studyhub/sharedfilepreview?groupno=<%=group.getGroupNo()%>">&nbsp;&nbsp;목록으로 이동</a> 
					<input type="hidden" name="user_no" value="<%=user.getUserNo()%>">
					<input type="hidden" name="group_no" value="<%= group.getGroupNo() %>">
				
			</form>
		</div>
	</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>