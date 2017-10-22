<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹 일정 메인 페이지
작성일자 17.10.19
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>

<!-- 메인 컨텐츠 -->

<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="schedulelist">
	</div>
	<div id="calendar" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
	</div>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>

<script type="text/javascript">
	$(function (){
		selectSchedule();
		calendar();
	});
	
	function calendar(){
		$("#calendar").fullCalendar({
			
		})
	});
	
	function selectSchedule(){
		var group_no = <%= group.getGroupNo() %>;
		$.ajax({
			url: "/studyhub/schedulelist",
			data: {groupno: group_no},
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					values += "";
				}
				$("#schedulelist").html(values);
			}
		});
	}
</script>
