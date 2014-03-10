package cl.max.acf.spring_mvc.web;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import cl.max.acf.spring_mvc.domain.Product;
import cl.max.acf.spring_mvc.repository.InMemoryProductDao;
import cl.max.acf.spring_mvc.service.SimpleProductManager;
import cl.max.acf.spring_mvc.web.InventoryController;

import junit.framework.TestCase;

public class InventoryControllerTests extends TestCase {
	
	@Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
        controller.setProductManager(spm);
        //controller.setProductManager(new SimpleProductManager());
        
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        //assertEquals("hello.jsp", modelAndView.getViewName());
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap =(Map<String, Object>)modelAndView.getModel().get("model"); 
        
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

}
