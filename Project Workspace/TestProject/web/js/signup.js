var emailCheck = 0;
var pwdCheck = 0;
var nameCheck = 0;
var phoneCheck = 0;
// 이메일 체크하여 가입버튼 비활성화, 중복확인.
function checkEmail() {
	var signupemail = $('#signupemail').val();
	$.ajax({
		type : "post",
		data : {
			email : signupemail,
			pagename : "signup"
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
	toggleBtn();
}
// 재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
function checkPwd() {
	var signuppwd = $('#signuppwd').val();
	var confirmpwd = $('#confirmpwd').val();
	if (signuppwd == "") {
		$("#signuppwd").css("background-color", "white");
	} else {
		$("#signuppwd").css("background-color", "#B0F6AC");
	}
	if (confirmpwd == "") {
		$("#confirmpwd").css("background-color", "white");
	} else {
		$("#confirmpwd").css("background-color", "#B0F6AC");
	}
	if (signuppwd == "" && confirmpwd == "") {
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
		nameCheck = 1;
		$("#username").css("background-color", "#B0F6AC");
	}
	toggleBtn();
}
function checkPhone() {
	var phone = $("#phone").val();
	if (phone == "") {
		$("#phone").css("background-color", "white");
		phoneCheck = 0;
	} else {
		$("#phone").css("background-color", "#B0F6AC");
		phoneCheck = 1;
	}
	toggleBtn();
}

function emptyStartPwdCheck() {
	var pwd = $("#pwd").val();
	if(pwd==""){
		pwdCheck=0;
	}else{
		pwdCheck=1;
	}
}

function toggleBtn() {
	var activeBtn = emailCheck + pwdCheck + nameCheck + phoneCheck;
	if (activeBtn == 4) {
		$("#signupbtn").prop("disabled", false);
		$("#signupbtn").css("background-color", "#004157");
	} else if (activeBtn == 2) {
		$("#signupbtn").prop("disabled", false);
		$("#signupbtn").css("background-color", "#004157");
	} else {
		$("#signupbtn").prop("disabled", true);
		$("#signupbtn").css("background-color", "#aaaaaa");
	}
}
