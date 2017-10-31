function pleaseLogin() {
	alert("로그인이 필요합니다.");
	location.href = "/studyhub/login";
}

// ///////////////////////////////////////////////////////////////////////////
// /// 이미지 슬라이더 /////
// ///////////////////////////////////////////////////////////////////////////

// moveType (0:left / 1:right)
var moveSpeed = 1000;
function imgMove(move) {
	var moveType = move;
	if (moveType == 0) {
		var aWidth = $(".RollDiv > div > a:first").width();
		$(
						"<a href=\""
								+ $(".RollDiv > div > a:first").attr("href")
								+ "\">" + $(".RollDiv > div > a:first").html()
								+ "</a>").insertBefore(".RollDiv > div > a:last");
		$(".RollDiv > div > a:first").animate({
			marginLeft : -aWidth
		}, {
			duration : moveSpeed,
			complete : function() {
				$(this).remove();
			}
		});
	} else {
		var aWidth = $(".RollDiv > div > a:last").width();
		$(
				"<a href=\"" + $(".RollDiv > div > a:last").attr("href")
						+ "\" style=\"margin-left:-" + aWidth + "px\">"
						+ $(".RollDiv > div > a:last").html() + "</a>")
				.insertBefore(".RollDiv > div > a:first");
		$(".RollDiv > div > a:first").animate({
			marginLeft : 0
		}, {
			duration : moveSpeed,
			complete : function() {
				$(".RollDiv > div > a:last").remove();
			}
		});
	}
}

function mygrouplist(userNo) {
	var user_no = userNo;
	$.ajax({
				url : "/studyhub/mygrouppreview",
				data : {
					userno : user_no
				},
				type : "get",
				dataType : "json",
				success : function(data) {
					var json = JSON.parse(JSON.stringify(data));
					var values = "";
					for ( var i in json.list) {
						values += "<li class='slide'>"
								+ "<a href='/studyhub/gmainpreview?group_no="
								+ json.list[i].group_no
								+ "&reset=0&user_no="
								+ user_no
								+ "'>"
								+ "<div>"
								+ "<div>"
								+ "<img id='groupimg' src='/studyhub/images/groupimg/"
								+ decodeURIComponent(json.list[i].renameimg)
								+ "'>"
								+ "</div>"
								+ "<div class='cover col-md-9'>"
								+ "<p id='groupname'>"
								+ decodeURIComponent(json.list[i].group_name)
								+ "</p>"
								+ "</div>"
								+ "<div class='col-md-3'>"
								+ "<span class='glyphicon glyphicon-user' aria-hidden='true'>&nbsp;</span>"
								+ json.list[i].usercount
								+ "</div>"
								+ "</div>" + "</a>" + "</li>";
					}
					$(".group-slides").html(values);
				}
			});
}