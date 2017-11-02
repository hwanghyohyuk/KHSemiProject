<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 시작 페이지
작성일자 17.10.02
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
<section class="container1">
	<div class="row">
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12" id="main-area">
			<div class="col-md-0 hidden-xs" style="height: 50px"></div>
			<!-- 텍스트 영역 -->
			<div
				class="col-md-10 col-lg-10 col-xs-12 col-md-offset-1 col-lg-offset-1">
				<h3 id="promo-text">함께 성장할 스터디를 찾고 소통하는 공간,</h3>
				<h3 id="promo-text2">스터디허브</h3>
			</div>

			<!-- 로그인 & 회원가입 요약영역 -->
			<div class="col-md-6 col-xs-12 col-md-offset-1 col-lg-offset-1"
				id="signup-area">
				<div class="form-group">
					<h3 id="signup-text">가입하고 바로 시작!</h3>
				</div>
				<!-- 페이스북 로그인 연동 -->
				<div class="form-group">
					<div class="form-group col-md-0 col-xs-0">
						<!-- <button type="button" class="btn btn-default btn-block"
							id="fb-btn">Facebook 으로 가입하기</button> -->

					</div>
					<div class="form-group col-md-4 col-xs-4">
						<!-- <hr /> -->
					</div>
					<!-- <div class="form-group col-md-4 col-xs-4" id="sep">또는</div> -->
					<div class="form-group col-md-4 col-xs-4">
						<hr />
					</div>
				</div>
				<form action="/studyhub/signup" method="post" name="signupcheckform">
					<div class="form-group">
						<input type="email" class="form-control" id="signupemail"
							placeholder="이메일 주소" name="signupemail"
							oninput='checkEmail("start")' onblur='checkEmail("start")'
							onclick='checkEmail("start")'>
					</div>
					<button type="submit" 
						id='signupbtn' disabled="disabled">가입하기</button>
				</form>
			</div>
			<!-- 공백 영역 -->
			<div class="col-md-12 col-lg-12 col-xs-12">
				<a href="#intro-2"><button class="btn btn-default btn-circle" id="menudown"><span class="glyphicon glyphicon-menu-down"></span></button></a>
			</div>
			
		</div>
	</div>
</section>


<!-- 서브 컨텐츠 -->
<section class="content-section-a" id="intro-2">
	<div class="container">
        <div class="row">
          <div class="col-lg-5 ml-auto">
            <hr class="section-heading-spacer">
            <div class="clearfix"></div>
            <h3 class="section-heading">스터디찾기:<br>나에게 맞는 스터디를 찾아보세요</h3>
            <p class="lead">StudyHub에서는 영어, 중국어, 제2외국어, 독서모임, 취업스터디, IT분야까지 다양한 스터디모임을 찾을 수 있습니다. 마음에 드는 모임이 없다면 직접 만들어보세요!</p>
          </div>
          <div class="col-lg-5 mr-auto">
            <img class="img-fluid" id="group1" src="images/group1.jpg" alt="">
          </div>
        </div>

      </div>
      <!-- /.container -->
    </section>

    <section class="content-section-b">

      <div class="container">

        <div class="row">
        <div class="col-lg-5 ml-auto order-lg-1">
            <img class="img-fluid" src="images/group2.jpg" alt="">
          </div>
          <div class="col-lg-5 mr-auto order-lg-2" id="b-text">
            <hr class="section-heading-spacer">
            <div class="clearfix"></div>
            <h3 class="section-heading">스터디 그룹끼리 소통하는<br>온라인 커뮤니티</h3>
            <p class="lead">공지사항, 모임일정공유, 자료공유, Q&A 기능이 있는 그룹 페이지에서 스터디 그룹원들과 온라인으로 소통하세요!</p>
          </div>
          
        </div>

      </div>
      <!-- /.container -->

    </section>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>




