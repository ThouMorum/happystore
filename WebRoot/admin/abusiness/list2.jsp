<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/business/css/Style1.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function openb(bid) {
		window.location.href = "${pageContext.request.contextPath}/admin/OpenBusiness?bid="
				+ bid;
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>店铺列表</strong>
					</TD>
				</tr>

				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="9%">序号</td>
								<td align="center" width="31%">店铺编号</td>
								<td align="center" width=10%">店铺名称</td>
								<td align="center" width="10%">店铺地址</td>
								<td align="center" width="10%">店铺所有者</td>
								<td align="center" width="10%">创建时间</td>
								<td align="center" width=10%">店铺星级</td>
								<td align="center" width="10%">操作</td>
							</tr>
							<c:forEach items="${listBusiness }" var="lb" varStatus="vs">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="4%">${vs.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="26%">${lb.bid }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${lb.bname }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${lb.address }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${lb.busername }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">${lb.createdate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><c:forEach begin="1" end="${lb.stars }">
											&nbsp;<font color='red'>❤</font>
										</c:forEach></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><input type="button" value="解禁"
										onclick="openb('${lb.bid}')" /></td>
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

