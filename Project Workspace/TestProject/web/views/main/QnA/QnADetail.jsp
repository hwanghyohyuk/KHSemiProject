<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
작성자 : 구미향
내용 : QnA질문게시판 페이지
작성일자 17.10.18
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디허브 StudyHub::QnA</title>

<!-- java 구문 -->

<!-- 초기화 블럭(변수선언 및 초기화) -->

<!--페이지 시작-->
<%@ include file="/views/include/common/head.jsp"%>
<!--헤더 부분-->
<%@ include file="/views/include/main/header.jsp"%>

<style>
#btns{
	float: right;
}
#crudmainphoto {
  opacity: 1;
    transition: .4s ease;
  backface-visibility: hidden;
}

.middle {
  transition: .3s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 47%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%)
}
.container{
    width: 100%;
}

.container:hover .image {
  opacity: 0.7;
}

.container:hover .middle {
  opacity: 0.8;
}

.text {
  background-color: black;
  color: white;
  font-size: 16px;
  padding: 16px 32px;
}

#exampleInputEmail1{
    display: inline-block;
}
</style>

<link rel="stylesheet" type="text/css" href="/studyhub/css/main.css">
<link rel="stylesheet" href="/studyhub/css/bootstrap.css">

<script type="text/javascript" src="/studyhub/js/jquery-3.2.1.js"></script>

</head>
<body>

<!--- 글쓴거 보이는 화면  -->

<div class="panel panel-info" style="width: 80vw; margin: 3vh 10vw">
  <div class="panel-heading">
  <h3 class="panel-title">제목</h3>
  
        </div>
  <div class="panel-body">
   컨텐츠<br><br>
   <!---댓글입력-->
    <form action="#" method="post">
          <input type="text" name="content" class="form-control" id="exampleInputEmail1" style="width: 64vw" placeholder="댓글을 달아주세요">
              <!--<span class ="input-group-btn">-->
                  <button class="btn btn-info btn-sm" type="submit" style="margin-left: 1vw">댓글달기</button>
             
    </form>
        
      <!---댓글보여지는부분--->
     
     <div class="panel-footer" style="width: 64vw; display: inline-block">Comments: </div>
     <button><a href="#" data-method="post" data-confirm="Are you sure">삭제</a></button>
 
  </div>
  <button class= "btn btn-default btn-sm" style="margin-top: 0.6vh; float: right"><a href="#" data-method="post" data-confirm="진짜로삭제할거에요?ㅠㅠ">삭제</a></button>
  <button class= "btn btn-default btn-sm" style="margin-top: 0.6vh; float: right"><a href="#" >수정</a></button>
  <div class="blank" style="height: 3vh; display: block "></div>
    
</div>



<!--푸터 부분-->
<%@ include file="/views/include/main/footer.jsp"%>
<!--페이지 끝-->
<%@ include file="/views/include/common/headend.jsp"%>

</body>
</html>