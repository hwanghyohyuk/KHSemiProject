function pleaseLogin() {
	alert("로그인이 필요합니다.");
	location.href = "/studyhub/login";
}

// ///////////////////////////////////////////////////////////////////////////
// /// 이미지 슬라이더 /////
// ///////////////////////////////////////////////////////////////////////////

// moveType (0:left / 1:right)
var moveSpeed = 1000;
function imgMove(move, part) {
	var moveType = move;
	var movePart = part;
	if (movePart == 'g')
		if (moveType == 0) {
			var aWidth = $(".RollDivG > div > a:first").width();
			$(
					"<a href=\"" + $(".RollDivG > div > a:first").attr("href")
							+ "\">" + $(".RollDivG > div > a:first").html()
							+ "</a>").insertBefore(".RollDivG > div > a:last");
			$(".RollDivG > div > a:first").animate({
				marginLeft : -aWidth
			}, {
				duration : moveSpeed,
				complete : function() {
					$(this).remove();
				}
			});
		} else {
			var aWidth = $(".RollDivG > div > a:last").width();
			$(
					"<a href=\"" + $(".RollDivG > div > a:last").attr("href")
							+ "\" style=\"margin-left:-" + aWidth + "px\">"
							+ $(".RollDivG > div > a:last").html() + "</a>")
					.insertBefore(".RollDivG > div > a:first");
			$(".RollDivG > div > a:first").animate({
				marginLeft : 0
			}, {
				duration : moveSpeed,
				complete : function() {
					$(".RollDivG > div > a:last").remove();
				}
			});
		}
	else if (movePart == 'b')
		if (moveType == 0) {
			var aWidth = $(".RollDivB > div > a:first").width();
			$(
					"<a href=\"" + $(".RollDivB > div > a:first").attr("href")
							+ "\">" + $(".RollDivB > div > a:first").html()
							+ "</a>").insertBefore(".RollDivB > div > a:last");
			$(".RollDivB > div > a:first").animate({
				marginLeft : -aWidth
			}, {
				duration : moveSpeed,
				complete : function() {
					$(this).remove();
				}
			});
		} else {
			var aWidth = $(".RollDivB > div > a:last").width();
			$(
					"<a href=\"" + $(".RollDivB > div > a:last").attr("href")
							+ "\" style=\"margin-left:-" + aWidth + "px\">"
							+ $(".RollDivB > div > a:last").html() + "</a>")
					.insertBefore(".RollDivB > div > a:first");
			$(".RollDivB > div > a:first").animate({
				marginLeft : 0
			}, {
				duration : moveSpeed,
				complete : function() {
					$(".RollDivB > div > a:last").remove();
				}
			});
		}
}

function boardlist() {
	$.ajax({
		url : "/studyhub/boardpreview",
		type : "get",
		dataType : "json",
		success : function(data) {
			var json = JSON.parse(JSON.stringify(data));
			var values = "";
			for ( var i in json.list) {
				values += "<a href='/studyhub/boardview?bno="
						+ json.list[i].board_no + "'>"
						+ "<img src='/studyhub/images/"
						+ decodeURIComponent(json.list[i].renameimg)
						+ "' /></a> ";
			}
			$("#board").html(values);
		}
	});
}

function mygrouplist(userno) {
	var user_no = userno;
	$
			.ajax({
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
						values += "<a href='/studyhub/gmainpreview?group_no="
								+ json.list[i].group_no
								+ "&reset=0&user_no="
								+ user_no
								+ "' data-toggle='tooltip' data-placement='bottom' title='"+decodeURIComponent(json.list[i].group_name)+", "+json.list[i].usercount+"명'>"
								+ "<img id='groupimg' src='/studyhub/images/groupimg/"
								+ decodeURIComponent(json.list[i].renameimg)
								+ "'>";
					}
					$("#group").html(values);
				}
			});
}

///////////////////////////////////////////////////
//툴팁 초기화

$(function() {
	$('[data-toggle="tooltip"]').tooltip()
})