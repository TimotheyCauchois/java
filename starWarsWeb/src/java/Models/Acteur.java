/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;



public class Acteur {
    
    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Personnage> duetPersonnages = new ArrayList(1);
    
    /**
     * Constructor
     * 
     * Personnage()
     */
    public Acteur(){}
    
    /**
     * Constructor
     * 
     * Personnage(String nom, String prenom)
     * @param id
     * @param nom
     * @param prenom
     */
    public Acteur(int id, String nom, String prenom){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Acteur(int i, String acteur1, String acteur10, ArrayList<Personnage> personnages1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Récupération du nombre de personnages
     * 
     * @return int
     */
    public int getNombrePersonnages(){ return this.duetPersonnages.size(); }
    
    // The methods of basic getter below.
    public int getId(){ return id; }
    public String getNom(){ return this.nom; }
    public String getPrenom(){ return this.prenom; }
    public ArrayList getDuetPersonnages() { return duetPersonnages; }

    // The methods of basic setter below.
    public void setId(int id){ this.id = id; }
    public void setNom(String nom){ this.nom = nom; }
    public void setPrenom(String prenom){ this.prenom = prenom; }
    public void setDuetPersonnages(ArrayList duetPersonnages) { this.duetPersonnages = duetPersonnages; }
    
    @Override
    public String toString(){
        return "\n[Acteur]"
            +"\n- id : "+this.getId()
            +"\n- nom de l'acteur : "+this.getNom()
            +"\n- prénom de l'acteur : "+this.getPrenom()
            +"\n- nombre de personnages : "+this.getNombrePersonnages();
    }
}
