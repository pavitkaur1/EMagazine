package com.wrox.begjsp.ch03;

import java.util.Map;

import com.dao.reguser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	@SuppressWarnings("unchecked")
	public String execute(){

	/*	if (this.username.equals("admin") 
				&& this.password.equals("admin123")) {
			return "success";
		} else {
			addActionError(getText("error.login"));
			return "error";
		}*/
		if (this.username.equals("adminak") 
				&& this.password.equals("admin123")) 
		{
			 @SuppressWarnings("rawtypes")
			Map session = ActionContext.getContext().getSession();
			  LoginAction ara=new LoginAction();
			  ara.setUsername(this.username);
			  ara.setPassword(this.password);
			  session.put("user",ara);	

			
			return "Admin";}
		
		else 
		{
reguser a=new reguser();
boolean r=a.check(this.username, this.password);

		
		if(r)
		{
			 @SuppressWarnings("rawtypes")
			Map session = ActionContext.getContext().getSession();
			  LoginAction ara=new LoginAction();
			  ara.setUsername(this.username);
			  ara.setPassword(this.password);
			  session.put("user",ara);	
			
			return "success";
				
		}
		
		else 
			return "error";
	
		}
		
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
}
