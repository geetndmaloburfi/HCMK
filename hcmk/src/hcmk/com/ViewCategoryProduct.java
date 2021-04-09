package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.CategoryDAO;
import hcmk.com.hibernate.entity.Category;

/**
 * Servlet implementation class ViewCategoryProduct
 */
@WebServlet("/ViewCategoryProduct")
public class ViewCategoryProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCategoryProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id=Long.parseLong(request.getParameter("cid"));
		request.setAttribute("cid", id);
		Category cat=CategoryDAO.getCategoryById(id);
		
		request.setAttribute("catName",cat.getCategoryName());
		getServletContext().getRequestDispatcher("/adminpages/showproductbycategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
