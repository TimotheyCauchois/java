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
import Models.Avis;


public class DAOAvis {
    
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
     * DAOAvis()
     */
    public DAOAvis(){
        try {
            Class.forName(this.strClassName);
            this.conn = DriverManager.getConnection(this.bddUrl, this.bddLogin, this.bddPassword);
            this.statement = (Statement) conn.createStatement();
            print("=> DAOAvis ready");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de lecture des avis dans une base de donnée
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
                print("Avis :"
                        +"\n- id du avis : "+datas.getInt(1)
                        +"\n- titre du avis : "+datas.getString(2)
                        +"\n- description : "+datas.getString(3)
                        );
            }
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de lecture des Avis dans une base de donnée
     * 
     * listReadingArrayList()
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM avis");
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    Avis newAvis = new Avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
     * Requète de lecture des Avis d'un film dans une base de donnée
     * 
     * listReadingArrayList()
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList(int idFilm) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM films_acces_avis WHERE films_id="+idFilm+"");
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    Avis newAvis = new Avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
     * Requète de lecture des avis dans une base de donnée
     * 
     * listReadingListTableModel()
     * @return TableModel
     * @throws java.sql.SQLException
     */
    public TableModel listReadingListTableModel() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM avis");
            ArrayList<Avis> resultDatas = new ArrayList();
            TableModel result;
                while (datas.next()) {
                    Avis newAvis = new Avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(Avis avis)
     * @param avis
     * @return String
     * @throws java.sql.SQLException
     */
    public String addAvis(Avis avis) throws SQLException{
        String result = "Ajout de l'avis non effectué.";
        try{
            String sql = "INSERT INTO `avis` (`titre`, `title`, `description`, `note_avis`) VALUES ";
            String sqlElements = "("
                            +"\""+avis.getTitre()+"\""+","
                            +"\""+avis.getDescription()+"\""+","
                            +avis.getNoteAvis()
                            +")";
            sql += sqlElements;
            print(sql);
            statement.executeUpdate(sql);
            print("->Insertion des datas dans la [avis] OK");
            result = "Ajout de l'avis effectué.";
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(String tableBDD, Avis avis)
     * @param tableBDD
     * @param avis
     * @throws java.sql.SQLException
     */
    public void addAvis(String tableBDD, Avis avis) throws SQLException{
        try{
            String sql = "INSERT INTO "+tableBDD+" (`titre`, `title`, `description`, `note_avis`) VALUES ";
            String sqlElements = "("
                            +"\""+avis.getTitre()+"\""+","
                            +"\""+avis.getDescription()+"\""+","
                            +avis.getNoteAvis()
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
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(Avis avis)
     * @param avis
     * @throws java.sql.SQLException
     */
    public int getAvisID(Avis avis) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT `id`, `title` FROM `avis` WHERE `title` LIKE \"%"+avis.getTitre()+"%\"");
            int resultData = 0;
                while (datas.next()) {
                    resultData = Integer.parseInt(datas.getString(2));
                }
                conn.close();
                print("->Sélection des datas OK");
                return resultData;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Requète de suppression d'un avis dans une base de donnée
     * 
     * deleteAvis(String table, int datasId)
     * @param tableBDD
     * @param datasId
     * @throws java.sql.SQLException
     */
    public void deleteAvis(String tableBDD, int datasId) throws SQLException{
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
     * Requète de suppression d'un avis dans une base de donnée
     * 
     * deleteAvis(String table, int datasId)
     * @param tableBDD
     * @param avis
     * @throws java.sql.SQLException
     */
    public void deleteAvis(String tableBDD, Avis avis) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+avis.getId()+";";
            print(sql);
            statement.executeUpdate(sql);
            print("->Suppression de la ligne "+avis.getId()+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
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
    
}