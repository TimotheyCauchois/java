package starWars;

public class Personnage {
	private String nom;
	private String prenom;
	
	/**
	* Constructor
	* Personnage()
	*/
	public Personnage(){}  
	
	/**
	* Constructor
	* Personnage(String nom, String prenom)
	* @param nom
	* @param prenom
	*/
	public Personnage(String nom, String prenom){
		this.nom = nom;
	    this.prenom = prenom;
	}   
	
	public String getNom(){ return this.nom; }
	public String getPrenom(){ return this.prenom; }
	public void setNom(String nom){ this.nom = nom; }
	public void setPrenom(String prenom){ this.prenom = prenom; }  
	
	public String toString(){
		return "Personnage : "+this.nom+" "+this.prenom;
	}
}
