<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息修改</title>
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

	
	<div class="container"
		style="width:100%;background:url('${pageContext.request.contextPath}/user/image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8"
				style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
				<font>基础信息修改</font>
				<form class="form-horizontal" style="margin-top:5px;"
					action="${pageContext.request.contextPath }/BusinessServlet_a?method=updateBusiness"
					method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="请输入用户名" name="bname" style="width:300px;"
								value="${Business.bname }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">店铺地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputEmail3"
								placeholder="" name="address" style="width:300px;"
									value="${Business.address }" >
						</div>
						<div id="div4"></div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">所有者</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="busername"
								placeholder="请输入姓名" name="busername" style="width:300px;"
								value="${Business.busername }" >
						</div>
						<div id="div5"></div>
					</div>

						<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="usercaption"
								 name="email" style="width:300px;"
								value="${Business.email }">
						</div>
						<div id="div5"></div>
					</div>
					

					

					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-6">
							<input type="text" id="phone" class="form-control"
								id="telephone" name="telephone" value="${Business.telephone }"
								style="width:300px;" >
						</div>
						<div id="div7"></div>
					</div>




					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="修改" name="submit"
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

	

</body>
</html>
