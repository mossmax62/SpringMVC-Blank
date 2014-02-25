package cl.max.acf.spring_mvc.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.max.acf.spring_mvc.service.ProductManager;

@Controller
public class InventoryController {
	
	private static final Log log = LogFactory.getLog(InventoryController.class);
	
	@Autowired
	private ProductManager productManager;
	
	
	


	@RequestMapping(value="/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp){
		
		 String now = (new Date()).toString();
	     log.info("Returning hello view with " + now);
	     
	     Map<String, Object> myModel = new HashMap<String, Object>();
	     myModel.put("now", now);
	     myModel.put("products",this.productManager.getProducts());
	     
	     
	     
	     return new ModelAndView("hello", "model", myModel);

	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	

}
