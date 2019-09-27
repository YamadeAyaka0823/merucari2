$(function(){
	$("#pulldown1").change(function(){
		var value = $("#pulldown1 option:selected").val();
		$.get("/pulldown/" + nameAllChild ,function(date){
			var obj = $.parseJSON(date);
			$("#pulldown2").html("");
			for(var i = 0; i<obj.length; i++){
				$("#pulldown2").append("<option value=" + obj[i].value + ">" + obj[i].th:text + "</option>");
			}
		})
	})
});