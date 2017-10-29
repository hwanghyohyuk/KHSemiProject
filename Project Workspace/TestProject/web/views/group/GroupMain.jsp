<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹메인 페이지
작성일자 17.10.16
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<!-- css, javascript -->

<%@ include file="/views/include/common/head.jsp"%>
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">

<style type="text/css">
	#edge {
		padding-left: 0px;
		padding-right: 0px;
	}
	
	#left {
		margin-bottom: 0px;
		height: 300px;
	}
	
	#right {
		margin-bottom: 0px;
		height: 200px;
	}
	
	#more {
		padding-left: 0px;
	}
	
	#leftlist {
		padding-left: 0px;
		padding-right: 0px;
		margin-top: 15px;
	}
	
	#rightlist {
		padding-left: 0px;
		padding-right: 0px;
		margin-top: 15px;
		height: 130px;
	}
	
	#usermanage, #userinfo {
		text-align: right;
	}
	
	#removegroup, #groupout {
		text-align: right;
		margin-top: 20px;
	}
	
	.list-group-item {
		padding-top: 10px;
		padding-bottom: 10px;
		padding-left: 5px;
		height: 40px;
	}
</style>

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>

<!-- 메인 컨텐츠 -->
<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
	<div class="col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-1 col-sm-9 col-xs-9">
		<h3><%= group.getGroupName() %>
			&nbsp;&nbsp;&nbsp; 
			<% if( group.getAuthorityNo() == 2 && group.getGroupState() == 2){ %>
				<a href="#" onclick='return removecancel()'>그룹해제 취소</a>
			<% } %>
			<div id="groupinfo">
			<!-- ajax로 불러옴 -->
			</div>
		</h3>
	</div>
	
	<% if(group.getAuthorityNo() == 2){ %>
	<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3' id='usermanage'>
		<a href="#" onclick='return usermanage()'>
			<span class='glyphicon glyphicon-user'> 회원관리</span>
		</a>
	</div>
	<% } else { %>
	<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3' id='userinfo'>
		<a href="#" onclick='return userinfo()'>
			<span class='glyphicon glyphicon-user'> 회원정보</span>
		</a>
	</div> 
	<% } %>
	
	<div class='col-lg-6 col-md-6 col-sm-12 col-xs-12' id='edge'>
		<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='edge'>
			<div class="well well-lg" id='left'> 
				<div class='col-lg-10 col-md-8 col-sm-8 col-xs-6'>
					공지사항		
				</div>
				<div class='col-lg-2 col-md-4 col-sm-4 col-xs-6' id='more'>
					<a href="/studyhub/gnoticepreview?groupno=<%=group.getGroupNo() %>">
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='leftlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='notice1'>
						</li>
						<li class='list-group-item' id='notice2'>
						</li>
						<li class='list-group-item' id='notice3'>
						</li>
						<li class='list-group-item' id='notice4'>
						</li>
						<li class='list-group-item' id='notice5'>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='edge'>
			<div class="well well-lg" id='left'>
				<div class='col-lg-10 col-md-8 col-sm-8 col-xs-6'>
					스터디일정					
				</div>
				<div class='col-lg-2 col-md-4 col-sm-4 col-xs-6' id='more'>
					<a href="/studyhub/schedulepreview?group_no=<%= group.getGroupNo() %>">
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='leftlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='schedule1'>
						</li>
						<li class='list-group-item' id='schedule2'>
						</li>
						<li class='list-group-item' id='schedule3'>
						</li>
						<li class='list-group-item' id='schedule4'>
						</li>
						<li class='list-group-item' id='schedule5'>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class='col-lg-6 coml-md-6 col-sm-12 col-xs-12' id='edge'>
		<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='edge'>
			<div class="well well-lg" id='right'>
				<div class='col-lg-10 col-md-8 col-sm-8 col-xs-6'>
					자유게시판					
				</div>
				<div class='col-lg-2 col-md-4 col-sm-4 col-xs-6' id='more'>
					<a href="/studyhub/gboardpreview?groupno=<%= group.getGroupNo() %>">
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='board1'></li>
						<li class='list-group-item' id='board2'></li>
						<li class='list-group-item' id='board3'></li>
					</ul>
				</div>
			</div>
		</div>
		<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='edge'>
			<div class="well well-lg" id='right'>
				<div class='col-lg-10 col-md-8 col-sm-8 col-xs-6'>
					파일 공유					
				</div>
				<div class='col-lg-2 col-md-4 col-sm-4 col-xs-6' id='more'>
					<a href="/studyhub/sharedfilepreview?groupno=<%= group.getGroupNo() %>">
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='sharefile1'></li>
						<li class='list-group-item' id='sharefile2'></li>
						<li class='list-group-item' id='sharefile3'></li>
					</ul>
				</div>
			</div>
		</div>	
		<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='edge'>
			<div class="well well-lg" id='right'>
				<div class='col-lg-10 col-md-8 col-sm-8 col-xs-6'>
					QnA				
				</div>
				<div class='col-lg-2 col-md-4 col-sm-4 col-xs-6' id='more'>
					<a href="/studyhub/gqnapreview">
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='qna1'>
							
						</li>
						<li class='list-group-item' id='qna2'>
						
						</li>
						<li class='list-group-item' id='qna3'>
						
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<% if(group.getAuthorityNo() == 2){ %>
	<div id="removegroup" class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>
		<a href="#" onclick="return removegroup()">
			<span class="glyphicon glyphicon-remove">
			</span>
			&nbsp;그룹 해제
		</a>
	</div>
	<% } else { %>
	<div id="groupout" class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>
		<a href="#" onclick="return groupout()">
			<span class="glyphicon glyphicon-remove">
			</span>
			&nbsp;그룹 탈퇴
		</a>
	</div>
	<% } %>
