package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");

		//passing the list of categories 
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*
	 * Methods to load all the products and based on category
	 */
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		//passing the list of categories 
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}

	
	/* 
	 * Meaning map this url to this method. to it uses the info in this url(id)to execute the method 
	 */
	@RequestMapping(value= {"/show/category/{id}/products"})     
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {// saying the pathvariable 'id'/{id} should be int id
		ModelAndView mv = new ModelAndView("page");
		
		//categroyDAO to fetch a single category
		Category category=null;
		
		category = categoryDAO.get(id );
		
		mv.addObject("title",category.getName());
		
		//passing the single category object
		mv.addObject("category",category);
		
		//passing the list of categories 
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickC",true);
		return mv;
	}
	
	/*
	 * for view a single product
	 */
	
	@RequestMapping(value= {"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable("id")int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		//categroyDAO to fetch a single category
		Product product=null;
		
		product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		
		//passing the list of categories 
		
		
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
	
	
	
}
