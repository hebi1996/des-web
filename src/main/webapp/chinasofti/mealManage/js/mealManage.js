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

function getMealList(mealName,seriesId,pageIndex,everyPageDataCount,SynOrAsyn,url){
	
}

function addMealCheck(){
	var mealName=$("#ADD_MEAL_NAME").val().trim();
	var mealSummarize=$("#ADD_MEAL_SUMMARIZE").val().trim();
	var mealDescription=$("#ADD_MEAL_DESCRIPTION").val().trim();
	var mealPrice=$("#ADD_MEAL_PRICE").val().trim();
	var mealSeriesId=$("#ADD_MEALSERIES_NAME").val().trim();
	if(mealName==""){
		$("#tishi").html("菜名不能为空");
		return;
	}
	if(mealName.length>20){
		$("#tishi").html("菜名最多20个字符");
		return;
	}
	
	if(mealSummarize==""){
		$("#tishi").html("摘要不能为空");
		return;
	}
	if(mealSummarize.length>250){
		$("#tishi").html("摘要最多250个字符");
		return;
	}
	
	if(mealDescription==""){
		$("#tishi").html("介绍不能为空");
		return;
	}
	if(mealDescription.length>250){
		$("#tishi").html("介绍最多250个字符");
		return;
	}
	if(mealPrice.trim()==""){
		$("#tishi").html("价钱不能为空");
		return;
	}

	var str=/^(([1-9]\d{0,8})|0)(\.\d{2})?$/;
	if(!str.test(mealPrice)){
		$("#tishi").html("整数(8位)或保留小数点后两位如：88.10");
		return;
	}
	$.ajax({
			type:"get",
			dataType:"json",
			url:"addMealName",
			data:{
				"mealName":mealName,
				"mealSummarize":mealSummarize,
				"mealDescription":mealDescription,
				"mealPrice":mealPrice,
				"mealSeriesId":mealSeriesId
			},
			async:true,
			success:function(data){
				alert("添加成功！");
				returnMealList();
			},
			error:function(data){	
				$("#tishi").html("添加出错!");
			}
		});
	
	    		
	    		

}

