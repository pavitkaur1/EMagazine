package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wrox.begjsp.ch03.Product;

import oracle.jdbc.pool.OracleDataSource;

public class reguser {
	
	static Connection conn=null;
	static int kos=0;
    
	   public   Connection getConnection1() //Get Connection
	   {
		   @SuppressWarnings("unused")
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		   String user="hr";
		   String password="hr";
		   try { 
		   OracleDataSource ods = new OracleDataSource();
		   ods.setUser(user);
		   ods.setPassword(password);
		   ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
		   ods.setConnectionCachingEnabled(true);

		   conn=ods.getConnection();
		   
		   }
		   catch(SQLException e)
		   {System.out.println(e);}
		   
		   
		/* try     //load driver
		  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }
		  catch(ClassNotFoundException ex1)
		  {
			  System.out.println("Driver Not Found");
		  }
		 try
		  { //conn.close();
			// DriverManager.
		//	if(conn.equals(null))
			 conn=DriverManager.getConnection(url, user, password);
		  }
		  catch(SQLException ex2)
		  {
			  System.out.println(ex2);
		  }*/
		   return conn;
	   }
public int ins(String username,String name,String password,int age,String add,String interest)
{try{
//if(conn.isClosed())
	//conn=getConnection1();
	if(kos==0)conn=getConnection1();
PreparedStatement stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?)");

stmt.setString(1, username);
stmt.setString(2, name);
stmt.setString(3, password);
stmt.setInt(4, age);
stmt.setString(5, add);
stmt.setString(6, interest);
int h=stmt.executeUpdate();
return h;
}
catch(SQLException e){  System.out.print(e);}
kos++;
return 0;
}
public int insadm(String bookid, String title,float cost,int nos ,int quantity,String path,String option,String edition)
{try{
//if(conn.isClosed())
	//conn=getConnection1();
	PreparedStatement stmt=null;
	if(kos==0)conn=getConnection1();
if(option.equals("general"))
	stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,1,0,0,0,0,0,0,?)");
if(option.equals("business"))
	stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,1,0,0,0,0,0,?)");
if(option.equals("spiritual"))
	 stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,0,1,0,0,0,0,?)");
if(option.equals("health"))
	 stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,0,0,1,0,0,0,?)");
if(option.equals("education"))
	 stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,0,0,0,1,0,0,?)");
if(option.equals("entertainment"))
	 stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,0,0,0,0,1,0,?)");
if(option.equals("sports"))
	 stmt=conn.prepareStatement("insert into userinf values(?,?,?,?,?,?,0,0,0,0,0,0,1,?)");


stmt.setString(1, bookid);
stmt.setString(2, title);
stmt.setFloat(3,cost );
stmt.setInt(4, nos);
stmt.setInt(5, quantity);
stmt.setString(6, path);
stmt.setString(7, edition);
int h=stmt.executeUpdate();
return h;
}
catch(SQLException e){  System.out.print(e);}
kos++;
return 0;
}

public boolean check(String user,String pwd)
{	ResultSet rs=null;
Statement stmt=null;
	if(kos==0)conn=getConnection1();
	try{
		stmt=conn.createStatement();
		 rs=stmt.executeQuery("select * from userinf where userid like '"+ user+ "' and password like '" + pwd +"'");
if(rs.next())return true;
else return false;
	}catch(SQLException e){return false;}

}
@SuppressWarnings({ "rawtypes", "unchecked" })
public ArrayList finder(String cat)
{ResultSet rs=null;
Statement stmt=null;
//if(kos==){System.out.println("error");}
ArrayList values1=new ArrayList();
if(kos==0)conn=getConnection1();
	try{
		 System.out.println(cat+"prob");
 stmt=conn.createStatement();
 rs=stmt.executeQuery("select bookid,title,cost,nos,quantity,edition,path from magazine where "+cat+"=1");

 //stmt.close();	
 //conn.close();
 while(rs.next())
 {
 	values1.add(new Product(rs.getString("bookid"),rs.getString("title"),rs.getLong("cost"),rs.getInt("nos"),rs.getInt("quantity"),rs.getString("edition"),rs.getString("path")));
 	
 }
 
//return rs;
 //conn.close();
	}
	catch(SQLException e){}//return null;}
//finally{
	kos++;
	return values1;
//}
	
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public ArrayList searchname(String cat)
{ResultSet rs=null;
Statement stmt=null;
//if(kos==){System.out.println("error");}
ArrayList values1=new ArrayList();
if(kos==0)conn=getConnection1();
	try{
		 System.out.println(cat+"prob");
 stmt=conn.createStatement();
 rs=stmt.executeQuery("select bookid,title,cost,nos,quantity,edition,path from magazine where title like '"+cat+"'");
//stmt.close();	
 //conn.close();
 while(rs.next())
 {
 	values1.add(new Product(rs.getString("bookid"),rs.getString("title"),rs.getLong("cost"),rs.getInt("nos"),rs.getInt("quantity"),rs.getString("edition"),rs.getString("path")));
 	
 }
 
//return rs;
 //conn.close();
	}
	catch(SQLException e){}//return null;}
//finally{
	kos++;
	return values1;
//}
	
}


public List<String> search()
{
	List<String> countries;
	ResultSet rs=null;
	Statement stmt=null;
	if(kos==0)conn=getConnection1();
	 countries = new ArrayList<String>();
	try{
	//	 System.out.println(cat+"prob");
stmt=conn.createStatement();
rs=stmt.executeQuery("select title from magazine ");
while(rs.next())
{		 System.out.println(rs.getString("title"));
	countries.add(rs.getString("title"));
	
}

	}
	catch(SQLException e){}//return null;}

	kos++;
	return countries;
	
	
	
//return null;
}
public void decon()
{
	try{
conn.close();	
}catch(SQLException e){}
	
}




}
