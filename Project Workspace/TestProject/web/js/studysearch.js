function pleaseLogin() {
	alert("로그인이 필요합니다.");
	location.href = "/studyhub/login";
}

$(function() { //카테고리 불러오기
	$.ajax({
		url : "/studyhub/categorylist",
		type : "get",
		datatype : "json",
		success : function(data) {
			var json = JSON.parse(JSON.stringify(data));
			var values = "";
			if (json.list.length > 0) {
				values += "<option value='0' selected >모든 분류</option>";
				for ( var i in json.list) {
					values += "<option value='" + json.list[i].category_no + "' >"
							+ decodeURIComponent(json.list[i].category_name)
							+ "</option>";
				}
			} else {
				values += "<option value='0' selected >분류 없음</option>";
			}
			$("#catelist").html(values);
		}
	});
});

