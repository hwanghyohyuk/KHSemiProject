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
	<div class="row center-block">
		<!-- 좌측 파티션 -->
		<h2>나의 정보를 최신으로 유지해주세요.</h2>
		<div class="col-md-6 col-xs-12" style="display: table">
			<div
				style="display: table-cell; vertical-align: middle; height: 600px">
				<form class="form-horizontal" action="/studyhub/myinfoupdate"
					method="post" name="signupform">
					<div class="form-group">
						<label for="email" class="col-sm-4 col-xs-10 control-label">이메일</label>
						<div class="col-sm-8 col-xs-10">
							<input type="text" readonly class="form-control" id="email" value="<%=user.getEmail() %>"></input>
						</div>
					</div>
					<div class="form-group ">
						<label for="name" class="col-sm-4 col-xs-10 control-label">이름</label>
						<div class="col-sm-8 col-xs-10">
							<input type="text" readonly class="form-control" id="name" value="<%=user.getUserName() %>"></input>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-4 col-xs-10 control-label">연락처</label>
						<div class="col-sm-6 col-xs-8">
							<input type="tel" class="form-control" id="modifytel"
								name="phone" placeholder="연락처 '-' 없이" value='<%=user.getPhone() %>'
								oninput='myinfoCheckPhone()' onblur='myinfoCheckPhone()' onclick='myinfoCheckPhone()'>
						</div>
						<div class="col-sm-2 col-xs-2">
						<p id='modifyteltxt'></p>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-4 col-xs-10 control-label">비밀번호
							변경</label>
						<div class="col-sm-6 col-xs-8">
							<input type="password" class="form-control" id="modifypwd"
								name="modifypwd" placeholder="Modify Password" oninput='myinfoPwdInput()' onblur='myinfoPwdInput()' onclick='myinfoPwdInput()'>
						</div>
						<div class="col-sm-2 col-xs-2">
						<p id='modifypwdtxt'></p>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-4 col-xs-10 control-label">비밀번호
							확인</label>
						<div class="col-sm-6 col-xs-8">
							<input type="password" class="form-control" id="confirmpwd"
								name="confirmpwd" placeholder="Confirm Password" oninput='myinfoPwdConfirm()' onblur='myinfoPwdConfirm()' onclick='myinfoPwdConfirm()'>
						</div>
						<div class="col-sm-2 col-xs-2">
						<p id='confirmpwdtxt'></p>
						</div>
					</div>
					<hr>
					<button type="submit" class="btn btn-primary pull-right" id="modifybtn" disabled="disabled">정보
						수정</button>
				</form>
			</div>
		</div>
		<!-- 우측 파티션 -->
		<div class="col-md-6 col-xs-12" style="display: table;">
			<div
				style="display: table-cell; vertical-align: middle; height: 600px; width: 100%">
				<div
					style="border-left: 1px solid #e7e7e7; display: table; height: 500px; width: 100%">
					<div
						style="display: table-cell; vertical-align: middle; width: 100%"
						align="center">
						<p>나의 그룹</p>
						<br>
						<p>리스트</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<script type="text/javascript" src="/studyhub/js/signup.js"></script>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>