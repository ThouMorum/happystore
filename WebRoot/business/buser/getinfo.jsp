<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息查询</title>
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
				<font>基础信息</font>
				<form class="form-horizontal" style="margin-top:5px;" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺编号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.bid }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.bname }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.address }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺所有者</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.busername }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.email }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.telephone }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">星级</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;" value="${Business.stars }"
								disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">创铺时间</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="" name="username" style="width:300px;"
								value="${Business.createdate }" disabled="true">
						</div>
						<div id="div1"></div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10"></div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>


</body>
</html>
