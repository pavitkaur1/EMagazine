<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<jsp:useBean id="currentPage" type="java.lang.String" scope="request"/>
Current page is <%= currentPage %>

<div id="leftMain">
<div id="navbar">
<ul>
<li><s:a href="welcome">HOME</s:a></li>
<li><s:a href="estore">BROWSE</s:a></li>
<li><s:a href="ajaxdemo">SEARCH</s:a></li>
<li><s:a href="shopcart">SHOPCART</s:a></li>
</ul>
</div>
</div>
</body>
</html>