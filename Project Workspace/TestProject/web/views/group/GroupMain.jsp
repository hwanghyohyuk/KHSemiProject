<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹메인 페이지
작성일자 17.10.16
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>
<!-- 메인 컨텐츠 -->

<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
	<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<h2 id="groupinfo"><%= group.getGroupName() %> <small>Secondary text</small></h2>
	</div>
</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<%@ include file="/views/include/common/headend.jsp"%>
<script type="text/javascript">
	$(function(){
		var groupno = "<%= group.getGroupNo() %>";
		var reset = "1";
		$.ajax({
			url: "studyhub/gmainpreview",
			data: { groupno: groupno, reset: reset },
			type: "get",
		});
	});
</script>