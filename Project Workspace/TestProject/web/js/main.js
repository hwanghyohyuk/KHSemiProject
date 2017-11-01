
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
			$(".RollDivG > div").append(
					"<a id='a-img' href=\"" 
							+ $(".RollDivG > div > a:first").attr("href")
							+ "\">" 
							+ $(".RollDivG > div > a:first").html()+ "</a>");
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
					"<a id='a-img' href=\""
							+ $(".RollDivG > div > a:last").attr("href")
							+ "\" style=\"margin-left:-"
							+ aWidth
							+ "px\">"
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
			$(".RollDivB > div").append(
					"<a id='a-img' href=\"" 
							+ $(".RollDivB > div > a:first").attr("href")
							+ "\">" 
							+ $(".RollDivB > div > a:first").html()+ "</a>");
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
					"<a id='a-img' href=\""
							+ $(".RollDivB > div > a:last").attr("href")
							+ "\" style=\"margin-left:-"
							+ aWidth
							+ "px\">"
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
				async: false,
				success : function(data) {
					var json = JSON.parse(JSON.stringify(data));
					var values = "";
					if(json.list.length >2){
						$(".RollDivB").css("width","64%");
						$(".sliderB").css("margin","0 8% 5% 8%");
					}else if(json.list.length>1){
						$(".RollDivB").css("width","40%");
						$(".sliderB").css("margin","0 18% 5% 18%");
					}else if(json.list.length>0){
						$(".RollDivB").css("width","20%");
						$(".sliderB").css("margin","0 28% 5% 28%");
					}else{
						$(".RollDivB").html("모집중인 그룹이 없습니다.");
						$(".RollDivB").css("text-align","center");
						$(".RollDivB").css("line-height","240px");
						$(".sliderB").css("margin","0 8% 5% 8%");
					}
					for ( var i in json.list) {
						values += "<a href=\"/studyhub/boardview?bno="
								+ json.list[i].board_no
								+ "\">"
								+ "<img src=\"/studyhub/images/"
								+ decodeURIComponent(json.list[i].renameimg)
								+ "\" /></a> ";
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
				async: false,
				success : function(data) {
					var json = JSON.parse(JSON.stringify(data));
					var values = "";
					if(json.list.length >2){
						$(".RollDivG").css("width","64%");
						$(".sliderG").css("margin","0 8% 5% 8%");
					}else if(json.list.length>1){
						$(".RollDivG").css("width","46%");
						$(".sliderG").css("margin","0 24% 5% 18%");
					}else if(json.list.length>0){
						$(".RollDivG").css("width","20%");
						$(".sliderG").css("margin","0 28% 5% 28%");
					}else{
						$(".RollDivG").html("가입된 그룹이 없습니다.<br><a href='#' data-toggle='modal' data-target='#seachfilter'>스터디 그룹 찾기</a>");
						$(".RollDivG").css("text-align","center");
						$(".RollDivG").css("line-height","50px");
						$(".RollDivG").css("padding-top","80px");
						$(".sliderG").css("margin","0 8% 5% 8%");
					}
					for ( var i in json.list) {
						values += "<a id='a-img' href=\"/studyhub/gmainpreview?group_no="
								+ json.list[i].group_no
								+ "&reset=0&user_no="
								+ user_no
								+"\">"
								+ "<img id=\"groupimg\" src=\"/studyhub/images/groupimg/"
								+ decodeURIComponent(json.list[i].renameimg)
								+ "\"><div id='namewrap'><p id='imgname'>"+ decodeURIComponent(json.list[i].groupname) +"</p>" +
										"<p><span class='glyphicon glyphicon-user'></span>"+ json.list[i].usercount +"</p></div></a>";
					}
					$("#group").html(values);
				}
			});
}
