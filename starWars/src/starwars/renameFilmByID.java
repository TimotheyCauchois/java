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
import java.util.Scanner;
import static starwars.StarWars.print;

/**
 *
 * @author timot
 */
public class renameFilmByID {
    public static void main(String[] args) {
        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "test";
            String login = "root";
            String motdepasse = "";
            String strUrl = "jdbc:mysql://localhost:3306/" + "test";

            Class.forName(strClassName);

            Scanner sc = new Scanner(System.in);

            print("Nouveau titre du film :");
            String titre = sc.nextLine();

            print("ID du film :");
            int id = sc.nextInt();
          
            sc.close();
            
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stRenameFilm = conn.createStatement();

            stRenameFilm.executeUpdate("update films set titre = '"+titre+"' where id="+ id);
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
