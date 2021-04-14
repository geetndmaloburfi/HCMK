package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.CartDetailDAO;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.CartDetail;

@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCart() {
        super();
     
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long cartDetailId=Long.parseLong(request.getParameter("cartdetailid"));
		System.out.println(cartDetailId);
		Object[] obj=CartDetailDAO.getCartDetailById(cartDetailId);
		CartDetail cartitem=(CartDetail)obj[0];
		Cart mycart= (Cart)obj[1];
		String reducePrice=CartDetailDAO.deleteCartDetailById(cartitem.getCartDetailId());
		System.out.println(reducePrice);
		request.getSession().setAttribute("message","Product Deleted from cart");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
