package p1;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestResultSetType {
  public static void main(String arg[]) {
	  Connection con = null;
	  try {
		  con = DatabaseConnection.getConnection();
		  String sql = "select id,price,name from product order by price asc";
		  
		  //PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY);
		  PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
		  ResultSet rs = ps.executeQuery();
		  System.out.println("Product list in ascending order...");
		  while(rs.next()) {
			  int id = rs.getInt(1);
			  String name = rs.getString(3);
			  float price =rs.getFloat(2);
			  
			  System.out.println(id+"\t"+price+"\t"+name);
		  }
		  System.out.println("Product list in descentding order....");
		  while(rs.previous()) {
			  int id = rs.getInt(1);
			  String name = rs.getString(3);
			  float price =rs.getFloat(2);
		      System.out.println(id+"\t"+price+"\t"+name);
		    
		  }
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  finally {
		try {
			con.close();
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
	}
  }
}

