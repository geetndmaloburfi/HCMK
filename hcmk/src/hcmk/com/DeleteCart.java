package hcmk.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCart() {
        super();
     
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("cartid")+"cartid");
		System.out.println(request.getParameter("cartdetailid")+"cartDetailid");
	}

}
