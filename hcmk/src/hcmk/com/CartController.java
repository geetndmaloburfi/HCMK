package hcmk.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmk.com.hibernate.DAO.CartDAO;
import hcmk.com.hibernate.DAO.CartDetailDAO;
import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.CartDetail;
import hcmk.com.hibernate.entity.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartAdd")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long product=Long.parseLong(request.getParameter("productId"));
		String user=request.getParameter("user");
		Product productId=ProductDAO.getProductById((int)product);
		Cart mycart = CartDAO.getCartByUser(user, false);
		List<Product> products = CartDetailDAO.getProductByUser(mycart.getCartId());
		boolean flag=false;
		if(products!=null)
		{
		for(Product p : products)
		{
			if(p.equals(productId))
			{
				flag=true;
			}
		}
		}
		if(mycart!=null&&!flag)
		{
			request.getSession().setAttribute("message","item added to cart");
			
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		double price=Double.parseDouble(productId.getPrice())+Double.parseDouble(productId.getMakingCharge());
		String totalPrice=price+"";
		String discount="0.0";
		String tax="0.0";
		CartDetail c=new CartDetail();
		c.setCartId(mycart);
		c.setDiscount(discount);
		c.setQuantity(quantity);
		c.setTotalPrice(totalPrice);
		c.setTax(tax);
		c.setProductId(productId);
		CartDetailDAO.addDetail(c);
		System.out.println("added to cart");
		try {
			Thread.sleep((long) 200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(mycart!=null&&flag)
		{
			int quantity=CartDetailDAO.getProductquantity(mycart.getCartId(), productId);
			int quantityUpdate=Integer.parseInt(request.getParameter("quantity"));
			CartDetail c=CartDetailDAO.getCartDetailAgain(mycart.getCartId(), productId);
			quantity=quantityUpdate+quantity;
			CartDetailDAO.updateDetail(c, quantity);;
		}
		else {
			request.getSession().invalidate();
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(0);
			newSession.setAttribute("message","login first");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
	}

}
