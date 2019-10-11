package com.wrox.begjsp.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
import com.dao.reguser;
import com.opensymphony.xwork2.ActionSupport;
 
@SuppressWarnings({ "serial", "unused" })
public class autocomplete extends ActionSupport {
  
	private String data = "Afghanistan, Zimbabwe, India, United States, Germany, China, Israel";
    private List<String> countries;
    private String country,tr;
     
    public String execute() {
        countries = new ArrayList<String>();
    	System.out.print("hooka booka");

    //  StringTokenizer st = new StringTokenizer(data, ",");
 reguser ac=new reguser();
 	
 countries=ac.search();
    //    while (st.hasMoreTokens()) {
       	System.out.print(country);
        //  countries.add(st.nextToken().trim());
        //}
        return SUCCESS;
    }
    public String getCountry() {
        return this.country;
    }
 
    public List<String> getCountries() {
        return countries;
    }
 
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
    public void setCountry(String country) {
        this.country = country;
    }
	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = country;
	}
}