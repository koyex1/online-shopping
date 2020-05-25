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
		
		String selectActiveCategory="FROM Category WHERE active=:active";
		
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
				
		return query.getResultList();
	}

	/*
	 * Getting single category based on ID
	 */
	@Override
	public Category get(int id) {
	
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	
	}

	@Override
	public boolean add(Category category) {
		try {
			//add the category to the database using sessionfactory
			sessionFactory.getCurrentSession().persist(category);
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
			sessionFactory.getCurrentSession().update(category);
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
			sessionFactory.getCurrentSession().update(category);
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
