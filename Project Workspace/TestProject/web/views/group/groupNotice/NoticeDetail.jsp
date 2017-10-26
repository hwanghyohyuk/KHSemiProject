<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹 공지 상세보기 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%@ page import="com.studyhub.common.vo.GNotice"%>

<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	GNotice gNotice = (GNotice) request.getAttribute("gnotice");
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->

<!--- 글쓴거 보이는 화면  -->
<div class="container">
	<div class="page-header">
		<h1>공지 상세보기</h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">제목</label>
			<div class="col-sm-10">
				<%=gNotice.getTitle() %>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">내용</label>
			<div class="col-sm-10">
				<%=gNotice.getContent() %>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="/studyhub/gnoitcedelete?gno=<%=gNotice.getNoticeNo() %>"
					class="btn btn-primary main-back pull-right">삭제</a> 
				<a href="/studyhub/gnoticeupdateview?gno=<%=gNotice.getNoticeNo() %>"
					class="btn btn-primary main-back pull-right">수정</a> 
				<a href="/studyhub/gnoitcelist"
					class="btn btn-primary main-back pull-right">목록</a>
			</div>
		</div>
	</form>

</div>

<div class="panel-body">
	컨텐츠<br> <br>
	<!---댓글입력-->
	<form action="#" method="post">
		<input type="text" name="content" class="form-control"
			id="exampleInputEmail1" style="width: 64vw" placeholder="댓글을 달아주세요">
		<!--<span class ="input-group-btn">-->
		<button class="btn btn-info btn-sm" type="submit"
			style="margin-left: 1vw">댓글달기</button>

	</form>

	<!---댓글보여지는부분--->

	<div class="panel-footer" style="width: 64vw; display: inline-block">Comments:
	</div>
	<button>
		<a href="#" data-method="post" data-confirm="Are you sure">삭제</a>
	</button>

</div>
<button class="btn btn-default btn-sm"
	style="margin-top: 0.6vh; float: right">
	<a href="#" data-method="post" data-confirm="진짜로삭제할거에요?ㅠㅠ">삭제</a>
</button>
<button class="btn btn-default btn-sm"
	style="margin-top: 0.6vh; float: right">
	<a href="#">수정</a>
</button>
<div class="blank" style="height: 3vh; display: block"></div>


<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>