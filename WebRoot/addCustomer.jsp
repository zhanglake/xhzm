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
	</head>

	<body>
		<form action="customerAction!addCustomer.action" method="post">
			<div class="content">
				<div class="content_title">
					新增顾客
					<a href="javascript:history.go(-1)" style="float:right;text-decoration: none;color: blue;">&lt;&lt;后退</a>
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
						<input type="submit" value="添加" class="btn-1" />
						<input type="reset" value="重置" class="btn-2" />
					</div>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
