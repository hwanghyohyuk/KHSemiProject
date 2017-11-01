<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.studyhub.common.vo.ShareFile"%>
<%
	ArrayList<ShareFile> list = (ArrayList<ShareFile>) request.getAttribute("list");
	ArrayList<ShareFile> clist = (ArrayList<ShareFile>) request.getAttribute("clist");
	int listCount = ((Integer) request.getAttribute("listCount"));
	int currentPage = ((Integer) request.getAttribute("currentPage"));
	int startPage = ((Integer) request.getAttribute("startPage"));
	int endPage = ((Integer) request.getAttribute("endPage"));
	int maxPage = ((Integer) request.getAttribute("maxPage"));
%>
<!-- 
작성자 : 구미향
내용 : 파일공유 메인 페이지
작성일자 17.10.23
 -->

<!--헤더 부분-->
<%@ include file="/views/include/common/head.jsp"%>

<!--자바스크립트 및 CSS-->
<link rel="stylesheet" type="text/css"
	href="/studyhub/css/fileshareList.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.min.css">
<script src='/studyhub/js/bootstrap.min.js'></script>


<!-- /head , body -->
<%@ include file="/views/include/common/headend.jsp"%>

<%@ include file="/views/include/main/header.jsp"%>
<%@ include file="/views/include/group/nav.jsp"%>

<!-- 메인 컨텐츠 -->

