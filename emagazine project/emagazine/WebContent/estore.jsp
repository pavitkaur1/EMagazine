<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%!   
public void jspInit() {
   getServletContext().setAttribute("cats", EShop.getCats());
}

public void jspDestroy() {
   getServletContext().removeAttribute("cats");
}

private  String dispPrice( String price) {
   int len = price.length();
   
          return price;
   }
%>

<html>
<head>

<title>Wrox Shopping Mall</title>
</head>
<body>
<table width="600">
<tr>
<td width="20%">
<%
   
   ArrayList cats = (ArrayList) application.getAttribute("cats");
   for (int i=0; i< cats.size(); i++) {
          Category curCat = (Category) cats.get(i);
String pp=request.getAttribute("javax.servlet.forward.request_uri").toString();
%>

<a href="<%= request.getAttribute("javax.servlet.forward.request_uri")  + "?catid=" + curCat.getId() %>">
         <%=  curCat.getName()  %>
</a>
<br/>
<%
    }
%>
</td>
<td>
<h1></h1>
<table border="1">
<tr><th align="left">Item</th><th align="left">Price</th><th align="left">Order</th></tr>
<%
   String selectedCat = request.getParameter("catid");
   if (selectedCat == null) 
     selectedCat = "1";
   ArrayList items = (ArrayList) EShop.getItems(selectedCat);
for (int i=0; i< items.size(); i++)  {
     Product curItem = (Product) items.get(i);
%>
<tr>
	<td>
	<img alt="" src="<%=curItem.getPath()%>" height="100px" width="100px">
	</td>
   <td width="300px"><%= curItem.getTitle()%></td>
   <td><%= dispPrice(String.valueOf(curItem.getCost()))  %></td>
   <td>
    <s:url action="shopcart"  var="urlTag1" >
 
</s:url>
<%
//String pp=request.getAttribute("javax.servlet.forward.request_uri").toString();

//session.setAttribute("action1","inc");
//session.setAttribute("sku1",curItem.getBookid());
//session.setAttribute("pp",pp);
%>
<a href="<%= request.getContextPath() + "/shopcart.jsp?action=inc&sku=" + curItem.getBookid() %>" >
       <b>BUY</b>
       </a>
       
   </td>
</tr>

<%
  }
%>

</table>
</td>
</tr>
</table>

</body>
</html>
