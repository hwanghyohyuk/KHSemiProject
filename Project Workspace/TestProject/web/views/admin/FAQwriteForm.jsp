<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.FAQ"%>
<!-- 
작성자 : 구미향
내용 : FAQ writeform 
작성일자 17.10.19
 -->

<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->


<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/write_form.css">
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<script>
function onTestChange() {
	var text = $("#textarea").val();
	text = text.replace(/\r?\n/g, '<br />');
	console.log("working");
}
</script>

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->

	<div class="row" id="layout">
		<div
			class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xm-6 col-xs-2" id="form-outline">
			<h2>새로운 FAQ 추가하기 </h2>
			<br>
			<form action="/studyhub/faqmanagementinsert" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="post_title" name="title"
						aria-describedby="emailHelp" placeholder="제목을 입력하세요">
				</div>
				
				<div class="tab-category">
					<label for="category">카테고리</label>
					<select name="categoryno">
					    <option value="1">회원가입</option>
					    <option value="2">스터디찾기</option>
					    <option value="3">그룹페이지</option>
					    <option value="4">파일공유</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="textarea" rows="15" onkeypress="onTestChange();"
						name="content" placeholder="내용을 입력하세요"></textarea>
				</div>

				<input type="submit" value="제출하기" class="btn btn-info" id="btns">
				<a href="/studyhub/noticeview">&nbsp; &nbsp;목록으로 이동</a> <input type="hidden"
					name="user_no" value="<%=user.getUserNo()%>">
			</form>
		</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>
</body>
</html>