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

import hcmk.com.hibernate.DAO.CartDAO;
import hcmk.com.hibernate.DAO.CartDetailDAO;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.CartDetail;

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
		try {
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_GhX8AcBTmCX9Qd", "Mxs3mAVyIY09aVpWLMU8PDmy");
		
		Order order =razorpayClient.Orders.fetch( request.getParameter("RzorPayID"));
		status =order.get("status").toString();
		System.out.println(order.get("status").toString());
		}catch( RazorpayException e)
		{
			e.printStackTrace();
		}
		if(status.equals("paid"));
		{
			long cartId=Long.parseLong(request.getParameter("mycartId"));
			String buyer=request.getParameter("user");
			String amount=request.getParameter("paymentAmount");
			Cart c=CartDAO.getCartByUser(buyer, false);
			System.out.println("cartid->"+cartId+"\nuser->"+buyer+"\nprice->"+amount);
			List<CartDetail> items= CartDetailDAO.getCartDetail(c);
			
		}
	}

}
