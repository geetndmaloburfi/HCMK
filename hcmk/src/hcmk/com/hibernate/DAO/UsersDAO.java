package hcmk.com.hibernate.DAO;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.*;
public class UsersDAO {

	public UsersDAO() {
		// TODO Auto-generated constructor stub
	}
	public static void addUsersDetails(Users user) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
			try {
				session.beginTransaction();
				session.save(user);
				session.getTransaction().commit();
				System.out.println("row added");
			} finally {
				session.close();
				factory.close();
			}	
	}
	@SuppressWarnings("unchecked")
	public static Users getUser(String username,String password) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<Users> Users;
		
		try {
			session.beginTransaction();
			Users=session.createQuery("from users where userName='"+username+"' and password='"+password+"'").getResultList();
			for(Users temp:Users)
			{
				System.out.println(temp);
			}
		} finally {
			session.close();
		}
		if(Users.size()==1)
			return Users.get(0);
		else
			return null;	
	}
	@SuppressWarnings("unchecked")
	public static List<Users> getAllUser() 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<Users> Users;
		
		try {
			session.beginTransaction();
			Users=session.createQuery("from users").getResultList();
			for(Users temp:Users)
			{
				System.out.println(temp);
			}
		} finally {
			session.close();
		}
		return Users;
	}
	
}
