package hcmk.com.hibernate.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hcmk.com.hibernate.entity.CartDetail;
import hcmk.com.hibernate.entity.OrderDetail;
import hcmk.com.hibernate.entity.Orders;


public class OrderDetailDAO {

	public OrderDetailDAO() {
		
	}
	public static List<OrderDetail> createOrderDetailList(List<CartDetail> lis,Orders orderid)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(OrderDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<OrderDetail> orders=new ArrayList<OrderDetail>();
		for(CartDetail l:lis)
		{
			OrderDetail o=new OrderDetail();
			o.setDiscount(l.getDiscount());
			o.setOrderId(orderid);
			o.setProductId(l.getProductId());
			o.setQuantity(l.getQuantity());
			o.setTax(l.getTax());
			o.setTotalPrice(l.getTotalPrice());
			orders.add(o);
		}
		try {
			session.beginTransaction();
			for(OrderDetail order:orders)
			{
			session.save(order);
			}
			
		} finally {
			session.close();
			factory.close();
		}
		
		
		return orders;
	}
	@SuppressWarnings("unchecked")
	public static List<OrderDetail> getOrderDetailListByOrderId(Long orderid)
	{
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(OrderDetail.class)
				.buildSessionFactory();
		Session session =factory.getCurrentSession();
		List<OrderDetail> details;
		try {
			session.beginTransaction();
			details=session.createQuery("from orderDetail where orderId="+orderid).getResultList();
			
		} finally {
			session.close();
			factory.close();
		}
		return details;
	}
	
}
