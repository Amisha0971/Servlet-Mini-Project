

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


@WebServlet("/Up_category")
public class UpdateCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      int Id=Integer.parseInt(request.getParameter("id"));
	      
	      Category c=null;
		    try {
				c= new CategoryDao().getCategory(Id);
				
				out.print("<form action='update_cat'>");
			    out.print("<input type='text' name='id' value='"+c.getId()+"' readonly>");
			    out.print("<input type='text' placeholder='Enter Name' name='name' value='"+c.getName()+"' required>");
			    out.print("<input type='text' placeholder='Enter Description' name='description' value='"+c.getDescription()+"' required>");
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
