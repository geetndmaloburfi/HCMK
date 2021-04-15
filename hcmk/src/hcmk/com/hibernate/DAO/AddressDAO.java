package hcmk.com.hibernate.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.Address;
import hcmk.com.hibernate.entity.Users;


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
		List<Address> address=null;
		try {
			session.beginTransaction();
			address=session.createQuery("from address where userName='"+username+"'").getResultList();
		} finally {
			session.close();
			factory.close();
		}
		
		return address;
	}
	public static Address getAddressbyId(long id) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Address address;
		try {
			session.beginTransaction();
			address=session.get(Address.class, id);
		} finally {
			session.close();
			factory.close();
		}
		
		return address;
	}
	public static void deleteAddressById(long id)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete address where addressId="+id);
			query.executeUpdate();		
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
	public static void addAddress(String adhar,String street,String city,String country,String pno,String pincode,Users username)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Address a=new Address();

		a.setAdharNo(adhar);
		a.setStreetAddress(street);
		a.setCity(city);
		a.setCountry(country);
		a.setPanNo(pno);
		a.setPincode(pincode);
		a.setUserName(username);
		try {
			session.beginTransaction();
			session.save(a);
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
		
}
