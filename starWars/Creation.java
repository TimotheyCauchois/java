package starWars;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import starWars.Film;

public class Creation {
	public static void main(String[] args) throws ParseException
	{
		Personnage perso1= new Personnage("Julien","Brigitte");
		Personnage perso2= new Personnage("Julien2","Brigitte2");
		Personnage perso3= new Personnage("Julien3","Brigitte3");
		Personnage perso4= new Personnage("Julien4","Brigitte4");
		
		ArrayList<Personnage> personnages = new ArrayList(1) ;
		ArrayList<Personnage> personnages1 = new ArrayList(1) ;
		ArrayList<Personnage> personnages2 = new ArrayList(1) ;
		personnages1.add(perso1);
		personnages1.add(perso2);
		personnages2.add(perso3);
		personnages2.add(perso4);
		
		Acteur acteur1 = new Acteur("acteur1","acteur1",personnages1);
		Acteur acteur2 = new Acteur("acteur2","acteur2",personnages2);
		Acteur acteur3 = new Acteur("george","acteur3",personnages);
		Acteur acteur4 = new Acteur("arthur4","acteur4",personnages);
		
		
		ArrayList<Acteur> acteurs = new ArrayList() ;
		acteurs.add(acteur1);
		acteurs.add(acteur2);
		
		ArrayList<Acteur> acteurs2 = new ArrayList() ;
		acteurs2.add(acteur3);
		acteurs2.add(acteur4);
		
		ArrayList<Film> films = new ArrayList() ;
		Film film1 = new Film("Jumanji", "1995", 1, 3000000, 30000000,acteurs);
		Film film2 = new Film("Jumanji", "2017", 1, 30000, 200,acteurs2);
		
//		Scanner sc = new Scanner(System.in);
//		
//		print("Titre du film :");
//		String titre = sc.nextLine();
//		
//		print("Année de sortie :");
//		String anneeDeSortie = sc.nextLine();
//		
//		print("Numéro de l'épisode :");
//		int numEp = sc.nextInt();
//		
//		print("Coûts de production :");
//		float cout = sc.nextFloat();
//		
//		print("Recette :");
//		float recette = sc.nextFloat();
//		
//		sc.close();
		
		Film film3 = new Film("Jumanji: Next Level", "2019", 2, 5000000, 50000000,acteurs2);
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
	public static void filmsToString(ArrayList<Film> films){
		for(int i=0; i<films.size() ; i++ )
		{
			print(films.get(i).toString() +"\n");
		}
	}	
	
	/**
	 * print
	 * @param text
	 */
	public static void print(String text)
	{
		System.out.println(text);
	}
	
	public static void triActeurs(Film f)	
	{
		ArrayList<String> result = new ArrayList<String>();
		for (int i=0 ;i< f.nbActeurs();i++) {
			result.add(f.acteurs.get(i).toString());
		}
		Collections.sort(result);
		for(String acteur :result) {
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
