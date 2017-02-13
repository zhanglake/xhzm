var ManageController = {
	now_order_line: 1,
	customer_id: null,
	init : function() {
		// 滚动条
		$(".main_content").slimScroll({
			height: '100%'
		});

		// 导航栏选中样式设置
		$("#manage_page").parent().addClass("nav_div_selected");
		
		// 标签切换事件
		$("#customer_tab").click(function() {
			ManageController.switchCustomerTab();
		});
		$("#customer_order_tab").click(function() {
			ManageController.switchCustomerOrderTab();
		});

		// 保存客户
		$("#save").click(function(){
			var name = $("#cust-name").val();
			var tel = $("#cust-tel").val();
			var phone = $("#cust-phone").val();
			var address = $("#cust-add").val();
			var customer = {
					"customerDto.name": name,
					"customerDto.telephone": tel,
					"customerDto.phone": phone,
					"customerDto.address": address
			};
			$.ajax({
				url: "customerAction!addCustomer.action",
				type: "post",
				dataType: "json",
				data: customer,
				success: function (data) {
					if (data.status === "success") {
						$.z_notice("success");
						$("#customer_table").bootstrapTable('refresh', {url: "manage!findAllCustomers.action"});
						ManageController.clearForm("customer");
					}
				},
				error: function () {
					$.z_notice("danger", "新增客户信息失败");
				}
			})
		});
		
		// 初始化表格
		$('#customer_table').bootstrapTable({
			url : 'manage!findAllCustomers.action',
			method : 'post',
			dataType : 'json',
			pagination : true,
			pageSize : 10,
			search : true,
			paginationPreText : '上一页',
			paginationNextText : '下一页',
			showExport : true,
			exportDataType : "basic",
			columns : 
				[{
					field : 'name',
					title : '客户姓名'
				}, {
					field : 'address',
					title : '地址'
				}, {
					field : 'telephone',
					title : '电话'
				}, {
					field : 'phone',
					title : '手机'
				}, {
					field : 'operate',
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
									return ['<a class="view" href="javascript:void(0)">查看订单</a>'].join('');
								},
					events : ManageController.customerOperateEvents
				} ],
		});
		
		// 新建订单时增加新的一行
		$("#new-lamp-line").click(function () {
			ManageController.now_order_line ++;
			var number = ManageController.now_order_line;
			
			var html_ = '<div><div class="form-group">';
			html_ += '<label class="control-label col-sm-1" for="order-lamp-' + number + '">品名</label>';
			html_ += '<div class="col-sm-3"><input type="text" class="form-control" id="order-lamp-'+number+'" placeholder="品名">';
			html_ += '<span id="order-lamp-'+number+'-block" class="help-block" style="display: none;">请填写品名</span></div>';
			html_ += '<label class="control-label col-sm-1" for="lamp-price-'+number+'">单价</label>';
			html_ += '<div class="col-sm-3"><input type="text" class="form-control" id="lamp-price-'+number+'" placeholder="单价"></div>';
			html_ += '<label class="control-label col-sm-1" for="lamp-number-'+number+'">数量</label>';
			html_ += '<div class="col-sm-3"><input type="text" class="form-control" id="lamp-number-'+number+'" placeholder="数量">';
			html_ += '<span id="lamp-number-'+number+'-block" class="help-block" style="display: none;">请输入数量</span></div>';
			html_ += '</div>';
			html_ += '<div class="form-group"><label class="control-label col-sm-1" for="lamp-desc-'+number+'">备注</label>';
			html_ += '<div class="col-sm-10"><input type="text" class="form-control" id="lamp-desc-'+number+'" placeholder="备注"></div>';
			html_ += '<span class="btn-1 remove-lamp" style="display: inline-block;text-align: center;"> - </span>';
			html_ += '</div></div>';
			
			$("#order-form").append(html_);
		});
		// 删除行form
		$("#order-form").on("click", ".remove-lamp", function () {
			$(this).parent().parent().remove();
		});
		// 保存订单
		$("#save-order").click(function () {
			var n = ManageController.now_order_line;
			var orderDetailList = new Array();
			for (var i = 1; i <= n; i++) {
				var lampName = $("#order-lamp-" + i).val();
				var lampPrice = $("#lamp-price-" + i).val();
				var lampNumber = $("#lamp-number-" + i).val();
				var lampDesc = $("#lamp-desc-" + i).val();
				var orderDetail = {
						"lampName": lampName,
						"lampPrice": lampPrice,
						"lampNumber": lampNumber,
						"lampDesc": lampDesc
				}
				orderDetailList.push(orderDetail);
			}
			var orderDto = {
					"customerId": ManageController.customer_id,
					"orderDetail": orderDetailList
			}
			var requestData = 'orderReq =' + JSON.stringify(orderDto);
			$.ajax({
				url: "orderAction!createOrderAndOrderDetail.action",
				type: "post",
				dataType: "json",
				data: requestData,
				success: function (data) {
					if (data.status === "success") {
						$.z_notice("success");
						$("#customer_order_table").bootstrapTable('refresh', {url: "manage!showOrderByCustomer.action"});
						ManageController.clearForm("order");
					}
				},
				error: function () {
					$.z_notice("danger", "新增订单失败");
				}
			})
		});
	},
	// 清空
	clearForm: function (type) {
		if (type === "customer") {
			$("#cust-form").find("input").val("");	
		}
		if (type === "order") {
			$("#order-form").find("input").val("");
			$("#order-form").find(".remove-lamp").parent().parent().remove();
			
		}
	},
	
	// 点击超链接事件
	customerOperateEvents : {
		'click .view': function (e, value, row, index) {
			var customer_id = row.customerId;
			ManageController.customerOrder(customer_id);
			ManageController.customer_id = customer_id;
		}
	},
	
	// 加载客户订单表格
	customerOrder : function(customer_id) {
		$('#customer_order_table').bootstrapTable({
			url : 'manage!showOrderByCustomer.action',
//			queryParams: function (params) {
//				var temp = {
//					limit: params.limit,
//					offset: params.offset,
//				};
//				return temp;
//			},
//			ajax: {
//				url: 'manage!showOrderByCustomer.action',
//				type: 'post',
//				dataType: 'json',
//				data: {'customerId':customer_id}
//			},
			method : 'post',
			dataType : 'json',
			pagination : true,
			pageSize : 10,
			search : true,
			paginationPreText : '上一页',
			paginationNextText : '下一页',
			showExport : true,
			exportDataType : "basic",
			columns : [{
				field : 'createDate',
				title : '订单日期'
			}, {
				field : 'deliveryDate',
				title : '配送日期 '
			}, {
				field : 'totalPrice',
				title : '订单总金额 '
			}, {
				field : 'description',
				title : '备注'
			}, {
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
								return ['<a class="like" href="javascript:void(0)">查看详细</a>' ];
							},
				events : ManageController.customerOrderOperateEvents
			}],
		});
		ManageController.switchCustomerOrderTab();
		
