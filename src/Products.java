

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


@WebServlet("/products")
public class Products extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String Name=request.getParameter("name");
	    String Price=request.getParameter("price");
	    String Image=request.getParameter("image");
	    String Description=request.getParameter("description");
	    products p=new products(Name, Price, Image, Description);
	    int q=0;
	    try {
			q=new ProductsDao().product(p);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if(q>0)
	    {
	    	response.sendRedirect("ProductServ");
	    }
	    else
	    {
	    	out.print("Internal Error");
			  request.getRequestDispatcher("product.html").include(request, response);
	    }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
