package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {

	Category get (int id);
	List<Category> list(); //Not going to collect list of the entire database, thus a value limits this list.
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
