<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.wrox.begjsp.ch03.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <s:form action="depo2" enctype="multipart/form-data">
<s:textfield name="bookid">bookid</s:textfield><br></br>
<s:textfield name="title" >title</s:textfield><br></br>
<s:textfield name="cost" >cost</s:textfield><br></br>
<s:textfield name="nos" >nos</s:textfield><br></br>
<s:textfield name="quantity" >quantity</s:textfield><br></br>
	<s:file name="userImage" label="User Image" />
<br></br>
<s:textfield name="edition" ></s:textfield>

<sx:autocompleter size="10" dropdownWidth="100px" list="{'general','business','spiritual','health','education','entertainment','sports'}" notifyTopics="/Changed" cssStyle="width:100px;" name="options" value="" ></sx:autocompleter>
	<br></br>

<s:submit></s:submit>   
</s:form>
</body>
</html>