<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>无锡兴海照明</title>

		<link href="css/default.css" rel="stylesheet" type="text/css"/>
		<style type="text/css">
			table > tbody > tr > td:first-child {
				width: 50px !important;
			}
		</style>
	</head>

	<body>
		<div class="content">
			<div class="content_title">
				顾客信息
				<a href="javascript:history.go(-1)" style="float:right;text-decoration: none;color: blue;">&lt;&lt;后退</a>
			</div>
			<div class="content_panel">
				<table>
					<thead>
						<th style="width: 200px;">
							日期
						</th>
						<th>
							总金额
						</th>
						<th style="width: 300px;">
							描述
						</th>
						<th>
							操作
						</th>
					</thead>
					<tbody>
						<s:iterator value="orders" id="o">
							<tr>
								<td>
									<s:property value="#o.date" />
								</td>
								<td>
									<s:property value="#o.totalPrice" />
								</td>
								<td>
									<s:property value="#o.description" />
								</td>
								<td>
									<a
										href="${pageContext.request.contextPath}/customerAction!showOrderDetails.action?orderId=<s:property value="#o.orderId"/>">查看详细</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
