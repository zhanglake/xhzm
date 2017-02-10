var ManageController = {
	init : function() {
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
									return ['<a class="like" href="javascript:void(0)">查看订单</a>',
											'&nbsp;&nbsp;&nbsp;&nbsp;',
											'<a class="remove" href="javascript:void(0)">新增订单</a>' ]
											.join('');
								},
					events : ManageController.customerOperateEvents
				} ],
		});
	},
	// 清空
	clearForm: function (type) {
		if (type === "customer") {
			$("#cust-form").find("input").val("");	
		}
	},
	
	// 点击超链接事件
	customerOperateEvents : {
		'click .like': function (e, value, row, index) {
			var customer_id = row.customerId;
			ManageController.customerOrder(customer_id);
		},
		'click .remove': function (e, value, row, index) {
			var customer_id = row.customerId;
		}
	},
	
	// 加载客户订单表格
	customerOrder : function(customer_id) {
		$.ajax({
			url: 'manage!showOrderByCustomer.action',
			type: 'post',
			dataType: 'json',
			data: {'customerId':customer_id},
			success: function(result) {
				console.log(result);
				$('#customer_order_table').bootstrapTable({
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
					data: result
				});
				
				ManageController.switchCustomerOrderTab();
			}
		});
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
		$("#tab4").hide();
		
		$("#tab2").html('<table id="customer_order_table"></table>');
		$("#tab3").html('<table id="order_table"></table>');
	},
	
	// 切换到客户订单
	switchCustomerOrderTab: function() {
		$("#customer_tab").removeClass("actived");
		$("#customer_order_tab").show().addClass("actived");
		$("#order_tab").removeClass("actived").hide();
		$("#add_order_tab").removeClass("actived").hide();
		
		$("#tab1").hide();
		$("#tab2").show();
		$("#tab3").hide();
		$("#tab4").hide();
		
		$("#tab3").html('<table id="order_table"></table>');
	},
	
	// 切换到订单详情
	switchOrderTab: function() {
		$("#customer_tab").removeClass("actived");
		$("#customer_order_tab").removeClass("actived");
		$("#order_tab").show().addClass("actived");
		$("#add_order_tab").removeClass("actived").hide();
		
		$("#tab1").hide();
		$("#tab2").hide();
		$("#tab3").show();
		$("#tab4").hide();
	},
	
	// 切换到添加客户
	switchAddCustomer: function() {
		$("#customer_tab").removeClass("actived");
		$("#customer_order_tab").removeClass("actived").hide();
		$("#order_tab").removeClass("actived").hide();
		$("#add_order_tab").show().addClass("actived");
		
		$("#tab1").hide();
		$("#tab2").hide();
		$("#tab3").hide();
		$("#tab4").show();
	}
	
}

$(document).ready(function() {
	ManageController.init();
});