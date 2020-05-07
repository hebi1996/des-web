<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
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
		<div class="container-fluid" id="MEAL_LIST_DIV_ID" style="display:block;">
			
			
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3 class="card-title col-md-3">当前：<span id="LABLE_FATHER_ORG_NAME">我的订单</span></h3>
							<div class="col-md-2 col-md-offset-7" id="mealAddDiv">
								
							</div>
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
	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">订单编号</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">订单时间</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">订单状态</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">总额</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">详细</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">处理</th>
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
											<c:forEach items="${orders }" var="o">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${o.oid }</td>
														<td valign="center" align="center" width="500px"><f:formatDate value="${o.orderTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
														<c:if test="${o.orderState eq 0}">
															<td valign="center" align="center" width="30">已下单</td>
														</c:if>
														<c:if test="${o.orderState eq 1}">
															<td valign="center" align="center" width="30">已接单</td>
														</c:if>
														<c:if test="${o.orderState eq 2}">
															<td valign="center" align="center" width="30">已送货</td>
														</c:if>
														<c:if test="${o.orderState eq 3}">
															<td valign="center" align="center" width="30">已完成</td>
														</c:if>
														<c:if test="${o.orderState eq 4}">
															<td valign="center" align="center" width="30">已取消</td>
														</c:if>
														<c:if test="${o.orderState eq 5}">
															<td valign="center" align="center" width="30">已申请取消</td>
														</c:if>
														
														<td valign="center" align="center" width="30"><f:formatNumber value="${o.orderPrice }" type="currency" pattern="￥.0"/></td>
														<td valign="center" align="center" width="30">
															<a href="" onclick="orders_info('${o.oid}'); return false;">详细信息</a>
														</td>
														<c:if test="${o.orderState eq 0}">
															<td valign="center" align="center" width="30">
																待接单
																<a href="" onclick="orders_cancel('${o.oid}','5'); return false;">取消</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 1}">
															<td valign="center" align="center" width="30">
																已接单
																<a href="" onclick="orders_cancel('${o.oid}','5'); return false;">取消</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 2}">
															<td valign="center" align="center" width="30">
																<a href="" onclick="orders_handle('${o.oid}','3'); return false;">收货</a>
																<a href="" onclick="orders_cancel('${o.oid}','5'); return false;">取消</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 3}">
															<td valign="center" align="center" width="30">已完成
																<a href="" onclick="orders_evaluate('${o.oid}'); return false;">评价</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 5}">
															<td valign="center" align="center" width="30">
																待回复
															</td>
														</c:if>
															
														
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
											<ul class="pagination" id="PAGE_ID">
												
												
													
											</ul>
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
		
		<div id="orderInfoDivId" class="card card-info" style="display:none;">
			
		
	    	<div class="card-header">
	             <h3 class="card-title">订单详细</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
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
	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜系</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜品</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">单价</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">数量</th>
													
			
												</tr>
											</thead>
											<tbody id="orderInfoListDivId">
												<%-- <c:forEach items="${sonOrders }" var="son">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${son.foodInfo.cuisine.seriesName }</td>
														<td valign="center" align="center" width="30">${son.foodInfo.mealName }</td>
														<td valign="center" align="center" width="30">${son.mealPrice }</td>
														<td valign="center" align="center" width="30">${son.mealCount }</td>
													</tr>
												</c:forEach> --%>
											</tbody>
											<tfoot></tfoot>
										</table>
									</div>
								</div>
								
							</div>
						
			             

	             </div>
	            <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%" align="center">
			               
			               <button type="button" class="btn btn-default" onclick="returnordersList()">返回</button>
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
		<script src="chinasofti/myOrders/js/myOrders.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		


</body></html>