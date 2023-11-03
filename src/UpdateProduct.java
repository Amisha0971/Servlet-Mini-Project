

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProductsDao;
import Model.UserDao;
import Model.products;

@WebServlet("/up_Product")
public class UpdateProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      int Id=Integer.parseInt(request.getParameter("id"));
	      
	      products p= null;
	      try {
			p=new ProductsDao().getProducts(Id);
			
			 out.print("<form action='update_pro'>");
			 out.print("<input type='text' name='id' value='"+p.getId()+"' readonly>");
			 out.print("<input type='text' placeholder='Enter Name' name='name' value='"+p.getName()+"' required>");
			 out.print("<input type='text' placeholder='Enter Price' name='price' value='"+p.getPrice()+"' required>");
			 out.print("<input type='text' placeholder='Enter Description' name='description' value='"+p.getDescription()+"' required>");
			 out.print("<button type=type='submit'>Save</button>");
			 out.print("</form>");
			    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
