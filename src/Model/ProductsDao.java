package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {
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
    public int product(products p) throws SQLException, ClassNotFoundException
    {
  	 String sql="insert into products(Name,Price,Image,Description)values(?,?,?,?)";
  	 con=getconnect();
  	 PreparedStatement ps=con.prepareStatement(sql);
     ps.setString(1,p.getName());
  	 ps.setString (2,p.getPrice());
  	 ps.setString(3,p.getImage());
  	 ps.setString(4,p.getDescription());
  	 int q=ps.executeUpdate();
  	 return q;
   }
    
    public List<products> getAllProducts() throws ClassNotFoundException, SQLException
    {
  	 List<products>lp=new ArrayList<>();
  	 String sql="Select * from products";
    	 con=getconnect();
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ResultSet rs=ps.executeQuery();
    	 while(rs.next())
    	 {
    	   products p=new products(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));	
    	    lp.add(p);
    	 }
    	 return lp;
    }
   
    public int deleteproduct(int id) throws ClassNotFoundException, SQLException 
    {
   	String sql="delete from products where Id=?";
   	con=getconnect();
   	PreparedStatement ps=con.prepareStatement(sql);
   	ps.setInt(1,id);
   	int c=ps.executeUpdate();
   	con.close();
   	return c;
    }
    
    
    public products getProducts (int id) throws ClassNotFoundException, SQLException
    {
  	  String sql="select * from products where Id=?";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setInt(1,id);
  	  ResultSet rs=ps.executeQuery();
      rs.next();
  	  products p=new products(rs.getInt(1), rs.getString(2), rs.getString (3), rs.getString(5));
  	  return p;
    }
    public int UpdateProduct(products p) throws SQLException, ClassNotFoundException
    {
  	  String sql="update products set Name=?,Price=?, Description=? where Id=?;";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setString(1,p.getName());
  	  ps.setString(2,p.getPrice());;
      ps.setString(3, p.getDescription());
  	  ps.setInt(4,p.getId());
  	  int a=ps.executeUpdate();
  	  con.close();
  	  return a;  
    }
    public products addcart (int id) throws ClassNotFoundException, SQLException
    {
  	  String sql="select * from products where Id=?";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setInt(1,id);
  	  ResultSet rs=ps.executeQuery();
      rs.next();
  	  products p=new products(rs.getInt(1),rs.getString(2), rs.getString (3),rs.getString(5));
  	  return p;
    }
    public products viewcart (int id) throws ClassNotFoundException, SQLException
    {
  	  String sql="select * from products where Id=?";
  	  con=getconnect();
  	  PreparedStatement ps=con.prepareStatement(sql);
  	  ps.setInt(1,id);
  	  ResultSet rs=ps.executeQuery();
      rs.next();
  	  products p=new products(rs.getInt(1), rs.getString(2), rs.getString (3), rs.getString(4),rs.getString(5));
  	  return p;
    }
}
