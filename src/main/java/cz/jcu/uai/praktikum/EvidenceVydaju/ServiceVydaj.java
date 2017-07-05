package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.io.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

public class ServiceVydaj {
	Double hodnota;
	Mesic mesic;
	Kategorie kategorie;
	GregorianCalendar kalendar = new GregorianCalendar();
	int rok;
	enum Mesic {}
	enum Kategorie {}
	public static File soubor = new File("Vydaj.at");
	public static ArrayList<ServiceVydaj> seznamVydaju = new ArrayList<>();
	
	
	public ServiceVydaj(Double h, Mesic m, Kategorie k) {
        this.hodnota = h;
        this.mesic = m;
        this.kategorie = k;
        rok = kalendar.get(Calendar.YEAR);
    }
	
	public static void ulozVydaj(ServiceVydaj v) {
		if(soubor.exists()){ 
			seznamVydaju = nactiVydaj(); 
			seznamVydaju.add(v);
	        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(soubor)))) {
	       oos.writeObject(seznamVydaju);
	       oos.flush(); 
	    } catch (IOException ex) {
	        Logger.getLogger(Vydaj.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    } 
	    else { 
	    	seznamVydaju.add(v); 
	    try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(soubor)))) {
	       oos.writeObject(seznamVydaju); 
	       oos.flush(); 
	    } catch (IOException ex) {
	        Logger.getLogger(Vydaj.class.getName()).log(Level.SEVERE, null, ex);
	    }
	   } 
	 }
	
	public static ArrayList<ServiceVydaj> nactiVydaj() {
		   try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(soubor)))) {
			   seznamVydaju = (ArrayList<ServiceVydaj>)ois.readObject(); 
	         } catch (IOException | ClassNotFoundException ex) {
	            System.out.println("Soubor neexistuje.");
	            JOptionPane.showMessageDialog(null,"Není co zobrazit!",null, JOptionPane.ERROR_MESSAGE);
	           Logger.getLogger(Vydaj.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         return seznamVydaju;
	     }
	
}