//		$.ajax({
//			url: 'manage!showOrderByCustomer.action',
//			type: 'post',
//			dataType: 'json',
//			data: {'customerId':customer_id},
//			success: function(result) {
//				console.log(result);
//				$('#customer_order_table').bootstrapTable({
//					data: result,
//					pagination : true,
//					pageSize : 10,
//					search : true,
//					paginationPreText : '上一页',
//					paginationNextText : '下一页',
//					showExport : true,
//					exportDataType : "basic",
//					columns : [{
//							field : 'createDate',
//							title : '订单日期'
//						}, {
//							field : 'deliveryDate',
//							title : '配送日期 '
//						}, {
//							field : 'totalPrice',
//							title : '订单总金额 '
//						}, {
//							field : 'description',
//							title : '备注'
//						}, {
//							title : '操作',
//							align : 'center',
//							formatter : function(value, row, index) {
//											return ['<a class="like" href="javascript:void(0)">查看详细</a>' ];
//										},
//							events : ManageController.customerOrderOperateEvents
//						}],
//				});
//				
//				ManageController.switchCustomerOrderTab();
//			}
//		});
	},
	
	customerOrderOperateEvents: {
		'click .like': function (e, value, row, index) {
			var customer_order_id = row.orderId;
			ManageController.orderDetail(customer_order_id);
		}
	},
	
	// 加载订单详情表格
	orderDetail: function(customer_order_id) {
		$.ajax({
			url: 'manage!showOrderDetailBuOrderId.action',
			type: 'post',
			dataType: 'json',
			data: {'orderId':customer_order_id},
			success: function(result) {
				console.log(result);
				$('#order_table').bootstrapTable({
					pagination : true,
					pageSize : 10,
					search : true,
					paginationPreText : '上一页',
					paginationNextText : '下一页',
					showExport : true,
					exportDataType : "basic",
					columns : [{
							field : 'lamp',
							title : '品名'
						},{
							field : 'price',
							title : '单价 '
						},{
							field : 'number',
							title : '数量 '
						}, {
							field : 'description',
							title : '备注'
						}],
					data: result
				});
				
				ManageController.switchOrderTab();
			}
		});
	},
	
	// 切换到客户查询
	switchCustomerTab: function() {
		$("#customer_tab").addClass("actived");
		$("#customer_order_tab").removeClass("actived").hide();
		$("#order_tab").removeClass("actived").hide();
		
		$("#tab1").show();
		$("#tab2").hide();
		$("#tab3").hide();
	},
	
	// 切换到客户订单
	switchCustomerOrderTab: function() {
		$("#customer_tab").removeClass("actived");
		$("#customer_order_tab").show().addClass("actived");
		$("#order_tab").removeClass("actived").hide();
		
		$("#tab1").hide();
		$("#tab2").show();
		$("#tab3").hide();
	},
	
	// 切换到订单详情
	switchOrderTab: function() {
		$("#customer_tab").removeClass("actived");
		$("#customer_order_tab").removeClass("actived");
		$("#order_tab").show().addClass("actived");
		
		$("#tab1").hide();
		$("#tab2").hide();
		$("#tab3").show();
	},
}

$(document).ready(function() {
	ManageController.init();
});