<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath}/user/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/user/js/bootstrap.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/css/style.css"
	type="text/css" />

<script>
function createAjax()
{
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

function $(id){
	 return document.getElementById(id);
}

</script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/head.jsp"></jsp:include>

	<div class="container"
		style="width:100%;background:url('${pageContext.request.contextPath}/user/image/regist_bg.jpg');">
		<div class="row">

			<div class="col-md-2"></div>

			<div class="col-md-8"
				style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
				<font>修改密码</font>
				<form class="form-horizontal" style="margin-top:5px;"
					action="${pageContext.request.contextPath }/User?method=updatePwd"
					method="post">
					
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">旧密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="oldpwd"
								placeholder="请输入旧密码" name="oldpwd"  style="width:300px;">
						</div>
						<div id="div2"></div>
					</div>
					
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="newpwd" name="newpwd" 
								placeholder="请输入新密码" style="width:300px;">
						</div>
						<div id="div3"></div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">确认新密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="renewpwd"
								placeholder="请重新输入新密码" name="renewpwd" style="width:300px;">
						</div>
						<div id="div4"></div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="修改密码" name="submit"
								border="0" 
								style="background: url('${pageContext.request.contextPath}/user/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/foot.jsp"></jsp:include>

</body>
</html>




