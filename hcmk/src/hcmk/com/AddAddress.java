package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.AddressDAO;
import hcmk.com.hibernate.DAO.UsersDAO;

import hcmk.com.hibernate.entity.Users;

@WebServlet("/AddAddress")
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddAddress() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String street =request.getParameter("street");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String pincode=request.getParameter("pincode");
		String pno=request.getParameter("pno");
		String adhar=request.getParameter("adhar");
		String user=request.getParameter("user");
		Users username=UsersDAO.getUserByUserName(user);
		AddressDAO.addAddress(adhar, street, city, country, pno, pincode, username);
		try {
			Thread.sleep((long) 200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/viewaddress.jsp").forward(request, response);
	}

}
