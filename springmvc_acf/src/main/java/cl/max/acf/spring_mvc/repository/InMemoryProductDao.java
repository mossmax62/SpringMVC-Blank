package cl.max.acf.spring_mvc.repository;

import java.util.List;

import cl.max.acf.spring_mvc.domain.Product;

public class InMemoryProductDao implements ProductDao {
	
	private List<Product> productList;
	
	
	public InMemoryProductDao (List<Product> productList){
		this.productList = productList;
	}

	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productList;
	}

	public List<Product> getProductWhereNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProduct(Product prod) {
		// TODO Auto-generated method stub
		
	}

}
