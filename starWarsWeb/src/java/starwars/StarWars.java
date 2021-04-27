package starwars;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import starwars.Film;
import starwars.DAOFilm;

/**
 *
 * @author timot
 */
public class StarWars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, SQLException {
        starwars.Personnage perso1 = new starwars.Personnage(1,"Julien", "Brigitte");
        starwars.Personnage perso2 = new starwars.Personnage(2,"Julien2", "Brigitte2");
        starwars.Personnage perso3 = new starwars.Personnage(3,"Julien3", "Brigitte3");
        starwars.Personnage perso4 = new starwars.Personnage(4,"Julien4", "Brigitte4");

        ArrayList<starwars.Personnage> personnages = new ArrayList(1);
        ArrayList<starwars.Personnage> personnages1 = new ArrayList(1);
        ArrayList<starwars.Personnage> personnages2 = new ArrayList(1);
        personnages1.add(perso1);
        personnages1.add(perso2);
        personnages2.add(perso3);
        personnages2.add(perso4);

        starwars.Acteur acteur1 = new starwars.Acteur(1,"acteur1", "acteur1", personnages1);
        starwars.Acteur acteur2 = new starwars.Acteur(2,"acteur2", "acteur2", personnages2);
        starwars.Acteur acteur3 = new starwars.Acteur(3,"george", "acteur3", personnages);
        starwars.Acteur acteur4 = new starwars.Acteur(4,"arthur4", "acteur4", personnages);

        ArrayList<starwars.Acteur> acteurs = new ArrayList();
        acteurs.add(acteur1);
        acteurs.add(acteur2);

        ArrayList<starwars.Acteur> acteurs2 = new ArrayList();
        acteurs2.add(acteur3);
        acteurs2.add(acteur4);

        ArrayList<starwars.Film> films = new ArrayList();
        starwars.Film film1 = new starwars.Film(1,"Jumanji", "1995", 1, 3000000, 30000000, acteurs);
        starwars.Film film2 = new starwars.Film(2,"Jumanji", "2017", 1, 30000, 200, acteurs2);

//		Scanner sc = new Scanner(System.in);
//		
//		print("Titre du film :");
//		String titre = sc.nextLine();
//		
//		print("Ann�e de sortie :");
//		String anneeDeSortie = sc.nextLine();
//		
//		print("Num�ro de l'�pisode :");
//		int numEp = sc.nextInt();
//		
//		print("Co�ts de production :");
//		float cout = sc.nextFloat();
//		
//		print("Recette :");
//		float recette = sc.nextFloat();
//		
//		sc.close();
        starwars.Film film3 = new starwars.Film(3,"Jumanji: Next Level", "2019", 2, 5000000, 50000000, acteurs2);
//		Film film3 = new Film(titre, anneeDeSortie, numEp, cout, recette);
//		print(film1.toString() + "\n");
//		print(film2.toString() + "\n");
//		print(film3.toString() + "\n");
//		print(perso1.toString() + "\n");
        films.add(film3);
        films.add(film2);
//		filmsToString(films);	
//		print(starWars.Film.calculBenefice(film2).toString());

        boolean isBefore = film2.isBefore("2018");
//		print(""+ isBefore);

        triActeurs(film2);
        
        
        
        
        
        
    }

    public static void filmsToString(ArrayList<starwars.Film> films) {
        for (int i = 0; i < films.size(); i++) {
            print(films.get(i).toString() + "\n");
        }
    }

    /**
     * print
     *
     * @param text
     */
    public static void print(String text) {
        System.out.println(text);
    }

    public static void triActeurs(starwars.Film f) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < f.nbActeurs(); i++) {
            result.add(f.acteurs.get(i).toString());
        }
        Collections.sort(result);
        for (String acteur : result) {
            System.out.println(acteur);
        }
    }

    
    
    
    
    
    
//	public static void makeBackUp(HashMap dicof)	
//	{
//		for(Film f : dicof) {
//			print(f);
//		}
//	}
//	
}
