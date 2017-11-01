<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.studyhub.common.vo.FAQ" %>
<!-- 
작성자 : 구미향
내용 : FAQ 메인 페이지(메인에서 도움말 클릭했을 때의 화면)
작성일자 17.10.17
 -->

<!-- java 구문 -->
<% ArrayList<FAQ> flist = (ArrayList<FAQ>)request.getAttribute("list");%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">

<script type="text/javascript">
	function toQnA(){
		location.href="/studyhub/qnalist";
	}
	function editFAQ(faqno){
		location.href="/studyhub/faqmanagementupdateview?no="+faqno;
	}
	function deleteFAQ(faqno, cno){
		var r = confirm("정말 삭제하시겠습니까?");
		if(r==true){
			location.href="/studyhub/faqmanagementdelete?faqno="+faqno+"&cno="+cno;
		}
	}
	
</script>
<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<!-- 메인 컨텐츠 -->
	
	<div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3" id="faqwrapper">
		<h2 id="main-text"><%=flist.get(0).getFaqCategoryName() %></h2>
		
		<% for(FAQ f : flist){ %>
		<hr>
		<span><%=f.getTitle() %></span> 
		
		<% if(user.getUserNo()==1){ %>
		
		<a class="edit" onclick="editFAQ(<%= f.getFaqNo()%>);"><span class="glyphicon glyphicon-pencil"></span></a>
		<a class="delete" onclick="deleteFAQ(<%= f.getFaqNo()%>, <%=f.getFaqCategoryNo()%>);"><span class="glyphicon glyphicon-remove"></span></a>
		
		<% } %>
		
		<a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse<%=f.getFaqNo() %>" aria-expanded="false"
			aria-controls="collapseExample"> 
			<span class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse<%=f.getFaqNo() %>">
			<div class="well"><%=f.getContent() %></div>
		</div>
		<% } %>
		<hr>
		<!-- <hr>
		<span>아이디를 해킹당한 것 같아요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse3" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse3">
			<div class="well">답변을 채워야 합니다 :)</div>
		</div>
		<hr>
		<span>비밀번호를 잊어버렸어요</span> <a class="btn btn-default btn-sm" id="btns"
			data-toggle="collapse" href="#collapse4" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-chevron-down"></span></a>
		<div class="collapse" id="collapse4">
			<div class="well">답변을 채워야 합니다 :)</div>
		</div>
		<hr> -->
		

		<span id="move"><b>질문이 해결되지 않는다면? → </b></span>
		<button onclick="toQnA();" class="btn btn-info" id="btns">질문게시판으로 이동</button>
		<hr>
		
		<p><a href="/studyhub/noticeview">FAQ메인으로 가기</a></p>

	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp" %>