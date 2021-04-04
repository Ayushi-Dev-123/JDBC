package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestInsert {
   public static void main(String arg[]) {
	   Connection con = null;
	   try {
		   con = DatabaseConnection.getConnection();
		   
		   String sql = "insert into product(name,price,brand) values(?,?,?)";
	   
	       PreparedStatement ps = con.prepareStatement(sql);
	       Scanner sc = new Scanner(System.in);
	       
	       System.out.println("Enter product name");
	       String nm = sc.next();
	       
	       System.out.println("Enter price");
	       float price = sc.nextFloat();
	       
	       System.out.println("Enter brand..");
	       String brand =sc.next();
	       
	       ps.setString(1, nm);
	       ps.setFloat(2, price);
	       ps.setString(3, brand);
	       
	       int x = ps.executeUpdate();
	       
	       if(x!=0)
	    	   System.out.println("Record inserted...");
	       else
	    	   System.out.println("Record not inserted...");
	   }
	   catch (Exception e) {
		 e.printStackTrace();
	   }
	   finally {
		 try {
			 con.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	   }
	   
   }
}
