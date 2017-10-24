/**
 * 글쓰기/글수정하기 폼에서 제목, 내용 등등 안쓰고 submit누르면 제출 안되게 하기
 */
var titleCheck = 0;

function checkTitle(){
	var title = $('#post_title').val();
	if(title==""||title==null){
		titleCheck = 0;
	}else{
		titleCheck = 1;
	}
	console.log("title:"+titleCheck);
}


function clearDisabled(){
	var checkall = titleCheck + contentCheck;
	if(checkall==3){
		
	}
}
