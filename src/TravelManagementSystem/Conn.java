package TravelManagementSystem;
import java.sql.*;

public class Conn {
	Connection con;
	Statement stat;
	Conn(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelManagementSystem", "root", "#aditya19");
			stat = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
