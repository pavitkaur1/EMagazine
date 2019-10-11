<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>Hello World</title>
<s:head />
<sx:head />
</head>
<body>

 <s:form action="depo">
    <sx:autocompleter size="1000" dropdownWidth="1000" list="countries" notifyTopics="/Changed" cssStyle="width:1000px;" name="couny" value="" ></sx:autocompleter>
	<br></br>
<s:submit></s:submit>   
</s:form>

</body>
</html>