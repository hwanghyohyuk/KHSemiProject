<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : FAQ 메인 페이지(메인에서 도움말 클릭했을 때의 화면)
작성일자 17.10.17
 -->

<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->

<style>

/* layout */

/*detail*/
#main-text {
	color: #001429;
}

#move {
	text-align: center;
}

#btns {
	float: right;
}


</style>
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">

<script type="text/javascript">
	function toQnA(){
		location.href="/studyhub/qnalist";
	}
</script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<!-- 메인 컨텐츠 -->

	<div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3">
		<h2 id="main-text">회원가입/로그인</h2>
		<hr>
		<span>아이디가 기억나지 않아요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse1" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse1">
			<div class="well">아이디가 왜 기억이 안날까요?</div>
		</div>
		<hr>
		<span>회원가입 할 때 페이지가 넘어가지 않아요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse2" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse2">
			<div class="well">답변을 채워야 합니다 :) </div>
		</div>
		<hr>
		<span>아이디를 해킹당한 것 같아요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse3" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse3">
			<div class="well">답변을 채워야 합니다 :)</div>
		</div>
		<hr>
		<span>비밀번호를 잊어버렸어요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse4" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse4">
			<div class="well">답변을 채워야 합니다 :)</div>
		</div>
		<hr>
		

		<span id="move">질문이 해결되지 않는다면? → </span>
		<button onclick="toQnA();" class="btn btn-info" id="btns">질문게시판으로 이동</button>

	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>

</body>
</html>