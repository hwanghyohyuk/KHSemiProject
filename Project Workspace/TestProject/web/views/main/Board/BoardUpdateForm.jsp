<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.Board"%>
<!-- 
작성자 : 황효혁
내용 : 모집게시판 상세보기 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->
<%
	Board board = (Board) request.getAttribute("board");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>글 수정</small>
		</h1>
	</div>

	<form class="form-horizontal">
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="제목" id="title" value="<%=board.getTitle()%>">
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">내용</label>
			<div class="col-sm-10">
				<textarea class="form-control" rows="10" id="content"
					placeholder="내용" ><%=board.getContent()%></textarea>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="exampleInputFile" class="col-sm-2 control-label">파일
				업로드</label> <input type="file" id="exampleInputFile">
			<p class="help-block"></p>
		</div>
		<hr>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary main-back pull-right">수정</button>
			</div>
		</div>
	</form>



</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>