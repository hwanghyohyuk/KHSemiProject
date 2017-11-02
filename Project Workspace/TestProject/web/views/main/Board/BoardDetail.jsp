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
<script type="text/javascript" src='/studyhub/js/board.js' ></script>
<style>
#groupimg {
	width: 140px;
	height: 140px;
}
</style>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- sendMessage -->
<%
	int senderNo = user.getUserNo();
	int receiverNo = board.getUploader();
	int groupNo = board.getGroupNo();
%>
<script type="text/javascript" >
window.onload = function(){ checkBtnState(<%=senderNo%>,<%=groupNo%>); }
</script>
<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>글 읽기</small>
		</h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-3 control-label">제목</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getTitle()%>
				</p>
			</div>
			<label class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getUploaderName()%>
				</p>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label class="col-sm-3 control-label">모집 기간</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getUploadDate()%> ~ <%=board.getDeadlineDate()%>
				</p>
			</div>
			<label class="col-sm-3 control-label">모집 상태</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=board.getStatus()%>
				</p>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label class="col-sm-3 control-label">내용</label>
			<div class="col-sm-5">
				<%=(board.getContent()).replaceAll("\n", "<br>") %>
			</div>
			
			<label class="col-sm-1 control-label">가입 신청</label>
			<div class="col-sm-3">
				<%if(board.getStatus().equals("모집중")){ %>
				<a id="joinbtn" class="btn btn-primary main-back pull-left" href='javascript:sendMessage(<%=senderNo%>,<%=receiverNo%>,<%=groupNo%>);'>가입 신청</a>
				<%}else{ %>
				<a class="btn btn-default pull-left" disabled href="#">모집 마감</a>
				<%} %>
			</div>		
		</div>
		<hr>
		<div class="form-group">
			<label class="col-sm-3 control-label">그룹정보</label>
			<div class="col-sm-2">
				<img id="groupimg" src="/studyhub/images/groupimg/<%=board.getgImgRename()%>" class="img-rounded">
			</div>
			<label class="col-sm-2 control-label">그룹명</label>
			<div class="col-sm-5">
				<p class="pull-left control-label"><%=board.getGroupName()%>
				</p>
			</div>
			<label class="col-sm-2 control-label">스터디 방식</label>
			<div class="col-sm-5">
				<p class="pull-left control-label"><%=board.getAttributeName()%>
				</p>
			</div>
			<label class="col-sm-2 control-label">스터디 지역</label>
			<div class="col-sm-5">
				<p class="pull-left control-label"><%=board.getLocation()%>
				</p>
			</div>
			<label class="col-sm-2 control-label">스터디 분류</label>
			<div class="col-sm-5">
				<p class="pull-left control-label"><%=board.getCategoryName()%>
				</p>
			</div>
			<label class="col-sm-2 control-label">그룹원 수</label>
			<div class="col-sm-5">
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