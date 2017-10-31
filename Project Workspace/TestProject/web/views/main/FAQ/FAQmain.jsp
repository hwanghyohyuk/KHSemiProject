<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		String notice = (String)request.getAttribute("notice");
	%>
<!-- 
작성자 : 구미향
내용 : FAQ 메인 페이지(메인에서 도움말 클릭했을 때의 화면)
작성일자 17.10.17
 -->
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/FAQ.css">

<script type="text/javascript">
	function insertFAQ(){
		location.href="/studyhub/views/admin/FAQwriteForm.jsp";
	}
</script>

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
	<div class="notice">
		<p id="notice-text">[공지] <%= notice %></p>
	</div>
	
	<% if(user!=null){
		if(user.getUserNo()==1){	
	%>
	<div class="head-text">
	<h1 id="head-text">[관리자모드]</h1>
	</div>
	
	<div class="service">
	<div class="col-md-6 col-md-offset-3">
	<h4><button onclick="insertFAQ();" class="btn btn-info">FAQ추가하기</button></h4>
	<%  }else{ %>
		<div class="head-text">
		<h1 id="head-text">무엇이 궁금하신가요?</h1>
		</div>
		<div class="service">
		<div class="col-md-6 col-md-offset-3">
		<h2 id="service-text">필요하신 서비스를 선택해주세요.</h2>
	<%   }}else{ %>
		<div class="head-text">
		<h1 id="head-text">무엇이 궁금하신가요?</h1>
		</div>
		<div class="service">
		<div class="col-md-6 col-md-offset-3">
		<h2 id="service-text">필요하신 서비스를 선택해주세요.</h2>
	<% } %>
	<div class="col-md-6 col-lg-6 col-md-offset-3">
				<div id="services">
					<ul class="services">
						<li class="service"><a href="/studyhub/faqmanagementlist?categoryno=1"><img id="img"
								src="/studyhub/images/member.png"></a>
							<p id="service">회원가입</p></li>
						<li class="service"><a href="/studyhub/faqmanagementlist?categoryno=2"><img id="img"
								src="/studyhub/images/studysearch.png"></a>
							<p id="service">스터디찾기</p></li>
						<li class="service"><a href="/studyhub/faqmanagementlist?categoryno=3"><img id="img"
								src="/studyhub/images/group.png"></a>
							<p id="service">그룹페이지</p></li>
						<li class="service"><a href="/studyhub/faqmanagementlist?categoryno=4"><img id="img"
								src="/studyhub/images/fileshare.png"></a>
							<p id="service">파일공유</p></li>
					</ul>
				</div>
			</div>
	
	</div>
	</div>
	
	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>

</body>
</html>