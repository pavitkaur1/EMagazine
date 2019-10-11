package com.wrox.begjsp.ch03;
//package com.pack1;

//package net.roseindia;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

@SuppressWarnings({ "unused", "serial" })
public class logoutAction extends ActionSupport {
@SuppressWarnings("rawtypes")
public String execute() throws Exception { 
Map session = ActionContext.getContext().getSession();
session.remove("user"); 
session.clear();

return SUCCESS;
}
}