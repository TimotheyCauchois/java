package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static starwars.StarWars.print;

public class Insert {

    public static void main(String[] args) {
        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "test";
            String login = "root";
            String motdepasse = "";
            String strUrl = "jdbc:mysql://localhost:3306/" + "test";

            Class.forName(strClassName);

            Scanner sc = new Scanner(System.in);

            print("Titre du film :");
            String titre = sc.nextLine();

            print("Ann�e de sortie :");
            String anneeDeSortie = sc.nextLine();

            print("Num�ro de l'�pisode :");
            int numEp = sc.nextInt();

            print("Co�ts de production :");
            float cout = sc.nextFloat();

            print("Recette :");
            float recette = sc.nextFloat();

            sc.close();
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddFilm = conn.createStatement();

            stAddFilm.executeUpdate("insert into films(titre,anneeDeSortie,numEpisode,cout,recette) values (" + "\"" + titre +"\"" + "," + "\""+ anneeDeSortie +"\"" +","+ "\""+ numEp +"\""+","+ cout +","+ recette +")");
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
