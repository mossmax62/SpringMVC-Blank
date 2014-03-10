package cl.max.acf.spring_mvc.service;

import java.io.Serializable;
import java.util.List;

import cl.max.acf.spring_mvc.domain.Product;

public interface ProductManager extends Serializable{
	
	public void increasePrice(int percentage);
	
	public List<Product> getProductByName(String name);
	
	public List<Product> getProducts();
}
