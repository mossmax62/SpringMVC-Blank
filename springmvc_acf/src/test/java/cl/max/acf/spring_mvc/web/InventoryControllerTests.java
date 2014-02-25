package cl.max.acf.spring_mvc.web;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import cl.max.acf.spring_mvc.service.SimpleProductManager;
import cl.max.acf.spring_mvc.web.InventoryController;

import junit.framework.TestCase;

public class InventoryControllerTests extends TestCase {
	
	@Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        //assertEquals("hello.jsp", modelAndView.getViewName());
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("uncheked")
        Map<String, Object> modelMap =(Map<String, Object>)modelAndView.getModel().get("model"); 
        
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

}
