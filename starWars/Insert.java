package starWars;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {	
	public static void main(String[] args) {
		
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "test"; 
			String login= "root"; 
			String motdepasse= "XXXX"; 
			String strUrl = "jdbc:mysql://localhost:3307/" +  "test";

			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			Statement stAddUser = conn.createStatement();  
			stAddUser.executeUpdate("insert into Acces values (5,'Tom','tomahawk','indien','Etudiant',22)");

			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}

			
			
	}
}


