package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestResultSetMethod {

	  public static void main(String arg[]) {
		  Connection con = null;
		  try {
			  con = DatabaseConnection.getConnection();
			 
			  String sql = "select id,price,name from product";
			  
			  PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);
			  
			  ResultSet rs = ps.executeQuery();
			 
			  //rs.next();
			  rs.absolute(-7);
			  //rs.relative();
			  System.out.println(rs.getInt(1)+"\t"+rs.getString(3));
			  
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
