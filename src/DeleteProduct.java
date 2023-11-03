

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


@WebServlet("/del_Product")
public class DeleteProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     int Id=Integer.parseInt(request.getParameter("id"));
	     
	     try {
			int c=new ProductsDao().deleteproduct(Id);
			
			if(c>0)
			{
			    out.print("Sucessfully deleted");
				response.sendRedirect("ProductServ");
			}
			 else
			 {
				 out.print("Error!");
				 request.getRequestDispatcher("ProductServ").include(request, response);
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
