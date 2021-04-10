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
	
	
}
