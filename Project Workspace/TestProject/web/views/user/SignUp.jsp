<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 회원가입 페이지
작성일자 : 17.10.20
 -->
<!-- java 구문 -->


<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/start.css">
<script type="text/javascript" src="/studyhub/js/signup.js"></script>



<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container col-md-12 col-lg-12 col-sm-12 col-xs-12" id="main-area">
	
	<div class="col-md-6 col-xs-12">
		<!-- 공백 영역 -->
		<div class="col-md-0 col-xs-0" style="height: 20px"></div>
		<!-- 공백 영역 -->
		<div class="col-md-7 col-lg-7 col-sm-7 col-xs-7 col-md-offset-2 col-lg-offset-2" id="signup-area" style="display: table">
			<div
				style="display: table-cell; vertical-align: middle; height: 100%">
				<div class="form-group">
					<h3 class="text-center" id="signup-text">회원가입</h3>
				</div>
				<form class="form-horizontal" action="/studyhub/signupprocess" method="post"
					name="signupform">
					<div class="form-group">
						<div class="col-sm-8 col-xs-8">
							<input type="email" class="form-control" id="signupemail"
								placeholder="이메일 주소" name="signupemail"
								oninput='checkEmail("signup")' onblur='checkEmail("signup")'
								onclick='checkEmail("signup")'
								value='
							<%if (request.getParameter("signupemail") != null) {%>
								<%=request.getParameter("signupemail")%>
								<%}%>
							'>
						</div>
						<div class="col-sm-4 col-xs-4">
						<p id='signupemailtxt'></p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-xs-8">
							<input type="password" class="form-control" id="signuppwd"
								placeholder="비밀번호 10자리 이상" name="signuppwd" oninput="checkPwd()">
						</div>
						<div class="col-sm-4 col-xs-4">
						<p id='signuppwdtxt'></p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-xs-8">
							<input type="password" class="form-control" id="confirmpwd"
								placeholder="비밀번호 확인" name="confirmpwd" oninput="checkPwd()">
						</div>
						<div class="col-sm-4 col-xs-4">
						<p id='confirmpwdtxt'></p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control" id="username"
								placeholder="사용자 이름" name="username" oninput="checkName()">
						</div>
						<div class="col-sm-4 col-xs-4">
						<p id='usernametxt'></p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-xs-8">
							<input type="tel" class="form-control" id="phone"
								placeholder="연락처 '-' 없이" name="phone" oninput="checkPhone()">
						</div>
						<div class="col-sm-4 col-xs-4">
						<p id='phonetxt'></p>
						</div>
					</div>
					<hr>
					<button type="submit" class="btn btn-primary pull-right"
						id="signupbtn" disabled="disabled">가입</button>
				</form>
			</div>
		</div>
		<div class="col-md-1 col-xs-1" style="height: 40px"></div>
	</div>
	<!-- 이미지 영역 -->
	<div class="col-md-0 hidden-xs" style="height: 60px"></div>
	<div class="col-md-6 col-xs-12">
		
	</div>
</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>