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
    	<style type="text/css">
    		#mb_con{
    			top:130px!important
    		}
    	</style>
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
												<input type="hidden" id="SEARCH_SERIES_ID_HIDDEN" name="SEARCH_SERIES_NAME_HIDDEN" value="">
												<select id="SEARCH_SERIES_ID" name="SEARCH_SERIES_ID">
								
												<option value="">所有菜系</option><option value="1">鲁菜</option><option value="2">川菜</option><option value="3">粤菜</option><option value="4">苏菜</option><option value="5">闽菜</option><option value="6">浙菜</option><option value="7">湘菜</option><option value="8">徽菜</option><option value="9">法国菜</option><option value="10">意大利菜</option><option value="11">韩国料理</option><option value="12">日本料理</option></select>
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
							<h3 class="card-title col-md-3">当前：<span id="LABLE_FATHER_ORG_NAME">菜单</span></h3>
							<div class="col-md-2 col-md-offset-7" id="mealAddDiv">
								
							</div>
						</div>
						<div class="card-body">
							<div id="example2_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">

								<div class="row">
									<div class="col-12">
										<div class="card">
										
											<div class="card-body">
												<div id="example3_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
													<c:forEach items="${foods }" var="meals" varStatus="index">
														<div class="row">
															<div class="form-inline col-sm-12">
																<div><img src="img/meal/${meals.mealImage }" style="whith:80px;height:80px"></div>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<div>
																	<table>
																		<tbody>
																			<tr>
																				<td style="font-size: medium;font-family: Serif"  >菜名：${meals.mealName }</td>
																			</tr>
																			<tr>
																				<td style="font-size: small;font-family: Serif" >价格：￥${meals.mealPrice }</td>
																			</tr>
																			<tr>
																				<td style="font-size: small;font-family: Serif">商品描述：${meals.mealSummarize }</td>
																			</tr>
																			<tr>
																				<td style="font-size: small;font-family: Serif" >数量：
																					<select id="my${index.count}">
																						<option value="1">1</option>
																						<option value="2">2</option>
																						<option value="3">3</option>
																						<option value="4">4</option>
																						<option value="5">5</option>
																					</select>
																				</td>

																				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																					<button value="" type="button" class="btn btn-info" onclick="addShoppingCart('${meals.mealId}','my${index.count }')">加入购物车</button>
																				</td>
																			</tr>
																			<tr>
																				<td style="font-size: small;font-family: Serif">
																					商家联系电话：${meals.shPhone}
																				</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<hr>
													</c:forEach>
												</div>
											</div>
											<!-- /.card-body -->
										</div>
					
									</div>
					
								</div>
						
							</div>
						</div>
						<!-- /.card-body -->
					</div>

				</div>

			</div>
			<div class="row">
									<div class="col-sm-12 col-md-9 col-md-offset-3">
										<div class="dataTables_paginate paging_simple_numbers">
											<ul class="pagination" id="PAGE_ID">
												<li style="margin-left: 30px">
													<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px">
														<span>1/1 页</span>
														<span>共5条</span>
													</div>
												</li>
											</ul>
										</div>
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
		<script src="static/comp/cropper/js/cropper.min.js"></script>
		<script src="chinasofti/meal/js/meal.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>