<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/business/css/Style1.css"
	type="text/css" rel="stylesheet">
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/business/EditProduct"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="bid" value="${Business.bid }">
		<input type="hidden" name="pid" value="${bproduct.pid }">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pname" value="${bproduct.pname }"
					id="userAction_save_do_logonName" class="bg" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否热门：</td>
				<td class="ta_01" bgColor="#ffffff"><c:if
						test="${bproduct.is_hot==1 }">
						<select name="is_hot">
							<option value="1" selected="selected">是</option>
							<option value="0">否</option>
						</select>
					</c:if> <c:if test="${bproduct.is_hot==0 }">
						<select name="is_hot">
							<option value="1">是</option>
							<option value="0" selected="selected">否</option>
						</select>
					</c:if></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					店铺售价：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="market_price" value="${bproduct.market_price }"
					id="userAction_save_do_logonName" class="bg" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					市场参考价：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="shop_price" value="${bproduct.shop_price } "
					id="userAction_save_do_logonName" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品数量：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input
					type="text" name="pnumber" value="${bproduct.pnumber }"
					id="userAction_save_do_logonName" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input
					type="file" name="pimage" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					所属分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><select
					name="cid">
						<c:forEach items="${categoryList }" var="c">
							<c:if test="${bproduct.category.cid==c.cid }">
								<option selected="selected" value="${c.cid }">${c.cname }</option>
							</c:if>
							<c:if test="${bproduct.category.cid!=c.cid }">
								<option value="${c.cid }">${c.cname }</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					促销类型：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><select
					name="pnid">
						<c:forEach items="${promotionList }" var="pro">
							<c:if test="${bproduct.promotion.pnid==pro.pnid }">
								<option selected="selected" value="${pro.pnid }">${pro.pnname }</option>
							</c:if>
							<c:if test="${bproduct.promotion.pnid!=pro.pnid }">
								<option value="${pro.pnid }">${pro.pnname }</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品描述：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><textarea
						name="pdesc" rows="5" cols="30">${bproduct.pdesc }</textarea></td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
		

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>