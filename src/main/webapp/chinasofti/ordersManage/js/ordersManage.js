var everyPageDataCount=7;
var mealPageIndex=0;
var mealAllPage=0;
$(document).ready(function () {
//	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
//	editor = KindEditor.create('textarea[id="POST_ADD_DES"]', {
//		allowUpload : true,
//	    uploadJson: '/postbar/postController/kindEditorImgInput',
//	    allowFileManager: false,
//	    width:'900px',
//	    height: '300px',
//	    items: [ 'fullscreen','|','undo', 'redo', '|', 'preview', 'print', 'cut', 'copy', 'paste',
//	            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
//	            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
//	            'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
//	            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
//	             'table', 'hr', 'emoticons', ]
//	});

	
 	

	
});

function getMealList(oid,orderState,pageIndex,everyPageDataCount,SynOrAsyn,url){
	
}





function orders_info(oid){
	
	 $.ajax({
			type:"get",
			dataType:"json",
			url:"getSonOrdersbyoIdForAdmin",
			data:{
				"oid":oid
			},
			async:true,
			success:function(data){
				$("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
				$("#orderInfoDivId").attr("style","display:block;");//隐藏div
				var user = data.user;
				var orders = data.orders;
				$("#orderInfoUserListDivId").append(
						"<tr bgcolor='#FFFFFF'>"+
							"<td  valign='center' align='center' width='30'>"+user.loginName+"</td>"+
							"<td  valign='center' align='center' width='30'>"+user.trueName+"</td>"+
							"<td  valign='center' align='center' width='30'>"+user.email+"</td>"+
							"<td  valign='center' align='center' width='30'>"+user.phone+"</td>"+
							"<td  valign='center' align='center' width='30'>"+user.address+"</td>"+
						"</tr>");
				$.each(orders,function(i,val){
					$("#orderInfoListDivId").append(
							"<tr bgcolor='#FFFFFF'>"+
								"<td  valign='center' align='center' width='30'>"+val.foodInfo.cuisine.seriesName+"</td>"+
								"<td  valign='center' align='center' width='30'>"+val.foodInfo.mealName+"</td>"+
								"<td  valign='center' align='center' width='30'>"+val.foodInfo.mealPrice+"</td>"+
								"<td  valign='center' align='center' width='30'>"+val.mealCount+"</td>"+
								"</tr>"
					);
				});
				
				
				/*var appendtd = function(name,value){
					$("#orderInfoUserListDivId").append(
							"<tr bgcolor='#FFFFFF'>"+
								"<td  valign='center' align='center' width='30'>"+value.user.loginName+"</td>"+
								"<td  valign='center' align='center' width='30'>"+value.user.trueName+"</td>"+
								"<td  valign='center' align='center' width='30'>"+value.user.eamil+"</td>"+
								"<td  valign='center' align='center' width='30'>"+value.user.phone+"</td>"+
								"<td  valign='center' align='center' width='30'>"+value.user.address+"</td>"+
							"</tr>")
				} */
			},
			error:function(data){	
				alert("服务器繁忙，请稍后再试！");
			}
		});
	 /*  $("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
		$("#orderInfoDivId").attr("style","display:block;");//隐藏div
	*/

}


function returnordersList(){
	window.location.href="ordersManage";
	/*$("#MEAL_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#orderInfoDivId").attr("style","display:none;");//隐藏div
*/}
function orders_handle(oid,orderState){
	  $.ajax({
			type:"get",
			dataType:"json",
			url:"changeOrderState",
			data:{
				"oid":oid,
				"orderState":orderState
			},
			async:true,
			success:function(data){
				alert("状态修改成功");
				window.location.href="ordersManage";
			},
			error:function(data){
				alert("服务器繁忙，请稍后再试！")
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
function searchByOrderOid(){
	
}






