<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>分类物品显示</title>
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
	width: 100%;
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


	<div class="row" style="width:1210px;margin:0 auto;">

		<c:forEach items="${pageBean.list }" var="p">
			<div class="col-md-2">
				<a
					href="${pageContext.request.contextPath}/Product?method=getById&pid=${p.pid}">
					<img src="${pageContext.request.contextPath}/${p.pimage}"
					width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<a
						href="${pageContext.request.contextPath}/Product?method=getById&pid=${p.pid}"
						style='color:green'>${fn:substring(p.pname,0,10) }...</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${p.shop_price }</font>
				</p>
			</div>
		</c:forEach>

	</div>

	<!--分页 -->
	<div style="width:380px;margin:0 auto;margin-top:50px;">
		<ul class="pagination" style="text-align:center; margin-top:10px;">
			<!-- 判断当前页是否是首页  -->
			<c:if test="${pageBean.currPage == 1 }">
				<li class="disabled"><a href="javascript:void(0)"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>

			<c:if test="${pageBean.currPage != 1 }">
				<li><a
					href="${pageContext.request.contextPath}/Product?method=findByPage&currPage=${pageBean.currPage-1}&cid=${param.cid}"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>



			<!-- 展示所有页码 -->
			<c:forEach begin="${pageBean.currPage-5>0?pageBean.currPage-5:1 }"
				end="${pageBean.currPage+4>pageBean.totalPage?pageBean.totalPage:pageBean.currPage+4 }"
				var="n">
				<!-- 判断是否是当前页 -->
				<c:if test="${pageBean.currPage==n }">
					<li class="active"><a href="javascript:void(0)">${n }</a></li>
				</c:if>
				<c:if test="${pageBean.currPage!=n }">
					<li><a
						href="${pageContext.request.contextPath}/Product?method=findByPage&currPage=${n}&cid=${param.cid}">${n }</a></li>
				</c:if>
			</c:forEach>


			<!-- 判断是否是最后一页 -->
			<c:if test="${pageBean.currPage == pageBean.totalPage }">
				<li class="disabled"><a href="javascript:void(0)"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
			<c:if test="${pageBean.currPage != pageBean.totalPage }">
				<li><a
					href="${pageContext.request.contextPath}/Product?method=findByPage&currPage=${pageBean.currPage+1}&cid=${param.cid}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>

		</ul>
	</div>
	<div
		style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

		<h4 style="width: 50%;float: left;font: 14px/30px "微软雅黑 ";">浏览记录</h4>
		<div style="width: 50%;float: right;text-align: right;">
			<a href="#">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">
			<ul style="list-style: none;">
				<c:forEach items="${hisList }" var="hispro">
					<li
						style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img
						src="${pageContext.request.contextPath}/${hispro.pimage}"
						width="130px" height="130px" />${hispro.pname}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/foot.jsp"></jsp:include>


</body>

</html>