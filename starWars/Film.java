package starWars;

public class Film {
	public String titre;
	public String anneeDeSortie;
	public int numEpisode;
	public double cout;
	public double recette;	
	
	public Film() {}
		/**
		 * @param titre Titre du film
		 * @param anneeDeSortie Année de diffusion
		 * @param numEpisode Numéro de l'épisode
		 * @param cout Coûts de production
		 * @param recette Recette
		 */
	public Film(String titre, String anneeDeSortie, int numEpisode, double cout, double recette)
	{
		this.titre = titre;
		this.anneeDeSortie = anneeDeSortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
	}
	public String getTitre(){return titre;}
	public String getAnneeDeSortie(){return anneeDeSortie;}
	public int getNumEpisode(){return numEpisode;}
	public double getRecette(){return recette;}	
	public double getCout(){return cout;}
	public void setTitre(String titre){this.titre = titre;}	
	public void setAnneeDeSortie(String anneeDeSortie){this.anneeDeSortie = anneeDeSortie;}
	public void setNumEpisode(int numEpisode){this.numEpisode = numEpisode;}
	public void setCout(float cout){this.cout = cout;}
	public void setRecette(float recette){this.recette = recette;}
	
	public String toString()
	{
		return "Classe : " + this.getClass().getName() +"\nTitre : " + this.titre +	"\nAnnée de sortie : " + this.anneeDeSortie +
				"\nNuméro d'épisode : " + this.numEpisode +	"\nCoût : " + this.cout +"\nRecette :" + this.recette;
	}	
}
