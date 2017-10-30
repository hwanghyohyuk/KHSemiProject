<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 이메일 찾기 페이지
작성일자 17.10.05
 -->
<!-- java 구문 -->
<% String email = String.valueOf(request.getAttribute("userEmail")); %>
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
			<p>사용자 이름을 입력해주세요</p>
			<form action="/studyhub/findnameprocess" method="post" name="findname">
				<div class="form-group">
					<input type="hidden" id="email" name="email" value="<%=email%>">
					<input type="text" class="form-control" id="name"
						placeholder="사용자 이름" name="name" oninput='emptyCheck()'>
				</div>
				<a href="/studyhub/login" class="btn btn-default pull-left">이전화면</a>
				<button type="submit" class="btn btn-primary pull-right main-back" id=findnamebtn disabled="disabled">사용자 이름 확인</button>
			</form>
		</div>
		<div class="col-sm-3 col-xs-2"></div>
	</div>
</div>
<!-- /메인 컨텐츠 -->

<script type="text/javascript">
function emptyCheck() {
	var name = $("#name").val();
	if(name==""){
		$("#findnamebtn").prop("disabled", true);
	}else{
		$("#findnamebtn").prop("disabled", false);
	}
}
</script>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>