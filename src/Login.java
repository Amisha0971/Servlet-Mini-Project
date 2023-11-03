

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Model.UserDao;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String Email=request.getParameter("email");
		String Pass=request.getParameter("psw");
		
		User u= new User(Email,Pass);
		
		
		boolean a=false;
		try {
			a= new UserDao().CheckUser(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a)
        {
           
  	       response.sendRedirect("welcome.html");
        }
		else
		{
			out.print("Something Went Wrong!");
		 request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
		
	}

	

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
