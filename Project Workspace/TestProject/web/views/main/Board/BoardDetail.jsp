<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.Board"%>
<!-- 
작성자 : 황효혁
내용 : 모집게시판 상세보기 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	Board board = (Board) request.getAttribute("board");
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--CSS 및 자바스크립트-->

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>글쓰기</small>
		</h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">제목</label>
			<div class="col-sm-10">
				<%=board.getTitle()%>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">내용</label>
			<div class="col-sm-10">
				<%=board.getContent()%>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="/studyhub/boarddelete?bno=<%=board.getBoardNo()%>" class="btn btn-primary main-back pull-right">삭제</a> <a
					href="/studyhub/boardupdateview?bno=<%=board.getBoardNo()%>" class="btn btn-primary main-back pull-right">수정</a> <a
					href="/studyhub/boardlist" class="btn btn-primary main-back pull-right">목록</a>
			</div>
		</div>
	</form>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>