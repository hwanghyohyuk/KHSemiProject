<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.QnA"%>
<!-- 
작성자 : 구미향
내용 : QnA질문게시판 페이지
작성일자 17.10.18
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub::QnA</title>

<!-- java 구문 -->
<%
	QnA qna = (QnA) request.getAttribute("qna");
%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" type="text/css"
	href="/studyhub/css/board_detail.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">
<link rel="stylesheet" href="/studyhub/css/detail.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>

</head>
<body>

	<!--- 글쓴거 보이는 화면  -->
	<div class="row">
	<h2 id="heading">QnA</h2>
		<div id="inner"
			class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xm-8 col-xs-2">
			
			<hr id="first-line">
			<div class="head-text">
				<h3 id="title-text"><%=qna.getTitle()%></h3>
				<div id="attr-text">
				<span>조회수 <%=qna.getReadCount() %> |</span>
				<span>작성날짜 <%=qna.getUploadDate() %> |</span>
				<span>작성자 <%=qna.getWriter() %></span>
				</div>
			</div>
			<hr id="second-line">

			<div class="panel-body" id="content"><%=qna.getContent()%></div>
			<!---댓글입력-->
			
				<input type="text" name="content" class="form-control"
					id="comment-write" placeholder="댓글을 달아주세요">
				<input type="hidden" name="qnano" id="qnano" value="<%= qna.getQnaNo()  %>">
				<input type="hidden" name="userno" id="userno" value="<%= user.getUserNo() %>">
				<!--<span class ="input-group-btn">-->
				<button class="btn btn-info btn-sm" onclick="insert();">댓글달기</button>
				<script type="text/javascript">
				
				$(function(){
					select();
				});
					function insert(){
						console.log("is it working");
						if($("#comment-write").val() ==""){
							alert("댓글을 입력하세요");
							focus("#comment-write");
							return false;
						}else{
							var comment = $("#comment-write").val();
							var userno = $("#userno").val();
							var qnano = $("#qnano").val();
							
							var queryString = { "userno": userno, "qnano": qnano, "comment": comment};
							
							$.ajax({
								url: "/studyhub/qnacommentinsert",
								data: queryString,
								type: "get",
								dataType: "json"
							});
							$("#comment-write").val("");
							select();
							return true
						}
					}	
					
					function select(){
						var qnano = "<%= qna.getQnaNo() %>";
						$.ajax({
							url: "/studyhub/qnacommentselect",
							data: { qnano: qnano },
							type: "get",
							datatype: "json",
							success: function(data){
								
								var json = JSON.parse(JSON.stringify(data));
								var values = "";
								for(var i in json.list){
									values +=
										"<div class='panel-footer'>"+
										decodeURIComponent(json.list[i].comment)+
										"<span> | "+ decodeURIComponent(json.list[i].username)+ "</span>"+
										"<span> | "+ decodeURIComponent(json.list[i].uploaddate)+ "</span>"+
										"<input type='hidden' value='"+ json.list[i].commentno +"' id='commentno'>"+
										"<input type='button' id='comment-del-btn' name='comment-del-btn' class='btn btn-info btn-sm' value='삭제' onclick='deleteC();'></div>"									;
									
								}
								$("#comment-list").html(values);
								
								
							},
							error: function(xhr,status,error){
								alert("error\nxhr: " + xhr + ", status: " + status+ ", error: " + error);
							}
						});
					}	
					
					function deleteC(){
						var commentno = $("#commentno").val();
						$.ajax({
							url: "/studyhub/qnacommentdelete",
							data: { commentno: commentno },
							type: "get",
							dataType: "json",
						});
						alert("삭제되었습니다.");
						select();	
					} 
				
				</script>	

			<!---댓글보여지는부분--->
			<div id="comment-list">
			<!-- <div class="panel-footer">
				Comments:
				
					<a href="#" data-method="post" data-confirm="댓글을 삭제하시겠습니까?"><button><span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></a>
				
			</div> -->
			</div> 
			
			<a href="/studyhub/qnalist">목록으로 이동</a> <a
				href="/studyhub/qnadelete?no=<%=qna.getQnaNo()%>" data-method="post"
				data-confirm="진짜로삭제할거에요?"><button
					class="btn btn-default btn-sm" id="btns">삭제</button></a> <a
				href="/studyhub/qnaupdateview?no=<%=qna.getQnaNo()%>">
				<button class="btn btn-default btn-sm" id="btns">수정</button>
			</a>

		</div>
	</div>

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>