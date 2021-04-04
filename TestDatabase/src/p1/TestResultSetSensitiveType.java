package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestResultSetSensitiveType {
	public static void main(String arg[]) {
		  Connection con = null;
		  try {
			  con = DatabaseConnection.getConnection();
			 
			  String sql = "select id,price,name from product";
			  
			  PreparedStatement ps = con.prepareStatement(sql,
					  ResultSet.TYPE_SCROLL_SENSITIVE,
					  ResultSet.CONCUR_UPDATABLE);
			  
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()) {
				  int id = rs.getInt("id");
				  if(id == 4) {
					  rs.updateFloat(2, 500);
					  rs.updateRow();
				  }
				  System.out.println(id+"\t"+rs.getFloat("price")+"\t"+rs.getString("name"));
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
