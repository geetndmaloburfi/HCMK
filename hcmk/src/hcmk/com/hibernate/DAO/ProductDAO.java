package hcmk.com.hibernate.DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.*;

public class ProductDAO {

	public ProductDAO() {

	}

	public static void main(
			String agrs[]) {/**
							 * SessionFactory factory=new Configuration() .configure("hibernate.cfg.xml")
							 * .addAnnotatedClass(Product.class) .buildSessionFactory(); Session session
							 * =factory.getCurrentSession(); try { session.beginTransaction(); List<Product>
							 * products= session.createQuery("from product ").getResultList(); for(Product
							 * temp:products) { System.out.println(temp); }
							 * 
							 * } finally { session.close(); factory.close(); }
							 **/
	}

	/**
	 * public void addProductDetails(Product product){ SessionFactory factory=new
	 * Configuration() .configure("hibernate.cfg.xml")
	 * .addAnnotatedClass(Product.class) .buildSessionFactory(); Session session
	 * =factory.getCurrentSession(); try { session.beginTransaction(); List<Product>
	 * products= session.createQuery("from product").getResultList(); for(Product
	 * temp:products) { System.out.println(temp); }
	 * 
	 * } finally { session.close();
	 * 
	 * } }
	 **/
	@SuppressWarnings("unchecked")
	public static List<Product> getBestsellerList() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		List<Product> products;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			products = session.createQuery("from product where bestseller=true").getResultList();
			for (Product temp : products) {
				System.out.println(temp);
			}

		} finally {
			session.close();

		}
		return products;
	}

	@SuppressWarnings("unchecked")
	public static List<Product> getCategoryList(int category){
		SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.buildSessionFactory();
		List<Product> products;
		Session session =factory.getCurrentSession();
		if(category>0) {
		try {
			session.beginTransaction();
			 products= session.createQuery("from product where categoryId="+category).getResultList();
			for(Product temp:products)
			{
				System.out.println(temp);
			}
			
		} finally {
			session.close();
		
		}
		}
		else {
			String metal="";
			if(category==-1)
			{
				metal="Gold";
			}
			else if(category==-2)
			{
				metal="Diamond";
			}
			else if(category==-3)
			{
				metal="Platinum";
			}
			try {
			session.beginTransaction();
			 products= session.createQuery("from product where metal="+"'"+metal+"'").getResultList();
			for(Product temp:products)
			{
				System.out.println(temp);
			}
			
		} finally {
			session.close();
		
		}
		}return products;
		}
	@SuppressWarnings("unchecked")
	public static Product getProductById(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		List<Product> products;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			products =session.createQuery("from product where productId="+id).getResultList();
			//System.out.println(product);
		} finally {
			session.close();

		}
		return products.get(0);
	}

}
