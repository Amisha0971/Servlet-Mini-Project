

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
import javax.servlet.http.HttpSession;

import Model.UserDao;


@WebServlet("/logoutserv")
public class Logoutserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session=request.getSession(false);  
	    if(session!=null)
	    {  
	      String email=(String)session.getAttribute("email");  
	      out.print("Hello, "+email+" Welcome to Profile");  
	    }  
	   else{  
	    	   out.print("Please login first");  
	    	   request.getRequestDispatcher("login.html").include(request, response);  
            }  
	   out.close();  
	   
	}  
	   	  
	   
	 



	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
