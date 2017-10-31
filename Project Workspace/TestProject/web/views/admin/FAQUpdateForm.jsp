<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.FAQ"%>
<!-- 
작성자 : 구미향
내용 : FAQ update form 
작성일자 17.10.31
 -->

<!-- java 구문 -->
<% FAQ faq = (FAQ)request.getAttribute("faq"); %>
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
			<h2>FAQ항목 수정 </h2>
			<br>
			<form action="/studyhub/faqmanagementupdate" method="post">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="post_title" name="title"
						aria-describedby="emailHelp" value="<%=faq.getTitle()%>">
				</div>
				
				<div class="tab-category">
					<label for="category">카테고리</label>
					<select name="categoryno">
					    <option value="1">회원가입</option>
					    
					    <% if(faq.getFaqCategoryNo()==2){ %>
					    <option value="2" selected>스터디찾기</option>
					    <% }else{ %>
					    <option value="2">스터디찾기</option>
					    <% } %>
					    
					    <% if(faq.getFaqCategoryNo()==3){ %>
					    <option value="3" selected>그룹페이지</option>
					    <% }else{ %>
					    <option value="3">그룹페이지</option>
					    <% } %>
					    
					    <% if(faq.getFaqCategoryNo()==4){ %>
					    <option value="4" selected>파일공유</option>
					    <% }else{ %>
					    <option value="4">파일공유</option>
					    <% } %>
					</select>
				</div>
				
				<div class="form-group">
					<label for="Content">내용</label>
					<textarea class="form-control" id="textarea" rows="15" onkeypress="onTestChange();"
						name="content"><%=faq.getContent() %></textarea>
				</div>
				<input type="hidden" name="faqno" value="<%=faq.getFaqNo() %>">

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