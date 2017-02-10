<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>无锡兴海照明</title>
		<link href="css/default.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="content">
			<div class="content_title">
				订单详细信息
				<a href="javascript:history.go(-1)" style="float:right;text-decoration: none;color: blue;">&lt;&lt;后退</a>
			</div>
			<div class="content_panel">
				<table>
					<thead>
						<th>
							名称
						</th>
						<th style="width: 70px !important;">
							数量
						</th>
						<th style="width: 70px !important;">
							单价
						</th>
						<th style="width: 400px !important;">
							备注
						</th>
					</thead>
					<tbody>
						<s:iterator value="orderLamps" id="ol">
							<tr>
								<td>
									<s:property value="#ol.lamp" />
								</td>
								<td>
									<s:property value="#ol.number" />
								</td>
								<td>
									<s:property value="#ol.price" />
								</td>
								<td>
									<s:property value="#ol.description" />
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
