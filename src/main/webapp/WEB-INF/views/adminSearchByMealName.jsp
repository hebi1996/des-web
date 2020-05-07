<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html style="height: auto;"><head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>JZ - 极宅 外卖网</title>

		<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="static/css/default/mask.css">
		
		<link rel="stylesheet" href="static/comp/cropper/css/cropper.min.css">
    	<link rel="stylesheet" href="static/comp/cropper/css/ImgCropping.css">
	</head>

	<body style="height: auto;">
		
		
		<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
		<div class="container-fluid" id="MEAL_LIST_DIV_ID">
			<div class="row">
				<div class="col-md-12" style="">
					<div class="card card-info">
						<div class="card-header">
							<h3 class="card-title">查询条件</h3>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-11">
									<div class="form-inline">
										<div class="form-group col-md-4">
											<label for="SEARCH_ORG_NAME" class="col-md-4">菜名：</label>
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_MEAL_NAME_HIDDEN" name="SEARCH_MEAL_NAME_HIDDEN" value="">
												<input type="text" id="SEARCH_MEAL_NAME" name="SEARCH_MEAL_NAME" size="20" value="" class="form-control" placeholder="请输入菜品名称">
												
											</div>
											
											
										</div>
										
										<div class="form-group col-md-4">
											
											
											<label for="SEARCH_ORG_NAME" class="col-md-4">菜品：</label>
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_SERIES_ID_HIDDEN" name="SEARCH_SERIES_NAME_HIDDEN" value="${mealSeries }">
												<select id="SEARCH_SERIES_ID" name="SEARCH_SERIES_ID">
												
												<option value="">所有菜系</option><option value="1">鲁菜</option><option value="2">川菜</option><option value="3">粤菜</option><option value="4">苏菜</option><option value="5">闽菜</option><option value="6">浙菜</option><option value="7">湘菜</option><option value="8">徽菜</option><option value="9">西餐</option><option value="10">西点</option><option value="11">药膳</option><option value="12">私房菜</option></select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1">
									<button class="btn btn-block btn-info" onclick="searchByMealName()">查询</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3 class="card-title col-md-3">当前：<span id="LABLE_FATHER_ORG_NAME">菜品管理</span></h3>
							<div class="col-md-2 col-md-offset-7" id="mealAddDiv"><button class="btn  btn-success btn-sm" type="button" onclick="ADD_MEAL()">新增</button>&nbsp;&nbsp;</div>
						</div>
						<div class="card-body">
							<div id="example2_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12 col-md-6"></div>
									<div class="col-sm-12 col-md-6"></div>
								</div>
								
								<div class="row">
									<div class="col-sm-12">
										<table id="example2" class="table table-bordered table-hover dataTable" role="grid">
											<thead>
												<tr role="row">
	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">序号</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜系</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜名</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">摘要</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">价格</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">编辑</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">图片</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">删除</th>
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
												<c:forEach items="${meals }" var="m" >
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${m.mealId }</td>
														<td valign="center" align="center" width="30">${m.cuisine.seriesName }</td>
														<td valign="center" align="center" width="30">${m.mealName }</td>
														<td valign="center" align="center" width="30">${m.mealSummarize }</td>
														<td valign="center" align="center" width="30">${m.mealPrice }</td>
														<td valign="center" align="center" width="30"><a
															href="javascript:" onclick="meal_edit('${m.mealId}','${m.mealName}','${m.mealSeriesId }','${m.mealSummarize }','${m.mealDescription }','${m.mealPrice }')">编辑</a></td>
														<td valign="center" align="center" width="30"><a
															href="javascript:" onclick="meal_edit_img('${m.mealId}')">上传</a>
														</td>
														<td valign="center" align="center" width="30"><a
															href="javascript:" onclick="DELETE_MEAL('${m.mealId}')">删除</a></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot></tfoot>
										</table>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-9 col-md-offset-3">
										<div class="dataTables_paginate paging_simple_numbers">
												<%-- 										<ul class="pagination" id="PAGE_ID">
												<c:if test="${page.prev }">
													<li><a href="mealseriesManage?page=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
													<li><a href="mealseriesManage?page=${page.now_page-1 }">上一页</a></li>
												</c:if>
												<c:if test="${page.next }">
													<li><a href="mealseriesManage?page=${page.now_page+1 }">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
													<li><a href="mealseriesManage?page=${page.page_total }">尾页</a></li>
												</c:if>
												
												<li style="margin-left: 30px">
													<input id="JUMP_INPUT_ID" type="text" style="display:inline;width:80px" size="6">
													<button id="goto_page" class="btn btn-sm btn-outline-primary"><a href="javascript:">跳转</a></button>
												</li>
												
												<li style="margin-left: 30px">
													<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px">
														<span>${page.now_page }/${page.page_total } 页</span>
														<span>共12条</span>
													</div>
												</li>
											</ul> --%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>

				</div>

			</div>

		</div>
		
		
		
		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="MEAL_ADD_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">菜品添加</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
	             <div class="card-body">
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">菜名：</label>
			              	 <div class="col-sm-10">
			                 	<input value="" type="text" name="ADD_MEAL_NAME" id="ADD_MEAL_NAME" class="form-control" style="width:900px" maxlength="20">
			                 </div>
			             </div>
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">菜系：</label>
			                 <div class="col-sm-10">
			                 	<select style="width:900px" class="form-control" id="ADD_MEALSERIES_NAME" name="ADD_MEALSERIES_NAME">
								
								</select>
			                 </div>
			             </div>
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">摘要：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="text" name="ADD_MEAL_SUMMARIZE" id="ADD_MEAL_SUMMARIZE" class="form-control" style="width:900px" maxlength="250">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">介绍：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="text" name="ADD_MEAL_DESCRIPTION" id="ADD_MEAL_DESCRIPTION" class="form-control" style="width:900px" maxlength="250">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">价格：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="number" name="ADD_MEAL_PRICE" id="ADD_MEAL_PRICE" class="form-control" style="width:900px" min="1">
			                 </div>
			       		  </div>
			           
			             <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%" align="center">
			               <button type="button" class="btn btn-info" onclick="addMealCheck()">提交</button>
			               <button type="button" class="btn btn-default" onclick="returnMealList()">返回</button>
			             </div>
			             <!-- /.card-footer -->
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: red;font-size: 15px">
									     
						</div>
	             </div>
	            
	        </div>
	    </div>
		
		<div id="MEAL_EDIT_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">菜品编辑</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
	             <div class="card-body">
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">菜名：</label>
			              	 <div class="col-sm-10">
			              	 	<input type="hidden" id="EDIT_MEAL_HIDDE" name="EDIT_MEAL_HIDDE" value="">
			                 	<input value="" type="text" name="EDIT_MEAL_NAME" id="EDIT_MEAL_NAME" class="form-control" style="width:900px" maxlength="20">
			                 </div>
			             </div>
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">菜系：</label>
			                 <div class="col-sm-10">
			                 	<select style="width:900px" class="form-control" id="EDIT_MEALSERIES_NAME" name="EDIT_MEALSERIES_NAME">
								</select>
			                 </div>
			             </div>
			             <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">摘要：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="text" name="EDIT_MEAL_SUMMARIZE" id="EDIT_MEAL_SUMMARIZE" class="form-control" style="width:900px" maxlength="250">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">介绍：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="text" name="EDIT_MEAL_DESCRIPTION" id="EDIT_MEAL_DESCRIPTION" class="form-control" style="width:900px" maxlength="250">
			                 </div>
			              </div>
			              <div class="form-group">
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">价格：</label>
			                 <div class="col-sm-10">
			                 	<input value="" type="number" name="EDIT_MEAL_PRICE" id="EDIT_MEAL_PRICE" class="form-control" style="width:900px" min="1">
			                 </div>
			       		  </div>
			            
			             <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%" align="center">
			               <button type="button" class="btn btn-info" onclick="editMealCheck()">提交</button>
			               <button type="button" class="btn btn-default" onclick="returnMealList()">返回</button>
			             </div>
			             <!-- /.card-footer -->
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi1" style="text-align: center;color: red;font-size: 15px">
									     
						</div>
	             </div>
	            
	        </div>
	    </div>
		
		<div id="MEAL_IMG_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">上传图片</h3>
	        </div> 
	        <input id="mealIdHidd" type="hidden" value="">
	        <div class="form-horizontal">
				<div class="card-body" style="text-align: center;">
			       <!-- ------------ -->
			       <button id="replaceImg" class="l-btn">更换图片</button>
				   <button class="l-btn" onclick="subphoto()">提交图片</button>
				   <button class="l-btn" onclick="returnMealList()">返回列表</button>
				   
					<div style="height:10px"></div>
					<div style="width: 150px;height: 150px;border: solid 1px #555;padding: 5px; margin: 0 auto;">
					    <img id="finalImg" src="" width="100%">
					</div>
					<div>
						<span id="maolian"></span>
					</div>


					<!--图片裁剪框 start-->
					<div style="display: none" class="tailoring-container">
					    <div class="black-cloth" onclick="closeTailor(this)"></div>
					    <div class="tailoring-content" style="top: -208px; left: 178px;">
					            <div class="tailoring-content-one">
					            <form enctype="multipart/form-data" id="uploadForm">
					                <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
					                	
					                    	<input type="file" accept="image/jpg,image/jpeg,image/png" name="file" id="chooseImg" class="hidden" onchange="selectImg(this)">
					                    选择图片
					                    
					                </label>
					                <div class="close-tailoring" onclick="closeTailor(this)">×</div>
					            </form>
					            </div>
					            <div class="tailoring-content-two">
					                <div class="tailoring-box-parcel">
					                    <img id="tailoringImg">
					                </div>
					                <div class="preview-box-parcel">
					                    <p>图片预览：</p>
					                    <div class="square previewImg"></div>
					                    <div class="circular previewImg"></div>
					                </div>
					            </div>
					            <div class="tailoring-content-three">
					                <button class="l-btn cropper-reset-btn">复位</button>
					                <button class="l-btn cropper-rotate-btn">旋转</button>
					                <button class="l-btn cropper-scaleX-btn">换向</button>
					                <button class="l-btn sureCut" id="sureCut">确定</button>
					            </div>
					        </div>
					</div>
			      <!-- --------------- -->
	             </div>

	        </div>
	    </div>
	    <script type="text/javascript">
	    	
	   
	    /** 文档加载完成后立即执行的方法 */
	    // var weeks = new Array();
	    	 setTimeout(function(){
	    		var series = $("#SEARCH_SERIES_ID_HIDDEN").val();
	    		$("#SEARCH_SERIES_ID option[value="+series+"]").attr("selected","selected");
	    	 	}
	    	 )
	    
	
	    
	    </script>
		
		<script src="static/comp/jquery/dist/jquery.js"></script>
		<script src="static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="static/kindeditor/kindeditor-all.js" type="text/javascript"></script> 
		<script src="static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="static/js/common/mask.js"></script>
		<script src="static/comp/cropper/js/cropper.min.js"></script>
		<script src="chinasofti/mealManage/js/mealManage.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>