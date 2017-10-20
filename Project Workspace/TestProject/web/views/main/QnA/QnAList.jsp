<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.QnA"%>
<!-- 
작성자 : 구미향
내용 : QnA질문게시판 페이지
작성일자 17.10.18
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub::FAQ</title>

<!-- java 구문 -->
<%
	ArrayList<QnA> list = (ArrayList<QnA>) request.getAttribute("list");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<script type="text/javascript">
	function insertPage() {
		location.href = "/studyhub/views/main/QnA/QnAWriteForm.jsp"
	}
</script>

<link rel="stylesheet" type="text/css" href="/studyhub/css/board_list.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>

</head>
<!-- 메인 컨텐츠 -->
<body>
	<div class="row">
		<div
			class="col-md-8 col-md-offset-2 col-sm-10 col-xs-9 col-xs-offset-1">
			<h2>Q&A게시판</h2>

			<div class="search">

				<form action="#" method="post">
					<select>
						<option value="제목">제목</option>
						<option value="작성자">작성자</option>
					</select> <input type="search" autocomplete name="keyword" length="50"
						id="search-input"> &nbsp; <input type="submit" value="검색"
						id="search-btn">
				</form>

			</div>

			<div class="table-area">
				<table class="table table-striped" align="center" width="600">
					<tr id="attr">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<%
						for (QnA qna : list) {
					%>
					<tr>
						<td><%=qna.getQnaNo()%></td>
						<td id="title_text"><a
							href="/studyhub/qnaview?no=<%=qna.getQnaNo()%>"><%=qna.getTitle()%></a></td>
						<td><%=qna.getWriter()%></td>
						<td><%=qna.getUploadDate()%></td>
						<td><%=qna.getReadCount()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<button onclick="insertPage();" id="btns">글쓰기</button>
			</div>
		</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>