<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>无锡兴海照明</title>
		<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
		<!-- 引入bootstrap -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<!-- 引入bootstrap表格 -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap-table.css" />
		<script type="text/javascript" src="js/bootstrap-table.js"></script>
		<script type="text/javascript" src="js/bootstrap-table-export.js"></script>
		<script type="text/javascript" src="js/tableExport.js"></script>
		<script type="text/javascript" src="js/plugins/z-notice.js"></script>
		<script type="text/javascript" src="js/jquery.slimscroll.js"></script>
		<script type="text/javascript" src="js/home/manage.js"></script>

		<link rel="stylesheet" type="text/css" href="css/home/default.css" />
	</head>
	<body>
		<jsp:include page="jsp_content/left.html" />
		<div class="right_side">
			<div class="main_content">
				<div class="tab_panel">
					<label id="customer_tab" class="actived">
						客户查询
					</label>
					<label id="customer_order_tab" style="display: none;">
						客户订单
					</label>
					<label id="order_tab" style="display: none;">
						订单详情
					</label>
					<!-- <button id="add_order_btn" class="btn-1"
						style="float: right; margin-top: 10px; margin-right: 20px;">
						添加
					</button> -->
				</div>
				<!-- 客户查询，添加 -->
				<div class="table_panel" id="tab1">
					<div style="width: 800px; height: 300px; margin: auto;">
						<form class="form-horizontal" id="cust-form">
							<div class="form-group">
								<label class="control-label col-sm-2" for="cust-name">
									姓名
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cust-name"
										placeholder="客户姓名">
									<span id="cust-name-block" class="help-block"
										style="display: none;">请填写客户姓名</span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="cust-tel">
									固定电话
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cust-tel"
										placeholder="固定电话">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="cust-phone">
									手机
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cust-phone"
										placeholder="手机号码">
									<span id="cust-phone-block" class="help-block"
										style="display: none;">固定电话或手机号码必填一项</span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="cust-add">
									地址
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cust-add"
										placeholder="客户地址">
									<span id="cust-add-block" class="help-block"
										style="display: none;">请填写客户地址</span>
								</div>
							</div>
						</form>
						<button class="btn btn-primary" style="float: right;" id="save">
							新 增
						</button>
					</div>
					<table id="customer_table"></table>
				</div>
				
				<!-- 客户订单查询，添加 -->
				<div class="table_panel" id="tab2" style="display: none;">
					<div style="width: 800px; height: 300px; margin: auto;">
						<form class="form-horizontal" id="order-form">
							<div>
							<div class="form-group">
								<label class="control-label col-sm-1" for="order-lamp-1">
										品名
								</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="order-lamp-1"
										placeholder="品名">
									<span id="order-lamp-1-block" class="help-block"
										style="display: none;">请填写品名</span>
								</div>
								<label class="control-label col-sm-1" for="lamp-price-1">
									单价
								</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="lamp-price-1"
										placeholder="单价">
								</div>
								<label class="control-label col-sm-1" for="lamp-number-1">
									数量
								</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="lamp-number-1"
										placeholder="数量">
									<span id="lamp-number-1-block" class="help-block"
										style="display: none;">请输入数量</span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-1" for="lamp-desc-1">
									备注
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="lamp-desc-1"
										placeholder="备注">
								</div>
								<span id="new-lamp-line" class="btn-1" style="display: inline-block;text-align: center;"> + </span>
							</div>
						</div>
						</form>
						<button class="btn btn-primary" style="float: right;" id="save-order">
							新 增
						</button>
					</div>
					<table id="customer_order_table"></table>
				</div>
				
				<!-- 客户订单详情查询 -->
				<div class="table_panel" id="tab3" style="display: none;">
					<table id="order_table"></table>
				</div>
			</div>
		</div>
	</body>
</html>