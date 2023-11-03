

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

@WebServlet("/update_pro")
public class UpdatePro extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
	       PrintWriter out=response.getWriter();
		   int Id=Integer.parseInt(request.getParameter("id"));
	       String Name=request.getParameter("name");
	       String Price=request.getParameter("price");
	       String Description=request.getParameter("description");
	       
	       products p=new products(Id, Name, Price, Description);
	       int a=0;
	       try {
			a=new ProductsDao().UpdateProduct(p);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       if(a>0)
		    {
		    	out.print("Sucessfully Updated");
		    	response.sendRedirect("ProductServ");
		    }
	       else
			 {
				 out.print("Error!");
				 request.getRequestDispatcher("ProductServ").include(request, response);
			 }
	
	       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
