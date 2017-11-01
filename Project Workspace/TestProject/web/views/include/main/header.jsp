
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.User"%>
<%
	User user = (User)session.getAttribute("user");
%>
<!-- 헤더 영역 : 네비게이션 바 -->
<nav id="navbar">
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
							class="black" id="color">스터디찾기</span>
					</a></li>
					<li><a href="/studyhub/noticeview">
							<p class="black" id="color">도움말</p>
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
							<p class="black" id="color">
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
							<p class='black' id='color'>
								<span class='badge' id="messagecount">
								</span>
								&nbsp;&nbsp;메시지함  <span class="caret"></span>
							</p>
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
														"<div class='col-lg-2 col-md-2 col-sm-2 col-xs-2' style='height: 34px; padding-top: 7px;'>" +
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
															"<button type='button' class='btn btn-primary' onclick='confirmMessage(" + json.list[i].messageno + ")'>확인</button>" +
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
						
						function confirmMessage(messageno){
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
					
					<li><a href="/studyhub/myinfo"><p class="black" id="color"><%=user.getUserName()%></p></a></li>
					<li><a href="/studyhub/logout"><p class="black" id="color">로그아웃</p></a></li>
					<%
						} else {
					%>
					<li><a href="/studyhub/signup"><p class="black" id="color">회원가입</p></a></li>
					<li><a href="/studyhub/login"><p class="black" id="color">로그인</p></a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
	</div>
</nav>

<script type="text/javascript" src='/studyhub/js/studysearch.js'></script>
<script type="text/javascript">
function studySearch() {
	var userNo = <%=(user!=null)?user.getUserNo():"''"%>;
	var attrNo = $("#attrlist").val();
	var cateNo = $("#catelist").val();
	var location = $("#location").val();
	var keyword = $("#keyword").val();
	$.ajax({
		url : "/studyhub/grouplist",
		data : {
			attrNo : attrNo,
			cateNo : cateNo,
			location : location,
			keyword : keyword,			
		},
		type : "post",
		datatype : "json",
		success : function(data) {
			var json = JSON.parse(JSON.stringify(data));
			var values = "";
			if (json.list.length > 0) {
				for ( var i in json.list) {
					if(userNo!=''){
						values+="<div class='col-md-6' style='margin-bottom:10px'><a href='/studyhub/gmainpreview?group_no="+json.list[i].group_no+"&reset=0&user_no="+userNo+"'>"
								+"<img src='/studyhub/images/groupimg/'"+decodeURIComponent(json.list[i].g_img_rename)+"' style='width:80px;height: 80px;' >"+decodeURIComponent(json.list[i].group_name)+"</a></div>"
					}else{
						values+="<div class='col-md-6' style='margin-bottom:10px'>"
						+"<a href='/studyhub/main'>"
						+"<img src='/studyhub/images/groupimg/'"+decodeURIComponent(json.list[i].g_img_rename)+"' style='width:80px;height: 80px;' >"
						+decodeURIComponent(json.list[i].group_name)+"</a></div>";
						}
					}
				} else {
					values += "그룹 없음";
					}
			$("#result").html(values);
		}
	});
}
</script>
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
				<div class="container-fluid">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="rule" class="col-sm-3 control-label">스터디 방식</label>
								<div class="col-sm-3">
									<select class="form-control" id="attrlist" name="attrlist" onchange='studySearch()'>
										<option value ='0' selected>모든 방식</option>
										<option value="1">온라인 스터디</option>
										<option value="2">오프라인 스터디</option>
									</select>
								</div>
								<label for="rule" class="col-sm-3 control-label">스터디 분야</label>
								<div class="col-sm-3">
									<select class="form-control" id="catelist" name="catelist" onchange='studySearch()'>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="rule" class="col-sm-3 control-label">스터디 지역</label>
								<div class="col-sm-3">
									<select class="form-control" id="location" name="location" onchange='studySearch()'>
										<option value ='0' selected>모든 지역</option>
										<option>서울</option>
										<option>경기</option>
										<option>강원</option>
										<option>충북</option>
										<option>충남</option>
										<option>전북</option>
										<option>전남</option>
										<option>경북</option>
										<option>경남</option>
										<option>제주</option>
									</select>
								</div>
								<div class="col-sm-6">
									<div id="imaginary_container">
										<div class="input-group stylish-input-group">
											<input type="text" class="form-control" placeholder="Search"
												id='keyword' name='keyword' oninput="studySearch()"> <span class="input-group-addon">
											<span class="glyphicon glyphicon-search"></span>
											</span>
										</div>
									</div>
								</div>
							</div>
						</form>
						<hr>
						<div id='result'></div>
						<script type="text/javascript">
						$(function() { //모든그룹 불러오기
							var userNo = <%=(user!=null)?user.getUserNo():"''"%>;
							$.ajax({
								url : "/studyhub/grouplist",
								type : "get",
								datatype : "json",
								success : function(data) {
									var json = JSON.parse(JSON.stringify(data));
									var values = "";
									if (json.list.length > 0) {
										for ( var i in json.list) {
											if(userNo!=''){
												values+="<div class='col-md-6' style='margin-bottom:10px'><a href='/studyhub/gmainpreview?group_no="+json.list[i].group_no+"&reset=0&user_no="+userNo+"'>"
														+"<img src='/studyhub/images/groupimg/"+decodeURIComponent(json.list[i].g_img_rename)+"' style='width:80px;height: 80px;' >"+decodeURIComponent(json.list[i].group_name)+"</a></div>"
											}else{
												values+="<div class='col-md-6' style='margin-bottom:10px'>"
												+"<a href='/studyhub/main'>"
												+"<img src='/studyhub/images/groupimg/"+decodeURIComponent(json.list[i].g_img_rename)+"' style='width:80px;height: 80px;' >"
												+decodeURIComponent(json.list[i].group_name)+"</a></div>";
												}
											}
										} else {
											values += "그룹 없음";
											}
									$("#result").html(values);
									}
							});
							});
						
						
						</script>
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

