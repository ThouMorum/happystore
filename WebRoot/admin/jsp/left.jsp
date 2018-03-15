<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/business/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/business/css/dtree.css" type="text/css" />
</head>
<body style="background-color:#aaceee" >
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
		d.add('0102','01','用户管理','','','mainFrame');
		d.add('010201','0102','查询全部用户','${pageContext.request.contextPath}/admin/AFindUser','','mainFrame');
		d.add('010202','0102','查询注销的用户','${pageContext.request.contextPath}/admin/AFindUserByState?viewstate=1','','mainFrame');
		d.add('010203','0102','查询被禁用的用户','${pageContext.request.contextPath}/admin/AFindUserByState?viewstate=2','','mainFrame');
		d.add('0104','01','店铺管理');
		d.add('010401','0104','查询全部店铺','${pageContext.request.contextPath}/admin/AFindBusiness','','mainFrame');
		d.add('010402','0104','查询申请注册店铺','${pageContext.request.contextPath}/admin/AFindSQBusiness','','mainFrame');
		d.add('010403','0104','查询被禁用店铺','${pageContext.request.contextPath}/admin/AFindJYBusiness','','mainFrame');
		d.add('0105','01','商品类型管理');
		d.add('010501','0105','查询全部商品类型','${pageContext.request.contextPath}/admin/AFindCategory','','mainFrame');
		d.add('010502','0105','添加商品类型','${pageContext.request.contextPath}/admin/category/add.jsp','','mainFrame');
		d.add('0106','01','促销类型管理');
		d.add('010601','0106','查询全部促销类型','${pageContext.request.contextPath}/admin/AFindPromotion','','mainFrame');
		d.add('010602','0106','添加促销类型','${pageContext.request.contextPath}/admin/promotion/add.jsp','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
