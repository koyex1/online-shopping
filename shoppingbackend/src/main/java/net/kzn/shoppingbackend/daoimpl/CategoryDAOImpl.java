/*THERE TWO WAYS THE ID FOR GET(ID) IS FETCHED EITHER BY SPECIFYING THE ID WHICH IS A CONSTANT OR LOOPING THROUGH A LIST WHICH USUALLY 
 * HAPPENS ON THE HREF/JSP PAGE
 * 
 * 
 *THE DUDE IS THE ONLY DUDE THAT INTERACTS WITH THE DATABASE AND NO ONE ELSE 
 *HE BASICALLY IS THE DOORWAY TO THE DATABASE-- THE ORM 
 *
 *THE JSP IS ACCESSING VALUES THROUGH THE PRIVATE VARIABLES .name .id .description, WHICH DIDNT THINK COULD BE POSSIBLE
 *SO ORDER: DATABASE-> DAOImpl(ORM) LIST method-> foreach/jsp/href links  with variables defined by the 
 *PageController -> DAOImp ->PageController(in no particular order)-> jsp/href link
 *
 */
/*
 *THE DUDE IS THE ONLY DUDE THAT INTERACTS WITH THE DATABASE AND NO ONE ELSE 
 *HE BASICALLY IS THE DOORWAY TO THE DATABASE-- THE ORM 
 */

package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*static {
	 * 	private static List<Category> categories = new ArrayList<>();

		Category category = new Category();
		
	//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//adding second category
				category = new Category();
				category.setId(2);
				category.setName("Mobile");
				category.setDescription("Description for Mobile");
				category.setImageURL("CAT_2.png");
				
				categories.add(category);
				
				//adding third category
				category = new Category();
				category.setId(1);
				category.setName("Laptop");
				category.setDescription("Description for Laptop");
				category.setImageURL("CAT_3.png");
				
				categories.add(category);
				
				
	}*/

	@Override
	public List<Category> list() {
		//a custom sql to pick out all the active rows in the list..so clearly no need for biased get(ID) function
		String selectActiveCategory="FROM Category WHERE active=:active"; 
		//the createQuery method takes in the custom sql code.
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		//set  :active parameter
		query.setParameter("active", true);
				
		return query.getResultList();
	}

	/*
	 * Getting single category(row of data) based on ***ID****
	 */
	@Override
	public Category get(int id) {// this is a CategoryDAO method
		//IN THE PRIMITIVE GET (ID) METHOD THERE WAS A LOOP OF THE CATEGORIES(STATIC VALUES)/DATATABLE (IN THE CASE OF THE NEW GET (ID) METHOD)
		//THAT LOOPED UNTIL GET ID()==ID
		
		//NOW THE REAL PROBLEM IS WHERE DO WE FIND THIS ID THATS FED INTO THE PARENTHESES? FROM THE HREF PAGE THAT USES A
		//FOR EACH LOOP TO LOOP THROUGH THE LIST CATEGORIES(STATIC VALUES)/DATATABLE (IN THE CASE OF THE NEW GET (ID) METHOD)
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));//the get is a sessionFactory method not a CategoryDAO method
	
	}

	/*
	 * Adding a single category(row of data) automatically with ID 1.. so no need specifying
	 */
	@Override
	public boolean add(Category category) {
		try {
			//add the category to the database using sessionfactory
			sessionFactory.getCurrentSession().persist(category);//persist is a sessionfactory method
			return true;
		}
		catch(Exception ex) {
			//if it fails to add print and error
			//and return false for it failing
			ex.printStackTrace();
			return false;
		}
		
	}
	
	/*
	 * update A single category 
	 */

	@Override
	public boolean update(Category category) {
		try {
			//update the category to the database using sessionfactory
			sessionFactory.getCurrentSession().update(category);//sessionFactory method
			return true;
		}
		catch(Exception ex) {
			//if it fails to update print and error
			//and return false for it failing
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		
		try {
			//update the category to the database using sessionfactory
			sessionFactory.getCurrentSession().update(category); //sessionFactory method
			return true;
		}
		catch(Exception ex) {
			//if it fails to update print and error
			//and return false for it failing
			ex.printStackTrace();
			return false;
		}
	}

}
