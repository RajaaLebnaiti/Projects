package gestion_stagiares_ocp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnexionDB {
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection= DriverManager.getConnection("jdbc:mysql://localhost/gestionstagiareocp", "root", "");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Connection Failed!!");
			
		}
		return connection;
	}

}
