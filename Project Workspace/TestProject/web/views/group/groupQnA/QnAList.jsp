<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!-- 작성자 : 양동균
내용 : 그룹QnAList 페이지
작성일자 17.10.02 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<%@ include file="/views/include/common/head.jsp"%>

<link rel="stylesheet" href="/studyhub/css/bootstrap2-toggle.min.css"> <!-- 토글버튼 css -->
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<script type="text/javascript" src="/studyhub/js/bootstrap2-toggle.js"></script> <!-- 토글버튼 js -->

<style type="text/css">
	#write {
		width: 100%;
		height: 140px;
		margin-top: 20px;
	}
	
	#read {
		width: 100%;
		height: 180px;
		text-align: left;
	}
	
	#serach {
		width: 100%;
		height: 34px;
		margin-top: 20px;
	}
	
	#qnatitle {
		text-align: left;
	}
	
	#qnaread {
		height: 125px;
		
	}
	
	#title_size{
		height: 40px;
	}
	
	#uploader{
		padding: 0px;
	}
	#modal-dialog {
		width: 70%;
		height: 300px;
	}
	
	#modal-footer {
		height: 64px;
		pading-top: 10px;
	}
	
	#modal-body {
		height: 170px;
		margin-top: 10px;
		padding-top: 5px;
	}
	#modalwrite{
		width: 100%;
	}
	
	.modal-header {
		background-color: #004157;
		color: white;
	}
	
	.panel-primary {
    	border-color: #004157;
	}
	
	.panel-primary>.panel-heading {
    	color: #fff;
    	background-color: #004157;
   		border-color: #004157;
	}
	
	.btn-primary {
	    color: #fff;
	    background-color: #004157;
	    border-color: #222d38;
	}
	
	.panel-heading {
		padding-top: 0px;
		padding-bottom: 0px;
		padding-left: 0px;
		padding-right: 0px;
	}

	.panel panel-default{
		margin-top: 20px;
		padding-left: 0px;
	}
	
	#insertbtn {
		padding-top: 0px;
		padding-bottom: 0px;
		padding-left: 0px;
		padding-right: 0px;
	}
	
	#widthsize {
		padding-top: 0px;
		padding-bottom: 0px;
		padding-left: 0px;
		padding-right: 0px;
		margin-bottom: 20px;
	}
	
	.commenttile {
		width: 100%;
		border: 1px; 
		border-radius: 4px;
		padding-top: 2px;
		padding-bottom: 2px;
		padding-left: 5px;
		padding-right: 5px;
	}
	
	.panel-footer {
		padding-top: 5px;
		padding-bottom: 5px;
		padding-left: 0px;
		padding-right: 0px;
		height: 36px;
	}
	
	#commentinsert {
		padding-top: 2px;
		padding-bottom: 2px;
		padding-left: 5px;
		padding-right: 5px;
		width: 40px;
		height: 24px;
	}
	
	.panel-body {
		padding-top: 6px;
		padding-bottom: 6px;
		padding-left: 5px;
		padding-right: 5px;
		height: 36px;
	}
	
	#xbtn {
		padding-top: 2px;
		padding-bottom: 2px;
		padding-left: 5px;
		padding-right: 5px;
	}
	
	#commentwriter{
		padding-left: 10px;
		padding-right: 5px;
	}
	
	ul {
		list-style: none;
		padding-left: 10px;
		margin-bottom: 0px;
	}
	
	li {
		padding-top: 5px;
		padding-bottom: 5px;
		height: 30px;
	}
	
	.glyphicon.glyphicon-remove{
		padding-top: 4px;
		height: 20px;
	}
	
	#commentcount{
		height: 80px;
		padding-top: 15px;
	}
	
	#qnaupdatebtn{
		margin-bottom: 10px;
	}
	
	body {
	  position: relative;
	}
	
	#qnawrapper{
		margin-top: 8vh;
		margin-bottom: 20vh;
	}

</style>
<!--헤더 부분-->
<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>


