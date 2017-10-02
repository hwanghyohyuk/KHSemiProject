	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 헤더 영역 : 네비게이션 바 -->
	<nav class="navbar navbar-default bg-white">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- 메인 로고 부분 -->
				<a class="navbar-brand" href="/studyhub/">StudyHub</a>
				<!-- / -->
			</div>
			<!-- 메뉴 부분 -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#"> <span
							class="glyphicon glyphicon-search main" aria-hidden="true"></span><span
							class="black">스터디찾기</span></a></li>
					<li><a href="/studyhub/views/main/MakeGroup.jsp"><p class="black">그룹만들기</p></a></li>
					<li><a href="/studyhub/views/main/FAQ/FAQmain.jsp"><p class="black">도움말</p></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/studyhub/views/member/SignUp.jsp"><p class="black">회원가입</p></a></li>
					<li><a href="/studyhub/views/member/Login.jsp"><p class="black">로그인</p></a></li>
				</ul>
			</div>
		</div>
	</nav>