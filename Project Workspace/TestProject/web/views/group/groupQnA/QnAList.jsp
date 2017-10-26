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
		margin-top: 20px;
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

	

</style>
<!--헤더 부분-->
<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>


<!-- 메인 컨텐츠 -->
<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
	<div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3">
		<div class="input-group" data-toggle="tooltip" data-placement="top" title="검색어 입력시 자동으로 데이터를 가져옵니다!">
			<span class="input-group-addon" id="basic-addon1"> <span
				class="glyphicon glyphicon-search"></span>
			</span> <input type="text" class="form-control"	placeholder="<%=user.getUserName()%> 님 검색어를 입력하세요!" id="qnasearch" aria-describedby="basic-addon1" oninput="qnasearch()" onblur="qnashow()">
		</div>
	</div>

	<div class="col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1">
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

	<div id="qna_list">
		<!-- ajax  -->
	</div>
	
	<div id="search_list">
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
	$(function(){
		selectQnA();
		$('[data-toggle="tooltip"]').tooltip();
		$("#qna_list").show();
		$("#search_list").hide();
	});

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
			selectQnA();
			return true
		}
	}
	
	function selectQnA(){
		var group_no = "<%= group.getGroupNo() %>";
		var user_no = "<%= user.getUserNo() %>";
		$.ajax({
			url: "/studyhub/selectgroupqna",
			data: { groupno: group_no },
			type: "get",
			datatype: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					if(user_no == json.list[i].user_no){
					values += 
						"<div class='col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1'>" +		
							"<div class='btn btn-default btn-sm' id='read'>" +
								"<form method='post' name='fr' id='qnainsertform' action=''>" +
									"<div class='col-xs-10 col-sm-10 col-md-11'>" +
							            "<div class='panel panel-primary' >" +
										  "<div class='panel-heading' id='title_size'>" +
										  	"<div class='col-xs-9 col-sm-9 col-md-10'>" +
										  		"<h3 class='panel-title' id='qnatitle'>" +
										    		decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
										    	"</h3>" +
										  	"</div>" +
										    "<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>" +
										    	decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
										    	decodeURIComponent(json.list[i].uploader) +
										    "</div>" +
										  "</div>" +
										  "<div class='panel-body' id='qnaread'>" +
										  		decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
										  "</div>" +
										"</div>" +
							        "</div>" +
									"<div class='col-xs-2 col-sm-2 col-md-1'>" +
										"<input type='button' id='qnaupdatebtn' name='qnaupdatebtn' class='btn btn-primary' value='수정' onclick='selectOne(" + json.list[i].g_qna_no + ");'>" +
									"</div>" +
									"<div class='col-xs-2 col-md-1 col-sm-2'>" +
										"<input type='button' id='qnadeletebtn' name='qnadeletebtn' class='btn btn-primary' value='삭제' onclick='deleteQnA(" + json.list[i].g_qna_no + ");'>" +
									"</div>" +		
								"</form>" +
							"</div>" +
							"<br>" +
						"</div>";
					}
					else {
						values += 
							"<div class='col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1'>" +		
								"<div class='btn btn-default btn-sm' id='read'>" +
									"<form method='post' name='fr' id='qnainsertform' action=''>" +
										"<div class='col-xs-10 col-sm-10 col-md-11'>" +
								            "<div class='panel panel-primary' >" +
											  "<div class='panel-heading' id='title_size'>" +
											  	"<div class='col-xs-9 col-sm-9 col-md-10'>" +
											  	"<div>" +
											  		"<input type='test' value='"+ json.list[i].g_qna_no +"' id='g_qna_no'>" +
											  	"</div>" +
											  		"<h3 class='panel-title' id='qnatitle'>" +
											    		decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
											    	"</h3>" +
											  	"</div>" +
											    "<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>" +
											    	decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
											    	decodeURIComponent(json.list[i].uploader) +
											    "</div>" +
											  "</div>" +
											  "<div class='panel-body' id='qnaread'>" +
											  		decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
											  "</div>" +
											"</div>" +
								        "</div>" +
									"</form>" +
								"</div>" +
								"<br>" +
							"</div>";
					}
				}
				$("#qna_list").html(values);
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
		selectQnA();
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
		selectQnA();
	}
	
	function qnasearch(){
		$("#qna_list").hide();
		$("#search_list").show();
		var groupno = "<%= group.getGroupNo() %>";
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
							"<div class='col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1'>" +		
								"<div class='btn btn-default btn-sm' id='read'>" +
									"<form method='post' name='fr' id='qnainsertform' action=''>" +
										"<div class='col-xs-10 col-sm-10 col-md-11'>" +
								            "<div class='panel panel-primary' >" +
											  "<div class='panel-heading' id='title_size'>" +
											  	"<div class='col-xs-9 col-sm-9 col-md-10'>" +
											  		"<h3 class='panel-title' id='qnatitle'>" +
											    		decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
											    	"</h3>" +
											  	"</div>" +
											    "<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>" +
											    	decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
											    	decodeURIComponent(json.list[i].uploader) +
											    "</div>" +
											  "</div>" +
											  "<div class='panel-body' id='qnaread'>" +
											  		decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
											  "</div>" +
											"</div>" +
								        "</div>" +
										"<div class='col-xs-2 col-sm-2 col-md-1'>" +
											"<input type='button' id='qnaupdatebtn' name='qnaupdatebtn' class='btn btn-primary' value='수정' onclick='selectOne(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +
										"<div class='col-xs-2 col-md-1 col-sm-2'>" +
											"<input type='button' id='qnadeletebtn' name='qnadeletebtn' class='btn btn-primary' value='삭제' onclick='deleteQnA(" + json.list[i].g_qna_no + ");'>" +
										"</div>" +		
									"</form>" +
								"</div>" +
								"<br>" +
							"</div>";
						}
						else {
							values += 
								"<div class='col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1'>" +		
									"<div class='btn btn-default btn-sm' id='read'>" +
										"<form method='post' name='fr' id='qnainsertform' action=''>" +
											"<div class='col-xs-10 col-sm-10 col-md-11'>" +
									            "<div class='panel panel-primary' >" +
												  "<div class='panel-heading' id='title_size'>" +
												  	"<div class='col-xs-9 col-sm-9 col-md-10'>" +
												  	"<div>" +
												  		"<input type='test' value='"+ json.list[i].g_qna_no +"' id='g_qna_no'>" +
												  	"</div>" +
												  		"<h3 class='panel-title' id='qnatitle'>" +
												    		decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") +
												    	"</h3>" +
												  	"</div>" +
												    "<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>" +
												    	decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
												    	decodeURIComponent(json.list[i].uploader) +
												    "</div>" +
												  "</div>" +
												  "<div class='panel-body' id='qnaread'>" +
												  		decodeURIComponent(json.list[i].content).replace(/\+/gi, " ") +
												  "</div>" +
												"</div>" +
									        "</div>" +
										"</form>" +
									"</div>" +
									"<br>" +
								"</div>";
						}
					}
			}
			$("#search_list").html(values);
		});
	}
	
	function qnashow(){
		$("#qna_list").show();
		$("#search_list").hide();
	}
</script>
<%@ include file="/views/include/common/tail.jsp"%>