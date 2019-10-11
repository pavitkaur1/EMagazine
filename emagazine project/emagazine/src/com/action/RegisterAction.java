package com.action;

import com.dao.reguser;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport 
{
    private String username,password,confirmPassword,address,interest,name,edition;
    String age;
    
    
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RegisterAction() {
    }
    public String execute() throws Exception {
 
    	@SuppressWarnings("unused")
		int l=0;
    
 
 reguser i=new reguser();
    
    
   l= i.ins(username, name, confirmPassword,Integer.valueOf(age) , address, interest);
// if(l>0)  
    	    	return "success";
 //else 
 	//return "input";
    }
}
