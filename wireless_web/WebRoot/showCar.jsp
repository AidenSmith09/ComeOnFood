<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import = "shopping.*,entity.*,dao.impl.*" %>
<html>
<head>
<title>购物车</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
	<jsp:useBean id="caritems" class="shopping.ShoppingCar" scope="session"></jsp:useBean>
	<%
		String id = request.getParameter("menuId");
		if (id != null && !(id.equals(""))) {
			MenutblDaoImpl imp = new MenutblDaoImpl();
			Menutbl menu1 = imp.findById(Integer.parseInt(id));
			caritems.addItem(Integer.parseInt(id), menu1);
			session.setAttribute("caritems", caritems);
		}
	%>
	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
		text="#000000" link="#000000" vlink="#000000" alink="#000000">

		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			bgcolor="#FFFFFF" height="100%">
			<tr valign="top">
				<td>
					<%
						int size = caritems.getNumOfItems();
					%>
					<table width="98%" border="0" cellspacing="1" cellpadding="2"
						align="center">
						<tr valign="bottom">
							<td height="30">
								<img src="">
								<font color="#000000">您的购物车中有以下商品</font>
							</td>
						</tr>
					</table>
					<table width="98%" border="0" cellspacing="2" cellpadding="0"
						align="center">
						<tr bgcolor=#808000>
							<td height="1" bgcolor="#999999"></td>
						</tr>
					</table>
					<table width="98%" border="0" cellspacing="2" cellpadding="0"
						align="center">
						<tr>
							<td height="5"></td>
						</tr>
					</table>
					<table width="98%" border="0" cellspacing="0" cellpadding="0"
						align="center">
						<tr>
							<td>
								<table width="100%" border="0" align="CENTER" cellpadding="2"
									cellspacing="1" bgcolor="#c0c0c0">
									<tr bgcolor="#dadada">
										<td height="22" width="50">
											<div align="CENTER">
												<font color="#000000">编号</font>
											</div>
										</td>
										<td width="610" height="22">
											<div align="CENTER">
												<font color="#000000">商品名称</font>
											</div>
										</td>
										<td height="22" width="104">
											<div align="CENTER">
												<font color="#000000">单价</font>
											</div>
										</td>
										<td height="22" width="100">
											<div align="CENTER">
												<font color="#000000">数量</font>
											</div>
										</td>
										<td width="116" height="22">
											<div align="CENTER">
												<font color="#000000">金额</font>
											</div>
										</td>
									</tr>
									<%
										if (size > 0) {
											Collection<CarItemBean> cols = caritems.getItems().values();
											for (CarItemBean item : cols) {
												Menutbl menu = item.getMenu();
									%>
									<tr bgcolor="#ffffff">
										<td width="50" align="center" height="22">
											<font color="#000000"><%=menu.getId()%></font>
										</td>
										<td align="center" height="22">
											<font color="#000000"><%=menu.getName()%></font>
											<input type="hidden" name="prodid" value="500047">
										</td>
										<td width="104" align="center" height="22">
											<font color="#000000">￥<%=menu.getPrice()%></font>
										</td>
										<td width="100" class="hh" align="center" height="22"><%=item.getNumber()%></td>
										<td width="116" class="bb" align="center" height="22">
											<font color="#000000">￥<%=item.getItemPrice()%></font>
										</td>
									</tr>


									<%
										}
										} else {
									%>
									<tr bgcolor="#ffffff">
										<td colspan="5">
											您没有订购任何菜肴或者已经订购已经提交~
										</td>
									</tr>
									<%
										}
									%>
									<tr bgcolor="#dadada">
										<td width="50" height="22" align="center">
											<font color="#000000">合计</font>
										</td>
										<td height="22" align="center">
											<font color="#000000">-</font>
										</td>
										<td width="104" height="22" align="center">
											<font color="#000000">-</font>
										</td>
										<td width="100" class="hh" height="22" align="center">
											<font color="#000000">-</font>
										</td>
										<td width="116" class="bb" align="center" height="22">
											<font color="#000000">￥<%=caritems.getTotalPrice()%></font>
										</td>
									</tr>
								</table>
								<br>
								<table width="300" border="0" cellspacing="1" cellpadding="4"
									align="CENTER" bgcolor="#c0c0c0">
									<tr bgcolor="#dadada">
										<td height="10" align="center">
											<a href="#"><font color="#000000"><a href="#">清空购物车</a>
											</font>
											</a>
										</td>
										<td height="10" align="center" style="cursor: hand">
											<font color="#000000"><a href="show.jsp">继续购物</a>
											</font>
										</td>
										<td height="10" align="center" style="cursor: hand">
											<font color="#000000"><a href="confirmOrderInfo.jsp">生成订单</a>
											</font>
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>

				</td>

			</tr>
		</table>
		<br>
	</body>
</html>

