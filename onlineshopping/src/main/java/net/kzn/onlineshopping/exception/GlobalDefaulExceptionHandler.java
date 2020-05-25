package net.kzn.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaulExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("errorTitle","Product not available");
		
		mv.addObject("errorDescription","The product you are looking for is not available right now");
		
		mv.addObject("title","Product unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("errorTitle","Contact Your Administrator!");
		
		
		//Only for debugging your application
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", ex.toString());
		
		mv.addObject("title","Error");
		
		return mv;
	}
}
