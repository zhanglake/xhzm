<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>无锡兴海照明</title>

		<link href="css/default.css" rel="stylesheet" type="text/css"/>
		<style type="text/css">
			#form_div {
				width: 612px;
				margin: auto;
			}
			#input_div {
				width: 262px;
				folat: left;
				display: inline-block;
				margin: 10px 20px;
			}
			#input_btn {
				width: 592px;
				text-align: right;
				margin: 10px 0px;
			}
			#input_div > input {
				border: 1px solid #666666;
				border-radius: 3px;
				width: 194px;
				height: 28px;
				padding-left: 5px;
				padding-right: 5px;
			}
			#add_customer {
    			float: right;
    			width: 80px;
    			line-height: 30px;
    			border: 0px;
    			background-color: #1ab394;
    			display: inline-block;
    			text-align: center;
    			margin: 5px;
    			text-decoration: none;
    			color: #ffffff;
    			border-radius: 3px;
			}
		</style>
		
		<SCRIPT type="text/javascript" src="js/jquery-3.1.0.min.js"></SCRIPT>
		<SCRIPT type="text/javascript">
			window.onload=function(){
				var context = $("#t").find("tbody").html().trim();
				if (context == '' || context == undefind) {
					var btn = document.getElementById("query_1");
					btn.click();
				}
			}
		</SCRIPT>
	</head>

	<body>
		<form action="loginAction!queryCustomer.action" method="post">
			<div class="content">
				<div class="content_title">
					顾客查询
				</div>
				<div id="form_div">
					<div id="input_div">
						<label>
							姓名：
						</label>
						<input type="text" id="query_name" name="customer.name" />
					</div>
					<div id="input_div">
						<label>
							公司：
						</label>
						<input type="text" id="query_company" name="customer.company" />
					</div>
					<div id="input_div">
						<label>
							电话：
						</label>
						<input type="text" id="query_phone" name="customer.phone" />
					</div>
					<div id="input_div">
						<label>
							手机：
						</label>
						<input type="text" id="query_telephone" name="customer.telephone" />
					</div>
					<div id="input_btn">
						<input type="submit" value="查询" class="btn-1" id="query_1" />
						<input type="reset" value="重置" class="btn-2" />
					</div>
				</div>
			</div>
		</form>
		<div class="content">
			<div class="content_title">
				顾客列表
				<a id="add_customer" href="addCustomer.jsp">新增顾客</a>
			</div>
			<div class="content_panel">
				<table id="t">
					<thead>
						<th>
							姓名
						</th>
						<th>
							公司
						</th>
						<th>
							电话
						</th>
						<th>
							手机
						</th>
						<th>
							操作
						</th>
					</thead>
					<tbody>
						<s:iterator value="customers" id="c">
							<tr>
								<td>
									<s:property value="#c.name" />
								</td>
								<td>
									<s:property value="#c.company" />
								</td>
								<td>
									<s:property value="#c.phone" />
								</td>
								<td>
									<s:property value="#c.telephone" />
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/customerAction!showOrder.action?customerId=<s:property value='#c.customerId'/>">查看订单</a>&nbsp;
									<a href="addOrder.jsp?id=<s:property value="#c.customerId" />&name=<s:property value="#c.name" />">新增订单</a>
								</td>
							</tr>
					</tbody>
					</s:iterator>
				</table>
			</div>
		</div>
	</body>
</html>
