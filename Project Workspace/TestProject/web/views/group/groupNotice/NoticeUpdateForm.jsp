<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 윤찬호
내용 : 공지 수정 페이지  
작성일자 17.10.21
 -->
<!-- java 구문 -->
 <%@ page import="java.util.*, com.studyhub.common.vo.GNotice" %>

<!-- 초기화 블럭(변수선언 및 초기화) -->
<% 
	GNotice gnotice = (GNotice)request.getAttribute("gnotice"); 
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<style>
#btns {
	float: right;
}

#layout {
	margin-top: 8vh;
}
</style>

<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="row" id="layout">
  <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-1">
  <h2>질문하기</h2>
  <br>
	<form action="/studyhub/gnoticeupdate" method="post">
		<div class="form-group">
			<label for="title">제목</label> <input type="text"
				class="form-control" id="post_title" name="title"
				aria-describedby="emailHelp" value= <%= gnotice.getTitle() %>>
		</div>
		<div class="range">
		<label for="Content">공개범위</label>
		<label class="radio-inline"> <input type="radio"
			name="access_no" id="inlineRadio1" value="1" checked>
			전체공개
		</label> <label class="radio-inline"> <input type="radio"
			name="access_no" id="inlineRadio2" value="2">
			회원공개
		</label>
		</div>
		<div class="form-group">
			<label for="Content">내용</label>
			<textarea class="form-control" id="Textarea" rows="15" name="content"
				><%= gnotice.getContent() %></textarea>
		</div>
		
		<input type="submit" value="수정하기" class="btn btn-default" id="btns">
		<a href="/studyhub/gnoticelist">목록으로 이동</a>
		<input type="hidden" name="no" value="<%= gnotice.getNoticeNo() %>">
		</form>
	</div>
</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>