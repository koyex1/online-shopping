package net.kzn.shoppingbackend.dao;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public interface UserDAO {

	//add a user
	boolean addUser(User user);
	User getByEmail(String email);
	//add an address
	boolean addAddress(Address address);
	//update a cart
	boolean updateCart(Cart cart);
}
