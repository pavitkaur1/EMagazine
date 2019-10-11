<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%!   

private static String SHOP_PAGE = "/estore.jsp";
private static String CART_PAGE = "/shopcart.jsp";
private static String BILL_PAGE = "/billing.jsp";
private  String dispPrice( String price) {
   int len = price.length();

          return price;
}
%>

<html>
<head>
<title>Wrox Shopping Mall - Shopping Cart</title>
</head>
<body>

<%
  ArrayList items = (ArrayList) session.getAttribute("lineitems");

String action = request.getParameter("action");
String sku = request.getParameter("sku");
 Product prod = null;
  if (sku != null)
    prod = EShop.getItem(sku);
  if (action==null)
	    action=new String("ss");

  if (items == null)  {  // add first item
    items = new ArrayList();
    items.add(new LineItem(1,sku,prod.getTitle(),
                  prod.getCost(),prod.getQuantity() ));
    session.setAttribute("lineitems", items);
    }
  else  if (action.equals("clear")) {
         items.clear();     
    }
  else if (action.equals("inc")){
     boolean itemFound = false;
     // check to see if sku exists
     for (int i=0; i<items.size(); i++) {
         LineItem curItem = (LineItem) items.get(i);
         if (curItem.getSku().equals(sku))  {
              itemFound = true;
              if(curItem.getQuantity()<curItem.getMaxq())
              {curItem.setQuantity(curItem.getQuantity() + 1);
              curItem.setMaxq(curItem.getMaxq()-1);
              }
              else{}//maxquantity reached
              break;
         }  // of if
       } //of for

     if (!itemFound) 
        items.add(new LineItem(1,sku,prod.getTitle(),
                  prod.getCost(),prod.getQuantity() ));
      
   } // of final else
   else if (action.equals("rem")){
	     boolean itemFound = false;
	     // check to see if sku exists
	     for (int i=0; i<items.size(); i++) {
	         LineItem curItem = (LineItem) items.get(i);
	         if (curItem.getSku().equals(sku))  {
	              itemFound = true;
	             if(curItem.getQuantity()>0)
	              {curItem.setQuantity(curItem.getQuantity() - 1);
	              curItem.setMaxq(curItem.getMaxq()+1);
	              }
	              else
	            	 {items.remove(curItem);curItem.setMaxq(curItem.getMaxq()+1);}
					if(items.size()==0){items.clear();}	            
	             break;
	         }  // of if
	       } //of for
   }        
  int total = 0;
%>
<table width="600" align="center">
<tr>
<td>
<h1></h1>
<table border="1" width="600">
<tr><th colspan="5">Your Shopping Cart</th></tr>
<tr><th align="left">Quantity</th><th align="left">Item</th><th align="right">Price</th>
<th align="right">Extended</th>
<th align="left">Add</th>
<th align="left">remove</th></tr>
<%session.setAttribute("lineitems", items);
  for (int i=0; i< items.size(); i++)  {
    LineItem curItem = (LineItem) items.get(i);
    int quan = curItem.getQuantity();
    long price = curItem.getPrice();
    long extended = quan * price;
    total += extended;
%>

<tr>
   <td width="300px"><%= quan %>

   </td>
   <td><%= curItem.getDesc()   %></td>
   <td align="right"><%= dispPrice(String.valueOf(price))  %></td>
   <td align="right"><%= dispPrice(String.valueOf(extended))  %></td>
   <td>
  <a href="<%= request.getContextPath() +  CART_PAGE + "?action=inc&sku=" + curItem.getSku() %>">
       <b>Add 1</b></a>
   </td>
<td>
<a href="<%= request.getContextPath() +  CART_PAGE + "?action=rem&sku=" + curItem.getSku() %>"><b>remove 1</b></a>
   </td>

</tr>
<% 
    }
%>
<tr>
<td colspan="5"> &nbsp;
</td>
</tr>
<tr>
<td colspan="3" align="right"><b>Total:</b></td>
<td align="right"><%= dispPrice(String.valueOf(total)) %></td>
<td>&nbsp;</td>
</tr>

<tr>
<td colspan="5">
<a href="<%= request.getContextPath() +  CART_PAGE + "?action=clear" %>">
Clear the cart</a>
</td>
</tr>


<tr>
<td colspan="5">
<s:a href="estore">
Return to Shopping</s:a>
</td>
</tr>

<tr>
<td colspan="5">
<a href="<%= request.getContextPath() + BILL_PAGE %>">
PAY</a>
</td>
</tr>


</table>
</td>
</tr>
</table>
</body>
</html>