<!-- 메인 컨텐츠 -->
<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2" id="qnawrapper" data-spy="scroll">
	<div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3">
		<div class="input-group" data-toggle="tooltip" data-placement="top" title="검색어 입력시 자동으로 데이터를 가져옵니다!">
			<span class="input-group-addon" id="basic-addon1"> <span
				class="glyphicon glyphicon-search"></span>
			</span> <input type="text" class="form-control"	placeholder="<%=user.getUserName()%> 님 검색어를 입력하세요!" id="qnasearch" aria-describedby="basic-addon1" oninput="qnasearch()">
		</div>
	</div>

	<div class="col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1" id="widthsize">
		<div class="btn btn-default btn-sm" id="write">
			<form method="post" name="fr" id="qnainsertform" action="">
				<input type="hidden" name="userno" id="userno"
					value="<%= user.getUserNo() %>"> <input type="hidden"
					name="groupno" id="groupno" value="<%= group.getGroupNo() %>">
				<div class="col-xs-10 col-md-11 col-sm-10">
					<input type="text" class="form-control"
						aria-describedby="sizing-addon1" placeholder="질문할 제목을 입력하세요."
						id="title">
				</div>
				<div class="col-xs-2 col-md-1 col-sm-2">
					<input type="button" id="qnainsertbtn" name="qnainsertbtn"
						class="btn btn-primary" value="등록" onclick="return insertqna();">
				</div>
				<div class="col-xs-10 col-md-11 col-sm-10">
					<textarea rows="4" class="form-control"
						placeholder="<%= user.getUserName() %>님 무엇이 궁금하세요?" id="content"></textarea>
				</div>
			</form>
		</div>
		<br>
		<!-- 글 간의 간격 -->
	</div>
	

	<div class='panel-group' id='qna_list' role='tablist' aria-multiselectable='true'>
		<!-- ajax  -->
	</div>
	
	<div class='panel-group' id='search_list' role='tablist' aria-multiselectable='true'>
		<!-- ajax -->
	</div>


</div>

<!-- 모달부분 -->
<div class="modal fade" id="qnamodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" id="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"> 질문 수정하기 </h4>
				</div>
				<div class="modal-body" id="modal-body">
					
					<div class="col-md-12 col-sm-12">		
						<div class="btn btn-default btn-sm" id="modalwrite">
							<form method="post" name="fr" id="qnainsertform" action="">
								<input type="hidden" id="modalgqnano">
								<div class="col-xs-12 col-md-12 col-sm-12">
						                   <input type="text" class="form-control" aria-describedby="sizing-addon1" id="modaltitle"></div>
								<div class="col-xs-12 col-md-12 col-sm-12">
						                   <textarea rows="4" class="form-control" id="modalcontent"></textarea>
								</div>
							</form>
						</div>
						<br> <!-- 글 간의 간격 -->
					</div>
					
				</div>
				<div class="modal-footer" id="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="updateQnA();" id="updatebtn">수정</button>
				</div>
			</div>
		</div>
	</div>

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>


