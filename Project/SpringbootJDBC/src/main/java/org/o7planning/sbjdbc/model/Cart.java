package org.o7planning.sbjdbc.model;

public class Cart {

	
		private books product;
	    private int quantity;
	 
	    public Cart() {
	    	super();
	    }
	 
	    public Cart(books product, int quantity) {
	        this.product = product;
	        this.quantity = quantity;
	    }
	 
	    public books getProduct() {
	        return product;
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
