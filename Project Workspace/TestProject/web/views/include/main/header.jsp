
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studyhub.common.vo.User"%>
<%
	User user = (User)session.getAttribute("user");
%>
<!-- 헤더 영역 : 네비게이션 바 -->
<nav class="navbar navbar-default bg-white" id="navbar">
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
					<li><a href="/studyhub/views/main/FAQ/FAQmain.jsp">
							<p class="black">도움말</p>
					</a></li>

					<%
						if (user != null) {
					%>
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
												+ "&reset=0'>"
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

