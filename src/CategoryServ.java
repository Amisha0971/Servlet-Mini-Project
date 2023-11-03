import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Model.CategoryDao;
import Model.UserDao;

@WebServlet("/CategoryServ")
public class CategoryServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<a href='welcome.html'>Back</a>");
        String Id = request.getParameter("id");
        String Name = request.getParameter("name");
        String Image = request.getParameter("image");
        String Description = request.getParameter("description");
        
        out.print("<style>body{background-color:lightgray}</style>"); 
        out.print("<center><h1><u><i>***Categories***</i></u></h1></center>");
        out.print("<html><center><h3><u><a href='Categories.html'> Add More Categories</a></u></h3></center></html>");
        List<Category> la = null;
        try {
            la = new CategoryDao().getAllCategory();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        out.print("<html><center><style>table,tr,th,td{ border:1px solid black; text-align: center;}</style><body><table style='width:40%'>");
        out.print("<table>");
        out.print("<tr>");
        out.print("<th> Id </th>");
        out.print("<th> Name </th>");
        out.print("<th> Image </th>");
        out.print("<th> Description </th>");
        out.print("<th> Action </th>");
        out.print("</tr>");
        for (Category c : la) {
            out.print("<tr>");
            out.print("<td>" + c.getId() + "</td>");
            out.print("<td>" + c.getName() + "</td>");
            out.print("<td><img src='./image/" + c.getImage() + "' width='200' height='200'></td>");
            out.print("<td>" + c.getDescription() + "</td>");
            out.print("<td><a href='Up_category?id=" + c.getId() + "'><b>Edit</b></a> || <a href='Del_category?id=" + c.getId() + "'><b>Delete</b></a></td>");
            out.print("</tr>");
        }
        out.print("</table></body></center></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
