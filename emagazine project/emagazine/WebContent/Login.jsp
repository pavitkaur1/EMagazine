<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<head>
<title>Struts 2 - Login Application</title>
</head>

<body>
<div  align="center">
<div id="navbar">

<h2> Login Application</h2>
<%session.invalidate(); %>
<s:form action="login" >

	<s:textfield name="username" key="label.username" size="20" />
	<s:password name="password" key="label.password" size="20" />
	<s:a href="reg">register</s:a>

	<s:submit method="execute" key="label.login" align="center"  value="login"/>
	
</s:form>
</div></div>
</body>
</html>
