<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core"  prefix="c"%>
<%@ page import = "shopping.*,entity.*,dao.impl.*" %>
<%
	request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HTML>
<HEAD>
<TITLE>网上订餐系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">

	function order(){
		var personNum = $("#personNum").val();
		var remark = $("#remark").val();
		var size = $("#size").val();
		if(size <= 0){
			alert("您没有订购任何菜不能提交订单!");
			return;
		}else if(personNum == null || personNum == ""){
			alert("请填写人数!");
			return;
		} else{
			$.ajax(
					{
						url:"${base}/OrderServlet",
						type:"post",
						data:"personNum="+personNum+"&remark="+remark,
						dataType:"json",
						success:successInfo
					}
				);
		}	
	}
	
	function successInfo(json){
		var success=json.success;
		if(success == null){
			$("#tipsDiv").show();
		}else{
			alert("订单提交成功，您的订单号是"+json.id);
			window.location.href = "show.jsp";
		}
		
	}

</script>


</HEAD>
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
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
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
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
						<TD align=middle height=30><FONT color=#000000> <SCRIPT
							language="javascript" src="images/DateTime2.js"></SCRIPT><SCRIPT
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
						<TD align=middle>
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
						<TD><BR>
						</TD>
					</TR> 
				</TBODY>
			</TABLE>
			<table cellspacing=1 cellpadding=4 width="92%" border=1
				align="center" bgcolor="#c0c0c0">
				<tr style="display: none;" id="tipsDiv"><td colspan="5" ><font color="red">生成订单失败！</font></td></tr>
				<tr bgcolor="#dadada">
					<td colspan="5" height="25" align=center><font color="#000000">确认订单信息</font></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" align="right"><font color="#000000">订 餐
					人：</font></td>
					<td colspan=4 width="78%"><input type="text" name="name"
						size="46" maxlength="20" value="${loginer.name }" readonly="readonly"></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" align="right"><font color="#000000">人数：</font></td>
					<td colspan=4 width="78%"><input type="text" name="personNum" id="personNum"
						size="46" maxlength="20"  ></td>
				</tr>
				
				<tr bgcolor="#ffffff">
					<td colspan="2" width="100%" align="center">
						<jsp:useBean id="caritems" class="shopping.ShoppingCar" scope="session"></jsp:useBean>
						
						
							<%
								int size = caritems.getNumOfItems();%>
							 <input type="hidden" id="size" value="<%=size %>"/>	
							<% 
								if(size > 0){
									Collection<CarItemBean> cols = caritems.getItems().values();
							 %>
							
							 <table>
							 <%
							 	for(CarItemBean item:cols){
									 	Menutbl menu = item.getMenu();
							  %>
							<tr bgcolor="#ffffff">
								<td width="50" align="center" height="22"><font
									color="#000000"><%=menu.getId() %></font></td>
								<td align="center" height="22"><font color="#000000"><%=menu.getName() %></font>
								</td>
								<td width="104" align="center" height="22"><font
									color="#000000">￥<%=menu.getPrice() %></font></td>
								<td width="100" class="hh" align="center" height="22"><%=item.getNumber() %></td>
								<td width="116" class="bb" align="center" height="22"><font
									color="#000000">￥<%=item.getItemPrice() %></font></td>
							</tr>
							 <%} %>
							 <tr bgcolor="#ffffff">
								<td width="50" height="22" align="center"><font
									color="#000000">合计</font></td>
								<td height="22" align="center"><font color="#000000">-</font></td>
								<td width="104" height="22" align="center"><font
									color="#000000">-</font></td>
								<td width="100" class="hh" height="22" align="center"><font
									color="#000000">-</font></td>
								<td width="116" class="bb" align="center" height="22"><font
									color="#000000">￥<%=caritems.getTotalPrice() %></font></td>
							</tr>
							</table>
							<%}else{ %>
								您还没有订购任何菜~
							<%} %>
						
						
						
					
					
					</td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" height="31" align="right"><font
						color="#000000">订单附言：</font></td>
					<td colspan=4 width="78%" height="31"><textarea name="bz"
						cols="45" rows="6" id="remark"></textarea></td>
				</tr>
				<tr bgcolor="#dadada">
					<td colspan="5" height="12" align="center"><input type="button"
						value="确认以上信息无误,提交" name="Submit" onclick="order()"></td>
				</tr>
			</table>
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
						<TD align=middle><BR>
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
