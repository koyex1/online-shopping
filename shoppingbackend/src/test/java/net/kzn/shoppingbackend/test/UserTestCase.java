package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	/*
	 * @Test public void testAdd() { user = new User();
	 * user.setFirstName("olumide"); user.setLastName("Roshan");
	 * user.setEmail("hr@gmail.com"); user.setContactNumber("1234512345");
	 * user.setRole("USER"); user.setPassword("123456"); //add the user
	 * assertEquals("Failed to add user!",true, userDAO.addUser(user));
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("10B Jadoo Society, krish");
	 * address.setAddressLineTwo("Near Kaabil Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("40001"); address.setBilling(true);
	 * 
	 * //link the user with the address using user id
	 * address.setUserId(user.getId());
	 * 
	 * //add the address assertEquals("Failed to add address", true,
	 * userDAO.addAddress(address));
	 * 
	 * if(user.getRole().equals("USER")) { //create a cart for this user cart = new
	 * Cart(); cart.setUser(user);
	 * 
	 * //add the cart assertEquals("Failed to add cart", true,
	 * userDAO.addCart(cart));
	 * 
	 * //add a shipping address for this user
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("10B Jadoo Society, krish");
	 * address.setAddressLineTwo("Near Kaabil Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("40001"); //Set shipping to true
	 * address.setShipping(true);
	 * 
	 * //link it with the user address.setUserId(user.getId());
	 * 
	 * //add the shipping address
	 * assertEquals("Failed to add shipping address!",true,
	 * userDAO.addAddress(address)); } }
	 */
	
	
	//----------------------------------
	
	  @Test public void testAdd() { user = new User();
	  user.setFirstName("olumide"); user.setLastName("Roshan");
	  user.setEmail("hr@gmail.com"); user.setContactNumber("1234512345");
	  user.setRole("USER"); user.setPassword("123456");
	  
	  
	  
	  if(user.getRole().equals("USER")) {
	//create a cart for this user 
		cart = new Cart(); 
	  
		cart.setUser(user);
	  
	  //Attach cart with the user 
		user.setCart(cart);
	  
	  
	  } //add the user 
	  assertEquals("Failed to add user!",true,
	  userDAO.addUser(user));
	  
	  }
	 
	
	//------------------------------------------
	
//	@Test
//	public void testUpdateCart() {
//		//fetch the user by its email
//		user = userDAO.getByEmail("hr@gmail.com");
//	
//		//get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		
//		cart.setCartLines(2);
//		
//		assertEquals("Failed to Update cart", true, userDAO.updateCart(cart));
//		
//		
//		
//	}
	
}
