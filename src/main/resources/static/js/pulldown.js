$(function(){
	$("#pulldown1").change(function(){
		var parentName = $("#pulldown1 option:selected").val();
		$.get("/item/pulldown/" + parentName ,function(date){
			var obj = $.parseJSON(date);
			$("#pulldown2").html("");
			for(var i = 0; i<obj.length; i++){
				$("#pulldown2").append("<option value=\"" + obj[i].itemValue + "\">" + obj[i].itemLabel + "</option>");
			}
		})
	})
});

$(function(){
	$('#pulldown2').change(function(){
		var parentName = $("#pulldown1 option:selected").val();
		var childName = $("#pulldown2 option:selected").val();
		$.get("/item/pulldown2/" + parentName + "/" + childName ,function(date){
			var obj = $.parseJSON(date);
			$("#pulldown3").html("");
			for(var i = 0; i<obj.length; i++){
				$("#pulldown3").append("<option value=\"" + obj[i].itemValue + "\">" + obj[i].itemLabel + "</option>");
			}
		})	
	})
});
