/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Acteur;
import Controllers.DAOAvis;
import static Controllers.StarWars.print;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Film {

    private int id;
    private String titre;
    private String anneeDeSortie;
    private int numEpisode;
    private double cout;
    private double recette;
    public ArrayList<Acteur> acteurs;
    private ArrayList<Avis> daoAvisList;
    private int moyenneAvis = 0;
    
    /**
     * Constructor
     * 
     * Film()
     */
    public Film() {}
    
    /**
     * Constructor
     * 
     * Film(boolean nouveaFilm)
     * @param nouveaFilm
     */
    public Film(boolean nouveaFilm){
        if(nouveaFilm==true){
            print("[Nouveau film]");
            //-
            Scanner scan = new Scanner(System.in);
            //-
            print("- (string) titre du film : ");
            String titreFilm = scan.nextLine();
            this.titre = titreFilm;
            //-
            print("- (string) année du film : ");
            String anneeDeSortieFilm = scan.next();
            this.anneeDeSortie = anneeDeSortieFilm;
            //-
            print("- (int) numéro du film : ");
            int numEpisodeFilm = scan.nextInt();
            this.numEpisode = numEpisodeFilm;
            //-
            print("- (double) coût du film : ");
            double coutFilm = scan.nextDouble();
            this.cout = coutFilm;
            //-
            print("- (double) recette du film : ");
            double recetteFilm = scan.nextDouble();
            this.recette = recetteFilm;
            //-
            this.id = 0;
            this.acteurs = new ArrayList();
            //-
            print("[Nouveau film enregistré]");
        }
    }
    
    /**
     * Constructor
     * 
     * Film(String titre, String anneeDeSortie, String numEpisode, String cout, String recette)
     * @param id
     * @param titre
     * @param anneeDeSortie
     * @param numEpisode
     * @param cout
     * @param recette
     */
    public Film(int id, String titre, String anneeDeSortie, int numEpisode, double cout, double recette) {
        this.id = id;
        this.titre = titre;
        this.anneeDeSortie = anneeDeSortie;
        this.numEpisode = numEpisode;
        this.cout = cout;
        this.recette = recette;
        this.acteurs = new ArrayList();
    }

    public Film(int i, String jumanji, String string, int i0, int i1, int i2, ArrayList<Acteur> acteurs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Récupération du nombre d'acteurs
     * 
     * @return int
     */
    public int getNombreActeurs(){ return !this.acteurs.isEmpty() && this.acteurs.size()>0 ? this.acteurs.size() : 0 ; }
    
    /**
     * Récupération du nombre de personnages
     * 
     * @return int
     */
    public int getNombrePersonnages(){
        int i = 0;
        for(Acteur acteur : this.acteurs){
            i +=acteur.getNombrePersonnages();
        }
        return i;
    }
    
    /**
     * Calcule du bénéfice du film
     * 
     * @return double
     */
    public ArrayList calculBenefice(){
        double x = this.recette-this.cout;
        ArrayList result = new ArrayList();
        if(x >= 0){
            result.add(true);
            result.add(x);
        } else {
            result.add(false);
            result.add(x);
        }
        return result;
    }
    
    /**
     * Calcule de la moyenne des avis du film
     * 
     */
    public int calculMoyenneAvis() throws SQLException{
        try {
            DAOAvis daoAvis = new DAOAvis();
            this.daoAvisList = daoAvis.listReadingArrayList(this.id);
            daoAvis.close();

            int moyenneAvis = 0;
            for(Avis avisList : this.daoAvisList){
                moyenneAvis = moyenneAvis + avisList.getId();
            }
            if(moyenneAvis<0 || moyenneAvis>0){
                moyenneAvis = ( moyenneAvis / this.daoAvisList.size() ) / 10;
            }
            this.moyenneAvis = moyenneAvis;
        } catch (Exception e) { System.err.println(e); }
        return this.moyenneAvis;
    }
    
    /**
     * Récupération du nombre de personnages
     * 
     * @param anneeInserted
     * @return boolean
     * @throws java.text.ParseException
     */
    public boolean isBefore(String anneeInserted) throws ParseException{
        DateFormat format = new SimpleDateFormat("YYYY", Locale.FRANCE);
        Date anneeDeSortieToDate = format.parse(this.anneeDeSortie);
        Date anneeInsertedToDate = format.parse(anneeInserted);
        return anneeDeSortieToDate.compareTo(anneeInsertedToDate) < 0;
    }
    
     /**
     * Triage des acteurs de la collection
     * 
     * @return ArrayList
     */
    public ArrayList tri(){
        ArrayList<Acteur> acteursTries = new ArrayList();
        if(this.acteurs!=null && !this.acteurs.isEmpty() && this.acteurs.size()>0){
            Collections.sort(this.acteurs, new Comparator<Acteur>() {
                @Override
                public int compare(Acteur acteur1, Acteur acteur2){ return  acteur1.getNom().compareTo(acteur2.getNom()); }
            });
            acteursTries.addAll(this.acteurs);
            print("\n[Trie effectué]");
        } else{
            acteursTries = null;
            print("\n[Trie non effectué]");
        }
        return acteursTries;
    }

    // The methods of basic getter below.
    public int getId(){ return this.id; }
    public String getTitre() { return titre; }
    public String getAnneeDeSortie() { return anneeDeSortie; }
    public int getNumEpisode() { return numEpisode; }
    public double getCout() { return cout; }
    public double getRecette() { return recette; }
    public ArrayList<Acteur> getActeurs() { return acteurs; }

    // The methods of basic setter below.
    public void setId(int id){ this.id = id; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setAnneeDeSortie(String anneeDeSortie) { this.anneeDeSortie = anneeDeSortie; }
    public void setNumEpisode(int numEpisode) { this.numEpisode = numEpisode; }
    public void setCout(double cout) { this.cout = cout;}
    public void setRecette(double recette) { this.recette = recette; }
    public void setActeurs(ArrayList<Acteur> acteurs) { this.acteurs = acteurs; }
    
    @Override
    public String toString(){
        return "[Film]"+
            "\n"+this.getId()
            +"\n- titre du film : "+this.getTitre()
            +"\n- année de sortie du film : "+this.getAnneeDeSortie()
            +"\n- numéro de l'épisode du film : "+this.getNumEpisode()
            +"\n- coût du film : "+this.getCout()
            +"\n- recette du film : "+this.getRecette()
            +"\n- bénéfice : "+this.calculBenefice()
            +"\n- nb acteurs : "+this.getNombreActeurs()
            +"\n- nb personnages : "+this.getNombrePersonnages();
    }

    public int nbActeurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
