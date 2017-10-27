<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 황효혁
내용 : 모집게시판 글쓰기 페이지
작성일자 17.10.27
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--자바스크립트 및 CSS-->

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<!-- 메인 컨텐츠 -->
<div class="container">
	<div class="page-header">
		<h1>
			모집게시판 <small>글쓰기</small>
		</h1>
	</div>

	<form class="form-horizontal" action="/studyhub/boardinsert"
		method="post">
		<div class="form-group">
			<label for="btitle" class="col-sm-2 control-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="제목"
					name="btitle" id="btitle">
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="groupname" class="col-sm-2 control-label">모집 그룹</label>
			<div class="col-sm-4">
			<%if(user!=null){ %>			
				<select class="form-control" id="bglist" name="bglist">
					<!--ajax -->
				</select>
				
				<script type="text/javascript">
						$(function(){
							var userno = "<%= user.getUserNo()%>";
							$.ajax({
								url : "/studyhub/bgrouplist",
								data : {
									userno : userno
								},
								type : "get",
								datatype : "json",
								success : function(data) {
									var json = JSON.parse(JSON.stringify(data));
									var values = "";
									for ( var i in json.list) {
										values += "<option value="+json.list[i].group_no+">"
												+ decodeURIComponent(json.list[i].group_name)
												+ "</option>";
										}
									$("#bglist").html(values);
								}
							});
						});
					</script>
				<%}%> 
			</div>
			<label for="deadline" class="col-sm-2 control-label">마감 날짜</label>
			<div class="col-sm-4">
				<input type="date" name="deadline" id="deadline">
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="bwriter" class="col-sm-2 control-label">작성자</label>
			<div class="col-sm-10">
				<input type="hidden" class="form-control" name="bwriterno"
					id="bwriterno" value="<%=user.getUserNo()%>"> <input
					type="text" readonly class="form-control" name="bwriter"
					id="bwriter" value="<%=user.getUserName()%>">
			</div>
		</div>
		<hr>
		<div class="form-group">
			<label for="bcontent" class="col-sm-2 control-label">내용</label>
			<div class="col-sm-10">
				<textarea class="form-control" rows="10" name="bcontent"
					id="bcontent" placeholder="내용"></textarea>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary main-back pull-right">등록</button>
			</div>
		</div>
	</form>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>