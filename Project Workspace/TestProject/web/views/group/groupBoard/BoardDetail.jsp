<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 :조남훈
내용 : 그룹게시판 detail 페이지
작성일자 17.10.26
 -->
<!-- java 구문 -->
<%@ page
	import="com.studyhub.common.vo.GBoard ,java.sql.Date, java.util.*"%>
<!-- 초기화 블럭(변수선언 및 초기화) -->
<%
	GBoard gBoard = (GBoard) request.getAttribute("gBoard");
%>
<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" type="text/css"
	href="/studyhub/css/board_detail.css">
<link rel="stylesheet" href="/studyhub/css/detail.css">

<%@ include file="/views/include/common/headend.jsp"%>


<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<div class="row">
	<h2 id="heading">
		　　
	</h2>

<div id="inner"
	class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xm-8 col-xs-2">

	<hr id="first-line">
	<div class="head-text">
		<h3 id="title-text"><%=gBoard.getTitle()%></h3>
	</div>

<br>
<br>
<hr>
<label class="col-sm-3 control-label">내용</label>
<div class="col-sm-9">
	<%=(gBoard.getContent()).replaceAll("\n", "<br>")%>
</div>
</div>

<div class="form-group ">
	<div class="col-sm-12">
		<button class="btn btn-primary main-back pull-right"
			style="margin-top: 0.6vh; float: right">
			<a href="javascript:checkDelete(<%=gBoard.getgBoardNo()%>)">삭제</a>
		</button>
		<button class="btn btn-default btn-sm"
			style="margin-top: 0.6vh; float: right">
			<a href="/studyhub/gboardupdateview?no=<%=gBoard.getgBoardNo()%>">수정</a>
		</button>
		<button class="btn btn-default btn-sm"
			style="margin-top: 0.6vh; float: right">
			<a href="/studyhub/gboardpreview?groupno=<%=group.getGroupNo()%>"
				data-method="post">목록</a>
		</button>
	</div>
</div>
</form>
</div>
<div class="container">
	<div class="comment-list">
		Comment<br> <br>
		<!---댓글입력-->
		<input type="text" name="content" class="form-control"
					id="comment-write" placeholder="댓글을 달아주세요"> 
					<input type="hidden" name="gboardno" id="gboardno" value="<%=gBoard.getgBoardNo()%>"> 
					<input type="hidden" name="uploader" id="uploader" value="<%=user.getUserNo()%>">
				<button class="btn btn-info btn-sm" onclick="insert();">댓글달기</button>
				<script type="text/javascript">
	function checkDelete(groupno){
		if (confirm('해당 게시글을 삭제하시겠습니까?')) {
		    location.href="/studyhub/gboarddelete?groupno="+groupno;
		} 
	}
	
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
				var gnoticeno = $("#gboardno").val();
				
				var queryString = { "uploader": uploader, "gboardno": gboardno, "comment": comment};
				
				$.ajax({
					url: "/studyhub/gboardcommentinsert",
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
			var gnoticeno = "<%=gBoard.getgBoardNo()%>";
					$.ajax({
								url : "/studyhub/gboardcommentselect",
								data : {
									gboardno : gboardno
								},
								type : "get",
								datatype : "json",
								success : function(data) {

									var json = JSON.parse(JSON
											.stringify(data));
									var values = "";
									for ( var i in json.list) {
										values += "<div class='panel-footer'>"
												+ decodeURIComponent(json.list[i].comment)
												+ "<span> | "
												+ decodeURIComponent(json.list[i].username)
												+ "</span>"
												+ "<span> | "
												+ decodeURIComponent(json.list[i].uploaddate)
												+ "</span>"
												+ "<input type='hidden' value='"+ json.list[i].commentno +"' id='commentno'>"
												+ "<input type='button' id='comment-del-btn' name='comment-del-btn' class='btn btn-info btn-sm' value='삭제' onclick='deleteC();'></div>";

									}
									$("#comment-list").html(values);

								},
								error : function(xhr, status, error) {
									alert("error\nxhr: " + xhr
											+ ", status: " + status
											+ ", error: " + error);
								}
							});
				}

				function deleteC() {
					var commentno = $("#commentno").val();
					$.ajax({
						url : "/studyhub/gboardcommentdelete",
						data : {
							commentno : commentno
						},
						type : "get",
						dataType : "json",
					});
					alert("삭제되었습니다.");
					select();
				}
			</script>



	</div>
</div>
</div>


<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>