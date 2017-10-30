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

function sendMessage(senderNo,receiverNo,groupNo){
	alert('senderNo : '+senderNo+'\nreceiverNo : '+receiverNo+'\ngroupNo : '+groupNo);
	$.ajax({
		type : "post",
		data : {
			senderNo : senderNo,
			receiverNo : receiverNo,
			groupNo : groupNo
		},
		url : "/studyhub/joinmessage",
		async : false,
		success : function(data) {
			if(data==1){
				alert('가입이 신청되었습니다.');
			}else{
				alert('가입 신청 오류!');
			}
		}
	});
	checkBtnState(sender,groupno);
}

function checkBtnState(sender,groupno){
	$.ajax({
		type : "post",
		data : {
			sender : sender,
			groupno : groupno
		},
		url : "/studyhub/ungstate",
		async : false,
		success : function(data) {
			if(data==1){
			}else{
			}
		}
	});
}