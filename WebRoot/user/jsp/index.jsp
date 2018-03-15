<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>开心商城</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath}/user/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/user/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container-fluid">

		<!-- 静态包含 -->
		<%@include file="/user/jsp/head.jsp"%>

		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/user/img/1.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/user/img/2.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/user/img/3.jpg">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					热门商品&nbsp;&nbsp;<img
						src="${pageContext.request.contextPath}/user/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border:1px solid #E7E7E7;border-right:0;padding:0;">
				<img
					src="${pageContext.request.contextPath}/user/img/77.jpg"
					width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<div class="col-md-6"
					style="text-align:center;height:200px;padding:0px;">
					 <img
						src="${pageContext.request.contextPath}/user/img/99.jpg"
						width="516px" height="200px" style="display: inline-block;">
					
				</div>
				<c:forEach items="${hotList }" var="hl">
					<div class="col-md-2"
						style="text-align:center;height:200px;padding:10px 0px;">
						<a
							href="${pageContext.request.contextPath }/Product?method=getById&pid=${hl.pid}">
							<img src="${pageContext.request.contextPath}/${hl.pimage}"
							width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a
								href="${pageContext.request.contextPath }/Product?method=getById&pid=${hl.pid}"
								style='color:#666'>${hl.pname }</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size:16px">&yen;${hl.shop_price }</font>
						</p>
					</div>
				</c:forEach>


			</div>
		</div>
		<div class="container-fluid">
			<%-- <img
				src="${pageContext.request.contextPath}/user/products/hao/ad.jpg"
				width="100%" /> --%>
		</div>
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					最新商品&nbsp;&nbsp;<img
						src="${pageContext.request.contextPath}/user/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border:1px solid #E7E7E7;border-right:0;padding:0;">
				<img
					src="${pageContext.request.contextPath}/user/img/66.jpg"
					width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<div class="col-md-6"
					style="text-align:center;height:200px;padding:0px;">
					 <img
						src="${pageContext.request.contextPath}/user/img/88.jpg"
						width="516px" height="200px" style="display: inline-block;">
					
				</div>
				<c:forEach items="${newList }" var="pro">
					<div class="col-md-2"
						style="text-align:center;height:200px;padding:10px 0px;">
						<a
							href="${pageContext.request.contextPath }/Product?method=getById&pid=${pro.pid}">
							<img src="${pageContext.request.contextPath}/${pro.pimage}"
							width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a
								href="${pageContext.request.contextPath }/Product?method=getById&pid=${pro.pid}"
								style='color:#666'>${pro.pname }</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size:16px">&yen;${pro.shop_price }</font>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- 静态包含 -->
		<%@include file="/user/jsp/foot.jsp"%>

	</div>
</body>

</html>