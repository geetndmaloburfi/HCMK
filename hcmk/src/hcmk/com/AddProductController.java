package hcmk.com;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import hcmk.com.hibernate.DAO.CategoryDAO;
import hcmk.com.hibernate.DAO.ProductDAO;
import hcmk.com.hibernate.DAO.SupplyDAO;
import hcmk.com.hibernate.entity.Category;
import hcmk.com.hibernate.entity.Product;
import hcmk.com.hibernate.entity.Supply;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product newProduct = new Product();
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> image = upload.parseRequest(request);
			for (FileItem i : image)
			{
				if (i.getName() != null)
				{
					String temp = i.getName();
					temp = "images/photoproducthcmk//" + temp;
					System.out.println(i.getName());
					newProduct.setPhotos(temp);

					i.write(new File(
							"C:/eclipse programs/hcmk/hcmk/WebContent/images/photoproducthcmk/" + i.getName()));

				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Date dNow = new Date( );
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("MM/dd/yyyy");
		newProduct.setProductName(request.getParameter("pname"));
		newProduct.setTitle(request.getParameter("ptitle"));
		newProduct.setMetal(request.getParameter("pmetal"));
		newProduct.setPrice(request.getParameter("pprice"));
		newProduct.setPurity(Integer.parseInt(request.getParameter("pname")));
		newProduct.setQuantity(Integer.parseInt(request.getParameter("pquantity")));
		newProduct.setcDate(ft.format(dNow));
		newProduct.setmDate(ft.format(dNow));
		newProduct.setBestseller(Boolean.parseBoolean(request.getParameter("pbestseller")));
		Supply sup=SupplyDAO.getSupplyById(Long.parseLong((request.getParameter("ps"))));
		newProduct.setSupplyId(sup);
		Category cat=CategoryDAO.getCategoryById(Long.parseLong((request.getParameter("pc"))));
		newProduct.setCategoryId(cat);
		newProduct.setSummary(request.getParameter("psummary"));
		ProductDAO.addProduct(newProduct);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

	}

}