<script type="text/javascript">
	var basic = 0;
	var startpage = 9;
	var endpage = 0;
	
	$(function(){
		selectQnA(startpage, endpage);
		$('[data-toggle="tooltip"]').tooltip();
		$("#qna_list").show();
		$("#search_list").hide();
		startpage += 10;
		endpage += 10;
	});
	
	
	// 스크롤 페이징
	$(window).scroll(function(){
		if($(window).scrollTop() >= $(document).height() - $(window).height()){
			location.href = "#tail"+endpage;
			selectQnA(startpage,endpage);
			startpage += 10;
			endpage += 10;
		}
	})

	function insertqna(){
		if($("#title").val() == ""){
			alert("제목을 입력하세요.");
			focus("#title");
			return false;
		}
		else if($("#content").val() == ""){
			alert("내용을 입력하세요.");
			focus("#content");
			return false
		}
		else {
			var userno = $("#userno").val();
			var groupno = $("#groupno").val();
			var title = $("#title").val();
			var content = $("#content").val();
					
			var queryString = { "userno": userno, "groupno": groupno, "title": title, "content": content};
			
			$.ajax({
				url: "/studyhub/insertgroupqna",
				data: queryString,
				type: "get",
				dataType: "json"
			});
			$("#title").val("");
			$("#content").val("");
			startpage = 9;
			endpage = 0;
			selectQnA(startpage, endpage);
			return true
		}
	}
	
	function selectQnA(startpage, endpage){
		var group_no = "<%= group.getGroupNo() %>";
		var user_no = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/selectgroupqna",
			data: { groupno: group_no, startpage: startpage, endpage: endpage },
			type: "get",
			datatype: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					if(user_no == json.list[i].user_no){
					values += 
						"<div class='panel panel-default col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1' id='widthsize'>" +
							"<div class='panel-heading' role='tab' id='heading" + i + "'>" +
								"<h4 class='panel-title'>" +
									"<div class='btn btn-default btn-sm' id='read'>" +
										"<div class='col-xs-10 col-sm-10 col-md-11'>" +
											"<a data-toggle='collapse' data-parent='#accordion' onclick='commentconfirm(" + json.list[i].g_qna_no + ")' href='#collapse" + i + "' aria-expanded='false' aria-controls='collapse" + i + "'>" +
												"<div class='panel panel-primary'>" +
													"<div class='panel-heading' id='title_size'>" +
														"<div class='col-xs-9 col-sm-9 col-md-10'>" +
															"<h3 class='panel-title' id='qnatitle'>" +
																decodeURIComponent(json.list[i].title).replace(/\+/gi, ' ') + "</h3>" +
														"</div>" +
														"<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>"+
															decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
															decodeURIComponent(json.list[i].uploader) +
														"</div>" + 
													"</div>" +
													"<div class='panel-body' id='qnaread'>" +
														decodeURIComponent(json.list[i].content).replace(/\+/gi, ' ') +
													"</div>" +
												"</div>" +
											"</a>" +
										"</div>" +
										"<div class='col-xs-2 col-md-1 col-sm-2' id='commentcount'>" +
											"댓글 " +json.list[i].commentcount + " 개" +
										"</div>" +
										"<div class='col-xs-2 col-sm-2 col-md-1'>" +
											"<input type='button' id='qnaupdatebtn' name='qnaupdatebtn' class='btn btn-primary' value='수정' onclick='selectOne(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +
										"<div class='col-xs-2 col-md-1 col-sm-2'>" +
											"<input type='button' id='qnadeletebtn' name='qnadeletebtn'	class='btn btn-primary' value='삭제' onclick='deleteQnA(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +
									"</div>" +
								"</h4>" +
							"</div>" +
								"<div id='collapse"+ i +"' class=' panel-collapse collapse'	role='tabpanel' aria-labelledby='heading"+ i +"'>" +
									"<div class='list-group'>" +
										"<ul id='commentbody" + json.list[i].g_qna_no + "'>" +
										"</ul>" +
									"</div>" +
									"<div class='panel-footer'>" +
										"<div class='col-lg-11 col-md-11 col-sm-11'>" +
											"<input type='text' placeholder='지금, 댓글을 작성해보세요!' id='commenttitle" + json.list[i].g_qna_no + "' class='commenttile'>" +
										"</div>" +
										"<div class='col-lg-1 col-md-1 col-sm-1' id='insertbtn'>" +
											"<input type='button' id='commentinsert' class='btn btn-primary'	onclick='commentInsert(" + json.list[i].g_qna_no + ")' value='작성'>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>";
					}
					else {
						values += 
							"<div class='panel panel-default col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1' id='widthsize'>" +
							"<div class='panel-heading' role='tab' id='heading" + i + "'>" +
								"<h4 class='panel-title'>" +
									"<div class='btn btn-default btn-sm' id='read'>" +
										"<div class='col-xs-10 col-sm-10 col-md-11'>" +
											"<a data-toggle='collapse' data-parent='#accordion' onclick='commentconfirm(" + json.list[i].g_qna_no + ")' href='#collapse" + i + "' aria-expanded='false' aria-controls='collapse" + i + "'>" +
												"<div class='panel panel-primary'>" +
													"<div class='panel-heading' id='title_size'>" +
														"<div class='col-xs-9 col-sm-9 col-md-10'>" +
															"<h3 class='panel-title' id='qnatitle'>" +
																decodeURIComponent(json.list[i].title).replace(/\+/gi, ' ') + "</h3>" +
														"</div>" +
														"<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>"+
															decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
															decodeURIComponent(json.list[i].uploader) +
														"</div>" + 
													"</div>" +
													"<div class='panel-body' id='qnaread'>" +
														decodeURIComponent(json.list[i].content).replace(/\+/gi, ' ') +
													"</div>" +
												"</div>" +
											"</a>" +
										"</div>" +
										"<div class='col-xs-2 col-sm-2 col-md-1'>" +
										"</div>" +
										"<div class='col-xs-2 col-md-1 col-sm-2'>" +
										"</div>" +
									"</div>" +
								"</h4>" +
							"</div>" +
								"<div id='collapse"+ i +"' class=' panel-collapse collapse'	role='tabpanel' aria-labelledby='heading"+ i +"'>" +
									"<div class='list-group'>" +
										"<ul id='commentbody" + json.list[i].g_qna_no + "'>" +
										"</ul>" +
									"</div>" +
									"<div class='panel-footer'>" +
										"<div class='col-lg-11 col-md-11 col-sm-11'>" +
											"<input type='text' placeholder='지금, 댓글을 작성해보세요!' id='commenttitle" + json.list[i].g_qna_no + "' class='commenttile'>" +
										"</div>" +
										"<div class='col-lg-1 col-md-1 col-sm-1' id='insertbtn'>" +
											"<input type='button' id='commentinsert' class='btn btn-primary'	onclick='commentInsert(" + json.list[i].g_qna_no + ")' value='작성'>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>";
					}
				}
				var tail = "<div class='col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1' id='tail" + endpage + "'>"
				if(endpage == 0){
					$("#qna_list").html(values + tail);
				} else {
					$("#qna_list").append(values + tail);
				}
			},
			error: function(xhr,status,error){
				alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);
			}
		});
	}
	
	function deleteQnA(param){
		var g_qna_no = param;
		$.ajax({
			url: "/studyhub/deletegroupqna",
			data: { gqnano: g_qna_no },
			type: "get",
			dataType: "json",
			async: false
		});
		alert("삭제되었습니다.");
		startpage = 9;
		endpage = 0;
		selectQnA(startpage, endpage);
	}
	
	function selectOne(param){
		gqnano = param;
		$.ajax({
			url: "/studyhub/selectonegroupqna",
			data: { g_qna_no: gqnano },
			type: "get",
			dataTypa: "json",
			async: false,
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var modalgqnano = "";
				var modaltitle = "";
				var modalcontent = "";
				for(var i in json.list){
						modaltitle += decodeURIComponent(json.list[i].title).replace(/\+/gi, " ");
						modalcontent += decodeURIComponent(json.list[i].content).replace(/\+/gi, " ");
						modalgqnano += json.list[i].g_qna_no;
				}
				$("#modaltitle").val(modaltitle);
				$("#modalcontent").val(modalcontent);
				$("#modalgqnano").val(modalgqnano);
			}
		});
		$("#qnamodal").modal();
	}
	
	function updateQnA(){
		var modaltitle = $("#modaltitle").val();
		var modalcontent = $("#modalcontent").val();
		var modalgqnano = $("#modalgqnano").val();
		var queryString = { title: modaltitle, content: modalcontent, gqnano: modalgqnano };
		$.ajax({
			url: "/studyhub/updategroupqna",
			data: queryString,
			type: "get",
			dataType: "json",
			async: false
		});
		alert("수정되었습니다.");
		$("#qnamodal").modal("hide");
		startpage = 9;
		endpage = 0;
		selectQnA(startpage, endpage);
	}
	
	function qnasearch(){
		$("#qna_list").hide();
		$("#search_list").show();
		var groupno = "<%= group.getGroupNo() %>";
		var user_no = "<%= user.getUserNo() %>";
		var searchdata = $("#qnasearch").val();
		$.ajax({
			url: "/studyhub/searchgroupqna",
			data: { searchdata: searchdata, groupno: groupno },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					if(user_no == json.list[i].user_no){
						values += 
							"<div class='panel panel-default col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1' id='widthsize'>" +
							"<div class='panel-heading' role='tab' id='heading" + i + "'>" +
								"<h4 class='panel-title'>" +
									"<div class='btn btn-default btn-sm' id='read'>" +
										"<div class='col-xs-10 col-sm-10 col-md-11'>" +
											"<a data-toggle='collapse' data-parent='#accordion' onclick='commentconfirm(" + json.list[i].g_qna_no + ")' href='#collapse" + i + "' aria-expanded='false' aria-controls='collapse" + i + "'>" +
												"<div class='panel panel-primary'>" +
													"<div class='panel-heading' id='title_size'>" +
														"<div class='col-xs-9 col-sm-9 col-md-10'>" +
															"<h3 class='panel-title' id='qnatitle'>" +
																decodeURIComponent(json.list[i].title).replace(/\+/gi, ' ') + "</h3>" +
														"</div>" +
														"<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>"+
															decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
															decodeURIComponent(json.list[i].uploader) +
														"</div>" + 
													"</div>" +
													"<div class='panel-body' id='qnaread'>" +
														decodeURIComponent(json.list[i].content).replace(/\+/gi, ' ') +
													"</div>" +
												"</div>" +
											"</a>" +
										"</div>" +
										"<div class='col-xs-2 col-sm-2 col-md-1'>" +
											"<input type='button' id='qnaupdatebtn' name='qnaupdatebtn' class='btn btn-primary' value='수정' onclick='selectOne(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +
										"<div class='col-xs-2 col-md-1 col-sm-2'>" +
											"<input type='button' id='qnadeletebtn' name='qnadeletebtn'	class='btn btn-primary' value='삭제' onclick='deleteQnA(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +
									"</div>" +
								"</h4>" +
							"</div>" +
								"<div id='collapse"+ i +"' class=' panel-collapse collapse'	role='tabpanel' aria-labelledby='heading"+ i +"'>" +
									"<div class='list-group'>" +
										"<ul id='commentbody" + json.list[i].g_qna_no + "'>" +
										"</ul>" +
									"</div>" +
									"<div class='panel-footer'>" +
										"<div class='col-lg-11 col-md-11 col-sm-11'>" +
											"<input type='text' placeholder='지금, 댓글을 작성해보세요!' id='commenttitle" + json.list[i].g_qna_no + "' class='commenttile'>" +
										"</div>" +
										"<div class='col-lg-1 col-md-1 col-sm-1' id='insertbtn'>" +
											"<input type='button' id='commentinsert' class='btn btn-primary'	onclick='commentInsert(" + json.list[i].g_qna_no + ")' value='작성'>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>";
						}
						else {
							values += 
								"<div class='panel panel-default col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1' id='widthsize'>" +
								"<div class='panel-heading' role='tab' id='heading" + i + "'>" +
									"<h4 class='panel-title'>" +
										"<div class='btn btn-default btn-sm' id='read'>" +
											"<div class='col-xs-10 col-sm-10 col-md-11'>" +
												"<a data-toggle='collapse' data-parent='#accordion' onclick='commentconfirm(" + json.list[i].g_qna_no + ")' href='#collapse" + i + "' aria-expanded='false' aria-controls='collapse" + i + "'>" +
													"<div class='panel panel-primary'>" +
														"<div class='panel-heading' id='title_size'>" +
															"<div class='col-xs-9 col-sm-9 col-md-10'>" +
																"<h3 class='panel-title' id='qnatitle'>" +
																	decodeURIComponent(json.list[i].title).replace(/\+/gi, ' ') + "</h3>" +
															"</div>" +
															"<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>"+
																decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
																decodeURIComponent(json.list[i].uploader) +
															"</div>" + 
														"</div>" +
														"<div class='panel-body' id='qnaread'>" +
															decodeURIComponent(json.list[i].content).replace(/\+/gi, ' ') +
														"</div>" +
													"</div>" +
												"</a>" +
											"</div>" +
											"<div class='col-xs-2 col-sm-2 col-md-1'>" +
											"</div>" +
											"<div class='col-xs-2 col-md-1 col-sm-2'>" +
											"</div>" +
										"</div>" +
									"</h4>" +
								"</div>" +
									"<div id='collapse"+ i +"' class=' panel-collapse collapse'	role='tabpanel' aria-labelledby='heading"+ i +"'>" +
										"<div class='list-group'>" +
											"<ul id='commentbody" + json.list[i].g_qna_no + "'>" +
											"</ul>" +
										"</div>" +
										"<div class='panel-footer'>" +
											"<div class='col-lg-11 col-md-11 col-sm-11'>" +
												"<input type='text' placeholder='지금, 댓글을 작성해보세요!' id='commenttitle" + json.list[i].g_qna_no + "' class='commenttile'>" +
											"</div>" +
											"<div class='col-lg-1 col-md-1 col-sm-1' id='insertbtn'>" +
												"<input type='button' id='commentinsert' class='btn btn-primary'	onclick='commentInsert(" + json.list[i].g_qna_no + ")' value='작성'>" +
											"</div>" +
										"</div>" +
									"</div>" +
								"</div>";
						}
					}
				$("#search_list").html(values);
			}
		});
	}
	
	function qnashow(){
		$("#qna_list").show();
		$("#search_list").hide();
	}
	
	function commentconfirm(param){// param 으로 gqnano가 넘어옴
		var groupno = "<%= group.getGroupNo() %>";
		var userno = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/gqnacommentselect",
			data: { gqnano: param, groupno: groupno },
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
									"<a onclick='commentDelete(" + json.list[i].comment_no + ", " + json.list[i].gqnano + ")'>" +
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
		var gqnano = param;
		var content = $("#commenttitle"+param).val();
		var user_no = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/gqnacommentinsert",
			data: { gqnano: gqnano, userno: user_no, content: content },
			type: "get",
			dataType: "json",
			async: false
		});
		$("#commenttitle"+param).val("");
		alert("등록되었습니다.");
		commentconfirm(gqnano);
	}
	
	function commentDelete(param, param2){
		var commentno = param;
		var gqnano = param2;
		$.ajax({
			url: "/studyhub/gnacommentdelete",
			data: { commentno: commentno },
			type: "get",
			dataType: "json",
			async: false
		})
		alert("삭제되었습니다.");
		commentconfirm(gqnano);
	}
</script>
<%@ include file="/views/include/common/tail.jsp"%>