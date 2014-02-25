package cl.max.acf.spring_mvc.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cl.max.acf.spring_mvc.domain.Product;

public class ProductTest {
	
	private Product product;
	
	@Before
	public void setUp() throws Exception{
		product = new Product();
		
	}
	
	@Test
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        assertNull(product.getDescription());
        product.setDescription(testDescription);
        assertEquals(testDescription, product.getDescription());
    }

    @Test
    public void testSetAndGetPrice() {
        double testPrice = 100.00;
        assertEquals(0, 0, 0);    
        product.setPrice(testPrice);
        assertEquals(testPrice, product.getPrice(), 0);
    }
	
	

}
