package hcmk.com.hibernate.DAO;
import java.util.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.*;
public class  CartDAO {

	public CartDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public static Cart getCartByUser(String username,boolean paid) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<Cart> Cart;
		
		try {
			session.beginTransaction();
			Cart=session.createQuery("from cart where userName='"+username+"' and placed="+paid).getResultList();
			
		} finally {
			session.close();
			factory.close();
		}
		if(Cart.size()==1)
			return Cart.get(0);
		else
			return null;	
	}
	public static Cart createCart(Users user) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Cart mycart=new Cart();
		mycart.setGrandTotal("0.0");
		mycart.setUserName(user);
		mycart.setPlaced(false);
		mycart.setCartDetailId(new ArrayList<CartDetail>());
		try {
			session.beginTransaction();
			session.save(mycart);
			session.getTransaction().commit();
			System.out.println("row added");
		} finally {
			session.close();
			factory.close();
		}
		return getCartByUser(user.getUserName(),false);
	}
	public static String updateTotalPrice(Cart myCart,String value)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Cart s=null;
		String gt;
		double up=Double.parseDouble(value);
		Session session =factory.getCurrentSession();
		try {
				session.beginTransaction();
				s=session.get(Cart.class, myCart.getCartId());
				gt=s.getGrandTotal();
				double existingValue=Double.parseDouble(gt);
				up+=existingValue;
				s.setGrandTotal(up+"");
				session.saveOrUpdate(s);
				session.getTransaction().commit();				
			}finally {
				session.close();
				factory.close();
			}
		return up+"";
		
	}
	public static List<CartDetail> getCartDetail(Cart id) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		 List<CartDetail> items;
		Cart s;
		try {
			session.beginTransaction();
			s=session.get(Cart.class, id.getCartId());
			items=s.getCartDetailId();
			session.saveOrUpdate(s);
			session.getTransaction().commit();		
		} finally {
			session.close();
			factory.close();
		}
		return items;
	}
	

//	
//	public static List<Object[]> GetAllProductinCart(Cart mycart)
//	{
//		SessionFactory factory=new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Cart.class).addAnnotatedClass(CartDetail.class).addAnnotatedClass(Product.class)
//				.buildSessionFactory();
//		List<Object[]> productsList=new ArrayList<Object[]>();
//		Session session =factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//		    SQLQuery query=session.createSQLQuery("");
//		}finally {
//			session.close();
//			factory.close();
//		}
//		
//		return productsList;
//	}
//	
	public static void updateTotalPriceAfterDelete(Cart myCart,String value)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Cart s=null;
		String gt;
		double up=Double.parseDouble(value);
		Session session =factory.getCurrentSession();
		try {
				session.beginTransaction();
				s=session.get(Cart.class, myCart.getCartId());
				gt=s.getGrandTotal();
				double existingValue=Double.parseDouble(gt);
				existingValue=existingValue-up;
				s.setGrandTotal(existingValue+"");
				session.saveOrUpdate(s);
				session.getTransaction().commit();				
			}finally {
				session.close();
				factory.close();
			}
		
		
	}
	public static void resetTotalPriceAfterOrder(Cart myCart,String value)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
		Cart s=null;
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			s=session.get(Cart.class, myCart.getCartId());
			s.setGrandTotal(value);
			session.saveOrUpdate(s);
			session.getTransaction().commit();		
		}finally {
		session.close();
		factory.close();
		}
		
	}
		
	
}