function meal_edit_img(mealId){
	$("#mealIdHidd").attr("value",mealId);
	$("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	$("#MEAL_IMG_DIV_ID").attr("style","display:block;");//隐藏div
	


}
function meal_edit(mealId,mealName,mealSeriesId,mealSummarize,mealDescription,mealPrice){
	
	$("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
 	$("#MEAL_EDIT_DIV_ID").attr("style","display:block;");//隐藏div
 	$.ajax({
		type:"get",
		dataType:"json",
		url:"getAllSeries",
		data:{
		},
		async:true,
		success:function(data){
			$("#EDIT_MEALSERIES_NAME").empty();
			$.each(data, function(name, value) {
				$("#EDIT_MEALSERIES_NAME").append(
						"<option value='"+value.seriesId+"'>" + value.seriesName
								+ "</option>")
			});
		},
		error:function(data){
			$("#tishi").html("密码错误!");
		}
	});
 	$("#EDIT_MEAL_HIDDE").attr("value",mealId);
 	$("#EDIT_MEAL_NAME").attr("value",mealName);
 	$("#EDIT_MEALSERIES_NAME option[value="+mealSeriesId+"]").attr("selected","selected");
 	$("#EDIT_MEAL_SUMMARIZE").attr("value",mealSummarize);
 	$("#EDIT_MEAL_DESCRIPTION").attr("value",mealDescription);
 	$("#EDIT_MEAL_PRICE").attr("value",mealPrice);


}
function editMealCheck(){
	
	var mealId=$("#EDIT_MEAL_HIDDE").val();
	var mealName=$("#EDIT_MEAL_NAME").val().trim();
	var mealSummarize=$("#EDIT_MEAL_SUMMARIZE").val().trim();
	var mealDescription=$("#EDIT_MEAL_DESCRIPTION").val().trim();
	var mealPrice=$("#EDIT_MEAL_PRICE").val().trim();
	var mealSeriesId=$("#EDIT_MEALSERIES_NAME").val().trim();
	if(mealName==""){
		$("#tishi1").html("菜名不能为空");
		return;
	}
	if(mealName.length>20){
		$("#tishi1").html("菜名最多20个字符");
		return;
	}
	
	if(mealSummarize==""){
		$("#tishi1").html("摘要不能为空");
		return;
	}
	if(mealSummarize.length>250){
		$("#tishi1").html("摘要最多250个字符");
		return;
	}
	
	if(mealDescription==""){
		$("#tishi1").html("介绍不能为空");
		return;
	}
	if(mealDescription.length>250){
		$("#tishi1").html("介绍最多250个字符");
		return;
	}
	if(mealPrice.trim()==""){
		$("#tishi1").html("价钱不能为空");
		return;
	}

	var str=/^(([1-9]\d{0,8})|0)(\.\d{2})?$/;
	if(!str.test(mealPrice)){
		$("#tishi1").html("整数(8位)或保留小数点后两位如：88.10");
		return;
	}
	$.ajax({
		type:"get",
		dataType:"json",
		url:"editMealName",
		data:{
			"mealId":mealId,
			"mealName":mealName,
			"mealSummarize":mealSummarize,
			"mealDescription":mealDescription,
			"mealPrice":mealPrice,
			"mealSeriesId":mealSeriesId
		},
		async:true,
		success:function(data){
			alert("修改成功！");
			returnMealList();
		},
		error:function(data){	
			$("#tishi1").html("操作出错!");
		}
	});
	

	
}

function DELETE_MEAL(mealId){
	$.ajax({
		type:"get",
		dataType:"json",
		url:"deleteMeal",
		data:{
			"mealId":mealId
		},
		async:true,
		success:function(data){
			alert("删除成功");
			returnMealseriesList();
		},
		error:function(data){	
			alert("操作出错！！")
		}
	});
	
}
function returnMealList(){
	window.location.href="mealManage";
	/*$("#ADD_MEAL_NAME").val("");
	$("#ADD_MEAL_SUMMARIZE").val("");
	$("#ADD_MEAL_DESCRIPTION").val("");
	$("#ADD_MEAL_PRICE").val("");
	$("#ADD_MEALSERIES_NAME").val("");
	
	
	$("#EDI_MEAL_NAME").val("");
	$("#EDI_MEAL_SUMMARIZE").val("");
	$("#EDI_MEAL_DESCRIPTION").val("");
	$("#EDI_MEAL_PRICE").val("");
	$("#EDI_MEALSERIES_NAME").val("");
	
	$("#mealIdHidd").val("");
	$("#EDIT_MEAL_HIDDE").val("");
	
	$("#tishi1").html("");
	$("#tishi").html("");
	$("#MEAL_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#MEAL_ADD_DIV_ID").attr("style","display:none;");//隐藏div
	$("#MEAL_EDIT_DIV_ID").attr("style","display:none;");//隐藏div
	$("#MEAL_IMG_DIV_ID").attr("style","display:none;");//隐藏div
*/}

function ADD_MEAL(){
	 $("#MEAL_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	 $("#MEAL_ADD_DIV_ID").attr("style","display:block;");//隐藏div
	 $.ajax({
			type:"get",
			dataType:"json",
			url:"getAllSeries",
			data:{
			},
			async:true,
			success:function(data){
				$("#ADD_MEALSERIES_NAME").empty();
				$.each(data, function(name, value) {
					$("#ADD_MEALSERIES_NAME").append(
							"<option value='"+value.seriesId+"'>" + value.seriesName
									+ "</option>")
				});
			},
			error:function(data){
				$("#tishi").html("密码错误!");
			}
		});
}


function GOTO_MEAL_NEXT_PAGE(){

	
}

function GOTO_MEAL_TAIL_PAGE(){
	
}

function GOTO_MEAL_PAGE(){
	
}


function GOTO_MEAL_HOME_PAGE(){
	
}

function GOTO_MEAL_PREVIOUS_PAGE(){
	
	 
}
function searchByMealName(){
	var mealName = $("#SEARCH_MEAL_NAME").val().trim();
	var mealSerires = $("#SEARCH_SERIES_ID").val();
	window.location.href="adminSearchByMealName?mealName="+mealName+"&mealSerires="+mealSerires;

}


(window.onresize = function () {
    var win_height = $(window).height();
    var win_width = $(window).width();
    if (win_width <= 768){
        $(".tailoring-content").css({
            "top": (win_height - $(".tailoring-content").outerHeight())/2,
            "left": 0
        });
    }else{
        $(".tailoring-content").css({
            "top": (win_height - $(".tailoring-content").outerHeight())/2,
            "left": (win_width - $(".tailoring-content").outerWidth())/2
        });
    }
})();

//弹出图片裁剪框
$("#replaceImg").on("click",function () {
    $(".tailoring-container").toggle();
});
//图像上传
function selectImg(file) {
    if (!file.files || !file.files[0]){
        return;
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        var replaceSrc = evt.target.result;
        //更换cropper的图片
        $('#tailoringImg').cropper('replace', replaceSrc,false);//默认false，适应高度，不失真
    }
    reader.readAsDataURL(file.files[0]);
}
//cropper图片裁剪
$('#tailoringImg').cropper({
    aspectRatio: 1/1,//默认比例
    preview: '.previewImg',//预览视图
    guides: false,  //裁剪框的虚线(九宫格)
    autoCropArea: 0.5,  //0-1之间的数值，定义自动剪裁区域的大小，默认0.8
    movable: false, //是否允许移动图片
    dragCrop: true,  //是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
    movable: true,  //是否允许移动剪裁框
    resizable: true,  //是否允许改变裁剪框的大小
    zoomable: false,  //是否允许缩放图片大小
    mouseWheelZoom: false,  //是否允许通过鼠标滚轮来缩放图片
    touchDragZoom: true,  //是否允许通过触摸移动来缩放图片
    rotatable: true,  //是否允许旋转图片
    crop: function(e) {
        // 输出结果数据裁剪图像。
    }
});
//旋转
$(".cropper-rotate-btn").on("click",function () {
    $('#tailoringImg').cropper("rotate", 45);
});
//复位
$(".cropper-reset-btn").on("click",function () {
    $('#tailoringImg').cropper("reset");
});
//换向
var flagX = true;
$(".cropper-scaleX-btn").on("click",function () {
    if(flagX){
        $('#tailoringImg').cropper("scaleX", -1);
        flagX = false;
    }else{
        $('#tailoringImg').cropper("scaleX", 1);
        flagX = true;
    }
    flagX != flagX;
});

//裁剪后的处理
$("#sureCut").on("click",function () {
    if ($("#tailoringImg").attr("src") == null ){
    	file="";
        return false;
    }else{
        var cas = $('#tailoringImg').cropper('getCroppedCanvas');//获取被裁剪后的canvas
        var base64url = cas.toDataURL('image/jpg'); //转换为base64地址形式
        
        $("#finalImg").prop("src",base64url);//显示为图片的形式
    
        base64url = base64url.substring(22); 
   
        file=base64url;
        
        //关闭裁剪框
        closeTailor();
    }
});
//关闭裁剪框
function closeTailor() {
    $(".tailoring-container").toggle();
}

function subphoto(){
	var mealId=$("#mealIdHidd").val();
	var file = $("#chooseImg").val();
	if(file==""){
		$.MsgBox.Alert("消息","请选择头像！");
		return;
	} 
	if(file.length>2000000){
		$.MsgBox.Alert("消息","剪裁区域的图片过大，上传头像大小不能超过2M！现在大小约为："+Math.floor((file.length/1000000))+"M");
		return;
	}
	 $("#uploadForm").ajaxSubmit({
         dataType:'json',
         data: { 
        	 "file": file,
        	 "mealId":mealId
        	 },
         type:'post',
         url: "upload",   
         beforeSubmit: function(){
             $("#maolian").html("图片上传中...");
             //$("#yulan").html("");
             
         },
         success: function(data){                   
             alert("上传成功");           
             returnMealList();
              
         },
         error: function(dataa){
             //$("#yulan").html(dataa);
                 alert("发生错误！");
         },
         resetForm: false,
         clearForm: false
         
 });           
	

	    		

}



