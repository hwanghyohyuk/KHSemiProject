var emailCheck = 0;
var pwdCheck = 0;
var nameCheck = 0;
var phoneCheck = 0;
var pagename = '';
// 이메일 체크하여 가입버튼 비활성화, 중복확인.
function checkEmail(pagename) {
	var signupemail = $('#signupemail').val();
	$.ajax({
		type : "post",
		data : {
			email : signupemail,
			pagename : pagename
		},
		url : "/studyhub/findemailprocess",
		success : function(data) {
			if (signupemail == "" && data == 0) {
				$("#signupemail").css("background-color", "#FFCECE");
				emailCheck = 0;
			} else {
				if (!signupemail.includes("@")) {
					$("#signupemail").css("background-color", "#FFCECE");
					emailCheck = 0;
				} else if (data == 0) {
					$("#signupemail").css("background-color", "#B0F6AC");
					emailCheck = 1;
				} else if (data == 1) {
					$("#signupemail").css("background-color", "#FFCECE");
					emailCheck = 0;
				}
			}
		}
	});
	if(pagename=='signup'){
		toggleBtn();
	}else if(pagename=='start'){
		startToggleBtn();
	}	
}
// 재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
function checkPwd() {
	var signuppwd = $('#signuppwd').val();
	var confirmpwd = $('#confirmpwd').val();
	if (signuppwd == "") {
		$("#signuppwd").css("background-color", "white");
	} else if(signuppwd.length < 10){
		$("#signuppwd").css("background-color", "#FFCECE");
	}else{
		$("#signuppwd").css("background-color", "#B0F6AC");
	}
	if (confirmpwd == "") {
		$("#confirmpwd").css("background-color", "white");
	} else {
		$("#confirmpwd").css("background-color", "#B0F6AC");
	}
	if (signuppwd == "" && confirmpwd == "" && signuppwd.length < 10) {
		$("#confirmpwd").css("background-color", "white");
		$("#signuppwd").css("background-color", "white");
	} else {
		if (signuppwd == confirmpwd) {
			$("#confirmpwd").css("background-color", "#B0F6AC");
			pwdCheck = 1;
		} else if (signuppwd != confirmpwd) {
			$("#confirmpwd").css("background-color", "#FFCECE");
			pwdCheck = 0;
		}
	}

	toggleBtn();
}
// 사용자이름과 연락처를 입력하지 않았을 경우 가입버튼 비활성화
function checkName() {
	var username = $("#username").val();
	if (username == "") {
		nameCheck = 0;
		$("#username").css("background-color", "white");
	} else {
		var pattern = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		if(pattern.test(username)){
			nameCheck = 1;
			$("#username").css("background-color", "#B0F6AC");
		}else{
			nameCheck = 0;
			$("#username").css("background-color", "#FFCECE");
		}	
	}
	toggleBtn();
}
function checkPhone() {
	var phone = $("#phone").val();
	if (phone == "") {
		$("#phone").css("background-color", "white");
		phoneCheck = 0;
	} else {
		var pattern = /^[0-9]{10,11}$/;
		if(pattern.test(phone)){
			$("#phone").css("background-color", "#B0F6AC");
			phoneCheck = 1;
		}else{
			$("#phone").css("background-color", "#FFCECE");
			phoneCheck = 0;
		}	
	}
	toggleBtn();
}

function toggleBtn() {
	var activeBtn = emailCheck + pwdCheck + nameCheck + phoneCheck;
	if (activeBtn == 4) {
		$("#signupbtn").prop("disabled", false);
		$("#signupbtn").css("background-color", "#004157");
	} else {
		$("#signupbtn").prop("disabled", true);
		$("#signupbtn").css("background-color", "#aaaaaa");
	}
}

function startToggleBtn() {
	var activeBtn = emailCheck;
	if (activeBtn == 1) {
		$("#signupbtn").prop("disabled", false);
		$("#signupbtn").css("background-color", "#004157");
	} else {
		$("#signupbtn").prop("disabled", true);
		$("#signupbtn").css("background-color", "#aaaaaa");
	}
}


