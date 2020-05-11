
$(document).ready(function () {

	
});
function getMealseriesList(SynOrAsyn,url){

}


function DELETE_CAET(cartId){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"deleteCartByCartId",
		data:{
			"cartId":cartId
		},
		async:true,
		success:function(data){
			alert("删除成功");
			window.location.href="cart";
		},
		error:function(data){	
			alert("操作出错！！")
		}
	});
	
}


function ADD_ORDERS(){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"createMyOrders",
		data:{
			"payType" : $("#payType").val()
		},
		async:true,
		success:function(data){
			alert("提交成功");
			CLEAR_CART();
			window.location.href="cart";
		},
		error:function(data){	
			alert("操作出错！！")
		}
	});

}
function CLEAR_CART(){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"clearMyCart",
		data:{
		},
		async:true,
		success:function(data){
			alert("购物车已清空！")
			window.location.href="cart";
		},
		error:function(data){	
			alert("操作出错！！")
		}
	});
	
}
