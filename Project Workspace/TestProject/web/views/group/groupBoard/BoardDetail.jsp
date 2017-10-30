<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 :조남훈
내용 : 그룹게시판 detail 페이지
작성일자 17.10.26
 -->
<!-- java 구문 -->
<%@ page
	import="com.studyhub.common.vo.GBoard ,java.sql.Date, java.util.*"%>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	GBoard gBoard = (GBoard) request.getAttribute("gboard");
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>


<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<div class="row">
	<div class="panel panel-info" style="width: 80vw; margin: 3vh 10vw">
		<div class="panel-heading">
			<form class="form-horizontal">
				<div class="form-group">

					<div class="col-sm-30">
						<label for="inputEmail3" class="col-sm-1 control-label">제목</label>
					</div>
					<%-- 					<h1><%=gBoard.getTitle()%></h1> 
 --%>
					<div class="col-sm-30">
						<label for="inputPassword3" class="col-sm-1 control-label">내용</label>
					</div>
					<%-- 					<%=gBoard.getContent()%> 
 --%>
				</div>

				<div class="form-group ">
					<div class="col-sm-12">
						<button class="btn btn-default btn-sm"
							style="margin-top: 0.6vh; float: right">
							<a href="#" data-method="post" data-confirm="삭제하시겠습니까?">삭제</a>
						</button>
						<button class="btn btn-default btn-sm"
							style="margin-top: 0.6vh; float: right">
							<a href="/studyhub/views/group/groupBoard/BoardUpdateForm.jsp">수정</a>
						</button>
						<button class="btn btn-default btn-sm"
							style="margin-top: 0.6vh; float: right">
							<a href="/studyhub/gboardpreview?groupno=<%=group.getGroupNo()%>"
								data-method="post">목록</a>
						</button>



					</div>
				</div>
		</div>

		<div class="panel-body">
			<!-- 댓글입력 -->
			<form action="#" method="post">
				<input type="text" name="content" class="form-control"
					id="exampleInputEmail1" style="width: 64vw" placeholder="댓글을 달아주세요">
				<button class="btn btn-info btn-sm" type="submit"
					style="margin-right: 1vw">댓글달기</button>
			</form>

			<!-- 댓글보여지는부분 -->
			<button>
				<a href="#" data-method="post">수정</a>
			</button>
			<button>
				<a href="#" data-method="post" data-confirm="Are you sure">삭제</a>
			</button>



		</div>

		<div class="blank" style="height: 3vh; display: block"></div>

	</div>


	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>