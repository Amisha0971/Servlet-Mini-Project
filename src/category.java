

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



import Model.Category;
import Model.CategoryDao;
import Model.UserDao;


@WebServlet("/category")
public class category extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String Name=request.getParameter("name");
	    String Image=request.getParameter("image");
	    String Description=request.getParameter("description");
	    Category c=new Category (Name, Image, Description);
		int d=0;
		try {
			d=new CategoryDao().category(c);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(d>0)
		  {
			 response.sendRedirect("CategoryServ");
		  }
		  else
		  {
			  out.print("Internal Error");
			  request.getRequestDispatcher("Categories.html").include(request, response);
		  }
		}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
