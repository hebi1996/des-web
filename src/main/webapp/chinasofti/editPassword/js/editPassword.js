function adminSubPassword(){
	var newPassword=$("#newPassword").val();
	var newPasswordCon=$("#newPasswordCon").val()
	var oldPassword=$("#oldPassword").val()
	var username=$()
	
	
	if(typeof (newPassword) == 'undefined' || newPassword.trim()==""  ){
		$("#tishi").html("新密码不能为空");
		return;
	}

	if(typeof (newPasswordCon) == 'undefined' || newPasswordCon.trim()==""){
		$("#tishi").html("确认密码不能为空");
		return;
	}
	if(newPassword.trim()!=newPasswordCon.trim()){
		$("#tishi").html("新密码与确认密码必须保持一致");
		return;
	}
	
	if(typeof (oldPassword) == 'undefined' || oldPassword.trim()==""  ){
		$("#tishi").html("当前密码不能为空");
		return;
	}
	 $.ajax({
			type:"get",
			dataType:"json",
			url:"editAdminPassword",
			data:{
				"oldPassword":oldPassword,
				"newPassword":newPassword
			},
			async:true,
			success:function(data){
				alert("修改成功，请重新登录！")
				window.location.replace("./adminlogin.jsp");
			},
			error:function(data){	
				$("#tishi").html("原密码错误!");
			}
		});
	
}
function userSubPassword(){
	
	var newPassword=$("#newPassword").val();
	var newPasswordCon=$("#newPasswordCon").val()
	var oldPassword=$("#oldPassword").val()
	
	
	if(typeof (newPassword) == 'undefined' || newPassword.trim()==""  ){
		$("#tishi").html("新密码不能为空");
		return;
	}

	if(typeof (newPasswordCon) == 'undefined' || newPasswordCon.trim()==""){
		$("#tishi").html("确认密码不能为空");
		return;
	}
	if(newPassword.trim()!=newPasswordCon.trim()){
		$("#tishi").html("新密码与确认密码必须保持一致");
		return;
	}
	
	if(typeof (oldPassword) == 'undefined' || oldPassword.trim()==""  ){
		$("#tishi").html("当前密码不能为空");
		return;
	}
	$.ajax({
		type:"get",
		dataType:"json",
		url:"editUserPassword",
		data:{
			"oldPassword":oldPassword,
			"newPassword":newPassword
		},
		async:true,
		success:function(data){
			alert("修改成功，请重新登录！")
			window.location.replace("./userlogin.jsp");
		},
		error:function(data){	
			$("#tishi").html("原密码错误!");
		}
	});
	
}
