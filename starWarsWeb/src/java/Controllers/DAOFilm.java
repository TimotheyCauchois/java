/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.StarWars.print;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import Models.Film;
import java.util.Collection;

public class DAOFilm {
    
    //-Attributs de base
    private String bddName = "test";
    private String bddLogin = "root";
    private String bddPassword = "";
    private String bddIP = "localhost";
    private String bddPort = "3306";
    private String bddUrl = "jdbc:mysql://"+this.bddIP+":"+this.bddPort+"/"+this.bddName;
    
    //-Attributs du driver JDBC
    private final String strClassName = "com.mysql.jdbc.Driver";
    private Statement statement;
    private Connection conn;
    
    /**
     * Constructor
     * 
     * DAOFilm()
     */
    public DAOFilm(){
        try {
            Class.forName(this.strClassName);
            this.conn = DriverManager.getConnection(this.bddUrl, this.bddLogin, this.bddPassword);
            this.statement = (Statement) conn.createStatement();
            print("=> DAOFilm ready");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
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
     * listReadingArrayList()
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM films");
            ArrayList<Film> resultDatas = new ArrayList();
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
     * Requète de lecture des films dans une base de donnée
     * 
     * listReadingListTableModel()
     * @return TableModel
     * @throws java.sql.SQLException
     */
    public TableModel listReadingListTableModel() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM films");
            ArrayList<Film> resultDatas = new ArrayList();
            TableModel result;
                while (datas.next()) {
                    Film newFilm = new Film(datas.getInt(1), datas.getString(2), datas.getString(3), 
                            datas.getInt(4), datas.getDouble(5), datas.getDouble(6) );
                    resultDatas.add(newFilm);
                }
                conn.close();
                result = (TableModel) resultDatas;
                print("->Sélection des datas OK");
                return result;
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
            String sql = "INSERT INTO "+tableBDD+" (`titre`, `anneeDeSortie`, `numEpisode`, `cout`, `recette`) VALUES ";
            String sqlElements = "("
                            +"\""+film.getTitre()+"\""+","
                            +"\""+film.getAnneeDeSortie()+"\""+","
                            +film.getNumEpisode()+","
                            +film.getCout()+","
                            +film.getRecette()
                            +")";
            sql += sqlElements;
            print(sql);
            this.statement.executeQuery(sql);
            print("->Insertion des datas dans la ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète d'ajout d'un film dans une base de donnée
     * 
     * addFilm(Film film)
     * @param film
     * @return String
     * @throws java.sql.SQLException
     */
    public String addFilm(Film film) throws SQLException{
        String result = "Ajout du film non effectué.";
        try{          
            String sql = "INSERT INTO films(`titre`, `anneeDeSortie`, `numEpisode`, `cout`, `recette`) VALUES ( "
                    +"\""+film.getTitre()+"\","
                    +"\""+film.getAnneeDeSortie()+"\","
                    +""+film.getNumEpisode()+","
                    +""+film.getCout()+","
                    +""+film.getRecette()+")";
            print(sql);
            this.statement.executeQuery(sql);
            print("->Insertion des datas dans films OK");
            result = "Ajout du film réussi.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Requète d'ajout d'un film dans une base de donnée
     * 
     * updateFilm(Film film)
     * @param film
     * @return String
     * @throws java.sql.SQLException
     */
    public String updateFilm(Film film) throws SQLException{
        String result = "Mise à jour du film non effectué.";
        try{
            String sql = "UPDATE `films` SET "
                    +"`id`="+film.getId()+","
                    +"`titre`=\""+film.getTitre()+"\","
                    +"`anneeDeSortie`=\""+film.getAnneeDeSortie()+"\","
                    +"`numEpisode`="+film.getNumEpisode()+","
                    +"`cout`="+film.getCout()+","
                    +"`recette`="+film.getRecette()+""
                    +" WHERE id="+film.getId()+"";
            print(sql);
            statement.executeUpdate(sql);
            print("->Update des datas dans la [Films] OK");
            result = "Mise à jour du film réussi.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Requète de suppression d'un film dans une base de donnée
     * 
     * deleteFilm(String table, int datasId)
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
     * deleteFilm(String table, Film film)
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
    
    /**
     * Requète de suppression d'un film dans une base de donnée
     * 
     * datasDelete(int datasId)
     * @param datasId
     * @throws java.sql.SQLException
     */
    public String deleteFilm(int datasId) throws SQLException{
        String result = "Suppression du film non effectué.";
        try{
            String sql = "DELETE FROM films WHERE id="+datasId+";";
            print(sql);
            statement.executeUpdate(sql);
            print("->Suppression de la ligne "+datasId+" dans la table [films] OK");
            result = "Suppression du film réussi.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Fermeture de la connexion JDBC
     * 
     * close()
     * @throws java.sql.SQLException
     */
    public void close() throws SQLException{
        this.conn.close();
        print("[La connexion à été fermée]");
    }
    
    // The methods of basic getter below.
    public String getBddName() {  return bddName;  }
    public String getBddLogin() { return bddLogin; }
    public String getBddPassword() { return bddPassword; }
    public String getBddIP() { return bddIP; }
    public String getBddPort() { return bddPort; }
    public String getBddUrl() { return bddUrl; }
    
    // The methods of basic setter below.
    public void setBddName(String bddName) { this.bddName = bddName; }
    public void setBddLogin(String bddLogin) { this.bddLogin = bddLogin; }
    public void setBddPassword(String bddPassword) { this.bddPassword = bddPassword; }
    public void setBddIP(String bddIP) { this.bddIP = bddIP; }
    public void setBddPort(String bddPort) { this.bddPort = bddPort; }
    public void setBddUrl(String bddUrl) {  this.bddUrl = bddUrl; }

    Collection listReadingArrayList(String select__from_films) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}