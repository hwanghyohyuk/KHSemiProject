var emailCheck = 0;
var pwdInputCheck = 0;
var pwdConfirmCheck = 0;
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
					$("#signupemailtxt").html("@ 없음").css("color","red");
				}else if(!signupemail.includes(".")){
					$("#signupemail").css("background-color", "#FFCECE");
					emailCheck = 0;
					$("#signupemailtxt").html("이메일확인").css("color","red");
				}else if (data == 0) {
					$("#signupemail").css("background-color", "#B0F6AC");
					emailCheck = 1;
					$("#signupemailtxt").html("사용 가능").css("color","green");
				} else if (data == 1) {
					$("#signupemail").css("background-color", "#FFCECE");
					emailCheck = 0;
					$("#signupemailtxt").html("이메일 중복").css("color","red");
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
		$("#signuppwdtxt").html("사용불가").css("color","red");
	}else{
		$("#signuppwd").css("background-color", "#B0F6AC");
		$("#signuppwdtxt").html("사용가능").css("color","green");
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
			$("#confirmpwdtxt").html("같음").css("color","green");
		} else if (signuppwd != confirmpwd) {
			$("#confirmpwd").css("background-color", "#FFCECE");
			pwdCheck = 0;
			$("#confirmpwdtxt").html("다름").css("color","red");
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
			$("#phonetxt").html("사용가능").css("color","green");
		}else{
			$("#phone").css("background-color", "#FFCECE");
			phoneCheck = -1;
			$("#phonetxt").html("사용불가").css("color","red");
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
//myinfo
function myinfoPwdInput() {
	var email = $('email').val();
	var name = $('name').val();
	var modifypwd = $('#modifypwd').val();
	if (modifypwd == "") {
		$("#modifypwd").css("background-color", "white");
		pwdInputCheck = 0;
	} else if(modifypwd.length < 10){
		$("#modifypwd").css("background-color", "#FFCECE");
		pwdInputCheck = 0;
		$("#modifypwdtxt").html("사용불가").css("color","red");
	}else{
		$.ajax({
			type : "post",
			data : {
				email : email,
				name : name,
				pwd : modifypwd,
				page : "myinfo"
			},
			url : "/studyhub/findpwdprocess",
			success : function(data) {
				if (data == 0) {
					$("#modifypwd").css("background-color", "#B0F6AC");
					pwdInputCheck = 1;
					$("#modifypwdtxt").html("사용가능").css("color","green");
				} else if (data == 1) {
					$("#modifypwd").css("background-color", "#FFCECE");
					pwdInputCheck = 0;
					$("#modifypwdtxt").html("기존 비밀번호").css("color","red");
				}
			}
		});
	}
	myinfoToggleBtn();
}

function myinfoPwdConfirm() {
	var modifypwd = $('#modifypwd').val();
	var confirmpwd = $('#confirmpwd').val();
	if(modifypwd!=""&&confirmpwd!="")
	if (modifypwd == confirmpwd) {
		$("#confirmpwd").css("background-color", "#B0F6AC");
		pwdConfirmCheck = 1;
		$("#confirmpwdtxt").html("같음").css("color","green");
	} else if (modifypwd != confirmpwd) {
		$("#confirmpwd").css("background-color", "#FFCECE");
		pwdConfirmCheck = 0;
		$("#confirmpwdtxt").html("다름").css("color","red");
	}
	myinfoToggleBtn();
}
function myinfoCheckPhone() {
	var modifytel = $("#modifytel").val();
	if (modifytel == "") {
		$("#modifytel").css("background-color", "white");
		phoneCheck = -1;
	} else {
		var pattern = /^[0-9]{10,11}$/;
		if(pattern.test(modifytel)){
			$("#modifytel").css("background-color", "#B0F6AC");
			phoneCheck = 1;
			$("#modifyteltxt").html("사용가능").css("color","green");
		}else{
			$("#modifytel").css("background-color", "#FFCECE");
			phoneCheck = -1;
			$("#modifyteltxt").html("사용불가").css("color","red");
		}	
	}
	myinfoToggleBtn();
}

function myinfoToggleBtn() {
	var activeBtn = pwdInputCheck+ pwdConfirmCheck + phoneCheck;
	if (activeBtn >= 2) {
		$("#modifybtn").prop("disabled", false);
		$("#modifybtn").css("background-color", "#004157");
	} else {
		$("#modifybtn").prop("disabled", true);
		$("#modifybtn").css("background-color", "#aaaaaa");
	}
}