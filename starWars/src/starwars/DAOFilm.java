/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static starwars.StarWars.print;

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
    private Statement statement;
    public DAOFilm() throws SQLException {
        try {
            Class.forName(strClassName);
            this.conn = DriverManager.getConnection(this.strUrl, this.login, this.motdepasse);
            this.statement = conn.createStatement();

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
    
    public void lister(){
        
    } 
    
    /**
     * Requète de lecture des films dans une base de donnée
     * 
     * listReadingConsole(String sqlQuery)
     * @param sqlQuery
     * @throws java.sql.SQLException
     */
    public void listReadingConsole(String sqlQuery) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery(sqlQuery);
            print("->Sélection des datas OK");
            while (datas.next()) {
                print("Film :"
                        +"\n- id du film : "+datas.getInt(1)
                        +"\n- titre du film : "+datas.getString(2)
                        +"\n- année de sortie : "+datas.getString(3)
                        +"\n- numéro de l'épisode du film : "+datas.getInt(4)
                        +"\n- coût du film : "+datas.getDouble(5)
                        +"\n- recette du film : "+datas.getDouble(6)
                        );
            }
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de lecture des films dans une base de donnée
     * 
     * listReadingArrayList(String sqlQuery)
     * @param sqlQuery
     * @return 
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList(String sqlQuery) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery(sqlQuery);
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    Film newFilm = new Film(datas.getInt(1), datas.getString(2), datas.getString(3), 
                            datas.getInt(4), datas.getDouble(5), datas.getDouble(6));
                    resultDatas.add(newFilm);
                }
                conn.close();
                print("->Sélection des datas OK");
                return resultDatas;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Requète d'ajout d'un film dans une base de donnée
     * 
     * addFilm(String tableBDD, Film film)
     * @param tableBDD
     * @param film
     * @throws java.sql.SQLException
     */
    public void addFilm(String tableBDD, Film film) throws SQLException{
        try{
            String sql = "INSERT INTO "+tableBDD+" (`titre`, `anneeDeSortie`, `nimEpisode`, `cout`, `recette`) VALUES ";
            String sqlElements = "("
                            +"\""+film.getTitre()+"\""+","
                            +"\""+film.getAnneeDeSortie()+"\""+","
                            +film.getNumEpisode()+","
                            +film.getCout()+","
                            +film.getRecette()
                            +")";
            sql += sqlElements;
            print(sql);
            statement.executeUpdate(sql);
            print("->Insertion des datas dans la ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de suppression d'un film dans une base de donnée
     * 
     * datasDelete(String table, int datasId)
     * @param tableBDD
     * @param datasId
     * @throws java.sql.SQLException
     */
    public void deleteFilm(String tableBDD, int datasId) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+datasId+";";
            print(sql);
            statement.executeUpdate(sql);
            print("->Suppression de la ligne "+datasId+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de suppression d'un film dans une base de donnée
     * 
     * datasDelete(String table, int datasId)
     * @param tableBDD
     * @param film
     * @throws java.sql.SQLException
     */
    public void deleteFilm(String tableBDD, Film film) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+film.getId()+";";
            print(sql);
            statement.executeUpdate(sql);
            print("->Suppression de la ligne "+film.getId()+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    
    
    // The methods of basic getter below.
    public String getDbName() {  return dbName;  }
    public String getLogin() { return login; }
    public String getMotdepasse() { return motdepasse; }
    public String getStrUrl() { return strUrl; }
    
    // The methods of basic setter below.
    public void setDbName(String dbName) { this.dbName = dbName; }
    public void setLogin(String login) { this.login = login; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }
    public void setStrUrl(String strUrl) { this.strUrl = strUrl; }
        
}
