package Model;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

public class UserDao {
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
    
  public int insert(User u) throws ClassNotFoundException, SQLException
  {
	  String sql="insert into user_table(Name,Email,City,Pass) values(?,?,?,?)";
      con=getconnect();
	  PreparedStatement ps=con.prepareStatement(sql);
	  ps.setString(1,u.getName());
	  ps.setString(2, u.getEmail());
	  ps.setString(3, u.getCity());
	  ps.setString(4, u.getPass());
	  int a=ps.executeUpdate();
	  return a;
	}
   public boolean CheckUser(User u) throws ClassNotFoundException, SQLException
   {
 	String sql="Select * from user_table where Email=? and Pass=?";
 	con=getconnect();
 	PreparedStatement ps=con.prepareStatement(sql);
 	ps.setString(1,u.getEmail());
 	ps.setString(2,u.getPass());
 	ResultSet rs=ps.executeQuery();
 	return rs.next();
    }
  }