
package com.wrox.begjsp.ch03;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.dao.reguser;

@SuppressWarnings("unused")
public class EShop {
    
    public EShop() {
    }
   // static ArrayList values1;
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList getCats() {
            ArrayList values = new ArrayList();

            values.add( new Category("1", "general"));
            values.add( new Category("2", "business"));
            values.add( new Category("3", "spiritual"));
            values.add( new Category("4", "health"));
            values.add( new Category("5", "education"));
            values.add( new Category("6", "entertainment"));
            values.add( new Category("7", "sports"));
            return values;
    }
    
    @SuppressWarnings("rawtypes")
	public static ArrayList getItems(String catid)  {
    	ArrayList values1 = new ArrayList();
        //ResultSet rs=null;
        reguser accs=new reguser();
        ArrayList vals=getCats();
      if(values1.size()==0){  
        for (int i=0; i< vals.size(); i++) {
            Category curCat1 = (Category) vals.get(i);
           
            if(curCat1.getId().equals(catid))
            {
            	// System.out.println(curCat1.getName());
            	values1=accs.finder(curCat1.getName());
         
         //   	System.out.println(rs.getString("title"));
            }
        }
      //  try{
        /*while(rs.next())
        {
        	values1.add(new Product(rs.getString("bookid"),rs.getString("title"),rs.getLong("cost"),rs.getInt("nos"),rs.getInt("quantity"),rs.getString("edition")));
        	
        }*///accs.decon();
        //	rs.close();
        }
        //catch(SQLException e ){}
     // }
        
       /* if (catid.equals("1"))  {
            rs=accs.finder("general");
        	
        	values.add(new Product("232", "Pentium 4 - 4 GHz, 512 MB, 300 GB","",  98999));
            values.add(new Product("238", "AMD Opteron - 4 GHz, 1 GB, 300 GB","",  120099));
            
            
        } else if (catid.equals("2")) {
            values.add(new Product("872", "Tomcat 5 Server for Windows", 
               "",  9900));
            values.add(new Product("758", "Tomcat 5 Server for Linux", 
               "",  9900));
                       
        } else if (catid.equals("3")) {
           values.add(new Product("511", "Beginning JavaServer Pages", 
               "",  3999));
           values.add(new Product("188", "Professional Apache Tomcat 5", 
               "",  4999));
           values.add(new Product("148", "Apache Tomcat Bible", 
               "",  4999));
            
        }*/
        return values1;
    }
    
        @SuppressWarnings("rawtypes")
		public static Product getItem(String sku)  {
         ArrayList cats = getCats();
         Product foundProd = null;
         for (int i=0; i < cats.size(); i++)  {
           Category curCat = (Category) cats.get(i);
           ArrayList items = getItems(curCat.getId());
             for (int j=0; j < items.size(); j++) {
                Product curProd = (Product) items.get(j);   
                if (curProd.getBookid().equals(sku)) {
                 foundProd = curProd;
                 break;
                }   
             }
           if (foundProd != null)
               break;
         }
            
            
        return foundProd;    
            
            
        }    
}
