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
					<label id="add_order_tab" style="display: none;">
						新增订单
					</label>
					<button id="add_order_btn" class="btn-1"
						style="float: right; margin-top: 10px; margin-right: 20px;">
						添加
					</button>
				</div>
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
							确 定
						</button>
					</div>
					<table id="customer_table"></table>
				</div>
				<div class="table_panel" id="tab2" style="display: none;">
					<table id="customer_order_table"></table>
				</div>
				<div class="table_panel" id="tab3" style="display: none;">
					<table id="order_table"></table>
				</div>
				<div class="table_panel" id="tab4" style="display: none;">
					<form method="post" action="orderAction!addOrder.action">
						<div style="width: 100%; height: 30px; margin: 10px 0px;">
							<label class="input_label">
								客户姓名 :
							</label>
							<input type="text" id="customer_name" class="form_input" />
							<input type="text" id="customer_id" name="orderCustomerId" />
						</div>
						<div style="width: 100%; height: 30px; margin: 10px 0px;">
							<label class="input_label">
								预计送货日期 :
							</label>
							<input type="text" id="delivery_date" class="form_input"
								name="deliveryDate" />
						</div>
						<div style="width: 100%; height: 30px; margin: 10px 0px;">
							<label class="input_label">
								备注 :
							</label>
							<input type="text" id="order_description" class="form_input"
								name="orderDescription" />
						</div>
						<div class="detail_div">
							<div style="width: 100%; height: 30px; margin: 10px 0px;">
								<label class="detail_input_label">
									品名 :
								</label>
								<input type="text" name="lamp" class="form_input" />
								<label id="add_div" class="btn-1"
									style="margin-left: 20px; text-align: center;">
									+
								</label>
							</div>
							<div style="width: 100%; height: 30px; margin: 10px 0px;">
								<label class="detail_input_label">
									单价 :
								</label>
								<input type="text" name="price" class="form_detail_input" />
								<label class="detail_input_label" style="width: 100px;">
									数量 :
								</label>
								<input type="text" name="number" class="form_detail_input" />
							</div>
							<div style="width: 100%; height: 30px; margin: 10px 0px;">
								<label class="detail_input_label">
									备注 :
								</label>
								<input type="text" name="description" class="form_input" />
							</div>
						</div>
						<button type="submit" id="submit" style="display: none;">
							提交
						</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>