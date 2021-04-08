package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.entity.Product;

@WebServlet("/UpdateProduct")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.getParameter("userName")*/
		Product demoproduct= new Product();
		long idnum=Long.parseLong(request.getParameter("idnum"));
		demoproduct.setSummary(request.getParameter("psummary"));
		demoproduct.setProductName(request.getParameter("pname"));
		demoproduct.setTitle(request.getParameter("ptitle"));
		demoproduct.setMakingCharge(request.getParameter("pmc"));
		demoproduct.setMetal(request.getParameter("pmetal"));
		demoproduct.setPrice(request.getParameter("pprice"));
		demoproduct.setPurity(Integer.parseInt(request.getParameter("ppurity")));
		demoproduct.setQuantity(Integer.parseInt(request.getParameter("pquantity")));
		demoproduct.setBestseller(Boolean.parseBoolean(request.getParameter("pbestseller")));
		ProductDAO.updateProduct(demoproduct,idnum);
		
		getServletContext().getRequestDispatcher("/adminpages/showproducts.jsp").forward(request, response);
		
		
		}
	}


