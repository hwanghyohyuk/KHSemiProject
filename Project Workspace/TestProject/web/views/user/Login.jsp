<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 로그인 페이지
작성일자 17.10.05
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--CSS 및 자바스크립트-->
<script type="text/javascript">
function emptyCheck() {
	var email = $("#email").val();
	var pwd = $("#pwd").val();
	if(email=="" || pwd==""){
		$("#loginbtn").prop("disabled", true);
	}else{
		$("#loginbtn").prop("disabled", false);
	}
}
</script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!-- 메인 컨텐츠 -->
<div class="container text-center">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="https://dummyimage.com/600x400/ffffff/004157&text=Logo+600*400"></a>
	<hr />
	<div class="row" style="height: 40px"></div>
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
			<form action="/studyhub/loginprocess" method="post" name="loginform">
				<div class="form-group">
					<input type="email" class="form-control" id="email"
						placeholder="이메일 주소" name="email" oninput='emptyCheck()'>
				</div>
				<div class="form-group">
					<input type="password" class="form-control"
						id="pwd" placeholder="암호" name="pwd" oninput='emptyCheck()'>
				</div>
				<button type="submit" class="btn btn-primary btn-block main-back" id = "loginbtn" disabled="disabled">로그인</button>
			</form>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
	<div class="row height40">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
		<div class="pull-left">
			<a href="/studyhub/signup">회원가입</a>
		</div>
		<div class="pull-right">
			<a href="/studyhub/findemail" >이메일 또는 비밀번호를
				잊으셨나요?</a>
		</div>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>