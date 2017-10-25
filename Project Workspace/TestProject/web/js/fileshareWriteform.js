/**
 * 파일공유게시판 한정- 글쓰기/글수정하기 폼에서 제목+파일첨부 안하고 submit누르면 제출 안되게 하기 (내용은 안써도 상관없음)
 */
var titleCheck = 0;
var fileCheck= 0;

function checkTitle(){
	var title = $('#post_title').val();
	if(title==""||title==null){
		titleCheck = 0;
		alert("제목을 입력해주세요");
	}else{
		titleCheck = 1;
	}
	clearDisabled();
}

function checkFile(){
	var attachedFile = document.getElementById('file').value;
	console.log(attachedFile);
	if(attachedFile==""||attachedFile==null){
		fileCheck = 0;
		alert("파일을 첨부해주세요");
	}else{
		fileCheck = 1;
	}
	clearDisabled();
}


function clearDisabled(){
	var checkall = titleCheck + fileCheck;
	if(checkall==2){
		$("#btns").prop("disabled", false);
	}
}