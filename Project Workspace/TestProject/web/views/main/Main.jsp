<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<script type="text/javascript" src='/studyhub/js/main.js'></script>
<%
	User changePwd = (User) session.getAttribute("user");
	if (changePwd.getPwdState() == 1) {
%>
<script type="text/javascript">
	alert('임시 비밀번호를 변경해주세요!');
	location.href = "/studyhub/myinfo";
</script>
<%
	}
%>
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="head">
			<span id="title" style="margin-left: 10%">나의 그룹</span>
		</div>
		<div class="sliderG">
			<div class="div-btn">
				<button class="btn-left" onClick="imgMove(0,'g');">
					<img class="btn-left" src="/studyhub/images/slider.png">
				</button>
			</div>
			<div class="RollDivG">
				<div id="group">
					<!-- ajax -->
				</div>
			</div>
			<div class="div-btn">
				<button class="btn-left" onClick="imgMove(1,'g');">
					<img class="btn-right" src="/studyhub/images/slider.png">
				</button>
			</div>
		</div>
	</div>
	<br>
	<br>
	<hr>
	<!-- 모집게시판 부분 -->
	<div class="row">
		<div class="head">
			<a href="/studyhub/boardlist" id="more">더보기</a><span id="title"
				style="margin-left: 10%">모집게시판</span>
		</div>
		<div class="sliderB">
			<div class="div-btn">
				<button class="btn-left" onClick="imgMove(0,'b');">
					<img class="btn-left" src="/studyhub/images/slider.png">
				</button>
			</div>
			<div class="RollDivB">
				<div id="board">
					<!-- ajax -->
				</div>
			</div>
			<div class="div-btn">
				<button class="btn-left" onClick="imgMove(1,'b');">
					<img class="btn-right" src="/studyhub/images/slider.png">
				</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(boardlist());
	$(mygrouplist(
<%=user.getUserNo()%>
	));
</script>
<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<%@ include file="/views/include/common/tail.jsp"%>
<!-- /미향 -->