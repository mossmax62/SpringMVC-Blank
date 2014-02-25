package cl.max.acf.spring_mvc.service;

import java.util.List;

import cl.max.acf.spring_mvc.domain.Product;

public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Product> products;

	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		 if (products != null) {
	            for (Product product : products) {
	                double newPrice = product.getPrice().doubleValue() * 
	                                    (100 + percentage)/100;
	                product.setPrice(newPrice);
	            }
	        }  
		
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		return this.products;
		
	}
	
	 public void setProducts(List<Product> products) {
	        //throw new UnsupportedOperationException();
		 this.products=products;
	    }

}
