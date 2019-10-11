<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />

    <body>
        <div align="center">
<div id="navbar">
        
        <h2>Registration </h2>
                <%@page import="com.dao.*"%>
        
        <% reguser g=new reguser(); %>;
        <s:form action="reg">
            <s:textfield  name="username" label="Username " />
            <s:textfield name="name"  label="name" />

            <s:password name="password" label="Password "/>
            <s:password name="confirmPassword" label="Confirm Password "/>
            <s:textfield name="age"  label="age " />
            <s:textfield name="address"  label="address " />
            <s:textfield name="interest"  label="interest " />
            
            <p/>
            <s:submit value="Register"/>
        
            <s:actionerror/>     
        </s:form>
    </div></div>
    </body>
</html>
