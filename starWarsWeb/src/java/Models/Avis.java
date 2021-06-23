/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
public class Avis {

    private int id;
    private String titre;
    private String description;
    private int note_avis;
    
    /**
     * Constructor
     * 
     * Avis()
     */
    public Avis() {}
    
    /**
     * Constructor
     * 
     * Avis(String titre, String description)
     * @param titre
     * @param description
     * @param note_avis
     */
    public Avis(String titre, String description, int note_avis){
        this.titre = titre;
        this.description = description;
        this.note_avis = note_avis;
    }
    
    /**
     * Constructor
     * 
     * Avis(int id, String titre, String description)
     * @param id
     * @param titre
     * @param description
     * @param note_avis
     */
    public Avis(int id, String titre, String description, int note_avis){
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.note_avis = note_avis;
    }
    
    // The methods of basic getter below.
    public int getId(){ return this.id; }
    public String getTitre() { return this.titre; }
    public String getDescription() { return this.description; }
    public int getNoteAvis() { return this.note_avis; }

    // The methods of basic setter below.
    public void setId(int id){ this.id = id; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setDescription(String description) { this.description = description; }
    public void setNoteAvis(int note_avis) { this.note_avis = note_avis; }
    
    @Override
    public String toString(){
        return "[Film]"+
            "\n"+this.getId()
            +"\n- titre de l'avis : "+this.getTitre()
            +"\n- titre description : "+this.getDescription();
    }
}
