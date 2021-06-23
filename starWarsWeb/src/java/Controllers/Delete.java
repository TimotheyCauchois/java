/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static Controllers.StarWars.print;

/**
 *
 * @author timot
 */
public class Delete {
    public Delete () {
        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "test";
            String login = "root";
            String motdepasse = "";
            String strUrl = "jdbc:mysql://localhost:3306/" + "test";

            Class.forName(strClassName);
            
            
            Scanner sc = new Scanner(System.in);
            print("table :");
            String table = sc.nextLine();
            print("id du film :");
            String id = sc.nextLine();
            sc.close();
            
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stDeleteFilm = conn.createStatement();
            stDeleteFilm.executeUpdate("Delete from " + table + " where id="+id);

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
