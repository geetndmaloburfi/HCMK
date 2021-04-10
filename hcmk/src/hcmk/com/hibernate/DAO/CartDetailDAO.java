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
	
	
}
