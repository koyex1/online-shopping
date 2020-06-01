package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.util.FileUploadUtility;
import net.kzn.onlineshopping.validator.ProductValidator;
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
public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
		HttpServletRequest request) {
	
	new ProductValidator().validate(mProduct, results);
	
	
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
	
	
	if(!mProduct.getFile().getOriginalFilename().equals("")) {
		FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
	}
	
	
	return "redirect:/manage/products?operation=product";
}


@PostMapping(value="/product/{id}/activation")
@ResponseBody
public String handleProductActivation(@PathVariable int id) {
	//is going to fetch the product from the database
	Product product = productDAO.get(id);
	
	boolean isActive = product.isActive();
	//activating and deactivating based on the value of active field
	product.setActive(!product.isActive());
	//updating the product
	productDAO.update(product);
	
	return (isActive) ? "You have successfully deactivated the product wwith id " + product.getId()
	:"You have successfully activated the product with id" + product.getId();
}



//returning Categories for all the request mapping
@ModelAttribute("categories")
public List<Category> getCategories(){
	
	return categoryDAO.list();
}


}
