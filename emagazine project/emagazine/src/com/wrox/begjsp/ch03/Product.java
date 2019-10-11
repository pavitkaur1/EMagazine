
package com.wrox.begjsp.ch03;

public class Product {
    
    private String bookid;
    
    private String title;
    
    private String edition ;
    private String path ;
    public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private long cost;
    private int nos;
    private int quantity;
    
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
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getNos() {
		return nos;
	}
	public void setNos(int nos) {
		this.nos = nos;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product() {
    }
    public Product( String bookid, String title,long price,int nos,int quantity,String edition,String path ) {
     this.bookid = bookid;
     this.title = title;
     this.edition = edition;
     this.cost = price;
     this.nos=nos;
     this.quantity=quantity;
     this.path=path;
    }
        
}
