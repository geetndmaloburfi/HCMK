package hcmk.com;

import java.util.*;
import hcmk.com.hibernate.entity.*;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.ProductDAO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/Category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId =Integer.parseInt(request.getParameter("category")) ;
		if(categoryId>0)
		{
		List<Product> products=ProductDAO.getCategoryList(categoryId);
		request.setAttribute("products",products);
		switch (categoryId) {
		case 1:
			request.setAttribute("catname", "Chains");
			break;
		case 2:
			request.setAttribute("catname", "Pendent Sets");
			break;
		case 3:
			request.setAttribute("catname", "Earrings");
			break;
		case 4:
			request.setAttribute("catname","Finger Rings");
			break;
		case 5:
			request.setAttribute("catname","Mangalsutra");
			break;
		case 6:
			request.setAttribute("catname","Neckwear");
			break;
		case 7:
			request.setAttribute("catname","Nose Pin");
			break;
		case 8:
			request.setAttribute("catname","Bangles");
			break;
		default:
			break;
		}
	
		getServletContext().getRequestDispatcher("/category.jsp").forward(request, response);
		}
		else {
			List<Product> products=ProductDAO.getCategoryList(categoryId);
			request.setAttribute("products",products);
			switch (categoryId) {
			case -1:
				request.setAttribute("catname", "Gold Jewellery");
				break;
			case -2:
				request.setAttribute("catname", "Diamond Jewellery");
				break;
			case -3:
				request.setAttribute("catname", "Platinum Jewellery");
				break;
			default:
				break;
			}
			getServletContext().getRequestDispatcher("/category.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
