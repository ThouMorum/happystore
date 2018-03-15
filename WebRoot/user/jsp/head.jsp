<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="col-md-4">
		<img src="${pageContext.request.contextPath}/user/img/logo99.jpg" />
	</div>
	<div class="col-md-5" style="visibility:hidden;">
		<img src="${pageContext.request.contextPath}/user/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">
			<c:if test="${empty user }">
				<li><a
					href="${pageContext.request.contextPath }/User?method=loginUI">登录</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user/jsp/register.jsp">注册</a></li>
			</c:if>
			<c:if test="${not empty user }">
				<li style="margin-left:140px;font-size:16px">欢迎 ：${user.name }</li>
				<li style="margin-left:20px"><a
					href="${pageContext.request.contextPath }/User?method=logout"
					onclick="return confirm('确定要退出吗？');">退出</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user/jsp/user_editinfo.jsp">修改基础信息</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user/jsp/user_changepwd.jsp">修改密码</a></li>
				<li><a
					href="${pageContext.request.contextPath }/Order?method=findAllByPage&currPage=1">我的订单</a></li>
			</c:if>
			<li><a
				href="${pageContext.request.contextPath }/user/jsp/cart.jsp">购物车</a></li>
		</ol>
	</div>
</div>
<div class="container-fluid">
	<nav class="navbar navbar-inverse" style="background:#b50319;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/user/Index">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul id="menuId" class="nav navbar-nav">

				</ul>
				<!-- 暂未实现该功能 	
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="搜索">
					</div>
					<button type="submit" class="btn btn-default" disabled="disabled">搜索</button>
				</form>
				 -->
			</div>
		</div>
	</nav>
</div>

<script type="text/javascript">
	$(function() {
		//发送ajax请求
		$
				.get(
						"${pageContext.request.contextPath}/Category?method=findAll",
						function(data) {
							//获取menu的ul标签
							var $ul = $("#menuId");

							//遍历数组
							$(data)
									.each(
											function() {
												$ul
														.append($("<li><a href='${pageContext.request.contextPath}/Product?method=findByPage&cid="
																+ this.cid
																+ "&currPage=1'>"
																+ this.cname
																+ "</a></li>"));
											});
						}, "json");
	});
</script>