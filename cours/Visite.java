package cours;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.text.*;

public class Visite {
	String name ="brigitte";
	String date = "2020-12-12";
	int note = 18 ;
	
	public Visite(){}
	
	public Visite(String name, String date, int note) {
		this.name = name;
		this.date = date;
		this.note = note;
	}
	
	public static void main(String[] args) {
		Visite v1 = new Visite();
		Visite v2 = new Visite("Tom","2020-08-06",15);
		
		System.out.println(v1.date);
		System.out.println(v2.date);
		System.out.println(v1.getDate());
		
	}
	public String getName(){
		return this.name;
	}
	public void setName(String n) {
		this.name = n ;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String n) {
		this.date = n ;
	}
	public int getNote(){
		return this.note;
	}
	public void setNote(int n) {
		this.note = n ;
	}
	public String toString(Visite v) {
		return (v.getName() + v.getDate() +v.getNote());
	}
	

	
	 

	
}