<div class="container">
	<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12" id="fswrapper">
	<h3 id="head-text">파일공유하기</h3>
		<!-- Tab -->
		<div class="category-tab">
			<ul class="nav nav-tabs" id="nav-ul">
				<%
					for (ShareFile c : clist) {
						if(c == clist.get(0)){ //게시판에 들어왔을 때 맨 첫번째탭 활성화 
				%>
				<li class="active">
				<a
					href="#category<%=c.getFileCategoryNo()%>"
					aria-controls="category<%=c.getFileCategoryNo()%>" role="tab" id="tab"
					data-toggle="tab"> <%=c.getFileCategoryName()%></a>
				</li>
				<% }else{ %>
				<li>
				<a href="#category<%=c.getFileCategoryNo()%>"
					aria-controls="category<%=c.getFileCategoryNo()%>" role="tab" id="tab"
					data-toggle="tab"> <%=c.getFileCategoryName()%></a>
				</li>
				
				<% }} %>

				<!-- 그룹장만 보이는 settings. 카테고리 추가, 삭제, 수정  -->
				<%
					if (group.getAuthorityNo() == 2) {
				%>
				<li><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab"> <span class="glyphicon glyphicon-cog"
						aria-hidden="true"></span></a></li>
				<% } %>

			</ul>
			<!-- 새 그룹에 카테고리가 없을 시  -->
		<% if(clist.isEmpty()==true){ %>
					<p>그룹장은 설정을 클릭하여 카테고리를 추가해주세요!</p>
		<% } %>
		</div>
		

		<!-- <div role="tabpanel"> -->
		<!-- 카테고리(탭) 하나씩 -->

		<div class="tab-content">
		
			<%
				for (ShareFile c : clist) {
					if(c == clist.get(0)){  //기본카테고리(탭 active)
			%>
			<div class="tab-pane fade in active"
				id="category<%=c.getFileCategoryNo()%>">

				<!-- search bar -->
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<form action="/studyhub/sharefilesearch" method="post"
						id="search-area">
						<input type="search" autocomplete name="keyword" length="15"
							placeholder="제목 또는 파일이름..." id="search-input" oninput="filesearch();"> <input
							type="submit" value="검색" id="search-btn"
							class="glyphicon glyphicon-search">
						<input type="hidden" name="groupno" value="<%=group.getGroupNo() %>">
					</form>
				</div>
				<hr id="fileboxline">
				<!-- file boxes  -->
				<div class="fileboxes">
					<div class="filebox">
						<a href="/studyhub/sharefileinsertview?no=<%=group.getGroupNo()%>"><img
							src="/studyhub/images/plus.png" id="plus-img"></a> <br>
						<p>새로운 파일 공유하기</p>
					</div>
					<%
						for (ShareFile sf : list) {
								if (c.getFileCategoryName().equals(sf.getFileCategoryName())) { //각 카테고리에 속한 파일만 뜨도록.다뜨는게아니라.. 
					%>

					<div class="filebox">
						<span id="title"> <a
							href="/studyhub/sharefiledetail?sfno=<%=sf.getFileNo()%>"> <%
 							if (sf.getTitle().length() > 9) {
 								%>
								<%=sf.getTitle().substring(0, 9)%>.. <%
									} else {
								%> <%=sf.getTitle()%>
								<%
									}
								%>
						</a></span>

						<hr>
						<h6><%=sf.getUserName()%></h6>
						<h6><%=sf.getUploadDate()%>
							| 다운로드수:
							<%=sf.getDownloadCount()%>
						</h6>
						<h6 id="filename">
							<%
								if (sf.getFileName().length() > 15) {
							%>
							<%=sf.getFileName().substring(0, 15)%>..
							<%
								} else {
							%>
							<%=sf.getFileName()%>
							<%
								}
							%>
						</h6>
						<h6>
							<a
								href="/studyhub/sharefiledown?ofile=<%=sf.getFileName()%>&rfile=<%=sf.getRenameFileName()%>">
								<button id="download" onclick="download();">download</button>
							</a>
						</h6>
					</div>

					<!-- 예시 div... <div class="filebox">
					<h4>title</h4>
					<p>content</p>
					<hr>
					<p>filename</p>
					<p>upload_date</p>
					<button id="download">download</button>
				</div> -->
					<%
						}
							}
					%>
				</div>

				<div
					class="col-md-8 col-md-offset-5 col-lg-8 col-lg-offset-5 col-sm-8 col-sm-offset-5 col-xs-8 col-xs-offset-5">
					<div id="pagination">
						<%
							if (currentPage <= 1) {
						%>
						<span> ◀◀ &nbsp; </span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=currentPage - 1%>&groupno=<%=group.getGroupNo()%>">◀◀&nbsp;</a>
						<%
							}
						%>

						<%
							for (int p = startPage; p <= endPage; p++) {
									if (p == currentPage) {
						%>
						<span>[<%=p%>]
						</span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=p%>&groupno=<%=group.getGroupNo()%>"><%=p%></a>
						<%
							}
								}
						%>

						<%
							if (currentPage >= maxPage) {
						%>
						<span>&nbsp; ▶▶ </span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=currentPage + 1%>&groupno=<%=group.getGroupNo()%>">&nbsp;▶▶</a>
						<%
							}
						%>
					</div>
				</div>


			</div>
			<%
				}else{
			%>
			<!-- 사용자가 추가한 카테고리들  -->
			<div class="tab-pane fade"  
				id="category<%=c.getFileCategoryNo()%>">

				<!-- search bar -->
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<form action="/studyhub/sharefilesearch" method="post"
						id="search-area">
						<input type="search" autocomplete name="keyword" length="15"
							placeholder="제목 또는 파일이름..." id="search-input"> <input
							type="submit" value="검색" id="search-btn"
							class="glyphicon glyphicon-search">
					</form>
				</div>
				<hr id="fileboxline">
				<!-- file boxes  -->
				<div class="fileboxes">
					<div class="filebox">
						<a href="/studyhub/sharefileinsertview?no=<%=group.getGroupNo()%>"><img
							src="/studyhub/images/plus.png" id="plus-img"></a> <br>
						<p>새로운 파일 공유하기</p>
					</div>
					<%
						for (ShareFile sf : list) {
							%><%-- 확인용.. <p><%=c.getFileCategoryName()%> and <%=sf.getFileCategoryName() %></p>   --%><% 
							if (c.getFileCategoryName().equals(sf.getFileCategoryName())) {
					%>

					<div class="filebox">
						<span id="title"> <a
							href="/studyhub/sharefiledetail?sfno=<%=sf.getFileNo()%>"> <%
 	if (sf.getTitle().length() > 9) {
 %>
								<%=sf.getTitle().substring(0, 9)%>.. <%
									} else {
								%> <%=sf.getTitle()%>
								<%
									}
								%>
						</a></span>

						<hr>
						<h6><%=sf.getUserName()%></h6>
						<h6><%=sf.getUploadDate()%>
							| 다운로드수:
							<%=sf.getDownloadCount()%>
						</h6>
						<h6 id="filename">
							<%
								if (sf.getFileName().length() > 15) {
							%>
							<%=sf.getFileName().substring(0, 15)%>..
							<%
								} else {
							%>
							<%=sf.getFileName()%>
							<%
								}
							%>
						</h6>
						<h6>
							<a
								href="/studyhub/sharefiledown?ofile=<%=sf.getFileName()%>&rfile=<%=sf.getRenameFileName()%>">
								<button id="download" onclick="download();">download</button>
							</a>
						</h6>
					</div>

					<!-- 예시 div... <div class="filebox">
					<h4>title</h4>
					<p>content</p>
					<hr>
					<p>filename</p>
					<p>upload_date</p>
					<button id="download">download</button>
				</div> -->
					<%
						}
							}
					%>
				</div>

				<div
					class="col-md-8 col-md-offset-5 col-lg-8 col-lg-offset-5 col-sm-8 col-sm-offset-5 col-xs-8 col-xs-offset-5">
					<div id="pagination">
						<%
							if (currentPage <= 1) {
						%>
						<span> ◀◀ &nbsp; </span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=currentPage - 1%>&groupno=<%=group.getGroupNo()%>">◀◀&nbsp;</a>
						<%
							}
						%>

						<%
							for (int p = startPage; p <= endPage; p++) {
									if (p == currentPage) {
						%>
						<span>[<%=p%>]
						</span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=p%>&groupno=<%=group.getGroupNo()%>"><%=p%></a>
						<%
							}
								}
						%>

						<%
							if (currentPage >= maxPage) {
						%>
						<span>&nbsp; ▶▶ </span>
						<%
							} else {
						%>
						<a
							href="/studyhub/sharefilelist?page=<%=currentPage + 1%>&groupno=<%=group.getGroupNo()%>">&nbsp;▶▶</a>
						<%
							}
						%>
					</div>
				</div>


			</div>
			
			
			<% }} %>
			
			<!-- <div class="tab-pane fade" id="add">새 카테고리 추가하는 div:누르면 바로 커서뜨고
				이름써서 카테고리추가가능하도록.</div> -->
			
			<!-- 설정탭(그룹장만 볼수있음)  -->
			<div class="tab-pane fade" id="settings">
				<div class="settings-area">
					<h3>
						<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						카테고리설정
					</h3>

					<div class="wrap">
						<div class="wrap-list">
							<ol class="list">
								<%
									for (ShareFile sf : clist) {
								%>
								<li><input type="text" class="edit-input" name="<%=sf.getFileCategoryName()%>"
									id="check<%=sf.getFileCategoryNo()%>" value="<%=sf.getFileCategoryName()%>">
									<button class="c-btn" onclick="editCategory(<%=sf.getFileCategoryNo()%>);" id="edit-btn"><span class="glyphicon glyphicon-pencil"></span></button>
									<button class="c-btn" onclick="deleteCategory(<%=sf.getFileCategoryNo()%>);" id="delete-btn"><span class="glyphicon glyphicon-remove-sign"></span></button>
								</li>
								<%
									}
								%>
								<li>
									
								</li>
							</ol>
							
										<div class="form-group">
											<input type="text" class="name-form" id="name-area" name="cname"
												placeholder="추가할 카테고리명을 입력...">
												<button class="add-btn" onclick="add();"><span class="glyphicon glyphicon-plus"></span></button> 
							</div>
						</div>
						<div
							class="col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3"
							id="buttons">
							
						</div>
						
						<script type="text/javascript">
							$(function(){
								select();
							});
							
							function add(){
								if($("#name-area").val() ==""){
									alert("카테고리 이름을 입력하세요");
									focus("#name-area");
								}else{
									var cname = $("#name-area").val(); 
									
									var groupno = <%=group.getGroupNo()%>;
									var queryString = { groupno: groupno, cname : cname };
									
									$.ajax({
										url: "/studyhub/filecategoryadd",
										data: queryString,
										type: "get",
										dataType: "json",
										async: false
									});
									$("#name-area").val("");
									alert("추가되었습니다.");
									select();
									return true;
								}
							}
							
							function select(){
								var groupno = <%=group.getGroupNo()%>;
								$.ajax({
									url: "/studyhub/filecategoryselect",
									data: { groupno : groupno },
									type: "get",
									dataType: "json",
									success: function(data){
										var json = JSON.parse(JSON.stringify(data));
										console.log("json:"+json);
										var values = "";
										for(var i in json.list){
											values +="<li><input type='text' class='edit-input' id='check" + json.list[i].categoryno +"' name='"+ decodeURIComponent(json.list[i].cname) +"' value='"+ decodeURIComponent(json.list[i].cname) +"'>"+
											"<button class='c-btn' onclick='editCategory(" +json.list[i].categoryno+ ");'"+
											"id='edit-btn'><span class='glyphicon glyphicon-pencil'></span></button>"+
												"<button class='c-btn' onclick='deleteCategory(" + json.list[i].categoryno + ");'"+ 
												"id='delete-btn'><span class='glyphicon glyphicon-remove-sign'></span></button></li>";
											
										}
										$(".list").html(values);
										
										var value2 = "";
				
										for(var j in json.list){
											value2 += "<li><a href='#category" + json.list[j].categoryno +"' aria-controls='category" +json.list[j].categoryno+ "' role='tab'"+
													"data-toggle='tab' id='tab'>"+ decodeURIComponent(json.list[j].cname) + "</a></li>";
										}
										value2 += "<li><a href='#settings' aria-controls='settings' role='tab' id='tab' data-toggle='tab'><span class='glyphicon glyphicon-cog'"+
										"aria-hidden='true'></span></a></li>";
										$("#nav-ul").html(value2);
									},
									error: function(xhr, status, error){
										alert("error\nxhr: " + xhr + ", status: " + status +", error: " + error);
									}
									
								});
							}
							
							function deleteCategory(no){
								var cno = no;
								var groupno = <%=group.getGroupNo()%>;
								$.ajax({
									url: "/studyhub/filecategorydelete",
									data: { cno : cno, groupno : groupno },
									type: "get",
									dataType: "json",
									async: false
								});
								alert("삭제되었습니다.");
								select();
							}
							
							function editCategory(no){
								if($("#check"+no).val() ==""){
									alert("카테고리 이름을 입력하세요");
									focus(".edit-input");
								}else{
									var cname = $("#check"+no).val();
									var cno = no;
									var groupno = <%=group.getGroupNo()%>;
									console.log(cname+","+cno+","+groupno);
									var queryString = { cname : cname, cno : cno, groupno: groupno };
									
									$.ajax({
										url: "/studyhub/filecategoryedit",
										data: queryString,
										type: "get",
										dataType: "json",
										async: false
									});
									alert("수정되었습니다.");
									select();
									return true;
								}
							}
							
							function filesearch(){
								var groupno = "<%= group.getGroupNo() %>";
								var keyword = $('#search-input').val();
								$.ajax({
									url: "/studyhub/sharefilesearch",
									data: { keyword: keyword, groupno: groupno },
									type: "get",
									dataType: "json",
									success: function(data){
										var json = JSON.parse(JSON.stringify(data));
										var values = "";
										for(var i in json.list){
											values += "<div class='filebox'><span id='title'><a"+ 
											"href='/studyhub/sharefiledetail?sfno="+json.list[i].fileNo+"'>"+
											decodeURIComponent(json.list[i].title)+"</a></span><hr><h6>"+decodeURIComponent(json.list[i].userName)+"</h6>"+
										"<h6>"+ json.list[i].uploadDate+"| 다운로드수:"+ json.list[i].downloadCount+"</h6><h6 id='filename'>"+
										decodeURIComponent(json.list[i].fileName)+"</h6><h6><a "+
											"href='/studyhub/sharefiledown?ofile="+decodeURIComponent(json.list[i].fileName)+"&rfile="+decodeURIComponent(json.list[i].renameFileName)+
											"'><button id='download' onclick='download();'>download</button></a></h6></div>";
										}
										$(".fileboxes").html(values);
									}
								});
							}
							
							
						
						</script>
						
					</div>


				</div>
			</div>

		</div>
		<!-- </div> -->

</div>
</div>
<!-- /메인 컨텐츠 -->

<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>

<%@ include file="/views/include/common/tail.jsp"%>