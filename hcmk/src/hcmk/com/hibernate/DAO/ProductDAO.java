package hcmk.com.hibernate.DAO;

import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
			
		} finally {
			session.close();
			factory.close();

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
			
			
		} finally {
			session.close();
			factory.close();
		
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
			
			
		} finally {
			session.close();
			factory.close();
		
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
			factory.close();

		}
		return products.get(0);
	}
	@SuppressWarnings("unchecked")
	public static List<Product> getAllProducts() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		List<Product> products;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			products = session.createQuery("from product").getResultList();
			
		} finally {
			session.close();
			factory.close();

		}
		return products;
	}
	public static void updateProduct(Product demo,long current) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			Transaction tr=session.beginTransaction();
			Product p=(Product)session.load(Product.class ,current);
			Date dNow = new Date( );
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("MM/dd/yyyy");
			p.setBestseller(demo.getBestseller());
			p.setProductName(demo.getProductName());
			p.setMakingCharge(demo.getMakingCharge());
			p.setPrice(demo.getPrice());
			p.setMetal(demo.getMetal());
			p.setQuantity(demo.getQuantity());
			p.setPurity(demo.getPurity());
			p.setSummary(demo.getSummary());
			p.setmDate(ft.format(dNow));
			tr.commit();
			
			//System.out.println(product);
		} finally {
			session.close();
			factory.close();

		}
		return ;
	}
	public static void addProduct(Product product)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.save(product);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();

		}
	}

}
