package hcmk.com.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hcmk.com.hibernate.entity.Supply;

public class SupplyDAO {

	public SupplyDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@SuppressWarnings("unchecked")
	public static Supply getSupplyById(long id)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Supply.class)
				.buildSessionFactory();
		List<Supply> sup;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			sup = session.createQuery("from supply where supplyId="+id).getResultList();
			
		} finally {
			session.close();

		}
		return sup.get(0);
	}

}
