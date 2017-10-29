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
	padding-left: 7px;
	padding-right: 7px;
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

#time, #meeting_onoff {
	text-align: right;
	padding-right: 6px;
}

#content {
	text-align: left;
	height: 40px;
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

#modalonoff, #modalonoff2, #modaltime, #modaltime2 {
	margin-top: 20px;
	width: 100%;
}

#modaltime, #modaltime2 {
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

#meeting_name {
	padding-left: 7px;
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

.fc-event, .fc-event-dot {
    background-color: #004157;
}

.fc-event {
    position: relative;
    display: block;
    font-size: .85em;
    line-height: 1.3;
    border-radius: 3px;
    border: 1px solid #2c7598;
}
</style>

<%@ include file="/views/include/common/headend.jsp"%>

<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
	<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
		<div class="btn btn-default btn-sm col-lg-12 col-md-12"
			id="schedulelist">
			<ul class="list-group" id="list-group">
				<!-- ajax로 일정목록을 불러옴 -->
			</ul>
		</div>
	</div>
	<div id="calendar" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
		<!-- 캘린더 ajax -->
	</div>
</div>

	<!-- 모달부분 -->
	<div class="modal fade" id="dkmodal" tabindex="-1" role="dialog"
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
						<input type="hidden" id="sc_no">
						<input type="hidden" id="datetype_date">
						
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="modal-tag">시간</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<div class="btn-group col-lg-5 col-md-5 col-sm-5 col-xs-5" data-toggle="buttons" id="modaltime">
							<label class="btn btn-primary active"> 
								<input type="radio" name="ampm" id="ampm" autocomplete="off" value="AM" checked>AM
							</label> 
							<label class="btn btn-primary"> 
								<input type="radio"	name="ampm" id="ampm" autocomplete="off" value="PM">PM
							</label>
						</div>
						
						<div class="btn-group col-lg-5 col-md-5 col-sm-5 col-xs-5" data-toggle="buttons" id="modaltime2">
							<label class="btn btn-primary"> 
								<input type="radio" name="ampm" id="ampm" autocomplete="off" value="AM" checked>AM
							</label> 
							<label class="btn btn-primary active"> 
								<input type="radio"	name="ampm" id="ampm" autocomplete="off" value="PM">PM
							</label>
						</div>
						<div id="selectedtime" class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<select class="form-control" id="hour">
								<option value="00">00</option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
							</select> &nbsp; : &nbsp; <select class="form-control" id="minute">
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
								<input type="radio" name="onoff" id="onoff" autocomplete="off" value="OFFLINE">OFFLINE
							</label>
						</div>
						
						<div class="btn-group" data-toggle="buttons" id="modalonoff2">
							<label class="btn btn-primary"> 
								<input type="radio" name="onoff" id="onoff" autocomplete="off" value="ONLINE" checked>ONLINE
							</label> 
							<label class="btn btn-primary active"> 
								<input type="radio" name="onoff" id="onoff" autocomplete="off" value="OFFLINE">OFFLINE
							</label>
						</div>
						
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<textarea id="modalcontent" placeholder="내용"></textarea>
					</div>
				</div>
				<div class="modal-footer" id="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="InsertSchedule();" id="insertbtn">등록</button>
					<button type="button" class="btn btn-primary" onclick="deleteSchedule();" id="deletebtn">삭제</button>
					<button type="button" class="btn btn-primary" onclick="updateSchedule();" id="updatebtn">수정</button>
				</div>
			</div>
		</div>
	</div>


