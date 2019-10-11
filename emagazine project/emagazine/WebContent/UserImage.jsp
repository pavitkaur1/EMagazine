<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Upload User Image</title>
</head>

<body>
Struts2 File Upload & Save Example
<s:actionerror />
<s:form action="userImage.action" method="post" enctype="multipart/form-data">
	<s:file name="userImage" label="User Image" />
	<s:submit value="Upload" align="center" />
</s:form>
</body>
</html>
