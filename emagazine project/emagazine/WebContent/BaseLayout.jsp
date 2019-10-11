<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" />
<tiles:useAttribute name="currentPage" scope="request" />
</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" height=100% width=100%>
	<tr>
		<td height="30"  colspan="2"><tiles:insertAttribute name="header" />
		<s:property  value="%{#session.user.username}" />

		<a href="<%= request.getContextPath() %>/logout.action">Logout</a>
                
 
		</td>
	</tr>
	<tr>
		<td height=80% width=17%><tiles:insertAttribute name="menu" /></td>
		<td width=83% valign="top"><tiles:insertAttribute name="body" /></td>
	</tr>
	<tr>
		<td height="30" colspan="2"><tiles:insertAttribute name="footer" />
		</td>
	</tr>
</table>
</body>
</html>