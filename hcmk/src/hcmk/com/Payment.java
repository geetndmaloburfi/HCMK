package hcmk.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Payment() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("	Started");
		long CartId = Long.parseLong(request.getParameter("mycartId"));
		long address = Long.parseLong(request.getParameter("address"));
		String amount = request.getParameter("paymentAmount");
		String buyer = request.getParameter("user");
		System.out.println(CartId + " " + amount + "  " + buyer + " " + address);

		RazorpayClient razorpayClient = null;
		Order order=null;
		JSONObject options = null;
		try {
			razorpayClient = new RazorpayClient("rzp_test_GhX8AcBTmCX9Qd", "Mxs3mAVyIY09aVpWLMU8PDmy");
			options= new JSONObject();
			options.put("amount", Double.parseDouble(amount)*100);
			options.put("currency", "INR");
			options.put("receipt", "txn_123456");
			//create order
			order = razorpayClient.Orders.create(options);
			System.out.println(order.get("id").toString());
		} catch (RazorpayException e) {

			e.printStackTrace();
		}
		request.setAttribute("payNow","pay");
		request.setAttribute("amount",Double.parseDouble(amount)*100);
		request.setAttribute("cartid", CartId);
		request.setAttribute("razorpayOrderId", order.get("id").toString());
		request.setAttribute("address",address);
		getServletContext().getRequestDispatcher("/checkout.jsp").forward(request, response);
		
		
		
	}

}
