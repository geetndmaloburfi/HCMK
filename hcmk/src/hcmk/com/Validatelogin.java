package hcmk.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.transform.AliasToEntityMapResultTransformer;

import hcmk.com.hibernate.DAO.UsersDAO;
import hcmk.com.hibernate.entity.Users;

@WebServlet("/User")
public class Validatelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validatelogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		PrintWriter out =response.getWriter();
		Users user=UsersDAO.getUser(userName,password);
		request.setAttribute("user", user);
		System.out.println("in post");
		if(user!=null)
		{
			request.getSession().invalidate();
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("username", user.getFirstName());
			
			getServletContext().getRequestDispatcher("/userSpecPage.jsp").forward(request, response);
		}
		else
			{
			
				   out.println( "<meta http-equiv='refresh' content='3;URL=/hcmk/login.jsp'>");//redirects after 3 seconds
				   out.println("<h1 style='color:red;text-align:center;margin-top:300px;='>Username or password incorrect!</h1>");
				
			   //getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
