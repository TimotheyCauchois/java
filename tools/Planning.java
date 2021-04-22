package tools;

import java.util.ArrayList;
import cours.Visite;

public class Planning {
	public ArrayList<Visite> visites;
	    /**
	     * Constructor 
	     * Planning()
	     */
	    public Planning() { this.visites = new ArrayList(); }
	    /**
	     * Constructor
	     * Planning(ArrayList Visite.visite)
	     * @param 
	     */
	    public Planning(ArrayList visite) { this.visites = visite; }
	    public ArrayList getVisite() { return visites; }
	    public void setVisite(ArrayList visite) { this.visites = visite; }
	    /**
	     * Adding a visit from the list of visits.
	     * @param visite cours.Visite
	     */
	    public void addVisite(Visite visite){ this.visites.add(visite); }
	    /**
	     * Deleting a visit from the list of visits.
	     * @param visite cours.Visite
	     */
	    public void removeVisite(Visite visite){ this.visites.remove(visite); }    
	    @Override
	    public String toString(){
	        int x = 0;
	        String toString;
	        if(visites.size()>0){
	            toString = "";
	            for(Visite visite : visites){
	                if(x==0){
	                    toString += visite;
	                } else { toString += " - "+visite; }
	                x++;
	            }
	        } else { toString = "planning vide"; }
	        return toString;
	    }
}
