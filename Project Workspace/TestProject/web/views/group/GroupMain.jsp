<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 양동균
내용 : 그룹메인 페이지
작성일자 17.10.16
 -->
<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>

<%@ include file="/views/include/common/headend.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>

<!-- 메인 컨텐츠 -->
<div class="container col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
	<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<h3><%= group.getGroupName() %>
			<div id="groupinfo">
			<!-- ajax로 불러옴 -->
			</div>
		</h3>
		
		내 권한 <%= group.getAuthorityNo() %>
	</div>
</div>

<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<script type="text/javascript">
	$(function(){
		var groupno = "<%= group.getGroupNo() %>";
		var reset = "1";
		
		var querystring = { "group_no": groupno, "reset": reset };
		$.ajax({
			url: "/studyhub/gmainpreview",
			data: querystring,
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data))
				var values = "";
				if(json.group_no > 0){
					values += 
						"<small>" +
							"그룹장 : " + decodeURIComponent(json.user_name) + 
							" / 그룹원 : " + json.membercount +
							" 명 / 스터디 분야 : " + decodeURIComponent(json.category_name) +
							" / 스터디 지역 : " + decodeURIComponent(json.location) +
							" / 스터디 형식 : " + decodeURIComponent(json.attribute_name) +
						"</small>";
				}
				$("#groupinfo").html(values);
			},
			error: function(){
				alert("에러");
			}
		});
		
		
	});
</script>

<%@ include file="/views/include/common/tail.jsp"%>