var btn_state = 0;//모집게시판 가입신청 버튼 상태

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

function sendMessage(sender,receiver,groupno){
	alert('sender : '+sender+'\nreceiver : '+receiver+'\ngroupno : '+groupno);
	$.ajax({
		type : "post",
		data : {
			sender : sender,
			receiver : receiver,
			groupno : groupno
		},
		url : "/studyhub/joinmessage",
		async : false,
		success : function(data) {
			if(data==1){
				alert('가입이 신청되었습니다.');
				btn_state=1;
			}else{
				alert('가입 신청 오류!');
				btn_state=0;
			}
		}
	});
		
}

function toggleJoinBtn(){
	if(btn_state==0){
		btn_state=1;
	}else if(btn_state==1){
		btn_state=0;
	}
	$("#joinbtn").prop("disabled", false);
	//수정 시작 부분
}