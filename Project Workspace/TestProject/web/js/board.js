var state = 0;//성공실패여부

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
				state=1;
			}else{
				alert('가입 신청 오류!');
				state=0;
			}
		}
	});
	if(state==1){
	checkBtnState(sender,groupno);
	state=0;
	}
}

function checkBtnState(senderNo,groupNo){
	$.ajax({
		type : "post",
		data : {
			senderNo : senderNo,
			groupNo : groupNo
		},
		url : "/studyhub/ungstate",
		async : false,
		success : function(data) {
			if(data==0){
				$("#joinbtn").prop("disabled", true);
				$("#joinbtn").html("가입대기 중");
			}else if(data==1){
				$("#joinbtn").prop("disabled", true);
				$("#joinbtn").html("가입 됨");
			}else if(data==2){
				$("#joinbtn").prop("disabled", false);
				$("#joinbtn").html("가입신청");
			}
		}
	});
}