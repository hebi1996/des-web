<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html style="height: auto;"><head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>用户注册</title>

		<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="static/css/default/mask.css">
	</head>

	<body style="height: auto;">

		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="POST_ADD_DIV_ID" class="card card-info">
	        <input id="regUUID" type="hidden" value="">
	        <div class="form-horizontal">
				<div class="card-body">
			    	
			           <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">真实姓名：</label>
			                 <div class="col-sm-10">
			                 	<input value="${user.trueName }" type="text"  name="editTrueName" id="editTrueName" class="form-control" style="width:600px" maxlength="20" readonly="readonly">
			                 </div>
			             </div>
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">电子邮箱：</label>
			                 <div class="col-sm-10">
			                 	<input value="${user.email }" type="text" name="editEmail" id="editEmail" class="form-control" style="width:600px" maxlength="20">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">手机号码：</label>
			                 <div class="col-sm-10">
			                 	<input value="${user.phone }" type="text" name="editPhone" id="editPhone" class="form-control" style="width:600px" maxlength="20">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">送货地址：</label>
			                 <div class="col-sm-10">
			                 	<input value="${user.address }" type="text" name="editAddress" id="editAddress" class="form-control" style="width:600px" min="50">
			                 </div>
			       		  </div>
			       		  <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">积分：</label>
			                 <div class="col-sm-10">
			                 	<input value="${user.integral }" type="text" name="editIntegral" id="editIntegral" class="form-control" style="width:600px" min="50">
			                 </div>
			       		  </div>
			              <!-- /.card-body -->
	             <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%" align="center">
			               <button type="button" class="btn btn-info" onclick="edtiUserCheck()">提交</button>
			             </div>
			             <!-- /.card-footer -->
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: red;font-size: 15px">
									     
						</div>
	             <!-- /.card-footer -->
	             </div>
	             
	           
	        </div>
	    </div>
		
		
		
		
		
		<script src="static/comp/jquery/dist/jquery.js"></script>
		<script src="static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="static/kindeditor/kindeditor-all.js" type="text/javascript"></script> 
		<script src="static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="static/js/common/mask.js"></script>
		<script src="chinasofti/editUser/js/editUser.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>