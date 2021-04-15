package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/Dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int working=Integer.parseInt(request.getParameter("getlink"));
		if(working==1)
		{
			getServletContext().getRequestDispatcher("/userorders.jsp").forward(request, response);
		}
		else if(working==2)
		{
			//List<Product> products = ProductDAO.getAllProducts();
			getServletContext().getRequestDispatcher("/usercartinfo.jsp").forward(request, response);
		}
		else if(working==3)
		{
			getServletContext().getRequestDispatcher("/viewaddress.jsp").forward(request, response);
		}else if(working==0)
		{
			getServletContext().getRequestDispatcher("/userdashboard.jsp").forward(request, response);
		}
		else if(working==4)
		{
			getServletContext().getRequestDispatcher("/addnewaddress.jsp").forward(request, response);
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
