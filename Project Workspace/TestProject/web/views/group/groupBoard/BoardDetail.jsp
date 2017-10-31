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
<%@ include file="/views/include/common/headend.jsp"%>


<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>


<div class="container">
	<div class="page-header">
		<h1>자유게시판</h1>
	</div>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-3 control-label">제목</label>
			<div class="col-sm-3">
				<p class="pull-left control-label"><%=gBoard.getTitle()%></p>
			</div>
			<br> <br>
			<hr>
			<label class="col-sm-3 control-label">내용</label>
			<div class="col-sm-9">
				<%=(gBoard.getContent()).replaceAll("\n", "<br>")%>
			</div>
		</div>

		<div class="form-group ">
			<div class="col-sm-12">
				<button class="btn btn-default btn-sm"
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
		<input type="text" name="content" class="form-control" width = "80%"
			id="comment-write" placeholder="댓글을 달아주세요">
		<input type="hidden" name ="gboardno" id ="gboardno" value="<%=gBoard.getgBoardNo() %>">
		<input type="hidden" name ="uploader" id ="uploader" value="<%=gBoard.getUploader() %>">
		<button class="btn btn-info btn-sm" onclick = "commentInsert()">댓글달기</button>
		<script type="text/javascript">
	function checkDelete(groupno){
		if (confirm('해당 게시글을 삭제하시겠습니까?')) {
		    location.href="/studyhub/gboarddelete?groupno="+groupno;
		} 
	}
	
		$(function(){
			select();
		});
	<%-- 		function insert(){
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
						url: "/studyhub/gbcommentinsert",
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
				var gboardno = "<%=gBoard.getgBoardNo()%>";

				$.ajax({
							url : "/studyhub/gbcommentselect",
							data : {
								gboardno : gboardno
							},
							type : "get",
							datatype : "json",
							success : function(data) {

								var json = JSON.parse(JSON.stringify(data));
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
								alert("error\nxhr: " + xhr + ", status: "
										+ status + ", error: " + error);
							}
						});
			}

			function deleteC() {
				var commentno = $("#commentno").val();
				$.ajax({
					url : "/studyhub/gbcommentdelete",
					data : {
						commentno : commentno
					},
					type : "get",
					dataType : "json",
				});
				alert("삭제되었습니다.");
				select();
			} --%>
			
			function commentconfirm(param){// param 으로 gboardno가 넘어옴
				var groupno = "<%= group.getGroupNo() %>";
				var userno = "<%= user.getUserNo() %>";
				$.ajax({
					url: "/studyhub/gboardcommentselect",
					data: { gboardno: param, groupno: groupno },
					type: "get",
					dataType: "json",
					success: function(data){
						var json = JSON.parse(JSON.stringify(data));
						var values = "";
						for(var i in json.list){
							if(userno == json.list[i].uploader){
								values += 
									"<li>" +
										"<div class='col-lg-1 col-md-1 col-sm-1' id='commentwriter'>" +
											decodeURIComponent(json.list[i].user_name).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-9 col-md-9 col-sm-9'>" +
											decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-2 col-md-2 col-sm-2'>" +
											decodeURIComponent(json.list[i].strdate) + "&nbsp;&nbsp;" +
											"<a onclick='commentDelete(" + json.list[i].comment_no + ", " + json.list[i].gboardno + ")'>" +
												"<span class='glyphicon glyphicon-remove'></span>" +
											"</a>" +
										"</div>" +
									"</li>";
							} else {
								values += 
									"<li>" +
										"<div class='col-lg-1 col-md-1 col-sm-1' id='commentwriter'>" +
											decodeURIComponent(json.list[i].user_name).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-9 col-md-9 col-sm-9'>" +
											decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-2 col-md-2 col-sm-2'>" +
											decodeURIComponent(json.list[i].strdate) + "&nbsp;&nbsp;" +
										"</div>" +
									"</li>";
							}
						}
						$("#commentbody"+param).html(values);
					}
				});
			}
			
			function commentInsert(param){
				var gboardno = param;
				var content = $("#commenttitle"+param).val();
				var uploader = "<%= gBoard.getUploader() %>";
				$.ajax({
					url: "/studyhub/gboardcommentinsert",
					data: { gboardno: gboardno, uploader: uploader, content: content },
					type: "get",
					dataType: "json",
					async: false
				});
				$("#commenttitle"+param).val("");
				alert("등록되었습니다.");
				commentconfirm(gboardno);
			}
			
			function commentDelete(param, param2){
				var commentno = param;
				var gboardno = param2;
				$.ajax({
					url: "/studyhub/gboardcommentdelete",
					data: { commentno: commentno },
					type: "get",
					dataType: "json",
					async: false
				})
				alert("삭제되었습니다.");
				commentconfirm(gboardno);
			}
		</script>

	</div>
</div>
</div>


<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/tail.jsp"%>