var everyPageDataCount=7;
var mealPageIndex=0;
var mealAllPage=0;
$(document).ready(function () {

	
});

function getMealList(mealName,seriesId,pageIndex,everyPageDataCount,SynOrAsyn,url){
	
}




function addShoppingCart(mealId,myId){
	var count = $("#"+myId+"").val();
	$.ajax({
		type:"get",
		dataType:"json",
		url:"addMealToCart",
		data:{
			"mealId":mealId,
			"count":count
		},
		async:true,
		success:function(data){
			$.MsgBox.Alert("消息", data.result);
		},
		error:function(data){	
			$("#tishi").html("服务器繁忙，请稍后再试!");
		}
	});
	
	

}
function GOTO_MEAL_NEXT_PAGE(){

	
}

function GOTO_MEAL_TAIL_PAGE(){
	
}

function GOTO_MEAL_PAGE(){
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
	if(jumpVal>mealAllPage){
		$.MsgBox.Alert("消息","页码超出上限");
		return;
	}
	
}


function GOTO_MEAL_HOME_PAGE(){
	
}

function GOTO_MEAL_PREVIOUS_PAGE(){
	
	 
}
function searchByMealName(){
	var mealName = $("#SEARCH_MEAL_NAME").val().trim();
	var mealSeries = $("#SEARCH_SERIES_ID").val();
	window.location.href="searchByMealName?mealName="+mealName+"&mealSeries="+mealSeries;
/*	$.ajax({
		type:"get",
		dataType:"json",
		url:"searchByMealName",
		data:{
		},
		async:true,
		success:function(data){
			//?menuUserName="+usrname.trim()+"&admin=0
			$("#example3_wrapper").empty();
			$.each(data, function(name, value) {
				$("#example3_wrapper").append(
						"<div class='row'>"+
						"<div class='form-inline col-sm-12'>"+
							"<div><img src=\"img/meal/"+value.mealImage+" }\" style=\"whith:80px;height:80px\"></div>"+
							"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
							"<div>"+
								"<table>"+
									"<tbody>"+
										"<tr>"+
											"<td>菜名："+value.mealName+"</td>"+
										"</tr>"+
										"<tr>"+
											"<td>价格："+value.mealPrice+"</td>"+
										"</tr>"+
										"<tr>"+
											"<td>摘要："+value.mealSummarize+"</td>"+
										"</tr>"+
										"<tr>"+
											"<td>数量："+
												"<select id=\"my"+01+"\">"+
													"<option value=\"1\">1</option>"+
													"<option value=\"2\">2</option>"+
													"<option value=\"3\">3</option>"+
													"<option value=\"4\">4</option>"+
													"<option value=\"5\">5</option>"+
												"</select>"+
											"</td>"+
											"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
												"<button value='' type=\"button\" class=\"btn btn-info\" onclick=\"addShoppingCart('"+value.mealId+"','my"+01+"')\">加入购物车</button>"+
											"</td>"+
										"</tr>"+
									"</tbody>"+
								"</table>"+
							"</div>"+
						"</div>"+
						"<div class=\"col-sm-12\">简介："+value.mealDescription+"</div>"+
					"</div>"
								
				)
			});
		},
		error:function(data){
			$("#tishi").html("密码错误!");
		}
	});*/
}




