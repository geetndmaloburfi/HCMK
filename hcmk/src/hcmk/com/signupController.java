package hcmk.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmk.com.hibernate.entity.Users;

import hcmk.com.hibernate.DAO.*;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/SignUp")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!request.getParameter("password").equals(request.getParameter("password2")))
		{
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			
			newSession.setAttribute("message","password did not match try again" );	
			
			getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
		}
		else
		{
		Users user= new Users();
		user.setUserName(request.getParameter("userName"));
		
		
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setGender(request.getParameter("gender"));
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setContactDetail(request.getParameter("contactDetail"));
		user.setPassword(request.getParameter("password"));
		UsersDAO.addUsersDetails(user);
		HttpSession newSession=request.getSession(true);
		newSession.setMaxInactiveInterval(300);
		newSession.setAttribute("message","Successfull account created now you can login with your credentail" );	
		
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
