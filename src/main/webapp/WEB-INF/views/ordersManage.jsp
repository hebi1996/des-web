<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
											<label for="SEARCH_ORG_NAME" class="col-md-4">订单号：</label>
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_OID_HIDDEN" name="SEARCH_OID_HIDDEN" value="">
												<input type="text" id="SEARCH_OID" name="SEARCH_OID" size="20" value="" class="form-control" placeholder="请输入订单号">
												
											</div>
											
											
										</div>
										
										<div class="form-group col-md-4">
											
											
											<label for="SEARCH_ORG_NAME" class="col-md-4">订单状态：</label>
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_ORDER_STATE_HIDDEN" name="SEARCH_ORDER_STATE_HIDDEN" value="">
												<select id="SEARCH_ORDER_STATE" name="SEARCH_ORDER_STATE">
													<option value="">全部</option>
													<option value="0">未接单</option>
													<option value="1">未送出</option>
													<option value="2">待收货</option>
													<option value="3">已完成</option>
													<option value="4">已取消</option>
													<option value="5">待取消</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1">
									<button class="btn btn-block btn-info" onclick="searchByOrderOid()">查询</button>
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
							<h3 class="card-title col-md-3">当前：<span id="LABLE_FATHER_ORG_NAME">订单管理</span></h3>
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
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">支付方式</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">详细</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">处理</th>
			
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
												<c:forEach items="${orders }" var="o">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${o.oid }</td>
														<td valign="center" align="center" width="350px"><f:formatDate value="${o.orderTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
															<td valign="center" align="center" width="30">待取消</td>
														</c:if>
														<td valign="center" align="center" width="30"><f:formatNumber value="${o.orderPrice }" type="currency" pattern="￥.0"/></td>
														<td valign="center" align="center" width="30">${o.payType }</td>
														<td valign="center" align="center" width="30">
															<a href="" onclick="orders_info('${o.oid}'); return false;">详细信息</a>
														</td>
														<c:if test="${o.orderState eq 0}">
															<td valign="center" align="center" width="30">
																<a href="" onclick="orders_handle('${o.oid }','1'); return false;">接单</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 1}">
															<td valign="center" align="center" width="30">
																<a href="" onclick="orders_handle('${o.oid }','2'); return false;">送出</a>
															</td>
														</c:if>
														
														<c:if test="${o.orderState eq 2}">
															<td valign="center" align="center" width="30">
																待收货
															</td>
														</c:if>
														
														<c:if test="${o.orderState eq 5}">
															<td valign="center" align="center" width="30">
																<a href="" onclick="orders_handle('${o.oid }','4'); return false;">作废</a>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 3}">
															<td valign="center" align="center" width="30">已完成
																<span><a href="javascript:">查看评价</a></span>
															</td>
														</c:if>
														<c:if test="${o.orderState eq 4}">
															<td valign="center" align="center" width="30">已取消
																<span><a href="javascript:"></a></span>
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
											<ul class="pagination" id="PAGE_ID"><li style="margin-left: 30px">		<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px"><span>1/1 页</span> <span>共1条</span></div></li></ul>
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
	             <h3 class="card-title">下单用户</h3>
	        </div>
		 <div class="form-horizontal">
	        							
	             <div class="card-body">
			        
			        
							<div id="example2_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
								
								<div class="row">
									<div class="col-sm-12">
										<table id="example2" class="table table-bordered table-hover dataTable" role="grid">
											<thead>
												<tr role="row">
	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">用户</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">姓名</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">邮箱</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">电话</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">地址</th>
												</tr>
											</thead>
											<tbody id="orderInfoUserListDivId">
												<%-- <c:if test="${uao.user ne null }">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${uao.user.loginName }</td>
														<td valign="center" align="center" width="30">${uao.user.trueName }</td>
														<td valign="center" align="center" width="30">${uao.user.email }</td>
														<td valign="center" align="center" width="30">${uao.user.phone }</td>
														<td valign="center" align="center" width="30">${uao.user.address }</td>
													</tr>
												</c:if> --%>
											</tbody>
											<tfoot></tfoot>
										</table>
									</div>
								</div>
								
							</div>
						
	             </div>
	            
	        </div>
		
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
												<%-- <c:forEach items="${uao.orders }" var="o">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">${o.foodInfo.cuisine.seriesName }</td>
														<td valign="center" align="center" width="30">${o.foodInfo.mealName }</td>
														<td valign="center" align="center" width="30">${o.foodInfo.mealPrice }</td>
														<td valign="center" align="center" width="30">${o.mealCount }</td>
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
		<script src="chinasofti/ordersManage/js/ordersManage.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>