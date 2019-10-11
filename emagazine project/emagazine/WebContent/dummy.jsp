<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.wrox.begjsp.ch03.*,java.util.*" session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"
>
<title>Insert title here</title>
</head>
<body>
<%
ArrayList items = (ArrayList) session.getAttribute("lineitems");

String action = request.getParameter("action");
String sku = request.getParameter("sku");
Product prod = null;
 if (sku != null)
   prod = EShop.getItem(sku);

  // add first item
   items = new ArrayList();
   items.add(new LineItem(1,sku,prod.getTitle(),
                 prod.getCost(),prod.getQuantity() ));
   session.setAttribute("lineitems", items);
 %>
<s:action name="estore" executeResult="true"/>
</body>
</html>