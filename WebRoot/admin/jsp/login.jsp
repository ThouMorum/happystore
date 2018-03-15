<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=" UTF-8" />
<title>开心商城管理员登录</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="${pageContext.request.contextPath}/admin/css/css.css"
	rel="stylesheet" type="text/css" />

<script>
	function createAjax() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
		}
		try {
			return new ActiveXObject('Microsoft.XMLHTTP');
		} catch (e) {
		}

		alert('浏览器版本太低，请更换浏览器！！！');
	}

	function $(id) {
		return document.getElementById(id);
	}

	$("username").onblur = function() {
		var username = this.value;

		if (!username) {
			$('res2').innerHTML = '<img src="${pageContext.request.contextPath}/admin/images/888.png"  /><font color=red>请输入帐号</font>';
		} else {
			$('res2').innerHTML = "";

		}
	};

	$("password").onblur = function() {
		var password = this.value;

		if (!password) {
			$('res2').innerHTML = '<img src="${pageContext.request.contextPath}/admin/images/888.png" /><font color=green>请输入密码</font>';
		} else {
			$('res2').innerHTML = "";

		}
	};
</script>
</head>

<body>

	<form method="post" name='theForm' id="login_form">
		<input type="hidden" name="module" value="privilege" /> <input
			type="hidden" name="action" value="signin" />
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="180"
					background="${pageContext.request.contextPath}/admin/images/a77.png"><img
					src="${pageContext.request.contextPath}/admin/images/a66.png" /></td>
			</tr>
		</table>
		<table width="562" border="0" align="center" cellpadding="0"
			cellspacing="0" class="right-table03">
			<tr>
				<td width="221"><table width="95%" border="0" cellpadding="0"
						cellspacing="0" class="login-text01">

						<tr>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="0" class="login-text01">
									<tr>
										<td align="center"><img
											src="${pageContext.request.contextPath}/admin/images/a88.png"
											width="120" height="140" style="padding-left:-20px" /></td>
									</tr>
									<tr>
										<td height="40" align="center">&nbsp;</td>
									</tr>

								</table></td>
							<td><img
								src="${pageContext.request.contextPath}/admin/images/line01.gif"
								width="5" height="292" /></td>
						</tr>
					</table></td>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="33%" height="35" class="login-text02"><font
								size="3" color="black">管理员名称：</font><br /></td>
							<td width="67%"><input name="username" id="username"
								type="text" size="30" /></td>
						</tr>
						<tr>
							<td height="35" class="login-text02"><font size="3"
								color="black"> 密 码：</font><br /></td>
							<td><input name="password" id="password" type="password"
								size="30" /></td>
						</tr>

						<td>&nbsp;</td>
						<td><span id="res2" style="display:block"></span></td>
						<td>&nbsp;</td>
						<tr>
							<td height="35" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>${msg}</font></td>
						</tr>
						<tr>
							<td height="35">&nbsp;</td>

							<td><input type="button" value="登录" onclick="return send()">
						</tr>
					</table></td>
			</tr>
		</table>
	</form>

	<script>
		function send() {

			var name = document.getElementById("username").value;
			var password = document.getElementById("password").value;

			if (name == "") {
				$('res2').innerHTML = '<img src="${pageContext.request.contextPath}/admin/images/888.png"  /><font color=red>请输入帐号</font>';
				return false;
			}
			if (password == "") {
				document.getElementById("res2").innerHTML = '<img src="${pageContext.request.contextPath}/admin/images/888.png" /><font color=green>请输入密码</font>';
				return false;
			}

			window.location.href = "${pageContext.request.contextPath}/admin/ALogin?username="
					+ name + "&password=" + password;

		}
	</script>
</body>
</html>