package hcmk.com;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.AdminDAO;
import hcmk.com.hibernate.entity.Admin;



@WebServlet("/Admin")
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdminValidation() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/adminlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Admin admin=new Admin();
		admin.setUserNameAdmin(request.getParameter("aun"));
		admin.setContact(request.getParameter("acd"));
		admin.setFirstName(request.getParameter("afn"));
		admin.setLastName(request.getParameter("aln"));
		admin.setPassword(request.getParameter("apass"));
		AdminDAO.addAdmin(admin);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}
}
