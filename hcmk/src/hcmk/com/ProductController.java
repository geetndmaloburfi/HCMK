package hcmk.com;
import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.entity.*;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int  productid=Integer.parseInt(request.getParameter("p"));
		Product product=ProductDAO.getProductById(productid);
		//System.out.println("product.productId"+product.getProductId());
		request.setAttribute("product", product);
		request.setAttribute("productid", productid);
		getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
	}

	
	
}
