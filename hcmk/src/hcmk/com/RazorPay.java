package hcmk.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import hcmk.com.hibernate.DAO.AddressDAO;
import hcmk.com.hibernate.DAO.CartDAO;
import hcmk.com.hibernate.DAO.CartDetailDAO;
import hcmk.com.hibernate.DAO.OrderDetailDAO;
import hcmk.com.hibernate.DAO.OrdersDAO;
import hcmk.com.hibernate.DAO.UsersDAO;
import hcmk.com.hibernate.entity.Address;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.CartDetail;
import hcmk.com.hibernate.entity.OrderDetail;
import hcmk.com.hibernate.entity.Orders;
import hcmk.com.hibernate.entity.Users;

@WebServlet("/RazorPay")
public class RazorPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RazorPay() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status="";
		String payid=request.getParameter("RzorPayID");
		String razorpayid=request.getParameter("RzorPayID");
		try {
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GhX8AcBTmCX9Qd", "Mxs3mAVyIY09aVpWLMU8PDmy");
		
		
		Order order =razorpayClient.Orders.fetch(razorpayid);
		status =order.get("status").toString();
		//payid=order.get("payment_Id").toString();
		System.out.println(order.get("status").toString());
		}catch( RazorpayException e)
		{
			e.printStackTrace();
		}
		if(status.equals("paid"));
		{
			
			long address=Long.parseLong(request.getParameter("address"));
			long cartId=Long.parseLong(request.getParameter("mycartId"));
			String buyer=request.getParameter("user");
			String amount=request.getParameter("paymentAmount");
			Cart c=CartDAO.getCartByUser(buyer, false);
			System.out.println("cartid->"+cartId+"\nuser->"+buyer+"\nprice->"+amount);
			List<CartDetail> items= CartDetailDAO.getCartDetail(c);
			Address add=AddressDAO.getAddressbyId(address);
			Users buyerobj=UsersDAO.getUserByUserName(buyer);
			Orders orderId=OrdersDAO.createOrder(amount, add, buyerobj, payid, razorpayid);
			System.out.println(orderId.getOrderId());
			List<OrderDetail> orderdetails=OrderDetailDAO.createOrderDetailList(items, orderId);
			for(OrderDetail order:orderdetails)
			{
				System.out.println(order.getOrderDetailId());
			}
			CartDetailDAO.deleteCartDetailByCartId(c);
			CartDAO.resetTotalPriceAfterOrder(c,"0.0");
			request.getSession().setAttribute("message","order Placed");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
	}

}
