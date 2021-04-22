package starWars;

public class Acteur {
	
	public String nom;
	public String prenom;
	
	public Acteur() {}
	/**
	 * 
	 * @param nom Nom de l'acteur
	 * @param prenom Prénom de l'acteur
	 */
	public Acteur(String nom, String prenom) 
	{
		this.nom = nom;
		this.prenom = prenom;
	}

	public void setNom(String nom){	this.nom = nom;	}
	public void setPrenom(String prenom){this.prenom = prenom;}	
	public String getNom(){return nom;}
	public String getPrenom(){return prenom;}
	
	public String toString()	
	{
		return "Classe : " + this.getClass().getName() +"\nNom : " + this.nom +"\nPrénom : " + this.prenom;
	}
	
}

