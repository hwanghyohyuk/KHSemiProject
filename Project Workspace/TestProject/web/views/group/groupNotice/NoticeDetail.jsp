<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹 공지 상세보기 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->
<%@ page import="com.studyhub.common.vo.GNotice, java.util.*"%>

<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	GNotice gNotice = (GNotice) request.getAttribute("gNotice");
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>
<!-- 메인 컨텐츠 -->

<!--- 글쓴거 보이는 화면  -->
<div class="container">
	<div class="page-header">
		<h1>공지사항 <small>글 읽기</small></h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-3 control-label">제목</label>
			<div class="col-sm-3">
				<p class = "pull-left control-label"><%=gNotice.getTitle()%></p>
			</div>
			<label class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-3">
			 	<p class = "pull-left control-label"><%=gNotice.getUploader_name()%></p>
			</div>
			<label class="col-sm-3 control-label">내용</label>
			<div class="col-sm-9">
				<%=(gNotice.getContent()).replaceAll("\n", "<br>") %>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<%
					if(user.getUserNo() == gNotice.getUploader()){
				%>
				<a class="btn btn-primary main-back pull-right"
				href="javascript:checkDelete(<%=gNotice.getNoticeNo()%>)">삭제</a>
				<script type="text/javascript">
				function checkDelete(groupno){
					if (confirm('해당 게시글을 삭제하시겠습니까?')) {
					    location.href="/studyhub/gnoticedelete?groupno="+groupno;
					} 
				}
				</script>
				<a href="/studyhub/gnoticeupdateview?no=<%=gNotice.getNoticeNo() %>"
					class="btn btn-primary main-back pull-right">수정</a>	
				<%
					}
				%>
				<a	href="/studyhub/gnoticepreview?groupno=<%=group.getGroupNo()%>"
					class="btn btn-default pull-right">목록</a>
			</div>
		</div>
	</form>
	
<div class="comment-list">
	Comment<br> <br>
	<!---댓글입력-->
		<input type="text" name="content" class="form-control" width = "80%"
			id="comment-write" placeholder="댓글을 달아주세요">
		<input type="hidden" name ="gnoticeno" id ="gnoticeno" value="<%=gNotice.getNoticeNo() %>">
		<input type="hidden" name ="uploader" id ="uploader" value="<%=gNotice.getUploader() %>">
		<button class="btn btn-info btn-sm" onclick = "insert();">댓글달기</button>
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
					var uploader = $("#uploader").val();
					var gnoticeno = $("#gnoticeno").val();
					
					var queryString = { "uploader": uploader, "gnoticeno": gnoticeno, "comment": comment};
					
					$.ajax({
						url: "/studyhub/gnoticecommentinsert",
						data: queryString,
						type: "get",
						dataType: "json"
					});
					$("#comment-write").val("");
					select();
					return true;
				}
			}	
			
			function select(){
				var gnoticeno = "<%= gNotice.getNoticeNo() %>";
				$.ajax({
					url: "/studyhub/gnoticecommentselect",
					data: { gnoticeno: gnoticeno },
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
					url: "/studyhub/gnoticecommentdelete",
					data: { commentno: commentno },
					type: "get",
					dataType: "json",
				});
				alert("삭제되었습니다.");
				select();	
			} 
		
		
		</script>

</div>
</div>



	<!---댓글보여지는부분--->
	
			<!-- <div class="panel-footer">
				Comments:
				
					<a href="#" data-method="post" data-confirm="댓글을 삭제하시겠습니까?"><button><span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></a>
				
			</div> -->
			
		
	
<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>