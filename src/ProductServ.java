

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProductsDao;
import Model.UserDao;
import Model.products;

@WebServlet("/ProductServ")
public class ProductServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	       PrintWriter out=response.getWriter();
	       out.print("<a href='welcome.html'>Back</a>");
	       String Id=request.getParameter("id");
	       String Name=request.getParameter("name");
	       String Price=request.getParameter("price");
	       String Image= request.getParameter("image");
	       String Description=request.getParameter("description");
	       out.print("<style>body{background-color:lightgray}</style>"); 
		   out.print("<center><h1><u><i>***Products***</i></u></h1></center>");
		   out.print("<html><center><h3><u><a href='product.html'> Add More Products</a></u></h3></center></html>");
  
		   List<products>lp=null;
		   try {
			lp=new ProductsDao().getAllProducts();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   out.print("<html><center><style>table,tr,th,td{ border:1px solid black;}</style><body><table style='width:40%'>");
		   out.print("<table>");
		   out.print("<tr>");
		   out.print("<th> Id </th>");
		   out.print("<th> Name </th>");
		   out.print("<th> Price </th>");
		   out.print("<th>Image </th>");
		   out.print("<th> Description </th>");
		   out.print("<th> Action </th>");
		   out.print("</tr>");
		   for(products p:lp)
		  {
			out.print("<tr>");
			out.print("<td>"+ p.getId() +"</td>");
			out.print("<td>"+ p.getName() +"</td>");
			out.print("<td>"+ p.getPrice() +"</td>");
			out.print("<td><img src='./image/"+ p.getImage() +"'width='200'height='200'></td>");
			out.print("<td>"+ p.getDescription() +"</td>");
			out.print("<td><a href='up_Product?id="+p.getId()+"'><b>Edit</b></a> || <a href='del_Product?id="+p.getId()+"'><b>Delete</b></a></td>");
			out.print("</tr>");
		 }
		   out.print("</table></body></center></html>");
		   
			 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
