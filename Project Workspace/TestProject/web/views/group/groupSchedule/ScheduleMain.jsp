<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹 일정 메인 페이지
작성일자 17.10.22
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<link rel="stylesheet" href="/studyhub/css/fullcalendar.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">

<script src='/studyhub/js/calendar/jquery.min.js'></script>
<script src='/studyhub/js/calendar/moment.min.js'></script>
<script src='/studyhub/js/calendar/fullcalendar.js'></script>
<!-- 캘린더 js -->
<script src="/studyhub/js/bootstrap.min.js"></script>

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

#modal-body {
	height: 330px;
	padding-left: 50px;
	padding-right: 50px;
	padding-top: 30px;
}

#modaldate {
	width: 80%;
	margin-top: 20px;
	padding-left: 5px;
	padding-right: 5px;
	padding-top: 7px;
}

#modalonoff, #modaltime {
	margin-top: 20px;
	width: 100%;
}

#modaltime {
	width: 35%;
	padding-left: 0px;
	padding-right: 0px;
}

#modalcontent {
	height: 100px;
	width: 100%;
	margin-top: 20px;
}

#modal-tag {
	text-align: center;
	margin-top: 20px;
	font-weight: bold;
	text-size: 14px;
	padding-top: 7px;
}

#hour, #minute {
	width: 60px;
	padding-left: 6px;
	padding-right: 6px;
	display: inline-block;
}

#selectedtime {
	width: 150px;
	display: inline-block;
	margin-top: 20px;
	padding-left: 0px;
	padding-right: 0px;
}
</style>
<%@ include file="/views/include/common/headend.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		<div class="btn btn-default btn-sm col-lg-12 col-md-12"
			id="schedulelist">
			<ul class="list-group" id="list-group">

				<li class="list-group-item" id="list-group-item">
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8" id="day">10월
						25일 수요일</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="time">PM
						3:00</div>
				</li>
				<li class="list-group-item" id='content'>예제)강남역 스타벅스</li>

			</ul>
		</div>
	</div>
	<div id="calendar" class="col-lg-8 col-md-8 col-sm-8 col-xs-8"></div>

	<!-- 모달부분 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">일정 등록</h4>
				</div>
				<div class="modal-body" id="modal-body">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="modal-tag">날짜</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<input type="text" id="modaldate" disabled>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="modal-tag">시간</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<div class="btn-group col-lg-5 col-md-5 col-sm-5 col-xs-5"
							data-toggle="buttons" id="modaltime">
							<label class="btn btn-primary active"> 
								<input type="radio" name="ampm" id="ampm" autocomplete="off" value="AM" checked>AM
							</label>
							<label class="btn btn-primary"> 
								<input type="radio"	name="ampm" id="ampm" autocomplete="off" value="PM"> PM
							</label>
						</div>
						<div id="selectedtime" class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<select class="form-control" id="hour">
								<option value="00">00</option>
								<option value="00">01</option>
								<option value="00">02</option>
								<option value="00">03</option>
								<option value="00">04</option>
								<option value="00">05</option>
								<option value="00">06</option>
								<option value="00">07</option>
								<option value="00">08</option>
								<option value="00">09</option>
								<option value="00">10</option>
								<option value="00">11</option>
							</select> 
								&nbsp; : &nbsp; 
							<select class="form-control" id="minute">
								<option value="00">00</option>
								<option value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
								<option value="50">50</option>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="modal-tag">온/오프라인</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<div class="btn-group" data-toggle="buttons" id="modalonoff">
							<label class="btn btn-primary active"> 
								<input type="radio" name="onoff" id="onoff" autocomplete="off" value="ONLINE" checked>ONLINE
							</label> 
							<label class="btn btn-primary"> 
								<input type="radio" name="onoff" id="onoff" autocomplete="off" value="OFF">OFFLINE
							</label>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<textarea id="modalcontent" placeholder="내용"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary"
						onclick="InsertSchedule()">등록</button>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<script type="text/javascript">
	$(function() {
		/* selectSchedule(); */
		calendar();
	});

	/* 날짜 클릭 이벤트 발생 */
	function calendar() {
		$("#calendar").fullCalendar({
			editable : true,
			eventLimit : true,
			dayClick : function(date, allDay, jsEvent, view) {
				var yy = date.format("YYYY");
				var mm = date.format("MM");
				var dd = date.format("DD");
				if (date.format("dd") == "Mo")
					var ss = "월";
				else if (date.format("dd") == "Tu")
					var ss = "화";
				else if (date.format("dd") == "We")
					var ss = "수";
				else if (date.format("dd") == "Th")
					var ss = "목";
				else if (date.format("dd") == "Fr")
					var ss = "금";
				else if (date.format("dd") == "Sa")
					var ss = "토";
				else
					var ss = "일";
				ss += "요일";
				$("#modaldate").val(yy + "년 " + mm + "월 " + dd + "일 " + ss);
				$("#myModal").modal();

			}
		});
	}
	
	/* 일정 등록 */
	function InsertSchedule() {
		var group = "<%= group.getGroupNo() %>";
		var modaldate = $("#modaldate").val();
		var modalampm = $("input:radio[name=ampm]:checked").val();		
		var modalhour = $("#hour option:selected").val();
		var modalminute = $("minute option:selected").val();
		var modalonoff = $("input:radio[name=onoff]:checked").val();
		
		var queryString = { group_no: groupno, modaldate: modaldate, modalampm: modalampm, modalhour: modalhour, modalminute: modalminute, modalonoff: modalonoff }
		
		$.ajax({
			url: "/studyhub/scheduleinsert",
			data: queryString,
			type: "get",
			dataType: "json",
			success: function(){
				alert("일정이 등록되었습니다.");
				selectSchedule();
			}
		});
	}

	/* 일정 셀렉트 */
	function selectSchedule() {
		var group_no = "<%= group.getGroupNo() %>";
		$.ajax({
			url : "/studyhub/schedulelist",
			data : { group_no : group_no },
			type : "get",
			dataType : "json",
			success : function(data) {
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for ( var i in json.list) {
					values += "<li class='list-group-item' id='list-group-item'>"
							+ "<div class='col-lg-8 col-md-8 col-sm-8 col-xs-8' id='day'>날짜</div>"
							+ "<div class='col-lg-4 col-md-4 col-sm-4 col-xs-4' id='time'>시간</div>"
							+ "</li>" 
							+ "<li class='list-group-item' id='content'>내용</li>";
				}
				$("#schedulelist").html(values);
			}
		});
	}
</script>

<%@ include file="/views/include/common/tail.jsp"%>
