<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>无锡兴海照明</title>
		<link href="css/default.css" rel="stylesheet" type="text/css"/>
		<style type="text/css">
		#form_div {
			width: 698px;
			margin: auto;
			padding: 20px 0px;
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
		#contain {
			width: 696px;
			border: 1px solid #d9d9d9;
			border-left: 4px solid #1ab394;
			background-color: #fafafa;
			margin: 15px 0px;
		}
		</style>

		<SCRIPT type="text/javascript" src="js/jquery-3.1.0.min.js"></SCRIPT>
		<SCRIPT type="text/javascript">
			function addLine(){
				var html = '';
				html += '<div id="contain">';
				html += '<div id="input_div">';
				html += '<label>品名：</label> ';
				html += '<input type="text" name="lamp" />';
				html += '</div>';
				html += '<div id="input_div" style="width: 140px;">';
				html += '<label>单价：</label> ';
				html += '<input type="text" name="price" style="width: 70px;" />';
				html += '</div>';
				html += '<div id="input_div" style="width: 140px;">';
				html += '<label>数量：</label> ';
				html += '<input type="text" name="number" style="width: 70px;" />';
				html += '</div>';
				html += '<div id="input_div" style="width: 568px;">';
				html += '<label>备注：</label> ';
				html += '<input type="text" name="description" style="width: 500px;"  />';
				html += '</div>';
				html += '<button class="btn-add" type="button" id="add_line" onclick="delLine();">-</button>';
				html += '</div>';
				$("#btns").before(html);
			}
			
			function delLine (){
				var targetElement = document.activeElement;
				$(targetElement).parent().remove();
			}
		</SCRIPT>
	</head>

	<body>
		<form action="orderAction!addOrder.action" method="post">
			<div class="content">
				<div class="content_title">
					顾客订单
					<a href="javascript:history.go(-1)" style="float:right;text-decoration: none;color: blue;">&lt;&lt;后退</a>
				</div>
				<div id="form_div">
					<div id="input_div" style="width: 658px;">
						<!-- <label>
							客户姓名：
						</label>
						<input type="text" value='<%=request.getParameter("name")%>'
							disabled="disabled" /> -->
						<input type="hidden" value='<%=request.getParameter("id")%>'
							name="orderCustomerId" />
					</div>
					<div id="input_div" style="width: 658px;">
						<label>
							订单备注：
						</label>
						<input type="text" name="orderDescription" style="width: 500px;">
					</div>
					<div id="contain">
						<div id="input_div">
							<label>品名：</label>
							<input type="text" name="lamp" />
						</div>
						<div id="input_div" style="width: 140px;">
							<label>单价：</label>
							<input type="text" name="price" style="width: 70px;" />
						</div>
						<div id="input_div" style="width: 140px;">
							<label>数量：</label>
							<input type="text" name="number" style="width: 70px;" />
						</div>
						<div id="input_div" style="width: 568px;">
							<label>备注：</label>
							<input type="text" name="description" style="width: 500px;" />
						</div>
						<button class="btn-add" type="button" id="add_line" onclick="addLine();">+</button>
					</div>
					<div id="btns" style="text-align: right;">
						<input type="submit" value="添加" class="btn-1" />
						<input type="reset" value="重置" class="btn-2" />
					</div>
		</form>
	</body>
</html>
