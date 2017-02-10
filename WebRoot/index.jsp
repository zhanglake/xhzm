
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>无锡兴海照明</title>
		<style type="text/css">
			#form_content {
				border: 1px solid #eaeaea;
				width: 400px;
				height: 300px;
				margin: auto;
				margin-top: 100px;
				border-radius: 5px;
			}
			#content_title {
				border-bottom: 1px solid #eaeaea;
				background-color: #1ab394;
				color: #ffffff;
				line-height: 40px;
				padding: 0px 20px;
				border-radius: 5px;
				text-align: center;
			}
			#content_panel {
				margin: auto;
				margin-top: 50px;
				width: 262px;
			}
			#content_panel tr {
				height: 48px;
			}
			#content_panel tr td:first-child {
				text-align: right;
			}
			#content_panel tr input {
				width: 194px;
				height: 28px;
				border-radius: 3px;
			}
			#content_panel tr:last-child input {
				background-color: #1ab394;
				color: #ffffff;
				border: 0px;
				cursor: pointer;
			}
		</style>
	</head>

	<body>
		<div id="form_content">
			<div id="content_title">
				用&nbsp;户&nbsp;登&nbsp;录
			</div>
			<div id="content_panel">
				<s:form action="loginAction!login">
					<s:textfield name="user.userName" label="用户名 "></s:textfield>
					<s:password name="user.passWord" label="密码  "></s:password>
					<s:submit value="登 录"></s:submit>
				</s:form>
			</div>
		</div>
	</body>
</html>
