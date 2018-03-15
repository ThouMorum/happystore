<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/business/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/business/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/business/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		d.add('0102','01','账号信息管理','','','mainFrame');
		d.add('010201','0102','修改密码','${pageContext.request.contextPath}/business/buser/changepwd.jsp','','mainFrame');
		d.add('010202','0102','查询基础信息','${pageContext.request.contextPath}/business/buser/getinfo.jsp','','mainFrame');
		d.add('010203','0102','更改信息','${pageContext.request.contextPath}/business/buser/editinfo.jsp','','mainFrame');
		d.add('0104','01','商品管理');
		d.add('010401','0104','商品列表','${pageContext.request.contextPath}/Business_Pro?method=findAllByBid','','mainFrame');
		d.add('010402','0104','发布商品','${pageContext.request.contextPath}/Business_Pro?method=addUI','','mainFrame');
		d.add('0105','01','订单项管理');
		d.add('010501','0105','所有订单项','${pageContext.request.contextPath}/BusinessServlet_c?method=findAllByBid','','mainFrame');
		d.add('010502','0105','未发货订单项','${pageContext.request.contextPath}/BusinessServlet_c?method=findNoByBid','','mainFrame');
		d.add('010503','0105','已发货订单项','${pageContext.request.contextPath}/BusinessServlet_c?method=findYesByBid','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
