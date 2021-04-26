package starWars;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Film {
	public String titre;
	public String anneeDeSortie;
	public int numEpisode;
	public double cout;
	public double recette;	
	public ArrayList<Acteur> acteurs;

	
	public Film() {}
		/**
		 * @param titre Titre du film
		 * @param anneeDeSortie Année de diffusion
		 * @param numEpisode Numéro de l'épisode
		 * @param cout Coûts de production
		 * @param recette Recette
		 */
	public Film(String titre, String anneeDeSortie, int numEpisode, double cout, double recette, ArrayList<Acteur> acteurs)
	{
		this.titre = titre;
		this.anneeDeSortie = anneeDeSortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
		this.acteurs = acteurs;
	}
	
	public ArrayList<Acteur> getActeurs() {	return acteurs;}
	public String getTitre(){return titre;}
	public String getAnneeDeSortie(){return anneeDeSortie;}
	public int getNumEpisode(){return numEpisode;}
	public double getRecette(){return recette;}	
	public double getCout(){return cout;}

	public void setActeurs(ArrayList<Acteur> acteurs) {this.acteurs = acteurs;}
	public void setTitre(String titre){this.titre = titre;}	
	public void setAnneeDeSortie(String anneeDeSortie){this.anneeDeSortie = anneeDeSortie;}
	public void setNumEpisode(int numEpisode){this.numEpisode = numEpisode;}
	public void setCout(float cout){this.cout = cout;}
	public void setRecette(float recette){this.recette = recette;}
	
	public String toString()
	{
		return "Classe : " + this.getClass().getName() +"\nTitre : " + this.titre +	"\nAnnée de sortie : " + this.anneeDeSortie +
				"\nNuméro d'épisode : " + this.numEpisode +	"\nCoût : " + this.cout +"\nRecette :" + this.recette + "\nActeurs :" + this.acteurs ;
	}	
	
	public int nbActeurs()	
	{
		return acteurs.size();
	}
	
	public static ArrayList calculBenefice(Film f)	
	{
		ArrayList result = new ArrayList(1);
		if(f.recette - f.cout > 0) {
			result.add(true);
			result.add(f.recette - f.cout);
		}
		else{
			result.add(false);
			result.add(f.recette - f.cout);
		}
		return result;
	}
	
	public boolean isBefore(String dateInserted)
		throws ParseException{
		DateFormat format = new SimpleDateFormat("YYYY", Locale.FRANCE);
	    Date anneeDeSortieToDate = format.parse(this.anneeDeSortie);
	    Date dateInsertedToDate = format.parse(dateInserted);
	    return anneeDeSortieToDate.compareTo(dateInsertedToDate) < 0;
	}
	
	
	
}
