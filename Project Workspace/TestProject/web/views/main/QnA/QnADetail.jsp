<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.QnA"%>
<!-- 
작성자 : 구미향
내용 : QnA질문게시판 페이지
작성일자 17.10.18
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub::QnA</title>

<!-- java 구문 -->
<%
	QnA qna = (QnA) request.getAttribute("qna");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">
<link rel="stylesheet" href="/studyhub/css/detail.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>

</head>
<body>

	<!--- 글쓴거 보이는 화면  -->
	<div class="row">
		<div class="col-md-6 col-md-offset-2 col-sm-6 col-sm-offset-2">

			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title"><%=qna.getTitle()%></h3>

				</div>
				<div class="panel-body" id="content"><%=qna.getContent()%></div>
				<!---댓글입력-->
				<form action="#" method="post">
					<input type="text" name="content" class="form-control"
						id="comment-write" 
						placeholder="댓글을 달아주세요">
					<!--<span class ="input-group-btn">-->
					<button class="btn btn-info btn-sm" type="submit">댓글달기</button>

				</form>

				<!---댓글보여지는부분--->

				<div class="panel-footer">Comments:
				<button>
					<a href="#" data-method="post" data-confirm="Are you sure"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				</button>
				</div>
				

			</div>
			<button class="btn btn-default btn-sm"
				id="btns">
				<a href="/studyhub/qnadelete?no=<%=qna.getQnaNo() %>" data-method="post" data-confirm="진짜로삭제할거에요?ㅠㅠ">삭제</a>
			</button>
			<button class="btn btn-default btn-sm"
				id="btns">
				<a href="/studyhub/qnaupdateview?no=<%= qna.getQnaNo()%>">수정</a>
			</button>

		</div>
	</div>




	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>