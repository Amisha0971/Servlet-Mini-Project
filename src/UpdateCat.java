

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Model.CategoryDao;
import Model.UserDao;

@WebServlet("/update_cat")
public class UpdateCat extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    int Id=Integer.parseInt(request.getParameter("id"));
	    String Name=request.getParameter("name");
	    String Image=request.getParameter("image");
	    String Description=request.getParameter("description");
	    Category c=new Category(Id, Name,Image, Description);
	    int a=0;
	    try {
			a= new CategoryDao().updateCategory(c);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(a>0)
	    {
	    	out.print("Sucessfully Updated");
	    	response.sendRedirect("CategoryServ");
	    }
	    else
		 {
			 out.print("Error!");
			 request.getRequestDispatcher("CategoryServ").include(request, response);
		 }

	     
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
