package hcmk.com.hibernate.DAO;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Query;

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
	@SuppressWarnings("unchecked")
	public static CartDetail getIdWithOtherPrimaryKey(long cartId,long productId)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<CartDetail> Cartdetails;
		try {
			session.beginTransaction();
			Cartdetails=session.createQuery("from cartDetail where cartId="+cartId+"and productId="+productId).getResultList();			
		}
		 finally {
			session.close();
			factory.close();
		}
		return Cartdetails.get(0);
	}
	public static String updateExistingQuantity(Cart Mycart,List<Product> pInMyCart,long productToAdd)
	{ 
		CartDetail item=getIdWithOtherPrimaryKey(Mycart.getCartId(),productToAdd);
		Product pid=ProductDAO.getProductById((int)productToAdd);
				SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(CartDetail.class)
						.buildSessionFactory();
				Session session =factory.getCurrentSession();
				int value=0;
				String price="";
				double priceup=0;
				CartDetail s=null;
				try {
					session.beginTransaction();
					s=session.get(CartDetail.class, item.getCartDetailId());
					 value=s.getQuantity()+1;
					 price=s.getTotalPrice();
					 priceup=Double.parseDouble(price)+Double.parseDouble(pid.getPrice())+Double.parseDouble(pid.getMakingCharge());
						
					s.setQuantity(value);
					s.setTotalPrice(priceup+"");
					session.saveOrUpdate(s);
					session.getTransaction().commit();
				} finally {
					session.close();
					factory.close();
				}
			
		
		return (Double.parseDouble(pid.getPrice())+Double.parseDouble(pid.getMakingCharge()))+"";
	}
	@SuppressWarnings("unchecked")
	public static List<CartDetail> getCartDetail(Cart mycart)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<CartDetail> Cartdetails;
		try {
			session.beginTransaction();
			Cartdetails=session.createQuery("from cartDetail where cartId="+mycart.getCartId()).getResultList();			
		}
		 finally {
			session.close();
			factory.close();
		}
		return Cartdetails;
	}
	
	public static Object[] getCartDetailById(long id)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		CartDetail Cartdetail;
		Object[] obj=new Object[2];
		try {
			session.beginTransaction();
			Cartdetail=session.get(CartDetail.class, id);
			Cart cart=Cartdetail.getCartId();
			obj[0]=Cartdetail;
			obj[1]=cart;
			
		}
		 finally {
			session.close();
			factory.close();
		}
		return obj;
	}

	public static String deleteCartDetailById(long id)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		CartDetail Cartdetail;
		String price="";
		Cart cart;
		try {
			session.beginTransaction();
			Cartdetail=session.get(CartDetail.class, id);
			cart=Cartdetail.getCartId();
			price=Cartdetail.getTotalPrice();
			System.out.println(price);
			
		}finally {
			
		}
		session.close();
		factory.close();
		CartDAO.updateTotalPriceAfterDelete(cart, price);
		 factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		session =factory.getCurrentSession();
		try {
			Thread.sleep((long) 200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		List<CartDetail> deleteditem;
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("delete cartDetail where cartDetailId= :id");
			query.setParameter("id",id);
			 
			int result = query.executeUpdate();	
			session.getTransaction().commit();
			System.out.println(result);
		}finally {
			session.close();
			factory.close();
		}
		return price;
	}
	public static void deleteCartDetailByCartId(Cart c)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CartDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("delete cartDetail where cartId="+c.getCartId());
			query.executeUpdate();		
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		return ;
		
	}
}
