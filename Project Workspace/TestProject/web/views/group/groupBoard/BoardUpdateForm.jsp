
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
		<h2>게시글 수정</h2>
		<br>
		<form action="/studyhub/gboardupdate" method="post">
			<div class="form-group">
				<label for="title">제목</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					name="title" 
					aria-describedby="emailHelp" value="<%=gb.getTitle() %>" >
			</div>
			<div class="range">
				<label for="Content">공개범위</label> <label class="radio-inline">
					<input type="radio" name="accessno" id="inlineRadio1" value="1">
					전체공개
				</label> <label class="radio-inline"> <input type="radio"
					name="accessno" id="inlineRadio2" value="2"> 회원공개
				</label> <label class="radio-inline"> <input type="radio"
					name="accessno" id="inlineRadio3" value="3"> 그룹원공개
				</label>
			</div>
			<div class="form-group">
				<label for="Content">내용</label>
				<textarea class="form-control" id="Textarea" rows="15"
				name="content" value="<%=gb.getContent() %>" ></textarea>
			</div>
			<input type="hidden" name="uploader" value="<%=user.getUserNo() %>">
			<input type="hidden" name="groupno" value="<%=group.getGroupNo() %>">
			<input type="submit" value="수정하기" class = "btn btn-info" id="btns"> <a
				href="/studyhub/gboardpreview?groupno=<%=group.getGroupNo()%>">취소</a>
		</form>
	</div>	
</div>



<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>