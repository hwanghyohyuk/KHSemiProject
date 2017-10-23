<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : 파일공유 write Form  페이지
작성일자 17.10.23
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/write_form.css">
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="row" id="layout">
		<div
			class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xm-6 col-xs-3" id="form-outline">
			<h2>파일 공유 글쓰기</h2>
			<br>
			<form action="/studyhub/qnainsert" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="post_title" name="title"
						aria-describedby="emailHelp" placeholder="제목을 입력하세요">
				</div>
				<div class="range">
					<label for="Content">공개범위</label> <label class="radio-inline">
						<input type="radio" name="access_no" id="inlineRadio1" value="1">
						전체공개
					</label> <label class="radio-inline"> <input type="radio"
						name="access_no" id="inlineRadio2" value="2"> 회원공개
					</label>
				</div>
				<div class="upload">
					<label for="upload">파일첨부</label>
					<input type="file" name="upfile">
				</div>
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="Textarea" rows="8"
						name="content" placeholder="파일에 대한 설명을 입력하세요"></textarea>
				</div>

				<input type="submit" value="제출하기" class="btn btn-info" id="btns">
				<a href="/studyhub/sharefilelist">&nbsp;&nbsp;목록으로 이동</a> <input type="hidden"
					name="user_no" value="<%=user.getUserNo()%>">
			</form>
		</div>
	</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>