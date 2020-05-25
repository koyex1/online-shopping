package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("Description for Television");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Successully added a category inside the table!",true,
	 * 
	 * 
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully fetched a single category in the table",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * 
	 * category= categoryDAO.get(33);
	 * assertEquals("Successfully deleted a single category in the table", true,
	 * categoryDAO.delete(category)); }
	 * 
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully deleted a single category in the table",2
	 * ,categoryDAO.list().size()); }
	 */
	
	@Test
	public void testCRUDCategory() {
		/*category type*/ category = new Category();
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT_1.png");
		/* categories.add(category) */assertEquals("Something wet wrong adding a category inside the table!",true,categoryDAO.add(category));
		
		/*category type*/ category = new Category();
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT_1.png");
		/* categories.add(category) */ assertEquals("Something went wrong in adding a category inside the table!",true,categoryDAO.add(category));
		
		//fetching and updating the category
		 
		
		/*category type*/ category = categoryDAO.get(2);
		 category.setName("TV");
		 assertEquals("something went wrong in fetching a single category in the table",true,categoryDAO.update(category));
		
		
		//delete the Category
		 assertEquals("Something went wrong deleting a single category ini the table", true,categoryDAO.delete(category)); 
		 
		
		//list the Category
		 assertEquals("Something went wrong in listing the category in the table",2,categoryDAO.list().size());
	}

}
