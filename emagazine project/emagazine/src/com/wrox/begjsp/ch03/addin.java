package com.wrox.begjsp.ch03;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.dao.reguser;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class addin extends ActionSupport implements
ServletRequestAware  {
String bookid,title,edition,path,option,nos,cost,quantity;

public String getBookid() {
	return bookid;
}

public void setBookid(String bookid) {
	this.bookid = bookid;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getEdition() {
	return edition;
}

public void setEdition(String edition) {
	this.edition = edition;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public String getOption() {
	return option;
}

public void setOption(String option) {
	this.option = option;
}

public String getNos() {
	return nos;
}

public void setNos(String nos) {
	this.nos = nos;
}

public String getCost() {
	return cost;
}

public void setCost(String cost) {
	this.cost = cost;
}

public String getQuantity() {
	return quantity;
}

public File getUserImage() {
	return userImage;
}

public void setUserImage(File userImage) {
	this.userImage = userImage;
}

public String getUserImageContentType() {
	return userImageContentType;
}

public void setUserImageContentType(String userImageContentType) {
	this.userImageContentType = userImageContentType;
}

public String getUserImageFileName() {
	return userImageFileName;
}

public void setUserImageFileName(String userImageFileName) {
	this.userImageFileName = userImageFileName;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}
private static final long serialVersionUID = 1L;
private File userImage;
private String userImageContentType;
private String userImageFileName;
private List values;
private HttpServletRequest servletRequest;

public String execute() {
   	int l=0;
   	

   	
   	String fp;
   	try {

		@SuppressWarnings("deprecation")
		String filePath = servletRequest.getRealPath("/");
		System.out.println("Server path:" + filePath);
		filePath="/img";
		File fileToCreate = new File(filePath, this.userImageFileName);
fp=filePath+this.userImageFileName;
		FileUtils.copyFile(this.userImage, fileToCreate);
	} catch (Exception e) {
		e.printStackTrace();
		addActionError(e.getMessage());

		return "input";
	}
    
    
    reguser i=new reguser();
       
       
      l= i.insadm(bookid, title,Float.valueOf(cost) ,Integer.valueOf(nos) ,Integer.valueOf(quantity),fp,option,edition);
 
	
	return "success";
}

public void setServletRequest1(HttpServletRequest servletRequest) {
	this.servletRequest = servletRequest;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	
}
}
