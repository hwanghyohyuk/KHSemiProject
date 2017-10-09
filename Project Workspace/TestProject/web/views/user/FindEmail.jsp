<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 이메일 찾기 페이지
작성일자 17.10.05
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<a href="/studyhub/"> <img class="img-responsive center-block"
		alt=""
		src="https://dummyimage.com/600x400/ffffff/004157&text=Logo+600*400"></a>
	<hr />
	<div class="row" style="height: 40px"></div>
	<div class="row">
		<div class="col-sm-3 col-xs-2"></div>
		<div class="col-sm-6 col-xs-8">
		<p>기억나는 이메일을 입력해주세요</p>
			<form action="/findemail" method="post" name="findemail">
				<div class="form-group">
					<input type="email" class="form-control" id="exampleInputEmail1"
						placeholder="이메일 주소" name="email">
				</div>
				<button type="submit" class="btn btn-primary btn-block main-back">이메일 확인</button>
			</form>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>