package hcmk.com.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.Address;


public class AddressDAO {

	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public static List<Address> getAddressList(String username) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<Address> address;
		try {
			session.beginTransaction();
			address=session.createQuery("from address where userName='"+username+"'").getResultList();
		} finally {
			session.close();
			factory.close();
		}
		
		return address;
	}
}
