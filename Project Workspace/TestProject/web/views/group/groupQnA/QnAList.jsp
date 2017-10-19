<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : OOO
내용 : OO 페이지
작성일자 17.10.02
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
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

</style>
<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>
<!-- 메인 컨텐츠 -->

<div class="container">
<div class="col-md-5 col-sm-5 col-sm-offset-3 col-md-offset-3">
		<div class="btn btn-default btn-sm" id="serach">
			검색 들어갈 자리
		</div>
	</div>
	
	<div class="col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1">		
		<div class="btn btn-default btn-sm" id="write">
			<form method="post" name="fr" id="qnainsertform" action="">
				<input type="hidden" name="userno" id="userno" value="<%= user.getUserNo() %>">
				<input type="hidden" name="groupno" id="groupno" value="<%= group.getGroupNo() %>">
				<div class="col-xs-10 col-md-11 col-sm-10">
		                   <input type="text" class="form-control" aria-describedby="sizing-addon1" placeholder="질문할 제목을 입력하세요." id="title">				</div>
				<div class="col-xs-2 col-md-1 col-sm-2">
					<input type="button" id="qnainsertbtn" name="qnainsertbtn" class="btn btn-primary" value="등록" onclick="return insertqna();">
				</div>
				<div class="col-xs-10 col-md-11 col-sm-10">
		                   <textarea rows="4" class="form-control" placeholder="<%= user.getUserName() %>님 무엇이 궁금하세요?" id="content"></textarea>
				</div>
			</form>
		</div>
		<br> <!-- 글 간의 간격 -->
	</div>
	
	<div id="qna_list">
		<!-- ajax  -->
	</div>
</div>
	
	



<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>

<script type="text/javascript">
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
			return true
		}
	}
	
	$(function selectQnA(){
		var group_no = "<%= group.getGroupNo() %>";
		$.ajax({
			url: "/studyhub/selectgroupqna",
			data: { groupno: group_no },
			type: "get",
			datatype: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					values += 
						"<div class='col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1'>" +		
							"<div class='btn btn-default btn-sm' id='read'>" +
								"<form method='post' name='fr' id='qnainsertform' action=''>" +
									"<div class='col-xs-10 col-sm-10 col-md-11'>" +
							            "<div class='panel panel-primary' >" +
										  "<div class='panel-heading' id='title_size'>" +
										  	"<div class='col-xs-9 col-sm-9 col-md-10'>" +
										  		"<h3 class='panel-title' id='qnatitle'>" +
										    		decodeURIComponent(json.list[i].title) +
										    	"</h3>" +
										  	"</div>" +
										    "<div class='col-xs-3 col-sm-3 col-md-2' id='uploader'>" +
										    	decodeURIComponent(json.list[i].uploaddate) + "&nbsp" +
										    	decodeURIComponent(json.list[i].uploader) +
										    "</div>" +
										  "</div>" +
										  "<div class='panel-body' id='qnaread'>" +
										  		decodeURIComponent(json.list[i].content) +
										  "</div>" +
										"</div>" +
							        "</div>" +
									"<div class='col-xs-2 col-sm-2 col-md-1'>" +
										"<input type='button' id='qnaupdatebtn' name='qnaupdatebtn' class='btn btn-primary' value='수정' onclick='insertqna();''>" +
									"</div>" +
									"<div class='col-xs-2 col-md-1 col-sm-2'>" +
										"<input type='button' id='qnadeletebtn' name='qnadeletebtn' class='btn btn-primary' value='삭제' onclick='insertqna();'>" +
									"</div>" +
								"</form>" +
							"</div>" +
							"<br>" +
						"</div>";
				}
				$("#qna_list").html(values);
			},
			error: function(xhr,status,error){
				alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);
			}
		});
	});
</script>

<!-- /동균 -->