
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.User"%>
<%
	User user = (User)session.getAttribute("user");
%>
<!-- 헤더 영역 : 네비게이션 바 -->
<nav class="navbar navbar-default" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- 메인 로고 부분 -->

			<%
				if (user != null) {
			%>
			<a class="navbar-brand" href="/studyhub/main"><img id="logo"
				src="/studyhub/images/logo.png"></a>
			<%
				} else {
			%>
			<a class="navbar-brand" href="/studyhub/"><img id="logo"
				src="/studyhub/images/logo.png"></a>
			<%
				}
			%>
			<!-- / -->
		</div>
		<!-- 메뉴 부분 -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<nav class="fill">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#" data-toggle="modal" data-target="#seachfilter">
							<span class="glyphicon glyphicon-search main" aria-hidden="true"></span><span
							class="black">스터디찾기</span>
					</a></li>
					<li><a href="/studyhub/noticeview">
							<p class="black">도움말</p>
					</a></li>

					<%
						if (user != null) {
							if(user.getUserNo()==1){ //관리자일 때 
					%>
					<li><a href="/studyhub/views/admin/MainDashBoard.jsp" id="admin-dmenu">관리자화면</a>
					</li>
					<% }else{ %>
					
					<li class="dropdown">
						<a href="javascript/mygroupdropdown()" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<p class="black">
								나의 그룹<span class="caret"></span>
							</p> 
						</a>
						<ul class="dropdown-menu" role="menu" id="mygroupmenu">
							<!-- ajax로 그룹리스트 불러옴 --> 
						</ul>
					</li>
					<% } %>
					<script type="text/javascript">
						$(function mygroupdropdown(){
							var userno = "<%= user.getUserNo()%>";
							$.ajax({
								url : "/studyhub/mygrouppreview",
								data : {
									userno : userno
								},
								type : "get",
								datatype : "json",
								success : function(data) {
									var json = JSON.parse(JSON.stringify(data));
									var values = "";
									for ( var i in json.list) {
										values += "<li>"
												+ "<a href='/studyhub/gmainpreview?group_no="
												+ json.list[i].group_no
												+ "&reset=0&user_no=" + userno + "'>"
												+ decodeURIComponent(json.list[i].group_name)
												+ "</a>" + "</li>";
										}
									var sub = "<li class='divider'></li>"
											+ "<li><a href='/studyhub/views/main/MakeGroup.jsp'> 새 그룹만들기</a></li>";
									$("#mygroupmenu").html(values + sub);
								}
							});
						});
					</script>
					<%
						}
					%>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%
						if (user != null) {
					%>
					<li class='drop-down' id='message'>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<P class='black'>
								<span class='badge' id="messagecount">
								</span>
								&nbsp;&nbsp;메시지함  <span class="caret"></span>
							</P>
						</a>
						<ul class="dropdown-menu" role="menu" id="mymessage">
							<!-- ajax로 그룹리스트 불러옴 -->
						</ul>
					</li>
					<script type="text/javascript">
						$(function (){
							messagecount();
							messageselect();
						});
								
						function messagecount(){
							var userno = "<%= user.getUserNo() %>";
							$.ajax({
								url: "/studyhub/messagecount",
								data: { userno: userno },
								type: "get",
								dataType: "json",
								success: function (data){
									var json = JSON.parse(JSON.stringify(data));
									var values = "";
									values += json.messagecount;
									$("#messagecount").html(values);
								}
							});
						}
						
						function messageselect(){
							var userno ="<%= user.getUserNo() %>";
							$.ajax({
								url: "/studyhub/messagelist",
								data: { userno: userno },
								type: "get",
								dataType: "json",
								success: function(data){
									var json = JSON.parse(JSON.stringify(data));
									var values = "";
									for(var i in json.list){
										values += 	"<li style='width: 680px; height: 40px; margin-top: 10px;'>" +
														"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2' style='height: 34px; padding-top: 7px;'>" +
															decodeURIComponent(json.list[i].groupname).replace(/\+/gi, " ") +
														"</div>" +
														"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2'>" +
															decodeURIComponent(json.list[i].username).replace(/\+/gi, " ") +
														"</div>" +
														"<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6' style='height: 34px; padding-top: 7px;'>" +
															decodeURIComponent(json.list[i].message).replace(/\+/gi, " ") +
														"</div>";
										if(json.list[i].messagestate == 0){
										values += "<div class='col-lg-1 col-md-1 col-sm-1 col-xs-1' style='padding-left: 0px;'>" +
															"<button type='button' class='btn btn-success' onclick='agree(" + json.list[i].messageno + "," + json.list[i].receiver + ", " + json.list[i].sender + "," + json.list[i].groupno + ")'>수락</button>" + 
															/* 수락 누르면 ung인서트하고 메시지상태 2로 업뎃*/
														"</div>" +
														"<div class='col-lg-1 col-md-1 col-sm-1 col-xs-1' style='padding-left: 0px;'>" +
															"<button type='button' class='btn btn-danger' onclick='negative(" + json.list[i].messageno + "," + json.list[i].receiver + ", " + json.list[i].sender + "," + json.list[i].groupno + ")'>거절</button>" +
															/* 거절 누르면  메시지상태2로 업뎃*/
														"</div>" +
													"</li>";
										} else if (json.list[i].messagestate == 1) {
											values += 	"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2' style='padding-left: 0px;'>" +
															"<button type='button' class='btn btn-primary' onclick='confirm(" + json.list[i].messageno + ")'>확인</button>" +
															/* 확인누르면 메시지상태 2로 업뎃 */
														"</div>" +
													"</li>";
										} else {
											values += 	"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2' style='padding-left: 0px;'>" +
														"</div>" +
													"</li>";
										}
									}
									var sub = 	"<li style='width: 680px; height: 30px;line-height:30px;'>" +
													"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2'>" +
														"그룹명" +
													"</div>" +
													"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2'>" +
														"보낸이" +
													"</div>" +
													"<div class='col-lg-6 col-md-6 col-sm-6 col-xs-6'>" +
														"내용" +
													"</div>" +
													"<div class='col-lg-1 col-md-1 col-sm-1 col-xs-1' style='padding-left: 0px;'>" +
														"수락" +
													"</div>" +
													"<div class='col-lg-1 col-md-1 col-sm-1 col-xs-1' style='padding-left: 0px;'>" +
														"거절" +
													"</div>" +
												"</li>" +
												"<hr style='margin:0 auto'>";
									$("#mymessage").html(sub + values);
								}
							});
						}
						
						// 초대 수락
						function agree(messageno, receiver, sender, groupno){
							$.ajax({
								url: "/studyhub/inviteprocess",
								data: { messageno: messageno, receiver: receiver, sender: sender, groupno: groupno, state: 1 },
								type: "get",
								async: false
							});
							alert("초대를 수락하였습니다.");
							messagecount();
							messageselect();
						}
						
						function negative(messageno, receiver, sender, groupno){
							$.ajax({
								data: { messageno: messageno, receiver: receiver, sender: sender, groupno: groupno, state: 0 },
								url: "/studyhub/inviteprocess",
								type: "get",
								async: false
							});
							alert("초대를 거절하였습니다.");
							messagecount();
							messageselect();
						}
						
						function confirm(messageno){
							$.ajax({
								data: { messageno: messageno, receiver: 1, sender: 1, groupno: 1, state: 2 },
								url: "/studyhub/inviteprocess",
								type: "get",
								async: false
							});
							messagecount();
							messageselect();
						}
					</script>
					
					<li><a href="/studyhub/myinfo"><p class="black"><%=user.getUserName()%></p></a></li>
					<li><a href="/studyhub/logout"><p class="black">로그아웃</p></a></li>
					<%
						} else {
					%>
					<li><a href="/studyhub/signup"><p class="black">회원가입</p></a></li>
					<li><a href="/studyhub/login"><p class="black">로그인</p></a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
	</div>
</nav>

<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="seachfilter"
	tabindex="-1" role="dialog" aria-labelledby="seachfilterLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="seachfilterLabel">스터디 찾기</h4>
			</div>
			<div class="modal-body">
				<div style="display: table; width: 100%">
					<div style="display: table-cell; vertical-align: middle">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="rule" class="col-sm-3 control-label">스터디 방식</label>
								<div class="col-sm-3">
									<select class="form-control">
										<option>온라인 스터디</option>
										<option>오프라인 스터디</option>
									</select>
								</div>
								<label for="rule" class="col-sm-3 control-label">스터디 분야</label>
								<div class="col-sm-3">
									<select class="form-control">
										<option>1</option>
										<option>2</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="rule" class="col-sm-3 control-label">스터디 지역</label>
								<div class="col-sm-3">
									<select class="form-control">
										<option>1</option>
										<option>2</option>
									</select>
								</div>
								<label for="rule" class="col-sm-3 control-label">상세 지역</label>
								<div class="col-sm-3">
									<select class="form-control">
										<option>1</option>
										<option>2</option>
									</select>
								</div>
							</div>
						</form>
						<hr>
						<div>결과도출</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
			</div>
		</div>
	</div>
</div>
<!-- /Modal -->