</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<script type="text/javascript">
	$(function(){
		authorityconfirm();
		groupinfo();
		schedule();
		notice();
		board();
		sharefile();
		QnA()
	});
	
	function authorityconfirm(){
		var authorityno = "<%= group.getAuthorityNo() %>";
		if(authorityno == 2 ){
			$("#userinfo").hide();
			$("#usermanage").show();
		} else {
			$("#userinfo").show();
			$("#usermanage").hide();
		}
	}
	
	function groupinfo(){
		var groupno = "<%= group.getGroupNo() %>";
		var reset = "1";
		var user_no = "<%= navuser.getUserNo() %>";
		
		var querystring = { "group_no": groupno, "reset": reset, "user_no": user_no };
		$.ajax({
			url: "/studyhub/gmainpreview",
			data: querystring,
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data))
				var values = "";
				if(json.group_no > 0){
					values += 
						"<small>" +
							"그룹장 : " + decodeURIComponent(json.user_name) + 
							" / 그룹원 : " + json.membercount +
							" 명 / 스터디 분야 : " + decodeURIComponent(json.category_name) +
							" / 스터디 지역 : " + decodeURIComponent(json.location) +
							" / 스터디 형식 : " + decodeURIComponent(json.attribute_name) +
						"</small>";
				}
				$("#groupinfo").html(values);
			},
			error: function(){
				alert("에러");
			}
		});
	}
	
	function usermanage(){
		alert("회원관리 준비중");
		return false;
	}
	
	function userinfo(){
		alert("회원정보 준비중");
		return false;
	}
	
	// 그룹해제
	function removegroup(){
		var userno = "<%= user.getUserNo() %>";
		var groupno = "<%= group.getGroupNo() %>";
		var authorityno = "<%= group.getAuthorityNo() %>";
		if(confirm("정말 그룹을 해제하실껀가요?")){
			if(confirm("그룹 해제시 모든 데이터는 삭제됩니다.\n그래도 해제하실껀가요?")){
				var random = Math.floor(Math.random() * 9000) + 1000;
				var inputval = prompt("다음 번호를 정확히 입력하세요.\n번호 : " + random, "번호를 입력하세요.");
				if(random == inputval){
					$.ajax({
						url: "/studyhub/groupout",
						data: { userno: userno, groupno: groupno, authorityno: authorityno },
						type: "get",
						dataType: "json",
						async: false
					});
					location.href="/studyhub/main";
					alert("그룹 해제는 일주일후에 이루어집니다.\n일주일이 되기전 언제든지 그룹해제취소가 가능합니다.");
					return false;
				} else {
					alert("번호가 일치하지 않습니다.\n그룹해제 실패!");
					return false;
				}
			} else {
				alert("그룹해제를 취소하였습니다.");
				return false;
			}
		} else {
			alert("그룹해제를 취소하였습니다.");
			return false;
		}
	}
	
	// 그룹해제 취소
	function removecancel(){
		var groupno = "<%= group.getGroupNo() %>";
		var userno = "<%= user.getUserNo() %>";
		if(confirm("그룹 해제를 취소하실건가요?")){
			var random = Math.floor(Math.random() * 9000) + 1000;
			var inputval = prompt("다음 번호를 정확히 입력하세요.\n번호 : " + random, "번호를 입력하세요.");
			if(random == inputval){
				$.ajax({
					url: "/studyhub/groupremovecancel",
					data: { groupno: groupno },
					type: "get",
					dataType: "json",
					async: false
				})
				alert("그룹 해제가 취소되었습니다.")
				location.href="/studyhub/main";
				return false
			} else {
				alert("번호가 일치하지 않습니다.\n그룹해제취소 실패!");
				return false;	
			}
		}
		return false;
	}
	
	// 그룹탈퇴
	function groupout(){
		var userno = "<%= user.getUserNo() %>";
		var groupno = "<%= group.getGroupNo() %>";
		var authorityno = "<%= group.getAuthorityNo() %>";
		if(confirm("정말로 탈퇴 하시겠습니까?")){
			var random = Math.floor(Math.random() * 9000) + 1000;
			var inputval = prompt("다음 번호를 정확히 입력하세요.\n번호 : " + random, "번호를 입력하세요.");
			if(random == inputval){
				$.ajax({
					url: "/studyhub/groupout",
					data: { userno: userno, groupno: groupno, authorityno: authorityno },
					type: "get",
					dataType: "json",
					async: false
				});
				location.href="/studyhub/main";
				alert("그룹에서 탈퇴하였습니다.");
				return false;
			} else {
				alert("번호가 일치하지 않습니다.\n그룹탈퇴 실패!")
				return false;
			}
		} else {
			return false;
		}
	}
	
	// 공지 리스트5개
	function notice(){
		var groupno = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/top5notice",
			data: { groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var notice1 = "";
				var notice2 = "";
				var notice3 = "";
				var notice4 = "";
				var notice5 = "";
				for(var i in json.list){
					if( i == 0 ){
						notice1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else if( i == 1 ){
						notice2 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else if( i == 2 ){
						notice3 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else if( i == 3 ){
						notice4 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else {
						notice5 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					}
				}
				if(notice1 != "")
					$("#notice1").html(notice1);
				else
					$("#notice1").html("등록된 공지사항이 없습니다.");
				
				if(notice2 != "")
					$("#notice2").html(notice2);
				else
					$("#notice2").html("등록된 공지사항이 없습니다.");
				
				if(notice3 != "")
					$("#notice3").html(notice3);
				else
					$("#notice3").html("등록된 공지사항이 없습니다.");
				
				if(notice4 != "")
					$("#notice4").html(notice4);
				else
					$("#notice4").html("등록된 공지사항이 없습니다.");
				
				if(notice5 != "")
					$("#notice5").html(notice5);
				else
					$("#notice5").html("등록된 공지사항이 없습니다.");
			}
		});
	}
	
	// 스터디일정 5개
	function schedule(){
		var groupno = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/top5schedule",
			data: { groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var json = JSON.parse(JSON.stringify(data));
				var schedule1 = "";
				var schedule2 = "";
				var schedule3 = "";
				var schedule4 = "";
				var schedule5 = "";
				for(var i in json.list){
					if( i == 0 ){
						schedule1 += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" +
										decodeURIComponent(json.list[i].meetingdate).replace(/\+/gi, " ") + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].ampm) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].hour) + " : " +
										decodeURIComponent(json.list[i].minute) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].meetingname).replace(/\+/gi, " ") +
									"</div>";
					} else if( i == 1 ){
						schedule2 += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" +
										decodeURIComponent(json.list[i].meetingdate).replace(/\+/gi, " ") + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].ampm) + "&nbsp;" +
										decodeURIComponent(json.list[i].hour) + " : " +
										decodeURIComponent(json.list[i].minute) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].meetingname).replace(/\+/gi, " ") +
									"</div>";
					} else if( i == 2 ){
						schedule3 += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" +
										decodeURIComponent(json.list[i].meetingdate).replace(/\+/gi, " ") + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].ampm) + "&nbsp;" +
										decodeURIComponent(json.list[i].hour) + " : " +
										decodeURIComponent(json.list[i].minute) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].meetingname).replace(/\+/gi, " ") +
									"</div>";
					} else if( i == 3 ){
						schedule4 += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" +
										decodeURIComponent(json.list[i].meetingdate).replace(/\+/gi, " ") + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].ampm) + "&nbsp;" +
										decodeURIComponent(json.list[i].hour) + " : " +
										decodeURIComponent(json.list[i].minute) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].meetingname).replace(/\+/gi, " ") +
									"</div>";
					} else {
						schedule5 += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" +
										decodeURIComponent(json.list[i].meetingdate).replace(/\+/gi, " ") + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].ampm) + "&nbsp;" +
										decodeURIComponent(json.list[i].hour) + " : " +
										decodeURIComponent(json.list[i].minute) + "&nbsp;&nbsp;" +
										decodeURIComponent(json.list[i].meetingname).replace(/\+/gi, " ") +
									"</div>";
					}
				}
				if(schedule1 != "")
					$("#schedule1").html(schedule1);
				else
					$("#schedule1").html("등록된 일정이 없습니다.");
				
				if(schedule2 != "")
					$("#schedule2").html(schedule2);
				else
					$("#schedule2").html("등록된 일정이 없습니다.");
				
				if(schedule3 != "")
					$("#schedule3").html(schedule3);
				else
					$("#schedule3").html("등록된 일정이 없습니다.");
				
				if(schedule4 != "")
					$("#schedule4").html(schedule4);
				else
					$("#schedule4").html("등록된 일정이 없습니다.");
				
				if(schedule5 != "")
					$("#schedule5").html(schedule5);
				else
					$("#schedule5").html("등록된 일정이 없습니다.");
			}
		});
	}
	
	//자유게시판 3개
	function board(){
		var groupno = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/top3board",
			data: { groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var board1 = "";
				var board2 = "";
				var board3 = "";
				for(var i in json.list){
					if(i == 0){
						board1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else if (i == 1){
						board2 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					} else {
						board3 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
										decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploader) +
									"</div>" +
									"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
										decodeURIComponent(json.list[i].uploaddate) +
									"</div>";
					}
				}
				if(board1 != "")
					$("#board1").html(board1);
				else
					$("#board1").html("등록된 게시글이 없습니다.");
				
				if(board2 != "")
					$("#board2").html(board2);
				else
					$("#board2").html("등록된 게시글이 없습니다.");
				
				if(board3 != "")
					$("#board3").html(board3);
				else
					$("#board3").html("등록된 게시글이 없습니다.");
			}
		});
	}
	
	// 파일공유게시판 3개
	function sharefile(){
		var groupno = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/top3sharefile",
			data: { groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var sharefile1 = "";
				var sharefile2 = "";
				var sharefile3 = "";
				for(var i in json.list){
					if(i == 0){
						sharefile1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
											decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploader) +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploaddate) +
										"</div>";
					} else if (i == 1){
						sharefile1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
											decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploader) +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploaddate) +
										"</div>";
					} else {
						sharefile1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
											decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploader) +
										"</div>" +
										"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
											decodeURIComponent(json.list[i].uploaddate) +
										"</div>";
					}
				}
				if(sharefile1 != "")
					$("#sharefile1").html(sharefile1);
				else
					$("#sharefile1").html("등록된 파일이 없습니다.");
				
				if(sharefile2 != "")
					$("#sharefile2").html(sharefile2);
				else
					$("#sharefile2").html("등록된 파일이 없습니다.");
				
				if(sharefile3 != "")
					$("#sharefile3").html(sharefile3);
				else
					$("#sharefile3").html("등록된 파일이 없습니다.");
			}
		});
	}
	
	// QnA게시판 3개
	function QnA(){
		var groupno = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/top3qna",
			data: { groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var qna1 = "";
				var qna2 = "";
				var qna3 = "";
				for(var i in json.list){
					if(i == 0){
						qna1 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
									decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploader) +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploaddate) +
								"</div>";
					} else if (i == 1){
						qna2 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
									decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploader) +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploaddate) +
								"</div>";
					} else {
						qna3 += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
									decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploader) +
								"</div>" +
								"<div class='col-lg-3 col-md-3 col-sm-3 col-xs-3'>" +
									decodeURIComponent(json.list[i].uploaddate) +
								"</div>";
					}
				}
				if(qna1 != "")
					$("#qna1").html(qna1);
				else
					$("#qna1").html("등록된 게시글이 없습니다.");
				if(qna2 != "")
					$("#qna2").html(qna2);
				else
					$("#qna2").html("등록된 게시글이 없습니다.");
				if(qna3 != "")
					$("#qna3").html(qna3);
				else
					$("#qna3").html("등록된 게시글이 없습니다.");
			}
		});
	}
</script>

<%@ include file="/views/include/common/tail.jsp"%>