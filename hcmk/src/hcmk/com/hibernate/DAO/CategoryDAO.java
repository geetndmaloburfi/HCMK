package hcmk.com.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.Category;


public class CategoryDAO {
	public CategoryDAO() {}
	@SuppressWarnings("unchecked")
	public static Category getCategoryById(long id)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.buildSessionFactory();
		List<Category> cat;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			cat = session.createQuery("from category where categoryId="+id).getResultList();
			
		} finally {
			session.close();
			factory.close();

		}
		return cat.get(0);
	}
	@SuppressWarnings("unchecked")
	public static List<Category> getAllCategory()
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.buildSessionFactory();
		List<Category> cat;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			cat = session.createQuery("from category ").getResultList();
			
		} finally {
			session.close();
			factory.close();

		}
		return cat;
	}

}
