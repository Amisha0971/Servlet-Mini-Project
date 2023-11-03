

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CategoryDao;
import Model.UserDao;


@WebServlet("/Del_category")
public class DeleteCategory  extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     int Id=Integer.parseInt(request.getParameter("id"));
	     
	     try {
				int b= new CategoryDao().deleteCategory(Id);
			 if(b>0)
				{
				    out.print("Sucessfully deleted");
					response.sendRedirect("CategoryServ");
				}
			 else
			 {
				 out.print("Error!");
				 request.getRequestDispatcher("CategoryServ").include(request, response);
			 }
	
		     } catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
