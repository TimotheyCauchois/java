package Models;

public class Personnage {

    public int id;
    private String nom;
    private String prenom;

    /**
     * Constructor Personnage()
     */
    public Personnage() {
    }

    /**
     * Constructor Personnage(String nom, String prenom)
     *
     * @param nom
     * @param prenom
     */
    public Personnage(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }
    
    public int getId() {
        return this.id;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String toString() {
        return "Personnage : " + this.nom + " " + this.prenom + " " + this.id ;
    }
}
