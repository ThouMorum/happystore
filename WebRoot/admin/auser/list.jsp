<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/business/css/Style1.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function sendzx(uid) {
		window.location.href = "${pageContext.request.contextPath}/admin/ChangeStateServlet?state=1&uid="
				+ uid;
	}
	function sendnozx(uid) {
		window.location.href = "${pageContext.request.contextPath}/admin/ChangeStateServlet?state=0&uid="
				+ uid;
	}
	function sendnojy(uid) {
		window.location.href = "${pageContext.request.contextPath}/admin/ChangeStateServlet?state=0&uid="
				+ uid;
	}
	function sendjy(uid) {
		window.location.href = "${pageContext.request.contextPath}/admin/ChangeStateServlet?state=2&uid="
				+ uid;
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
					</TD>
				</tr>

				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="4%">序号</td>
								<td align="center" width="20%">编号</td>
								<td align="center" width="8%">账号</td>
								<td align="center" width="8%">真实姓名</td>
								<td align="center" width="9%">email</td>
								<td align="center" width="8%">telephone</td>
								<td align="center" width="10%">生日</td>
								<td align="center" width="5%">性别</td>
								<td align="center" width="8%">状态</td>
								<td align="center" width="10%">操作1</td>
								<td align="center" width="10%">操作2</td>
							</tr>
							<c:forEach items="${listUser }" var="lu" varStatus="vs">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="4%">${vs.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">${lu.uid }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${lu.username }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${lu.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="9%">${lu.email }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${lu.telephone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${lu.birthday }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">${lu.sex }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%"><c:if test="${lu.state==0 }">正常</c:if> <c:if
											test="${lu.state==1 }">被注销</c:if> <c:if
											test="${lu.state==2 }">被禁用</c:if></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><c:if test="${lu.state!=1 }">
											<input type="button" value="注销" onclick="sendzx('${lu.uid}')" />
										</c:if> <c:if test="${lu.state==1 }">
											<input type="button" value="取消注销"
												onclick="sendnozx('${lu.uid}')" />
										</c:if></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><c:if test="${lu.state!=2 }">
											<input type="button" value="禁用" onclick="sendjy('${lu.uid}')" />
										</c:if> <c:if test="${lu.state==2 }">
											<input type="button" value="取消禁用"
												onclick="sendnojy('${lu.uid}')" />
										</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>

			</TBODY>
		</table>
	</form>
</body>
</HTML>

