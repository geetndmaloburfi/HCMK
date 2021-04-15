package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmk.com.hibernate.DAO.AddressDAO;

@WebServlet("/DeleteAddress")
public class DeleteAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteAddress() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long addressid=Long.parseLong(request.getParameter("address"));
		AddressDAO.deleteAddressById(addressid);
		getServletContext().getRequestDispatcher("/viewaddress.jsp").forward(request, response);
		
	}

}
