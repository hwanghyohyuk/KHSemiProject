<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 비밀번호 찾기 페이지
작성일자 17.10.05
 -->
<!-- java 구문 -->
<% String email = String.valueOf(request.getAttribute("userEmail")); %>
<% String name = String.valueOf(request.getAttribute("userName")); %>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="/studyhub/images/logo_big.png" style="margin-top: 10vh"></a>
	<hr />
	<div class="row" style="height: 40px"></div>
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
		<p>기억나는 비밀번호를 입력해주세요</p>
			<form action="/studyhub/findpwdprocess" method="post" name="findpwd">
				<div class="form-group">
					<input type="hidden" id="email" name="email" value="<%=email%>">
					<input type="hidden" id="name" name="name" value="<%=name%>">
					<input type="password" class="form-control"
						id="pwd" placeholder="비밀번호" name="pwd" oninput='emptyCheck()'>
				</div>
				<a href="/studyhub/login" class="btn btn-default pull-left">이전화면</a>
				<button type="submit" class="btn btn-primary main-back pull-right" id="findwpdbtn" disabled="disabled">비밀번호 확인</button>
			</form>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->
<script type="text/javascript">
function emptyCheck() {
	var pwd = $("#pwd").val();
	if(pwd==""){
		$("#findwpdbtn").prop("disabled", true);
	}else{
		$("#findwpdbtn").prop("disabled", false);
	}
}
</script>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>