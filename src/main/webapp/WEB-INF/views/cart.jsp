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
	</head>

	<body style="height: auto;">
		<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
		<div class="container-fluid" id="MEALSERIES_LIST_DIV_ID">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3 class="card-title col-md-3">当前：<span id="LABLE_FATHER_ORG_NAME">购物车</span></h3>
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
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">全选</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜系</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">菜名</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">单价</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">数量</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">操作</th>
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
												<c:forEach items="${carts }" var="carts" varStatus="c">
													<tr bgcolor="#FFFFFF">
														<td valign="center" align="center" width="30">
															<input type="checkbox">
														</td>
														<td valign="center" align="center" width="30" value="">${carts.foodInfo.cuisine.seriesName }</td>
														<td valign="center" align="center" width="30" value="">${carts.foodInfo.mealName }</td>
														<%--需要进行价格的累加--%>
														<td valign="center" align="center" width="30" value="">${carts.foodInfo.mealPrice }</td>
														<td valign="center" align="center" width="30" value="">${carts.count }</td>
														<td valign="center" align="center" width="30">
															<a href="" onclick="DELETE_CAET('${carts.cartId}'); return false;">删除</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
											</tfoot>
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
					<div class="col-md-5 col-md-offset-7" id="mealseriesAddDiv">
						<select id="payType">
							<option value="货到付款">货到付款</option>
							<option value="微信">微信</option>
						</select>
						<button class="btn  btn-success btn-sm" type="button" onclick="ADD_ORDERS()">提交订单</button>&nbsp;&nbsp;
						<button type="button" class="btn btn-default" onclick="CLEAR_CART()">清空购物车</button>
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
		<script src="chinasofti/cart/js/cart.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>