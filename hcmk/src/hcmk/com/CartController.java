package hcmk.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hcmk.com.hibernate.DAO.CartDAO;
import hcmk.com.hibernate.DAO.CartDetailDAO;
import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.DAO.UsersDAO;
import hcmk.com.hibernate.entity.Cart;
import hcmk.com.hibernate.entity.CartDetail;
import hcmk.com.hibernate.entity.Product;
import hcmk.com.hibernate.entity.Users;

@WebServlet("/CartAdd")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartController() {
        super();
        
    }
protected CartDetail productUpdateQuantity(Cart myCart,List<Product> pInMyCart,long pid, HttpServletResponse response,HttpServletRequest request)throws ServletException, IOException {
	//when product is in the list 
	PrintWriter out =response.getWriter();
	String updatedPrice=CartDetailDAO.updateExistingQuantity(myCart, pInMyCart, pid);
	System.out.println("in productUpdateQuantit");
	out.print("<script>showToast('Product Quantity increased')</script>");
	CartDAO.updateTotalPrice(myCart, updatedPrice);
	request.getSession().setAttribute("message","New product Added to cart");
	getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		String user=request.getParameter("user");
		
		Cart mycart=CartDAO.getCartByUser(user, false);
		if(mycart==null)
		{
			Users me=UsersDAO.getUserByUserName(user);
			mycart=CartDAO.createCart(me);
		}
		long productToAdd=Long.parseLong(request.getParameter("productId"));
		Product productId=ProductDAO.getProductById((int )productToAdd);
		List<Product> pInMyCart=CartDetailDAO.getProductByUser(mycart.getCartId());
		boolean flag=false;
		if(pInMyCart!=null)
		{ 
			for(Product p:pInMyCart)
			{
				if(p.getProductId()==productToAdd)
				{
					productUpdateQuantity(mycart,pInMyCart,productToAdd,response,request);
					flag=true;
				}
			}
			if(!flag)
			{//when product is not in cartdetail
				int quantity=1;
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
				CartDAO.updateTotalPrice(mycart, totalPrice);
				System.out.println("added to cart");
				try {
					Thread.sleep((long) 200);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				out.print("<script>showToast('New Product Added')</script>");
				request.getSession().setAttribute("message","New product Added to cart");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}
		else//when cart is empty
		{
			int quantity=1;
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
			CartDAO.updateTotalPrice(mycart, totalPrice);
			System.out.println("added to cart");
			try {
				Thread.sleep((long) 200);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			out.print("<script>showToast('New Product Added')</script>");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		
	}
}
