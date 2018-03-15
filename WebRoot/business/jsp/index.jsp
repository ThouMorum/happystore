<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>开心商场店铺管理登陆</title>
<link href="${pageContext.request.contextPath}/business/css/cb.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/business/css/n.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #ffffff;
	font-size: 12px;
}

.STYLE4 {
	color: #8da8c3;
	font-size: 12px;
}

.STYLE6 {
	font-size: 12px;
	color: #5593ce;
}
-->
</style>
<script>
	function check() {
		f = document.form1;
		if (f.username.value == "") {
			alert("请填写用户名");
			return false;
		}
		if (f.password.value == "") {
			alert("请填写密码");
			return false;
		}
		if (f.tyeps.value == "") {
			alert("请选择用户类型");
			return false;
		}
		if (f.yz.value == "") {
			alert("请填写验证码");
			return false;
		}
	}
</script>
</head>

<body>
	<table width="100%" height="594" border="0" align="center"
		cellpadding="0" cellspacing="0" style="margin:0px; padding:0px">
		<tr>
			<td height="594" align="center" valign="top"
				background="${pageContext.request.contextPath}/business/images/bj.gif">
				<table width="465" height="414" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td height="152" colspan="6" valign="bottom"><img
							src="${pageContext.request.contextPath}/business/images/22.png"
							width="450" height="90" /></td>
					</tr>

					<tr>
						<td width="15" height="262"
							background="${pageContext.request.contextPath}/business/images/bj1.gif">&nbsp;</td>
						<td width="420" valign="middle"
							background="${pageContext.request.contextPath}/business/images/bj2.gif">
							<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/BusinessServlet_a?method=login"
								onsubmit="return check();">
								<table width="100%" height="170" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="31%" align="right"><span class="STYLE1">用户名：</span></td>
										<td colspan="3" align="left"><label> <input
												name="username" type="text" id="username" />
										</label></td>
									</tr>
									<tr>
										<td align="right"><span class="STYLE1">密码：</span></td>
										<td colspan="3" align="left"><label> <input
												name="password" type="password" id="password" />
										</label></td>
									</tr>

									<tr>
										<td align="right"><span class="STYLE1">验证码：</span></td>
										<td align="left"><label> <input name="yz"
												type="text" id="yz" size="5" />
										</label></td>
										<td align="left"><img
											src="${pageContext.request.contextPath}/user/Code"
											style="cursor: pointer;height: 50%"
											onclick="this.src='${pageContext.request.contextPath}/user/Code?a='+ Math.random()" /></td>
										<td align="left"></td>
									</tr>
									<tr>
										<td colspan="4" align="center">${msg}</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td width="15%" valign="top"><p class="STYLE4">&nbsp;</p>
										</td>
										<td width="20%" align="right" valign="middle"><br /> <br />
										</td>
										<td width="34%" height="55" align="left"><a href="javascript:document.getElementById('form1').submit();"><input
											name="image" type="image" style="width:60px; height:55px;"
											src="${pageContext.request.contextPath}/business/images/login2.gif" /></a>
										</td>
									</tr>
								</table>
							</form>
						</td>
						<td width="13" background="Images/bj3.gif">&nbsp;</td>
					</tr>
				</table>
				<table width="465" height="76" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="76">&nbsp;</td>
					</tr>
				</table> <br />
				<table width="100%" height="64" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="64" align="center" valign="middle"><span
							class="STYLE6">Copyright &copy; 2017 开心商城 版权所有<br /> <br /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
