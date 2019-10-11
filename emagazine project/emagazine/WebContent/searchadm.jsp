<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.wrox.begjsp.ch03.*,java.util.*"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("couny") %>
<br>
<%search ss=new search ();   
ArrayList items = (ArrayList) ss.rtrn(request.getParameter("couny"));
for (int i=0; i< items.size(); i++)  {
    Product curItem = (Product) items.get(i);
%>
<table>
<tr>
  <td><%= curItem.getTitle()   %></td>
  <td><%= String.valueOf(curItem.getCost())  %></td>
  <td><a href="<%= request.getContextPath() + "/shopcart.jsp?action=inc&sku=" + curItem.getBookid() %>">
        <b>BUY</b></a>
  </td>
</tr>
</table>
<%
  }
%>

<s:property  value="country"/>
<s:bean name="com.wrox.begjsp.ch03.search" var="country"></s:bean>
</body>
</html>