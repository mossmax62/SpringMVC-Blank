package cl.max.acf.spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.max.acf.spring_mvc.domain.Product;
import cl.max.acf.spring_mvc.repository.ProductDao;

@Component
public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductDao productDao;
	
	private List<Product> products;
	

	

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		List<Product> products = productDao.getProductList();
		 if (products != null) {
	            for (Product product : products) {
	                double newPrice = product.getPrice().doubleValue() * 
	                                    (100 + percentage)/100;
	                product.setPrice(newPrice);
	                productDao.saveProduct(product);
	            }
	        }  
		
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		return productDao.getProductList();
		
	}
	
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		return productDao.getProductWhereNameLike(name);
		
	}
	
	 

}
