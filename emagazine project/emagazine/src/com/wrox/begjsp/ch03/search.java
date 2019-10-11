package com.wrox.begjsp.ch03;

import java.util.ArrayList;

import com.dao.reguser;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class search extends ActionSupport {
	 String couny;

	public String getCouny() {
		return couny;
	}

	public void setCouny(String couny) {
		this.couny = couny;
	}
    public String execute() {
          return "success";
    }
    @SuppressWarnings("rawtypes")
	public ArrayList rtrn(String c)
    {
    	reguser sc=new reguser();	
        ArrayList a=new ArrayList();
        a=sc.searchname(c);
        return a;
    }
}
