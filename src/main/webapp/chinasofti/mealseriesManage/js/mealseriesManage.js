var everyPageDataCount=7;
var mealseriesPageIndex=0;
var mealseriesAllPage=0;
$("#goto_page").click(function(){
	var to_page = $("#JUMP_INPUT_ID").val();
	if(to_page>=3){
		to_page = 3;
	}
	if(to_page<=1){
		to_page = 1;
	}
	window.location.href="mealseriesManage?page="+to_page;
	
});
function getMealseriesList(seriesName,pageIndex,everyPageDataCount,SynOrAsyn,url){
	
}

function addMealseriesCheck(){
	var mealseriesName=$("#ADD_MEALSERIES").val().trim();
	
	if(mealseriesName==""){
		$("#tishi").html("菜系名称不能为空");
		return;
	}
	if(mealseriesName.length>10){
		$("#tishi").html("菜系名称最多10个字符");
		return;
	}
	 $.ajax({
			type:"get",
			dataType:"json",
			url:"addMealSeriesName",
			data:{
				"mealseriesName":mealseriesName
			},
			async:true,
			success:function(data){
				alert("添加成功！");
				returnMealseriesList();
			},
			error:function(data){	
				$("#tishi").html("密码错误!");
			}
		});
	

	  

}



function mealseries_edit(seriesId,seriesName){
$("#MEALSERIES_LIST_DIV_ID").attr("style","display:none;");//隐藏div
$("#MEALSERIES_EDIT_DIV_ID").attr("style","display:block;");//隐藏div
$("#EDIT_MEALSERIES_HIDDE").attr("value",seriesId);
$("#EDIT_MEALSERIES").attr("value",seriesName);
}
function editMealseriesCheck(){
	var seriesName=$("#EDIT_MEALSERIES").val()
	var seriesId=$("#EDIT_MEALSERIES_HIDDE").val();
	if(seriesName==""){
		$("#tishi1").html("菜系名称不能为空");
		return;
	}
	if(seriesName.length>10){
		$("#tishi1").html("菜系名称最多10个字符");
		return;
	}
	 $.ajax({
			type:"get",
			dataType:"json",
			url:"editMealSeries",
			data:{
				"seriesName":seriesName,
				"seriesId":seriesId
			},
			async:true,
			success:function(data){
				alert("修改成功");
				returnMealseriesList();
			},
			error:function(data){	
				$("#tishi").html("操作出错!");
			}
		});
	    		


	
}

function DELETE_MEALSERIES(seriesId){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"deleteMealSeries",
		data:{
			"seriesId":seriesId
		},
		async:true,
		success:function(data){
			alert("删除成功");
			returnMealseriesList();
		},
		error:function(data){	
			$("#tishi").html("操作出错!");
		}
	});
	
}
function returnMealseriesList(){
	
	window.location.href="mealseriesManage?page=1";
	/*$("#ADD_MEALSERIES").val("");
	$("#EDIT_MEALSERIES").val("");
	$("#EDIT_MEALSERIES_HIDDE").val("");
	
	$("#tishi1").html("");
	$("#tishi").html("");
	$("#MEALSERIES_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#MEALSERIES_ADD_DIV_ID").attr("style","display:none;");//隐藏div
	$("#MEALSERIES_EDIT_DIV_ID").attr("style","display:none;");//隐藏div
*/}

function ADD_MEALSERIES(){
	 $("#MEALSERIES_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	 $("#MEALSERIES_ADD_DIV_ID").attr("style","display:block;");//隐藏div
}


function GOTO_MEALSERIES_NEXT_PAGE(){
	window.location.href="mealseriesManage?page=2";

}

function GOTO_MEALSERIES_TAIL_PAGE(){
	
}

function GOTO_MEALSERIES_PAGE(){
	var jumpVal=$("#JUMP_INPUT_ID").val().trim();
	if(jumpVal==""){
		$.MsgBox.Alert("消息","跳转页不能为空");
		return;
	}
	if(!(/^[0-9]+$/.test(jumpVal))){
		$.MsgBox.Alert("消息","页码必须为数字");
		return;
	}
	if(jumpVal<=0){
		$.MsgBox.Alert("消息","页码必须大于等于1");
		return;
	}
	if(jumpVal>mealseriesAllPage){
		$.MsgBox.Alert("消息","页码超出上限");
		return;
	}
	
}


function GOTO_MEALSERIES_HOME_PAGE(){

}

function GOTO_MEALSERIES_PREVIOUS_PAGE(){

	 
}
function searchBySeriesName(){

}






