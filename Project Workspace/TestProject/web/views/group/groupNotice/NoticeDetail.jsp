<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!-- 
작성자 : 윤찬호
내용 : 그룹 공지 상세보기 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%@ page import="com.studyhub.common.vo.GNotice" %>

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
<div class = "row">
<div class="panel panel-info" style="width: 80vw; margin: 3vh 10vw">
	<div class="panel-heading">
		<h3 class="panel-title">제목</h3>

	</div>
	<div class="panel-body">
		컨텐츠<br>
		<br>
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

</div>


</table>



<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>