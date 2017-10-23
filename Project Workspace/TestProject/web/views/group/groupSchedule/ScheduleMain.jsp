<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹 일정 메인 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<style type="text/css">
	#schedulelist {
		margin-top: 20px;
	}

	.list-group-item {
		margin-top: 0px;
	}
	
	#list-group {
		padding-top: 10px;
		font-weight: bold;
	}
	
	#list-group-item {
		margin-top: 10px;
		height: 40px;
		background-color: #004157;
		color: white;
	}
	
	#day {
		text-align: left;
		padding-left: 0px;
	}
	
	#time {
		text-align: right;
	}
	
	#content {
		text-align: left;
	}
	
	.modal-header {
		background-color: #004157;
		color: white;
	}
	
</style>

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>
<link rel="stylesheet" href="/studyhub/css/fullcalendar.css"> <!-- 달력 css -->
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">

<!-- 메인 컨텐츠 -->

<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		<div class="btn btn-default btn-sm col-lg-12 col-md-12" id="schedulelist">
			<ul class="list-group" id="list-group">
			  
			  <li class="list-group-item" id="list-group-item">
			  	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8" id="day">10월 25일 수요일</div>
			  	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="time">PM 3:00</div>
			  </li>
			  <li class="list-group-item" id='content'>강남역 스타벅스</li>
			
			</ul>
		</div>
	</div>
	<div id="calendar" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
	</div>
	
	<!-- 모달테스트 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">간편 일정 등록</h4>
	      </div>
	      <div class="modal-body">
			
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary">일정 등록</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>

<script src='/studyhub/js/calendar/jquery.min.js'></script>
<script src='/studyhub/js/calendar/moment.min.js'></script>

<script src='/studyhub/js/calendar/fullcalendar.js'></script> <!-- 캘린더 js -->
<script src="/studyhub/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function (){
		/* selectSchedule(); */
		calendar();
	});
	
	/* 날짜 클릭 이벤트 발생 */
	function calendar(){
		$("#calendar").fullCalendar({
			editable: true,
			eventLimit: true,
			dayClick: function(date, allDay, jsEvent, view) {
				var yy = date.format("YYYY");
				var mm = date.format("MM");
				var dd = date.format("DD");
				if(date.format("dd") == "Mo")
					var ss = "월";
				else if(date.format("dd") == "Tu")
					var ss = "화";
				else if(date.format("dd") == "We")
					var ss = "수";
				else if(date.format("dd") == "Th")
					var ss = "목";
				else if(date.format("dd") == "Fr")
					var ss = "금";
				else if(date.format("dd") == "Sa")
					var ss = "토";
				else
					var ss = "일";
				ss += "요일";
				$(".modal-body").html(yy + "년 " + mm + "월 " + dd + "일 " + ss);
				$("#myModal").modal();
				
			}
		});
	}
	
	/* 일정 셀렉트 */
	function selectSchedule(){
		var groupno = <%= group.getGroupNo() %>;
		$.ajax({
			url: "/studyhub/schedulelist",
			data: {group_no: group_no},
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					values += 
						"<li class='list-group-item' id='list-group-item'>" +
					  		"<div class='col-lg-8 col-md-8 col-sm-8 col-xs-8' id='day'>날짜</div>" +
					  		"<div class='col-lg-4 col-md-4 col-sm-4 col-xs-4' id='time'>시간</div>" +
					  	"</li>"
					  	"<li class='list-group-item' id='content'>내용</li>";
				}
				$("#schedulelist").html(values);
			}
		});
	}
</script>
