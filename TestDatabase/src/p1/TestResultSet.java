package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestResultSet {
  public static void main(String arg[]) {
	  Connection con = null;
	  try {
		  con = DatabaseConnection.getConnection();
		  String sql = "select * from product";
		  PreparedStatement ps = con.prepareStatement(sql);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			  int id = rs.getInt("id");
			  String name = rs.getString("name");
			  float price =rs.getFloat(3);
			  String brand = rs.getString(4);
			  System.out.println(id+"\t"+name+"\t"+price+"\t"+brand);
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
