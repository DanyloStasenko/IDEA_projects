package edu.shop.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.shop.java.models.Product;
import edu.shop.java.services.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	public ProductController() {
		
	}
	 
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<Product> products = productService.getAll();
		
		modelAndView.addObject("products", products);
		modelAndView.setViewName("products");
		
		return modelAndView;
	}
}
