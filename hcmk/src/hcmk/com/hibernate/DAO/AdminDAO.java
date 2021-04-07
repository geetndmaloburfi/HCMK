package hcmk.com.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.Admin;

public class AdminDAO {	
	public AdminDAO() {
		
	}

	@SuppressWarnings("unchecked")
	public static Admin getAdmin(String username,String password) 
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<Admin> admin;
		
		try {
			session.beginTransaction();
			admin=session.createQuery("from admin where userNameAdmin='"+username+"' and password='"+password+"'").getResultList();
			for(Admin temp:admin)
			{
				System.out.println(temp);
			}
		} finally {
			session.close();
		}
		if(admin.size()==1)
			return admin.get(0);
		else
			return null;	
	}

}
