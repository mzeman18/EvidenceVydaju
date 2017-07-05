package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class VydajDaoImpl implements VydajDao {

	   List<Vydaj> vydaje;
	   File soubor;

	   public VydajDaoImpl(String path){
		   vydaje = new ArrayList<Vydaj>();
		   soubor = new File(path);
	   }
	      
	@Override
	public List<Vydaj> findAll() {
		return vydaje;
	}

	@Override
	public void saveVydaj(Vydaj v) {
	     if(soubor.exists()){ 
	    	 vydaje = loadVydaj(); 
	    	 vydaje.add(v); 
	            try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(soubor)))) {
	           oos.writeObject(vydaje); 
	           oos.flush(); 
	        } catch (IOException ex) {
	            Logger.getLogger(Vydaj.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        } 
	        else { 
	        	vydaje.add(v);
	        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(soubor)))) {
	           oos.writeObject(vydaje); 
	           oos.flush(); 
	        } catch (IOException ex) {
	            
	        }
	       } 
	     }
	
	public List<Vydaj> loadVydaj() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(soubor)))) {
            vydaje = (ArrayList<Vydaj>)ois.readObject(); 
        } catch (IOException | ClassNotFoundException ex) {
           System.out.println("Soubor neexistuje.");
           JOptionPane.showMessageDialog(null,"Chyba!",null, JOptionPane.ERROR_MESSAGE);
       }
        return vydaje;
	 }
	
}
	


