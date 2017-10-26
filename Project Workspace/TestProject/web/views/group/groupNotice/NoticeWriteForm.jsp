<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 윤찬호
내용 : 그룹공지 작성 페이지
작성일자 17.10.19
 -->

<!-- java 구문 -->
<%@ page import="java.util.*, com.studyhub.common.vo.GNotice"%>
<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>

<style>
#btns {
	float: right;
}

#layout {
	margin-top: 8vh;
}
</style>
<script type="text/javascript">
	function CheckForm(access){
		var isAccessChk = false;
		var arr_Access = document.getElementsByName("accessno");
		for(var i = 0; i<arr_Access.length; i++){
			if(arr_Access[i].checked == true){
				isAccessChk = true;
				break;
				
			}
		}
		if(!isAccessChk){
			alert("공개 범위를 선택해주세요");
			return false;
		}
	}


</script>

<%@ include file="/views/include/common/headend.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="row" id="layout">
	<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-1">
		<h2>그룹 공지 작성</h2>
		<br>
		<form action="/studyhub/gnoticecreate" method="post">
			<div class="form-group">
				<label for="title">제목</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					name="title" 
					aria-describedby="emailHelp" placeholder="제목을 입력하세요">
			</div>
			<div class="range">
				<label for="Content">공개범위</label> <label class="radio-inline">
					<input type="radio" name="accessno" id="inlineRadio1" value="1">
					전체공개
				</label> <label class="radio-inline"> <input type="radio"
					name="accessno" id="inlineRadio2" value="2"> 회원공개
				</label> <label class="radio-inline"> <input type="radio"
					name="accessno" id="inlineRadio3" value="3"> 그룹원공개
				</label>
			</div>
			<div class="form-group">
				<label for="Content">내용</label>
				<textarea class="form-control" id="Textarea" rows="15"
				name="content" placeholder="내용을 입력하세요"></textarea>
			</div>
			<input type="hidden" name="uploader" value="<%=user.getUserNo() %>">
			<input type="hidden" name="groupno" value="<%=group.getGroupNo() %>">
			<input type="submit" value="제출하기" class = "btn btn-info" id="btns"> <a
				href="/studyhub/gnoticepreview?groupno=<%=group.getGroupNo()%>">목록으로
				이동</a>
		</form>
	</div>	
</div>



	<!-- /메인 컨텐츠 -->

	<!--푸터 부분-->
	<%@ include file="/views/include/main/footer.jsp"%>
	<!--페이지 끝-->
	<%@ include file="/views/include/common/tail.jsp"%>