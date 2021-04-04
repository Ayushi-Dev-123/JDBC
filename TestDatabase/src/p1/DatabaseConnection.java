package p1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
   public static Connection con = null;
   public static Connection getConnection() {
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb","root","root");
	        
	   }
	   catch (Exception e) {
		 e.printStackTrace();
	   }
	   return con;
   }
}
