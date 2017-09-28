<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StudyHub</title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/font.css">
</head>
<body>
	<!-- 네비게이션 바 -->
	<nav class="navbar navbar-default bg-white">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">StudyHub</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#"> <span
							class="glyphicon glyphicon-search main" aria-hidden="true"></span><span
							class="black">스터디찾기</span></a></li>
					<li><a href="#"><p class="black">그룹찾기</p></a></li>
					<li><a href="#"><p class="black">도움말</p></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><p class="black">회원가입</p></a></li>
					<li><a href="#"><p class="black">로그인</p></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- 메인 컨텐츠 -->
	<div class="container">
		<!-- 이미지 영역 -->
		<div class="col-md-6 col-xs-12">
			<!-- 공백 영역 -->
			<div class="col-md-0 col-xs-0" style="height: 40px"></div>
			<img alt=""
				src="https://dummyimage.com/540x540/3d6280/9da0cc.jpg&text=image+540x540"
				style="width: 100%">
			<!-- 공백 영역 -->
			<div class="col-md-0 col-xs-0" style="height: 40px"></div>
		</div>
		<!-- 공백 영역 -->
		<div class="col-md-6 col-xs-12">
			<div class="col-md-0 col-xs-0" style="height: 100px"></div>
			<!-- 공백 영역 -->
			<div class="col-md-1 col-xs-1" style="height: 40px"></div>

			<!-- 로그인 & 회원가입 요약영역 -->
			<div class="col-md-10 col-xs-10" style="display: table">
				<div
					style="display: table-cell; vertical-align: middle; height: 100%">
					<div class="form-group" style="height: 40px">
						<h3>가입하고 바로 시작!</h3>
					</div>
					<!-- 페이스북 로그인 연동 -->
					<div class="form-group">
						<div class="form-group col-md-0 col-xs-0">
							<button type="button" class="btn btn-default btn-block"
								style="border: 1px solid #337AB7; color: #337AB7;">Facebook
								으로 가입하기</button>
						</div>
						<div class="form-group col-md-5 col-xs-5">
							<hr />
						</div>
						<div class="form-group col-md-2 col-xs-2"
							style="line-height: 40px; text-align: center">또는</div>
						<div class="form-group col-md-5 col-xs-5">
							<hr />
						</div>
					</div>
					<form>
						<div class="form-group">
							<input type="email" class="form-control" id="exampleInputEmail1"
								placeholder="이메일 주소">
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								id="exampleInputPassword1" placeholder="암호">
						</div>
						<button type="submit" class="btn btn-primary btn-block">가입하기</button>
					</form>
				</div>
			</div>
			<div class="col-md-1 col-xs-1" style="height: 40px"></div>
			<!-- 공백 영역 -->
			<div class="col-md-12 col-xs-12" style="height: 100px"></div>
		</div>
	</div>


	<!-- 서브 컨텐츠 -->
	<div class="container">
		<div class="col-md-6 col-xs-12">
			<div class="col-md-0 col-xs-0" style="height: 40px"></div>
			<img alt=""
				src="https://dummyimage.com/540x540/3d6280/9da0cc.jpg&text=image+540x540"
				style="width: 100%">
			<div class="col-md-0 col-xs-0" style="height: 40px"></div>
		</div>
		<div class="col-md-6 col-xs-12">
			<div class="col-md-0 col-xs-0" style="height: 80px"></div>
			<!-- 공백 영역 -->
			<div class="col-md-2 col-xs-2" style="height: 40px"></div>
		<!-- 컨텐츠 영역 -->
		<div class="col-md-8 col-xs-8" style="display: table">
			<div
				style="display: table-cell; vertical-align: middle; text-align: center; height: 100%">
				<div class="col-md-12 col-xs-12">
					<p style="font-size: 40pt">나에게 맞는 스터디 찾기</p>
				</div>
				<div class="col-md-12 col-xs-12">
					<img alt=""
						src="https://dummyimage.com/350x350/000/fff.jpg&text=Description"
						style="width: 100%">
				</div>
			</div>
		</div>
		<!-- 공백 영역 -->
		<div class="col-md-2 col-xs-2" style="height: 40px"></div>
		<!-- 공백 영역 -->
		<div class="col-md-12 col-xs-12" style="height: 20px"></div>
		</div>
	</div>



	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>