<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<script type="text/javascript">
	var authority = "<%= group.getAuthorityNo() %>";
	$(function() {
		selectSchedule();
		calendar();
	});

	/* 날짜 클릭 이벤트 발생 */
	function calendar() {
		var output = JSON.stringify(dateoutput());
		console.log(output);
		$("#calendar").fullCalendar({
			eventLimit : true,
			 header: {
		            left: 'prev,today,next',
		            center: 'title',
		            right: 'month'
		     },
		    events: dateoutput(),
			dayClick : function(date, allDay, jsEvent, view) {
				var yy = date.format("YYYY");
				var mm = date.format("MM");
				var dd = date.format("DD");
				var datetype = date.format("YYYY-MM-DD");
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
				$("#datetype_date").val(datetype);
				$("#modaltime").show();
				$("#modaltime2").hide();
				$("#modalonoff").show();
				$("#modalonoff2").hide();
				$("#hour").val("00").prop("seleted", true);
				$("#minute").val("00").prop("seleted", true);
				$("#modalcontent").val("");
				if( authority == 2)
					$("#insertbtn").show();
				else
					$("#insertbtn").hide();
				$("#deletebtn").hide();
				$("#updatebtn").hide();				
				$("#dkmodal").modal();

			}
		});
	}	
	
	/* 날짜에 일정 출력 */
	function dateoutput(){
		var group_no = "<%= group.getGroupNo() %>";
		var jsonlist = new Array();
		$.ajax({
			url: "/studyhub/dateschedule",
			data: { group_no: group_no },
			type: "get",
			dataType: "json",
			async: false,
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				for ( var i in json.list) {
					var jsondata = new Object();
					jsondata.start = decodeURIComponent(json.list[i].start);
					var replacetitle = decodeURIComponent(json.list[i].title).replace(/\+/gi, " ");
					jsondata.title = replacetitle;
					
					jsonlist.push(jsondata);
					console.log(jsondata);
				}
			}
		});
		return jsonlist;
	}
	
	/* 일정 리스트클릭 */
	function selectOne(data){
		$.ajax({
			url: "/studyhub/scheduleselectone",
			data: { scheduleno: data },
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				var meetingDate = "";
				var ampm = "";
				var hour = "";
				var minute = "";
				var onoff = "";
				var meetingName = "";
				var scno = "";
				for ( var i in json.list) {
					meetingDate += decodeURIComponent(json.list[i].meeting_date);
					ampm += decodeURIComponent(json.list[i].ampm);
					hour += decodeURIComponent(json.list[i].hour);
					minute += decodeURIComponent(json.list[i].minute);
					onoff += decodeURIComponent(json.list[i].onoff);
					meetingName += decodeURIComponent(json.list[i].meeting_name);
					scno += json.list[i].schedule_no;
				}
				
				meetingDate = meetingDate.replace(/\+/gi, " ");
				
				$("#sc_no").val(scno);
				$("#modaldate").val(meetingDate);
				if(ampm == "PM"){
					$("#modaltime").hide();
					$("#modaltime2").show();
				} else {
					$("#modaltime2").hide();
					$("#modaltime").show();
				}
				$("#hour").val(hour).prop("seleted", true);
				$("#minute").val(minute).prop("seleted", true);
				if(onoff = "ONLINE"){
					$("#modalonoff").show();
					$("#modalonoff2").hide();
				} else {
					$("#modalonoff").hide();
					$("#modalonoff2").show();
				}
				$("#modalcontent").val(meetingName);
				$("#insertbtn").hide();
				if( authority == 2){
					$("#deletebtn").show();
					$("#updatebtn").show();
				} else {
					$("#deletebtn").hide();
					$("#updatebtn").hide();
				}
				$("#dkmodal").modal();
			}
		});
	}
	
	/* 일정 등록 */
	function InsertSchedule() {
		var groupno = "<%=group.getGroupNo()%>";
		var datetype =	$("#datetype_date").val();
		var modaldate = $("#modaldate").val();
		var modalampm = $("input:radio[name=ampm]:checked").val();		
		var modalhour = $("#hour option:selected").val();
		var modalminute = $("#minute option:selected").val();
		var modalonoff = $("input:radio[name=onoff]:checked").val();
		var modalcontent = $("#modalcontent").val();
		
		var queryString = { group_no: groupno, modaldate: modaldate, modalampm: modalampm, modalhour: modalhour, modalminute: modalminute, modalonoff: modalonoff, modalcontent: modalcontent, datetype_date: datetype };
		
		$.ajax({
			url: "/studyhub/scheduleinsert",
			data: queryString,
			type: "get",
			dataType: "json"
		});
		alert("일정이 등록되었습니다.");
		$("#dkmodal").modal("hide");
		selectSchedule();
		calendar();
	}
	
	/* 일정 수정 */
	function updateSchedule() {
		var scheduleno = $("#sc_no").val();
		var groupno = "<%=group.getGroupNo()%>";
		var modaldate = $("#modaldate").val();
		var modalampm = $("input:radio[name=ampm]:checked").val();		
		var modalhour = $("#hour option:selected").val();
		var modalminute = $("#minute option:selected").val();
		var modalonoff = $("input:radio[name=onoff]:checked").val();
		var modalcontent = $("#modalcontent").val();
		
		var queryString = { schedule_no: scheduleno, group_no: groupno, modaldate: modaldate, modalampm: modalampm, modalhour: modalhour, modalminute: modalminute, modalonoff: modalonoff, modalcontent: modalcontent };
		$.ajax({
			url: "/studyhub/scheduleupdate",
			data: queryString,
			type: "get",
			dataType: "json"
		});
		alert("일정이 수정되었습니다.");
		$("#dkmodal").modal("hide");
		selectSchedule();
		calendar();
	}
	
	/* 일정 삭제 */
	function deleteSchedule() {
		var scheduleno = $("#sc_no").val();
		$.ajax({
			url: "/studyhub/scheduledelete",
			data: { schedule_no: scheduleno },
			type: "get",
			dataType: "json"
		});
		alert("일정이 삭제되었습니다.");
		$("#dkmodal").modal("hide");
		selectSchedule();
		calendar();
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
							var replace = decodeURIComponent(json.list[i].meeting_date).replace(/\+/gi, ' ');
							values += 
								"<div onclick='selectOne(" + json.list[i].schedule_no + ");'>" +
									"<li class='list-group-item' id='list-group-item'>" +
										"<input type='hidden' value='" + json.list[i].schedule_no + "'>" +
										"<div class='col-lg-8 col-md-8 col-sm-8 col-xs-8' id='day'>" +
											replace +
										"</div>" +
										"<div class='col-lg-4 col-md-4 col-sm-4 col-xs-4' id='time'>" +
											decodeURIComponent(json.list[i].ampm) + "&nbsp;" +
											decodeURIComponent(json.list[i].hour) + " : " +
											decodeURIComponent(json.list[i].minute) +
										"</div>" +
									"</li>" +
									"<li class='list-group-item' id='content'>" +
										"<div class='col-lg-8 col-md-8 col-sm-8 col-xs-8' id='meeting_name'>" +
											decodeURIComponent(json.list[i].meeting_name).replace(/\+/gi, " ") +
										"</div>" +
										"<div class='col-lg-4 col-md-4 col-sm-4 col-xs-4' id='meeting_onoff'>" +
											decodeURIComponent(json.list[i].onoff) +
										"</div>" +
									"</li>" +
								"</div>"
						}
						$("#list-group").html(values);
					}
				});
	}
</script>

<%@ include file="/views/include/common/tail.jsp"%>
