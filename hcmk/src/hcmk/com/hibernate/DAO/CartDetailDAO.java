package hcmk.com.hibernate.DAO;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.*;
public class  CartDetailDAO {

	public CartDetailDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public static List<Product> getProductByUser(long cartid) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<CartDetail> Cartdetails;
		List<Product> myproducts=new ArrayList<Product>();
		
		try {
			session.beginTransaction();
			Cartdetails=session.createQuery("from cartDetail where cartId="+cartid).getResultList();
			for(CartDetail temp:Cartdetails)
			{
				myproducts.add(ProductDAO.getProductById((int)temp.getProductId().getProductId()));
			}
		} finally {
			session.close();
			factory.close();
		}
		if(Cartdetails.size()<=0)
			return null;
		else
			return myproducts;	
	}
	@SuppressWarnings("unchecked")
	public static int getProductquantity(long cartid,Product p) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<CartDetail> Cartdetails;
		List<Product> myproducts=new ArrayList<Product>();
		
		try {
			session.beginTransaction();
			Cartdetails=session.createQuery("from cartDetail where cartId="+cartid).getResultList();
			for(CartDetail temp:Cartdetails)
			{
				myproducts.add(ProductDAO.getProductById((int)temp.getProductId().getProductId()));
			}
		} finally {
			session.close();
			factory.close();
		}
		int quantity=0;
		for(int i=0;i<myproducts.size();i++)
		{
			if(p.equals(myproducts.get(i)))
			{
				quantity=Cartdetails.get(i).getQuantity();
			}
		}
		return quantity;
	}
	@SuppressWarnings("unchecked")
	public static CartDetail getCartDetailAgain(long cartid,Product p) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<CartDetail> Cartdetails;
		List<Product> myproducts=new ArrayList<Product>();
		
		try {
			session.beginTransaction();
			Cartdetails=session.createQuery("from cartDetail where cartId="+cartid).getResultList();
			for(CartDetail temp:Cartdetails)
			{
				myproducts.add(ProductDAO.getProductById((int)temp.getProductId().getProductId()));
			}
		} finally {
			session.close();
			factory.close();
		}
		
		for(int i=0;i<myproducts.size();i++)
		{
			if(p.equals(myproducts.get(i)))
			{
				return Cartdetails.get(i);
			}
		}
		return null;
	}
	public static void addDetail(CartDetail detail) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(detail);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
		
	}
	public static void updateDetail(CartDetail detail,int value) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			CartDetail s=session.get(CartDetail.class, detail.getCartDetailId());
			s.setQuantity(value);
			session.saveOrUpdate(detail);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
		
	}
	
	
}
