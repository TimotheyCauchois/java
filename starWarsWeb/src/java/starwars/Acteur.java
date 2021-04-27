package starwars;

import java.util.ArrayList;

public class Acteur {

    public int id;
    public String nom;
    public String prenom;
    public ArrayList<Personnage> personnages = new ArrayList(1);

    public Acteur() {
    }

    /**
     *
     * @param nom Nom de l'acteur
     * @param prenom Pr�nom de l'acteur
     */
    public Acteur(int id,String nom, String prenom, ArrayList<Personnage> personnages) {
        this.nom = nom;
        this.prenom = prenom;
        this.personnages = personnages;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPersonnages(ArrayList<Personnage> personnages) {
        this.personnages = personnages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "Classe : " + this.getClass().getName() + "\nNom : " + this.nom + "\nPr�nom : " + this.prenom + "\nPersonnage : " + this.personnages + "id : " + this.id;
    }

    public int nbPersonnages() {
        return personnages.size();
    }
}
