<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<!-- 이미지 영역 -->
	<div class="col-md-0 hidden-xs" style="height: 60px"></div>
	<div class="col-md-6 col-xs-12">
		<img alt=""
			src="https://dummyimage.com/540x540/3d6280/9da0cc.jpg&text=image+540x540"
			style="width: 100%">
	</div>
	<div class="col-md-6 col-xs-12">
		<!-- 공백 영역 -->
		<div class="col-md-0 col-xs-0" style="height: 100px"></div>
		<!-- 공백 영역 -->
		<div class="col-md-1 col-xs-1" style="height: 40px"></div>
		<div class="col-md-10 col-xs-10" style="display: table">
			<div
				style="display: table-cell; vertical-align: middle; height: 100%">
				<div class="form-group">
				<h3 class="text-center">회원가입</h3>
				</div>
				<form action="/signup" method="post" name="signupform">
					<div class="form-group">
						<input type="email" class="form-control" id=""
							placeholder="이메일 주소" name="email">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							id="" placeholder="비밀번호" name="pwd">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							id="" placeholder="비밀번호 확인" name="confirmpwd">
					</div>
					<div class="form-group">
						<input type="text" class="form-control"
							id="" placeholder="사용자 이름" name="username">
					</div>
					<div class="form-group">
						<input type="tel" class="form-control"
							id="" placeholder="연락처" name="phone">
					</div>
					<button type="submit" class="btn btn-primary pull-right">가입</button>
				</form>
			</div>
		</div>
		<div class="col-md-1 col-xs-1" style="height: 40px"></div>
	</div>
</div>

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>




<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp" %>