var uk ="_uk_",pk="_pk_",rk="_rk_";
$(function(){
	layui.use("layer");
	$("#loginName").focus();
	$("#loginName").val($.localStorage.get(uk));
	$("#loginPwd").val($.localStorage.get(pk));
	if($.localStorage.get(rk)){
		$("#rememberPwd").attr("checked",true);
	}
	
});
function subLogin(){
    var $msg = $("#message"),$usrname=$("#loginName"),$pwd=$("#loginPwd"),$rememberPwd = $("#rememberPwd");
    var usrname = $usrname.val()||"";

	var pwd = $pwd.val()||"";
	if(usrname.trim().length==0){
		$("#tishi").html("用户名不能为空");
		return ;
	}
    if(pwd.trim().length==0){
    	$("#tishi").html("密码不能为空!");
        return ;
    }
    if($rememberPwd.is(':checked')){
    	$.localStorage.set(uk, usrname);
    	$.localStorage.set(pk, pwd);
    	$.localStorage.set(rk, true);
    }else{
    	$.localStorage.remove(uk);
    	$.localStorage.remove(pk);
    	$.localStorage.remove(rk);
    }
   $.ajax({
		type:"get",
		dataType:"json",
		url:"toadmain",
		data:{
			"username":usrname,
			"password":pwd
		},
		async:true,
	   success:function(data){
		   //?menuUserName="+usrname.trim()+"&admin=0
		   window.location.replace("adminMain?menuUserName=" +usrname.trim() + "&admin=0");
	   },
		error:function(data){
			$("#tishi").html("密码错误!");
		}
	});
}





if(window !=top){
	top.location.href=location.href;
}


