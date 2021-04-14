package hcmk.com.hibernate.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.Address;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.Orders;
import hcmk.com.hibernate.entity.Users;

public class OrdersDAO {

	public OrdersDAO() {
		
	}
	public static Orders createOrder(String grandTotal,Address add,Users buyer,String Payid,String razorpayid)
	{
		long id;
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Orders.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		Orders order=new Orders();
		Date dNow = new Date( );
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("MM/dd/yyyy");
	    order.setOrderDate(ft.format(dNow));
		order.setAddressId(add);
		order.setGrandTotal(grandTotal);
		order.setGrandTotal(grandTotal);
		order.setUserName(buyer);
	    order.setSubTotal(grandTotal);
	    order.setTotalTax("0.0");
	    order.setPaymentId(Payid);
	    order.setRazorOrderId(razorpayid);
	    order.setStatus("paid");
		try {
			session.beginTransaction();
			session.save(order);
			id=order.getOrderId();
		} finally {
			session.close();
			factory.close();
		}
		return order;
	}

}
