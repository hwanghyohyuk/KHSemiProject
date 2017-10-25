
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.GBoard"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->
<%@page import="java.util.*, com.studyhub.common.vo.GBoard" %>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<%GBoard gb = new GBoard(); %>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<style>
#btns {
	float: right;
}

#layout {
	margin-top: 8vh;
}

</style>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->
<div class="row" id="layout">
  <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-1">
  <h2>게시글 작성하기</h2>
  <br>
	<form action="/studyhub/gboardinsert" enctype="multipart/form-data" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="post_title" name="title"
						oninput="checkTitle()" placeholder="제목을 입력하세요" >
				</div>
				<div class="range">
					<label for="Content">공개범위</label> <label class="radio-inline">
						<input type="radio" name="access_no" id="inlineRadio1" value="1">
						전체공개
					</label> <label class="radio-inline"> <input type="radio"
						name="access_no" id="inlineRadio2" value="2"> 회원공개
					</label>
				</div>
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="Textarea" rows="8"
						name="content" placeholder="파일에 대한 설명을 입력하세요"></textarea>
				</div>

				<input type="submit" value="제출하기" class="btn btn-primary main-back pull-right" id="btns">
				<a href="/studyhub/gboardpreview?groupno=<%=gb.getgBoardNo()%>">목록으로 이동</a>
				<input type="hidden" name="user_no" value="<%=user.getUserNo()%>">
				<input type="hidden" name="group_no" value="<%= group.getGroupNo() %>">
				
			</form>


<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>