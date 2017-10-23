<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.*, com.studyhub.common.vo.ShareFile"%>
<% ArrayList<ShareFile> list = (ArrayList<ShareFile>)request.getAttribute("list"); %>
<!-- 
작성자 : 구미향
내용 : 파일공유 메인 페이지
작성일자 17.10.23
 -->
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/studyhub/css/fileshare.css">
</head>
<body >
    <!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>
<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp" %>

<!-- 메인 컨텐츠 -->

<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
	
		<div class="category-tab">
		<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">tab1</a></li>
  <li role="presentation"><a href="#">tab2</a></li>
  <li role="presentation"><a href="#">+</a></li>
</ul>
		</div>
		<% for (ShareFile sf : list){ %>
		<div class="fileboxes">
		<div class="filebox">
		<h4><%= sf.getTitle() %></h4>
		<p><%= sf.getContent() %></p>
		<hr>
		<h6><%= sf.getUserName() %></h6>
		<h6><%= sf.getUploadDate() %></h6>
		<h6><%= sf.getFileName()%> | 다운로드수: <%= sf.getDownloadCount()%></h6>
		<h6><button id="download">download</button></h6>
		</div>
		
		<% } %>
		
		<div class="filebox">
		<h4>title</h4>
		<p>content</p>
		<hr>
		<p>filename</p>
		<p>upload_date</p>
		<button id="download">download</button>
		</div>
		
		<div class="filebox">
		<h4>title</h4>
		<p>content</p>
		<hr>
		<p>filename</p>
		<p>upload_date</p>
		<button id="download">download</button>
		</div>
		
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
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<%@ include file="/views/include/common/headend.jsp"%>
</body>
</html>