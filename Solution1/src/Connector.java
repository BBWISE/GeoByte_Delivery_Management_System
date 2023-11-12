import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
	
	//Connecting to a local database
	public static Connection localConnector() {
		Connection con = null;
		try  {
			return con =DriverManager.getConnection("jdbc:mysql://localhost:3306/geobyte_delivery_management_system?serverTimezone=UTC","root", "B.blessing2");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex);
		}
		return con;
		
	}
	
}
