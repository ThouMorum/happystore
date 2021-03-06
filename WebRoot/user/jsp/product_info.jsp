<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>物品详细信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath}/user/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/user/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
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


</style>
</head>

<body>


	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/head.jsp"></jsp:include>


	<div class="container">
		<div class="row">
		
		
			<div 
				style="border: 1px solid #e4e4e4;width:930px;visibility:hidden; margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
				<a ></a> <a></a>
				<a></a>
			</div>

			<div style="margin:0 auto;width:950px;">
				<div class="col-md-6">
					<img style="opacity: 1;width:400px;height:350px;" title=""
						class="medium"
						src="${pageContext.request.contextPath}/${product.pimage}">
				</div>

				<div class="col-md-6">
					<form id="formId"
						action="${pageContext.request.contextPath }/Cart?method=add"
						method="post">
						<input type="hidden" name="pid" value="${product.pid }">
						<div>
							<span style="font-size:30px"><strong>${product.pname }</strong></span>
						</div>
						<div
							style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>编号：${product.pid }</div>
						</div>
						
						<div
							style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>店铺名称：${product.business.bname }</div>
						</div>
						
						<div style="margin:10px 0 10px 0;">
							商城价: <strong style="color:#ef0101;">￥：${product.shop_price }元/份</strong>
							参 考 价：
							<del>￥${product.market_price }元/份</del>
						</div>

						<div style="margin:10px 0 10px 0;">
							促销:  <strong style="color:#ef0101;">${product.promotion.pnname }</strong>
						</div>

						<div
							style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							

							<div
								style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">
								购买数量: <input id="quantity" name="count" value="1" maxlength="4"
									size="10" type="text">
							</div>
							
							<div
								style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">
								剩余数量:<span style="margin-left:20px;color:red;font-size:18px">${product.pnumber }</span>
							</div>
							
							<div style="margin:20px 0 10px 0;;text-align: center;">
								<a  href="javascript:void(0)" style="text-decoration:none;" onclick="addCart()"> <input
									style=" color:black; background: url('${pageContext.request.contextPath}/user/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;"
									value="加入购物车" type="button">
								</a> &nbsp;
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width:950px;margin:0 auto;">
				<%-- <div
					style="background-color:#d3d3d3;padding-left:-5px;width:900px;padding:10px 10px;margin:10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>

				<div  style="color:#333333;font-size:14px">${product.pdesc }</div> --%>
				
				
				<div style="background-color:#d3d3d3;width:900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品介绍</strong></th>
							</tr>
							<tr class="warning">
								<th>${product.pdesc }</th>
							</tr>
						</tbody>
					</table>
				</div>

				<!-- <div
					style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
					<strong>商品参数</strong>
				</div>
				<div style="margin-top:10px;width:900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">基本参数</th>
							</tr>
							<tr>
								<th width="10%">级别</th>
								<td width="30%">标准</td>
							</tr>
							<tr>
								<th width="10%">标重</th>
								<td>500</td>
							</tr>
							<tr>
								<th width="10%">浮动</th>
								<td>200</td>
							</tr>
						</tbody>
					</table>
				</div> -->

				<div style="background-color:#d3d3d3;width:900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color:#d3d3d3;width:900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>

	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/foot.jsp"></jsp:include>

</body>
<script type="text/javascript">
	function addCart() {
		//将表单提交
		document.getElementById("formId").submit();
	}
</script>
</html>