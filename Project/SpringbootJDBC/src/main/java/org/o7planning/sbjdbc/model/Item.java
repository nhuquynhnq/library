package org.o7planning.sbjdbc.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
	private books product;
    private int quantity;
 
    public Item() {
    	super();
    }
 
   
 
    public books getProduct() {
        return product;
    }
    public Integer getId() {
        return id;
    }
 
 
    public void setProduct(books product) {
        this.product = product;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
}

}
