<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.studyhub.common.vo.ShareFile"%>
<%
	ArrayList<ShareFile> list = (ArrayList<ShareFile>)request.getAttribute("list");
%>
<!-- 
작성자 : 구미향
내용 : 파일공유 메인 페이지
작성일자 17.10.23
 -->

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css" href="/studyhub/css/fileshareList.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<script src="/studyhub/js/bootstrap.min.js"></script>

<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->


<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
	<!-- Tab -->
	<div class="category-tab">
		<ul class="nav nav-tabs" role="tablist">
		    <li role="presentation" class="active"><a href="#reading" aria-controls="reading" role="tab" data-toggle="tab">Reading</a></li>
		    <li role="presentation"><a href="#listening" aria-controls="listening" role="tab" data-toggle="tab">listening</a></li>
		    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
		    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">+</a></li>
		 </ul>
	</div>
	
	<div role="tabpanel">
  	<!-- Tab panes -->
	  <div class="tab-content">
	    <div role="tabpanel" class="tab-pane active" id="reading">
	    
			<!-- file boxes  -->
			<div class="fileboxes">
				<div class="filebox">
					<a href="/studyhub/views/group/groupFileShare/fileshareWriteform.jsp"><img src="/studyhub/images/plus.png" id="plus-img"></a>
					<br>
					<p>새로운 파일 공유하기</p>
				</div>
				<%
					for (ShareFile sf : list) {
				%>
			
				<div class="filebox">
					<span id="title">
					<a href="/studyhub/sharefiledetail?sfno=<%=sf.getFileNo() %>">
					<% if(sf.getTitle().length()>9){ %>
					<%=sf.getTitle().substring(0, 9) %>..
					<% }else{ %>
					<%=sf.getTitle()%>
					<% } %>
					</a></span>
					
					<hr>
					 <h6><%=sf.getUserName()%></h6> 
					 <h6><%=sf.getUploadDate()%> | 다운로드수:
						<%=sf.getDownloadCount()%> </h6> 
					<h6 id="filename">
					<% if(sf.getFileName().length()>15){ %>
					<%=sf.getFileName().substring(0, 15) %>..
					<% }else{ %>
					<%=sf.getFileName()%>
					<% } %>
					</h6>
					<h6>
						<a href="/studyhub/sharefiledown?ofile=<%=sf.getFileName() %>&rfile=<%=sf.getRenameFileName()%>">
						<button id="download" onclick="download();">download</button></a>
					</h6>
				</div>
		
				<%
					}
				%>
		
				<div class="filebox">
					<h4>title</h4>
					<p>content</p>
					<hr>
					<p>filename</p>
					<p>upload_date</p>
					<button id="download">download</button>
				</div>
			</div>

	    </div>
	    <div role="tabpanel" class="tab-pane" id="listening">contents</div>
	    <div role="tabpanel" class="tab-pane" id="messages">message?s</div>
	    <div role="tabpanel" class="tab-pane" id="+">...</div>
	  </div>
	</div>
	
	

	

</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<%@ include file="/views/include/common/tail.jsp"%>
</body>
</html>