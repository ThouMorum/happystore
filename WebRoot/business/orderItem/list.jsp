<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/business/css/Style1.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function send(itemid) {
		window.location.href = "${pageContext.request.contextPath}/BusinessServlet_c?method=send&itemid="
				+ itemid;
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong>
					</TD>
				</tr>

				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="5%">序号</td>
								<td align="center" width="20%">订单项编号</td>
								<td align="center" width="8%">订购数量</td>
								<td align="center" width="12%">订购产品名称</td>
								<td align="center" width="12%">订购产品图片</td>
								<td align="center" width="7%">订单项金额</td>
								<td align="center" width="10%">收货地址</td>
								<td align="center" width="10%">收货联系人</td>
								<td align="center" width="10%">收货联系方式</td>
								<td align="center" width="5%">操作</td>
							</tr>
							<c:forEach items="${orderItemList }" var="oil" varStatus="vs">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">${vs.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">${oil.itemid }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${oil.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="12%">${oil.product.pname }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="12%"><img width="40" height="45"
										src="${ pageContext.request.contextPath }/${oil.product.pimage}">
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%">${oil.subtotal }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${oil.order.address }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${oil.order.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${oil.order.telephone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><c:if test="${oil.is_ok==1 }">已发货</c:if> <c:if
											test="${oil.is_ok==0 }">
											<input type="button" value="发货"
												onclick="send('${oil.itemid}')" />
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

