<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>店铺注册</title>
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
	<!-- 动态包含 -->
	<jsp:include page="/user/jsp/head.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8"
				style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
				<font>店铺注册</font>STORE REGISTER
				<form class="form-horizontal" style="margin-top:5px;"
				action="${pageContext.request.contextPath }/BusinessServlet_a?method=register"
					method="post">
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">店铺名称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption"
								placeholder="请输入店名(唯一)" name="name" style="width:300px;">
						</div>
						<div id="div1"></div>
					</div>


					

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="Email" name="email" style="width:300px;">
						</div>
						<div id="div4"></div>
					</div>


					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">店铺所有人</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="请输入店铺所有人姓名" name="username" style="width:300px;">
						</div>
						<div id="div5"></div>
					</div>

					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="address"
								placeholder="请输入地址" name="address" style="width:300px;">
						</div>
						<div id="diva8"></div>
					</div>

					<div class="form-group">
						<label for="telephone" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-6">
							<input type="text" id="phone" class="form-control"
								id="telephone" placeholder="请输入手机" name="telephone"
								style="width:300px;">
						</div>
						<div id="div7"></div>
					</div>
					
					
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="请输入密码" name="password" style="width:300px;">
						</div>
						<div id="div2"></div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="code"
								placeholder="请输入验证码" name="code">
						</div>
						<div class="col-sm-2">
							<img src="${pageContext.request.contextPath}/user/Code"
								style="cursor: pointer;"
								onclick="this.src='${pageContext.request.contextPath}/user/Code?a='+ Math.random()" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit" onclick="return send()"
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

	window.onload = function() {
		$("usercaption").onblur = function() {
			var username = this.value;
			var ajax = createAjax();
			var url = '${pageContext.request.contextPath}/BusinessServlet_a?method=checkBusiness&username='
					+ username;
			ajax.open('get', url);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {
					if (ajax.responseText == "no") {
						$('div1').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>该地铺名称已经被占用</font>';

					} else {
						if (username == '') {

							$('div1').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入要注册的地铺名称</font>';
						} else {

							$('div1').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/999.png"   /><font color=red>地铺名称可以使用</font>';
						}

					}

				}
			};
			ajax.send(null);

		};

		/* $("username").onblur=function(){
			var a=this.value;
			if(a){
				$('div1').innerHTML = '';
			}else{
				$('div1').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>用户名已经被占用</font>';
			}
		}; */

		$("inputPassword3").onblur = function() {
			var a = this.value;
			if (a) {
				$('div2').innerHTML = '';
			} else {
				$('div2').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入密码</font>';
			}
		};

		$("confirmpwd").onblur = function() {
			var a = this.value;
			var b = $("inputPassword3").value;
			if (a) {
				if (a == b) {
					$('div3').innerHTML = '';
				} else {
					$('div3').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>2次密码不一致</font>';
				}
			} else {
				$('div3').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请重新输入密码</font>';
			}
		};

		$("inputEmail3").onblur = function() {
			var a = this.value;
			if (a) {
				$('div4').innerHTML = '';
			} else {
				$('div4').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入email</font>';
			}
		};

		$("username").onblur = function() {
			var a = this.value;
			if (a) {
				$('div5').innerHTML = '';
			} else {
				$('div5').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入姓名</font>';
			}
		};

		$("phone").onblur = function() {
			var a = this.value;
			if (a) {
				$('div7').innerHTML = '';
			} else {
				$('div7').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入手机号码</font>';
			}
		};

		$("code").onblur = function() {
			var a = this.value;
			if (a) {
				$('span1').innerHTML = '';
			} else {
				$('span1').innerHTML = '<img src="${pageContext.request.contextPath}/user/images/888.png"   /><font color=red>请输入验证码</font>';
			}
		};

	}
</script>
</html>




