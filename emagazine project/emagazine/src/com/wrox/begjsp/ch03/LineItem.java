
package com.wrox.begjsp.ch03;
public class LineItem {
    
    private int quantity;
    
    private String sku;
    
    private String desc;
    
    private long price;
    private int maxq;
    public LineItem() {
    }
    public LineItem( int quantity, String sku, String desc, long price,int maxq) {
    this.quantity = quantity;
    this.sku = sku;
    this.desc = desc;
    this.price = price;
    this.maxq=maxq;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public int getMaxq() {
		return maxq;
	}
	public void setMaxq(int maxq) {
		this.maxq = maxq;
	}
	public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getSku() {
        return this.sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public long getPrice() {
        return this.price;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }
    
}
