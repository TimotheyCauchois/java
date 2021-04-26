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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timot
 */
public class DAOFilm {

    private String dbName = "test";
    private String login = "root";
    private String motdepasse = "";
    private String strUrl = "jdbc:mysql://localhost:3306/" + "test";
    private String strClassName = "com.mysql.jdbc.Driver";
    private Connection conn;

    public DAOFilm() throws SQLException {
        try {
            Class.forName(strClassName);
            this.conn = DriverManager.getConnection(this.strUrl, this.login, this.motdepasse);
            Statement statement = conn.createStatement();

        } catch (ClassNotFoundException e) {
            System.err.println("Driver non charg� !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        this.conn.close();
    }

}
