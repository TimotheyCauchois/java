/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author timot
 */
public class Delete {
    public static void main(String[] args) {
        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "test";
            String login = "root";
            String motdepasse = "";
            String strUrl = "jdbc:mysql://localhost:3306/" + "test";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddUser = conn.createStatement();
            stAddUser.executeUpdate("insert into Acces values (5,'Tom','tomahawk','indien','Etudiant',22)");

            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non charg� !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
}
