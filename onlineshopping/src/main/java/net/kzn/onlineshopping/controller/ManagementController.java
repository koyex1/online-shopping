package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	private static final Logger Logger=LoggerFactory.getLogger(ManagementController.class);

@GetMapping(value="/products")
public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
	
	
	ModelAndView mv= new ModelAndView("page");
	
	mv.addObject("userClickManageProducts",true);
	mv.addObject("title","Manage Products");
	
	
	Product nProduct = new Product();
	nProduct.setSupplierId(1); //new additions should have an id of one the rest auto-increment
	nProduct.setActive(true);
	mv.addObject("product",nProduct);
	
	if(operation!=null) {
		if(operation.equals("product")) {
			mv.addObject("message","Product Submitted Successfully!");
		}
	}
	
	return mv;
}




//handling product submission
@PostMapping(value="/products")
public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model) {
	
	
	//check if there are any errors
	if(results.hasErrors()) {
		model.addAttribute("userClickManageProducts",true);
		model.addAttribute("title","Manage Products");
		model.addAttribute("message","Validation failed for Product submission");
		return "page";
	}
	Logger.info(mProduct.toString());
	
	//create a new product record
	productDAO.add(mProduct);
	
	return "redirect:/manage/products?operation=product";
}




//returning Categories for all the request mapping
@ModelAttribute("categories")
public List<Category> getCategories(){
	
	return categoryDAO.list();
}


}
