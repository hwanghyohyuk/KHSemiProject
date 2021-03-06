<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.QnA"%>
<!-- 
작성자 : 구미향
내용 : QnA질문 수정 페이지  
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%
	QnA qna = (QnA) request.getAttribute("qna");
%>

<!-- 초기화 블럭(변수선언 및 초기화) -->

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


<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->

	<div class="row" id="layout">
		<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-1">
			<h2>질문하기</h2>
			<br>
			<form action="/studyhub/qnaupdate" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="post_title" name="title"
						aria-describedby="emailHelp" value=<%=qna.getTitle()%>>
				</div>
				<div class="range">
					<label for="Content">공개범위</label> <label class="radio-inline">
						<input type="radio" name="access_no" id="inlineRadio1" value="1"
						checked> 전체공개
					</label> <label class="radio-inline"> <input type="radio"
						name="access_no" id="inlineRadio2" value="2"> 회원공개
					</label>
				</div>
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="Textarea" rows="15"
						name="content"><%=qna.getContent()%></textarea>
				</div>

				<input type="submit" value="제출하기" class="btn btn-default" id="btns">
				<a href="/studyhub/qnalist">목록으로 이동</a> <input type="hidden"
					name="no" value="<%=qna.getQnaNo()%>">
			</form>
		</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>
</body>
</html>