<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<style type="text/css">
	#write {
		width: 100%;
		height: 140px;
	}
	
	#content {
		/* height: 150px; */
	}
</style>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>
<!-- 메인 컨텐츠 -->

<div class="row">
	<div class="col-md-7 col-sm-7 col-sm-offset-1 col-md-offset-1">		
		<div class="btn btn-default btn-sm" id="write">
			<form onsubmit="qnawrite">
				<div class="col-xs-10 col-md-11 col-sm-10">
	                    <input type="text" class="form-control" aria-describedby="sizing-addon1" placeholder="질문할 제목을 입력하세요." id="content">
				</div>
				<div class="col-xs-2 col-md-1 col-sm-2">
					<input type="submit" class="btn btn-primary" value="등록">
				</div>
				<div class="col-xs-10 col-md-11 col-sm-10">
	                    <textarea rows="4" size="40" value="" class="form-control" placeholder="<%= user.getUserName() %>님 무엇이 궁금하세요?"></textarea>
				</div>
				
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	function qnawrite(){
		var group_no = "<%= group.getGroupNo() %>";
		var user_no = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/insertqna",
			data: { groupno: group_no, userno: user_no, title: title, content: content, },
			type: "get",
			dataType: "json",
			success: function(data){
				selectQnA();
			}
		});
	}
	
	function selectQnA(){
		var group_no = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/selectqna",
			data: { groupno: group_no },
			type: "get",
			datatype: "json",
			success: function(data){
				/* 셀렉문이어붙일 태그틀 만들기 */	
			}
		});
	}
</script>
<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
