

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Locale.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.CategoryDao;
import Model.ProductsDao;
import Model.products;




@MultipartConfig
@WebServlet("/up_Img")
public class UploadImage extends HttpServlet {
	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Part file=request.getPart("image");
		String imageFileName=getSubmittedFileName(file);
		String uploadPath="E:/JAVA PROJECT/online mobile shopping projects /webContent/image/"+imageFileName;
		System.out.println("hello i am post"+imageFileName);
		
	    FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		try{
		byte[]data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	 products p=null;
			int x;
			try {
				x = new ProductsDao().product(p);
				
				if(x>0)
					System.out.println("Image Name Inserted");
				else
					System.out.println("Image Name Not Inserted");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		
	    response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<img src='"+uploadPath+"' alt='Uploaded Image'>");
	}
   
	
	private static String getSubmittedFileName(Part file) {
		for(String cd:file.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String fileName=cd.substring(cd.indexOf('=')+1).trim().replace("\""," ");
				return fileName.substring(fileName.lastIndexOf('/')+1).substring(fileName.lastIndexOf('\\')+1);
			}
			
		}
		return null;
	}

}
