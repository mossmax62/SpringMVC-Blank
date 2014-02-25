package cl.max.acf.spring_mvc.repository;

import java.util.List;

import cl.max.acf.spring_mvc.domain.Product;

public interface ProductDao {
	
	public List<Product> getProductsList();
	public void saveProduct(Product prod);

}