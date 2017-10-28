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
	
</style>

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>

<!-- 메인 컨텐츠 -->
<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
	<div class="col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-1 col-sm-9 col-xs-9">
		<h3><%= group.getGroupName() %>
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
					<a href='#' onclick='notice()'>
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='leftlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='notice1'>1</li>
						<li class='list-group-item' id='notice2'>2</li>
						<li class='list-group-item' id='notice3'>3</li>
						<li class='list-group-item' id='notice4'>4</li>
						<li class='list-group-item' id='notice5'>5</li>
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
					<a href='#' onclick='schedule()'>
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='leftlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='schedule1'>1</li>
						<li class='list-group-item' id='schedule2'>2</li>
						<li class='list-group-item' id='schedule3'>3</li>
						<li class='list-group-item' id='schedule4'>4</li>
						<li class='list-group-item' id='schedule5'>5</li>
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
					<a href='#' onclick='board()'>
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='board1'>1</li>
						<li class='list-group-item' id='board2'>2</li>
						<li class='list-group-item' id='board3'>3</li>
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
					<a href='#' onclick='fileshare()'>
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='fileshare1'>1</li>
						<li class='list-group-item' id='fileshare2'>2</li>
						<li class='list-group-item' id='fileshare3'>3</li>
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
					<a href='#' onclick='qna()'>
						더보기  <span class='glyphicon glyphicon-arrow-right'></span>
					</a>
				</div>
				<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12' id='rightlist'>
					<ul class='list-group'>
						<li class='list-group-item' id='qna1'>1</li>
						<li class='list-group-item' id='qna2'>2</li>
						<li class='list-group-item' id='qna3'>3</li>
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
	
	function removegroup(){
		alert("그룹해제 준비중");
		return false;
	}
	
	function groupout(){
		alert("그룹탈퇴 준비중");
		return false;
	}
</script>

<%@ include file="/views/include/common/tail.jsp"%>