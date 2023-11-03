package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
	String url="jdbc:mysql://localhost:3306/mobileshop";
    String name="root";
    String pass="abc@12345";
    String driver="com.mysql.cj.jdbc.Driver";
    
    Connection con;
    private Connection getconnect() throws ClassNotFoundException, SQLException{
    Class.forName(driver);
    Connection con=DriverManager.getConnection(url, name, pass);
    return con;
    }
    
    public int category(Category c) throws ClassNotFoundException, SQLException
    {
  	 String q="insert into category(Name,Image,Description)values(?,?,?)";
  	   con=getconnect();
  	   PreparedStatement ps=con.prepareStatement(q);
  	   ps.setString(1,c.getName());
  	   ps.setString(2,c.getImage());
  	   ps.setString(3,c.getDescription());
  	   int d=ps.executeUpdate();
  	   return d;
    }
    public List<Category> getAllCategory() throws ClassNotFoundException, SQLException
    {
   	 List<Category > la=new ArrayList<>();
        String sql="Select * from category";
     	  con=getconnect();
     	  PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
      	  Category c=new Category (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
      	  la.add(c);
       }
        return la;
    }
    
    public int deleteCategory (int id) throws ClassNotFoundException, SQLException 
    {
   	 String sql="delete from category where Id=?";
   	 con=getconnect();
   	 PreparedStatement ps=con.prepareStatement(sql);
     ps.setInt(1,id);
     int b=ps.executeUpdate();
     con.close();
     return b;
   	
    }
    public Category getCategory (int Id) throws ClassNotFoundException, SQLException
    {
  	  String sql="select * from category where Id=?";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setInt(1,Id);
  	  ResultSet rs=ps.executeQuery();
  	  rs.next();
  	  Category  c=new Category (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
  	  return c;
  	  
    }
    public int updateCategory(Category  c) throws ClassNotFoundException, SQLException
    {
  	  String sql="update category set Name=?,Description=? where Id=?;";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setString(1,c.getName());
  	  ps.setString(2, c.getDescription());
  	  ps.setInt(3,c.getId());
  	  int a=ps.executeUpdate();
  	  con.close();
  	  return a;
    }
}
