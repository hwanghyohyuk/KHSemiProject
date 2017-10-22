<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.studyhub.common.vo.GNotice"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹공지 작성 페이지
작성일자 17.10.19
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹공지 작성::StudyHub</title>
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<!--그룹 네비게이션 바 -->
<%@ include file="/views/include/group/nav.jsp"%>

<style>
#btns {
	float: right;
}

#layout {
	margin-top: 8vh;
}

</style>


<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>


</head>
<!-- 메인 컨텐츠 -->
<body>
	<div class="row" id="layout">
		<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-1">
			<h2>그룹 공지 작성</h2>
			<br>
			<form action="/studyhub/gnoticecreate" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="제목을 입력하세요">
				</div>
				<div class="range">
					<label for="Content">공개범위</label> <label class="radio-inline">
						<input type="radio" name="option" id="inlineRadio1"
						value="option1"> 전체공개
					</label> <label class="radio-inline"> <input type="radio"
						name="option" id="inlineRadio2" value="option2"> 회원공개
					</label>
				</div>
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="Textarea" rows="15"
						placeholder="내용을 입력하세요"></textarea>
				</div>
				<input type="submit" value="제출하기" id="btns"> 
				<a href="/studyhub/gnoticepreview?groupno=<%= group.getGroupNo() %>">목록으로 이동</a>
		</div>
		</form>


		<!-- /메인 컨텐츠 -->

		<!--푸터 부분-->
		<%@ include file="/views/include/main/footer.jsp"%>
		<!--페이지 끝-->
		<%@ include file="/views/include/common/headend.jsp"%>
</body>
</html>