
$(document).ready(function () {

	
});

function getMealList(SynOrAsyn,url){

}




function orders_info(oid){
	    		

	$.ajax({
		type:"get",
		dataType:"json",
		url:"getSonOrderByOid",
		data:{
			"oid":oid
		},
		async:true,
		success:function(data){
			$("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
			$("#orderInfoDivId").attr("style","display:block;");//隐藏div
			$.each(data, function(name, value) {
				$("#orderInfoListDivId").append(
						"<tr bgcolor='#FFFFFF'>"+
							"<td  valign='center' align='center' width='30'>"+value.foodInfo.cuisine.seriesName+"</td>"+
							"<td  valign='center' align='center' width='30'>"+value.foodInfo.mealName+"</td>"+
							"<td  valign='center' align='center' width='30'>"+value.mealPrice+"</td>"+
							"<td  valign='center' align='center' width='30'>"+value.mealCount+"</td>"+
						"</tr>")
			});
			
		},
		error:function(data){	
			alert("服务器繁忙，请稍后再试！")
		}
	});

}

function returnordersList(){
	window.location.href="myOrders";
/*	$("#MEAL_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#orderInfoDivId").attr("style","display:none;");//隐藏div
	$("#container").attr("style","display:none;");//隐藏div
	*/
}
function orders_handle(oid,orderState){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"orders_handle",
		data:{
			"oid":oid,
			"orderState":orderState
		},
		async:true,
		success:function(data){
			alert("修改成功，祝您用餐愉快！")
			returnordersList();
		},
		error:function(data){	
			alert("服务器繁忙，请稍后再试！")
		}
	});
}
function orders_cancel(oid,orderState){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"orders_cancel",
		data:{
			"oid":oid,
			"orderState":orderState
		},
		async:true,
		success:function(data){
			alert("申请已提交，请等待店家回复！")
			returnordersList();
		},
		error:function(data){	
			alert("服务器繁忙，请稍后再试！")
		}
	});
}
