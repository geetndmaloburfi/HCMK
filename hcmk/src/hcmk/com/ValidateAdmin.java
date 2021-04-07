package hcmk.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmk.com.hibernate.DAO.AdminDAO;
import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.entity.Admin;
import hcmk.com.hibernate.entity.Product;
import java.util.*;

@WebServlet("/ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateAdmin() {
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
			//List<Product> products = ProductDAO.getAllProducts();
			getServletContext().getRequestDispatcher("/adminpages/showproducts.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		PrintWriter out =response.getWriter();
		Admin admin=AdminDAO.getAdmin(userName, password);
		//request.setAttribute("user", user.getUserName()+"");
		System.out.println("in post");
		if(admin!=null)
		{
			request.getSession().invalidate();
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("username",admin.getUserNameAdmin());
			newSession.setAttribute("Admin","yes");
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		}
		else
			{
			
				   out.println( "<meta http-equiv='refresh' content='3;URL=/hcmk/adminlogin.jsp'>");//redirects after 3 seconds
				   out.println("<h1 style='color:red;text-align:center;margin-top:300px;='>Username or password incorrect!</h1>");
				
			   //getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
	}

	

}
