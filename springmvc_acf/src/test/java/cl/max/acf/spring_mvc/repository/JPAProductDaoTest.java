package cl.max.acf.spring_mvc.repository;

import static org.junit.Assert.*;

import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.max.acf.spring_mvc.domain.Product;
import cl.max.acf.spring_mvc.service.SimpleProductManager;

public class JPAProductDaoTest {
	
	private ApplicationContext context;
	private ProductDao productDao;
	private static String TABLE_DESCRIPTION = "Table";
	private static String LAMP_DESCRIPTION = "Lamp";
	
	@Before
	public void setUp()throws Exception{
		
		context= new ClassPathXmlApplicationContext("classpath:test-app-config.xml");
		productDao=(ProductDao)context.getBean("productDao");
		
	}

	 	@Test
	    public void testGetProductList() {
	        List<Product> products = productDao.getProductList();
	        assertEquals(products.size(), 3, 0);	   
	    }

	    @Test
	    public void testSaveProduct() {
	        List<Product> products = productDao.getProductList();

	        Product p = products.get(0);
	        Double price = p.getPrice();
	        p.setPrice(200.12);
	        p.setDescription("Lamp");
	        productDao.saveProduct(p);

	        List<Product> updatedProducts = productDao.getProductList();
	        Product p2 = updatedProducts.get(0);
	        assertEquals(p2.getPrice(), 200.12, 0);

	        p2.setPrice(price);
	        productDao.saveProduct(p2);
	        
	        
	    }
	    
	    @Test
		public void testGetProdByName(){
			List<Product> productsFromDb = null;
			try{
				
				productsFromDb=productDao.getProductWhereNameLike(LAMP_DESCRIPTION);
				Product product = productsFromDb.get(0);
				Product productStub = new Product();
				productStub.setDescription(LAMP_DESCRIPTION);
				assertTrue(product.getDescription().equals(productStub.getDescription()));
				
			}catch(Exception e){e.printStackTrace();}
			
		}
}
