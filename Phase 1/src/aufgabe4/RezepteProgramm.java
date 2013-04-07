package aufgabe4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.*;

import jaxb.objects.*;

public class RezepteProgramm {
	
	private static Scanner in;
	private static final String REZEPTE_XML = "/Phase 1/Aufgabe 3/Aufgabe3d.xml";
	 
	//
	public static void main(String[] args) throws JAXBException, IOException {
	 
	int eingabe = 0; 	
	  in = new Scanner(System.in);
	  

	  //JAXB Context Object erstellen
	  JAXBContext jaxbContext = JAXBContext.newInstance(Rezepteseite.class);
	  
	  //Unmarshaller erstellen  für Ausgabe 
	  	Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
	  	// ein XML Dokument wird als Object des Typs "Rezeptseite" erstellt
	  	Rezepteseite rezepteseite = (Rezepteseite) unMarshaller.unmarshal(new FileInputStream(REZEPTE_XML));

	  
	 // Marshaller erstellen fürs Schreiben des Kommentars
	    Marshaller marshaller =jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	  
	
	    

	  // Ausgabe der Werte des XML Dokuments
	  List<Rezept> rezeptList = rezepteseite.getRezept();
		
	  // Menüaufbau	
	  System.out.println("Rezeptesammlung");  
	  System.out.println(); 
	  System.out.println("Was möchten sie machen?");  
	  
	  System.out.println("1. Rezept ansehen"); 
	  System.out.println("2. Rezept kommentieren"); 
	  System.out.println("Eingabe: "); 
	  
	  eingabe = in.nextInt();
	 

	   
	  //Testausgabe
	  rezeptInhaltAusgeben(rezeptList.get(0));
	  
	  switch(eingabe){
      	case 1:
      		 // Rezepte mit Namen anzeigen
      			System.out.println("Vorhandene Rezepte"); System.out.println(); 
      			
      			for (int rezeptnr = 0; rezeptnr < rezeptList.size(); rezeptnr++) {
      				Rezept rezept = (Rezept) rezeptList.get(rezeptnr);
   			
      				//Ausgabe
      				System.out.println((rezeptnr+1) + rezept.getRezeptname()); 
      			} 
      			
      			System.out.println("Rezeptauswahl: "); 
      			rezeptInhaltAusgeben(rezeptList.get( in.nextInt() ));
      			
          break;
      case 2:
             // Rezeptauswahl, anschließend kommentieren starten 
    	  	// Write to File
    	  	// create bookstore, assigning book
    	    // Bookstore bookstore = new Bookstore();
    	    //marshaller.marshal(neues, new File(REZEPTE_XML));
          break;
      
	  }
	  
	}

  
  
				 
	public static void rezeptInhaltAusgeben(Rezept rezept){				 
		// Ausgaben Allgemeine Informationen
			System.out.println("Rezeptname: " + rezept.getRezeptname()); 
			System.out.println("Rezeptid: " + rezept.getRezeptid()); 
			System.out.println("Kategorie: " + rezept.getKategorie()); 
			System.out.println("URL: " + rezept.getUrl()); 
				 
			System.out.println("Kurzinfo: " + rezept.getKurzinfo()); 
			
			
		// Bilder
			if(rezept.getBilder() != null){
					 
	    		System.out.println("Bilder"); 
	    		List<Bild> bilderList = rezept.getBilder().getBild(); 
	    		
	    		for (int bildercount = 0; bildercount < bilderList.size(); bildercount++) {
	    			Bild bild = (Bild) bilderList.get(bildercount);
						 
	    			//Ausgabe
	    			System.out.println("Bildsrc: " + bild.getSrc());  //wie ist die "Slideshow beschreibbar"?
	    			System.out.println("Bildbeschreibung: " + bild.getBildbeschreibung());  
	    		}
			}
		
			
		// Zutaten
			System.out.println("Zutaten "); 
			System.out.println("Portionen: " + rezept.getZutaten().getPortionen()); 
				 
			List<Zutat> zList =  rezept.getZutaten().getZutat();
		
			for (int zcount = 0; zcount < zList.size(); zcount++) {
				Zutat zutat = (Zutat) zList.get(zcount);
						 
				//Ausgabe
				System.out.println("Zutatenname: " + zutat.getZutatenname()); 
				System.out.println("Anzahl: " + zutat.getAnzahl()); 
				System.out.println("Mengeneinheit: " + zutat.getMengeneinheit()); 
			} 
					 				 
		// Zubereitung
			System.out.println("Zubereitung"); 
				 
		//Ausgabe der festen Elementen
			System.out.println("Arbeitszeit"); 
			System.out.println("Dauer: " + rezept.getZubereitung().getArbeitszeit().getDauer()); 
			System.out.println("Zeiteinheit: " + rezept.getZubereitung().getArbeitszeit().getZeiteinheit()); 

			System.out.println("Schwierigkeitsgrad: " + rezept.getZubereitung().getSchwierigkeitsgrad()); 

			System.out.println("Brennwert"); 
			System.out.println("Brennwertmenge: " + rezept.getZubereitung().getBrennwert().getBrennwertmenge()); 
			System.out.println("Brennwerteinheit: " + rezept.getZubereitung().getBrennwert().getBrennwerteinheit()); 

				 
		// Ausgabe zusätzlicher Angaben 
		
		// Ausgabe Ruhzeit
			if(rezept.getZubereitung().getRuhezeit() != null){  							
			
				System.out.println("Ruhezeit"); 
				System.out.println("Dauer: " + rezept.getZubereitung().getRuhezeit().getDauer());
				System.out.println("Zeiteinheit: " + rezept.getZubereitung().getRuhezeit().getZeiteinheit()); 
			}
				 
		 //Ausgabe Koch/Backzeit
			if(rezept.getZubereitung().getKochBackzeit() != null){  						
				System.out.println("Koch/Backzeit"); 
				System.out.println("Dauer: " + rezept.getZubereitung().getKochBackzeit().getDauer());
				System.out.println("Zeiteinheit: " + rezept.getZubereitung().getKochBackzeit().getZeiteinheit()); 
			}		 
				 
			System.out.println("Beschreibung: " + rezept.getZubereitung().getBeschreibung()); 
				 	 
				 
				 
		// Kommentare
			if(rezept.getKommentare().getKommentar() != null){
					 
				System.out.println("Kommentare"); 
					 
				List<Kommentar> kommentarList = rezept.getKommentare().getKommentar(); 
				for (int kcount = 0; kcount < kommentarList.size(); kcount++) {
					
					Kommentar kommentar = (Kommentar) kommentarList.get(kcount);
				
					//Ausgabe
					System.out.println("Username: " + kommentar.getUsername());  
					System.out.println("Zeitpunkt: " + kommentar.getZeitpunkt());  
					System.out.println("Text: " + kommentar.getText());  

				}
			}
			 
	
	} 
  
	
	 
}
