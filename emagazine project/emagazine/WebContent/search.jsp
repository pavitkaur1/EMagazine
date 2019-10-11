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

   <s:form>
    <h2>Struts 2 Autocomplete (Drop down) Example!</h2>
     
    Country:

    <sx:autocompleter size="10" list="countries" name="countries"  ></sx:autocompleter>

   </s:form>

</body>
</html>