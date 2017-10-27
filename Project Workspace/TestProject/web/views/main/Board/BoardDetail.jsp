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
<!--자바스크립트 및 CSS-->
<style>
#groupimg {
	width: 100px;
	height: 100px;
}
</style>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>글 읽기</small>
		</h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="btitle" class="col-sm-3 control-label">제목</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getTitle()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getUploaderName()%>
				</p>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="btitle" class="col-sm-3 control-label">모집 기간</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getUploadDate()%> ~ <%=board.getDeadlineDate()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-3 control-label">모집 상태</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getStatus()%>
				</p>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="btitle" class="col-sm-3 control-label">내용</label>
			<div class="col-sm-9">
				<%=(board.getContent()).replaceAll("\n", "<br>") %>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="btitle" class="col-sm-3 control-label">그룹정보</label>
			<div class="col-sm-1">
				<img id="groupimg" src="/imamges/groupimg/<%=board.getgImgRename()%>">
			</div>
			<label for="btitle" class="col-sm-2 control-label">그룹명</label>
			<div class="col-sm-1">
				<p class="pull-left control-label"><%=board.getGroupName()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-2 control-label">스터디 방식</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getAttributeName()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-2 control-label">스터디 지역</label>
			<div class="col-sm-1">
				<p class="pull-left control-label"><%=board.getLocation()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-2 control-label">스터디 분류</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getCategoryName()%>
				</p>
			</div>
			<label for="btitle" class="col-sm-2 control-label">그룹원 수</label>
			<div class="col-sm-1">
				<p class="pull-left control-label"><%=board.getMemberCount()%>
				</p>
			</div>
		</div>
	</form>
	<hr>
	<div class="col-sm-offset-2 col-sm-10">
		<%
			if (user.getUserNo() == board.getUploader()) {
		%>
		<a class="btn btn-default pull-right"
			href="javascript:checkDelete(<%=board.getBoardNo()%>)">삭제</a>
			<script type="text/javascript">
			function checkDelete(bno){
				if (confirm('해당 게시글을 삭제하시겠습니까?')) {
				    location.href="/studyhub/boarddelete?bno="+bno;
				} 
			}
			</script>
		<a class="btn btn-default pull-right"
			href="/studyhub/boardupdate.move?bno=<%=board.getBoardNo()%>">수정</a>
		<%
			}
		%>
		<a class="btn btn-default pull-right" href="/studyhub/boardlist">목록</a>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>