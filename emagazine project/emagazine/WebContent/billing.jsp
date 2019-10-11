<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.wrox.begjsp.ch03.*,java.util.*" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! private static String SHOP_PAGE = "/estore.jsp"; %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
tum kya leke aaye the aur kya leke jaoge
<table>
<tr>
<td>title</td>
<td>cost</td>
<td>quantity</td>
<td>book id</td>
</tr>

<%

ArrayList items = (ArrayList) session.getAttribute("lineitems");
 for (int i=0; i<items.size(); i++) {
         LineItem curItem = (LineItem) items.get(i);
%>

<tr>
<td><%= curItem.getDesc()%></td>
<td><%= curItem.getPrice()%></td>
<td><%= curItem.getQuantity()%></td>
<td><%= curItem.getSku()%></td>
</tr>
<%} 

session.removeAttribute("lineitems");
%>
</table>
<s:a href="estore">
Return to Shopping</s:a>


</body>
</html>