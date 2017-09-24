<%@ page language="java" import="java.util.*,dao.impl.*,dao.*,entity.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上订餐</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

</HEAD>
<%
	MenutblDaoImpl imp = new MenutblDaoImpl();
	List<Menutbl> menus = imp.findAll();
%>

<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<jsp:useBean id="caritems" class="shopping.ShoppingCar" scope="session"></jsp:useBean>
<table cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<tr>
		<td width="220" rowspan="3"><img src="images/jb_logo.jpg"
			width="200"></td>
		<td width="556" height="36">&nbsp;</td>
	</tr>
	<tr>
		<TD
			style="FONT-SIZE: 24pt; FILTER: blur(add=1, direction=120, strength=5); WIDTH: 100%; COLOR: #000000; FONT-FAMILY: arial; POSITION: relative"
			noWrap><B><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		网上订餐系统</B></TD>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/001.gif" height=42>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width=0 height=20></TD>
						<TD align=middle><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="show.jsp" target="_self"><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网站首页</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="aboutUs.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">关于我们</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">定餐帮助</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="show.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网上订餐</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="contactUs.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">客服中心</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing="0" cellPadding="0" width="776" align=center border="0">
	<TBODY>
		<TR vAlign=top>
			<TD width=181 background="images/002.gif">
			<TABLE cellSpacing=0 cellPadding=0 width=181 border=0>
				<TBODY>
					<TR>
						<TD><IMG height=234 src="images/left_top.jpg" width=181></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align="middle" height=30><FONT color=#000000> <SCRIPT
							language=javascript src="images/DateTime2.js"></SCRIPT> <SCRIPT
							language=javascript>tick('cn');</SCRIPT> </FONT></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD >
						<TABLE cellSpacing=0 cellPadding=0 width="94%" border=0>
							<TBODY>
								<TR>
									<TD>&nbsp;</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD><IMG height=72 src="images/001.jpg" width=595></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width="90%">
						<div class='cnt'><marquee
							style="FONT-SIZE: 13px; COLOR: #0000FF" scrollamount='5'
							direction='left'><IMG height=15 src="images/tp009.gif"
							width=15>欢迎使用网上订餐系统，祝您用餐愉快!</marquee></div>
						&nbsp;&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=right background="images/004.gif" height=19></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="96%" align=center border=0>
				<TBODY>
					<TR>
						<TD>

						<TABLE cellSpacing=1 cellPadding=1 width="100%" align=center
							bgColor=#c0c0c0 border=0>
							<TBODY>
								<TR bgColor=#dadada>
									<td align="right">
									<c:choose>
										<c:when test="${empty loginer }">
											<a href="login.jsp">登录</a>
										</c:when>
										<c:otherwise>
											<font color="#8f8888">欢迎您，<c:out value="${loginer.name }"></c:out></font>
										</c:otherwise>
									</c:choose>	 
									</td>
									<TD  align="left"><a href="showCar.jsp"><img
										src="images/lcart_cn.gif" border=0></a></TD>
								</TR>
							</TBODY>
						</TABLE>
						
						<BR>
						<TABLE cellSpacing=2 cellPadding=1 width="100%" align=center
							border="0">
							<TBODY>
								<%
								    for(int i=0;i<menus.size();i=i+2){ 
									Menutbl menu1 = menus.get(i);
									Menutbl menu2 = menus.get(i+1);
								%>	
								<TR>
									<TD width="50%">
									<TABLE height="100%" width="100%" cellSpacing=1 cellPadding=2 border=0>
										<TBODY>
											<TR>
												<TD vAlign=top width=90 height=90><A href="menuDetail.jsp?id=<%=menu1.getId()%>"
													target=_blank><IMG height=80 alt=点击图片查看内容
													src="<%=menu1.getPic()%>" width=80 border=0></A></TD>
												<TD vAlign=top>
												<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center
													border=0>
													<TBODY>
														<TR>
															<TD><A href="menuDetail.jsp?id=<%=menu1.getId()%>" target=_blank><STRONG><%=menu1.getName()%></STRONG></A></TD>
														</TR>
														<TR>
															<TD height=21><FONT color=#ff0000>现价：人民币<%=menu1.getPrice()%>元</FONT>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
											<TR>
												<TD height=28>编号: <%=menu1.getId()%></TD>
												<TD>
												<TABLE cellSpacing=1 cellPadding=0  width="70%"  border=0 width="100%">
													<TBODY>
														<TR>
														<% if(!caritems.isExist(menu1.getId())){ %>
															<TD align="middle" width="70"><a href="showCar.jsp?menuId=<%=menu1.getId()%>"><img
																src="images/buy_cn.gif" border="0"></a></TD>
														<%}else{ %>
															<td>已在购物车中</td>
														<%} %>
															<TD align=middle width=70><A href="menuDetail.jsp?id=<%=menu1.getId()%>" target=_blank><IMG
																src="images/detail_cn.gif" border=0></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
									
									<TD width="50%">
									<TABLE height="100%" cellSpacing=1 cellPadding=2 border=0 width="100%">
										<TBODY>
											<TR>
												<TD vAlign=top width=90 height=90><A href="menuDetail.jsp?id=<%=menu2.getId()%>"
													target=_blank><IMG height=80 alt=点击图片查看内容
													src="<%=menu2.getPic()%>" width=80 border=0></A></TD>
												<TD vAlign=top>
												<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center
													border=0 width="100%">
													<TBODY>
														<TR>
															<TD><A href="menuDetail.jsp?id=<%=menu2.getId()%>" target=_blank><STRONG><%=menu2.getName()%></STRONG></A></TD>
														</TR>
														<TR>
															<TD height=21><FONT color=#ff0000>现价：人民币<%=menu2.getPrice()%>元</FONT><BR>
															<%=menu2.getRemark()%></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
											
											<TR>
												<TD height=28>编号: <%=menu2.getId()%></TD>
												<TD>
												<TABLE cellSpacing=1 cellPadding=0 width="70%" border=0 width="100%">
													<TBODY>
														<TR>
															<TD  width=70><A href="showCar.jsp?menuId=<%=menu2.getId()%>"><IMG
																src="images/buy_cn.gif" border=0></A></TD>
															<TD  width=70><A href="menuDetail.jsp?id=<%=menu2.getId()%>" target=_blank><IMG
																src="images/detail_cn.gif" border=0></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
								</TR>
								<%} %>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/005.gif" height=8></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD bgColor=#eeeeee>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align="middle"><BR>
						<P align=center><FONT color=#000000>Copyright &copy;
						</FONT></P>
						<P align=center>&nbsp;</P>
						<BR>
						<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
