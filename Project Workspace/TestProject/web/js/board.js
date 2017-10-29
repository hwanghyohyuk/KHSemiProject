function boardInsert() {
	var btitle = $('#btitle').val();
	var bglist = $('#bglist').val();
	var bcontent = $('#bcontent').val();
	if (btitle == '') {
		alert('제목은 필수입력사항입니다.');
		$('#btitle').focus();
	}else if(bglist==0){
		alert('오류 발생! 목록페이지로 이동합니다.');
		location.replace(this.href);
		location.href="/studyhub/boardlist";
	}else if (bcontent == '') {
		alert('내용은 필수입력사항입니다.');
		$('#bcontent').focus();
	}else{
		$('#boardinsert').submit();
	}	
}