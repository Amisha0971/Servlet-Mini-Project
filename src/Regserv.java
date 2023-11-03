

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.User;
import Model.UserDao;


@WebServlet("/regserv")
public class Regserv extends HttpServlet {
	
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String Name=request.getParameter("name");
	    String Email=request.getParameter("email");
	    String City=request.getParameter("city");
	    String Pass=request.getParameter("psw");
	    User u=new User(Name, Email, City, Pass);
		  int a=0;
		   try {
			a= new UserDao().insert(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(a>0)
		  {
			  out.print("Register Successfully!");
			  request.getRequestDispatcher("login.html").include(request, response);
		  }
		  else
		  {
			  out.print("Internal Error");
			  request.getRequestDispatcher("reg.html").include(request, response);
		  }
		  
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
