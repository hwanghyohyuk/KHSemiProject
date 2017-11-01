$(function() {
	var userno;
	$.ajax({
		url : "/studyhub/categorylist",
		data : {
			userno : userno
		},
		type : "get",
		datatype : "json",
		success : function(data) {
			var json = JSON.parse(JSON.stringify(data));
			var values = "";
			if (json.list.length > 0) {
				for ( var i in json.list) {
					values += "<option value='" + json.list[i].group_no + "' >"
							+ decodeURIComponent(json.list[i].group_name)
							+ "</option>";
				}
			} else {
				values += "<option value='0' >등록할 그룹 없음</option>";
			}
			$("#bglist").html(values);
		}
	});
});