package hcmk.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

import hcmk.com.hibernate.entity.CartDetail;
import hcmk.com.hibernate.entity.CartProduct;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Geetu")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    List<CartProduct> items=new ArrayList<CartProduct>();
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
				
				String json = "";
				if(br!=null)
				{
					json=br.readLine();
					//System.out.println(json);
				}
				List<CartProduct> res=new Gson().fromJson(json, (Type) new TypeReference<List<CartProduct>>() { });
				System.out.println(res);
				
				
				
			/*	ArrayNode arrayRoot = (ArrayNode) mapper.readTree(json);
				ObjectNode objectRoot = (ObjectNode) mapper.readTree(json);
				Iterator<String> fields = objectRoot.fieldNames();
				String field = "";
				Iterator<JsonNode> elements = arrayRoot.elements();
				JsonNode element;
				
				while(elements.hasNext()){
					element = elements.next();				
					fields = element.fieldNames();
					field = "";
					while(fields.hasNext()){
						field = fields.next();
						System.out.println("field: "+field);
					}*/

				
				
				
				
				
				
				
				
				
				
				
//				int i=0;
//				while(i<json.length())
//				{
//					int start=json.indexOf('{',i);
//					int end=json.indexOf('}',i);
//					String temp=json.substring(start,end+1);
//					ObjectMapper mapper =new ObjectMapper();
//					CartProduct item= mapper.readValue(temp, CartProduct.class);
//					items.add(item);
//					i=end+1;
//				}
//				
//					System.out.println(items.size()); 
				
				
				
	} 
				 

}
