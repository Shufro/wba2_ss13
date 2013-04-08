package aufgabe4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.*;

import jaxb.objects.*;

public class RezepteProgramm {
	
	private static Scanner in;
	 
	/**
	 * Hauptmethode, initialisiert die Marshaller zum Binding der XML Datei und startet den Aufruf des Menüs.
	 *
	 */
	public static void main(String[] args) throws JAXBException, IOException {
	 
	//Rezeptnummer
	  in = new Scanner(System.in);
	  

	  //JAXB Context Object erstellen
	  JAXBContext jaxbContext = JAXBContext.newInstance(Rezepteseite.class);
	  
	  //Unmarshaller erstellen  fuer Ausgabe 
	  	Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
	  	// ein XML Dokument wird als Object des Typs "Rezeptseite" erstellt
	  	Rezepteseite rezepteseite = (Rezepteseite) unMarshaller.unmarshal(new FileInputStream("Aufgabe 3/Aufgabe3d.xml"));


	  	Marshaller marshaller =jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		
	  	
	  // Ausgabe der Werte des XML Dokuments
	  List<Rezept> rezeptList = rezepteseite.getRezept();
	  
	  // Ausgabe beginnen
	  menueAusgabe(rezeptList, marshaller, rezepteseite);

	}

  
  
	/***
	* Diese Methode gibt die Daten des XML Dokuments des gewünschten Rezeptes aus.		 
	* 
	* @param rezept Übergabe des Rezeptes
	*/
	public static void rezeptInhaltAusgeben(Rezept rezept){				 
		// Ausgaben Allgemeine Informationen
			System.out.println();
			System.out.println("Rezeptname: " + rezept.getRezeptname()); 	
			System.out.println("------------------------------");
			System.out.println("Kategorie: " + rezept.getKategorie()); 
			if(rezept.getKurzinfo() !=null){
				System.out.println("Kurzinfo: " + rezept.getKurzinfo()); 
				}
			System.out.println();
			
			System.out.println("Rezeptid: " + rezept.getRezeptid()); 
			System.out.println("Rezepturl:" + rezept.getUrl()); 
				 
			
			
		// Bilder
			if(rezept.getBilder() != null){
				System.out.println();	 
	    		System.out.println("Bilder"); 
	    		System.out.println("------");
	    		List<Bild> bilderList = rezept.getBilder().getBild(); 
	    		
	    		for (int bildercount = 0; bildercount < bilderList.size(); bildercount++) {
	    			Bild bild = (Bild) bilderList.get(bildercount);
						 
	    			//Ausgabe
	    			System.out.println("Bild " + bild.getBildbeschreibung());
	    			System.out.println("Bildquelle: " + bild.getSrc());  
	    			System.out.println();
	    			
	    		}
			}
		
			
		// Zutaten
			System.out.println();
			System.out.println("Zutaten - ausgelegt für " + rezept.getZutaten().getPortionen() + " Portionen"); 
			System.out.println("-------------------------------------");
	 
			
			List<Zutat> zList =  rezept.getZutaten().getZutat();
		
			for (int zcount = 0; zcount < zList.size(); zcount++) {
				Zutat zutat = (Zutat) zList.get(zcount);
						 
				//Ausgabe
				if (zutat.getAnzahl() != null){ 
				System.out.println(zutat.getAnzahl() + " " + zutat.getMengeneinheit() + " " + zutat.getZutatenname() );}
				
				//falls Anzahl nicht gegeben (angelehnt an chefkoch.de)
				else{System.out.println(zutat.getMengeneinheit() + " " + zutat.getZutatenname() );} 
			
//				System.out.println("Anzahl: " + zutat.getAnzahl()); 
//				System.out.println("Mengeneinheit: " + zutat.getMengeneinheit()); 
			} 
					 				 
		// Zubereitung
			System.out.println();
			System.out.println("Zubereitung"); 
			System.out.println("-----------");
			
		//Ausgabe der festen Elementen
			System.out.println("Arbeitszeit: " + rezept.getZubereitung().getArbeitszeit().getDauer() + " " + rezept.getZubereitung().getArbeitszeit().getZeiteinheit()); 
//			System.out.println("Dauer: " + rezept.getZubereitung().getArbeitszeit().getDauer()); 
//			System.out.println("Zeiteinheit: " + rezept.getZubereitung().getArbeitszeit().getZeiteinheit()); 

			System.out.println("Schwierigkeitsgrad: " + rezept.getZubereitung().getSchwierigkeitsgrad()); 

			System.out.println("Brennwert: " + rezept.getZubereitung().getBrennwert().getBrennwertmenge() + " " + rezept.getZubereitung().getBrennwert().getBrennwerteinheit()); 
//			System.out.println("Brennwertmenge: " + rezept.getZubereitung().getBrennwert().getBrennwertmenge()); 
//			System.out.println("Brennwerteinheit: " + rezept.getZubereitung().getBrennwert().getBrennwerteinheit()); 

				 
		// Ausgabe zusaetzlicher Angaben 
		
		// Ausgabe Ruhzeit
			if(rezept.getZubereitung().getRuhezeit() != null){  							
			
				System.out.println("Ruhezeit: " + rezept.getZubereitung().getRuhezeit().getDauer() + " "+ rezept.getZubereitung().getRuhezeit().getZeiteinheit() ); 
//				System.out.println("Dauer: " + rezept.getZubereitung().getRuhezeit().getDauer());
//				System.out.println("Zeiteinheit: " + rezept.getZubereitung().getRuhezeit().getZeiteinheit()); 
			}
				 
		 //Ausgabe Koch/Backzeit
			if(rezept.getZubereitung().getKochBackzeit() != null){  						
				System.out.println("Koch/Backzeit: " + rezept.getZubereitung().getKochBackzeit().getDauer() +" "+ rezept.getZubereitung().getKochBackzeit().getZeiteinheit()); 
//				System.out.println("Dauer: " + rezept.getZubereitung().getKochBackzeit().getDauer());
//				System.out.println("Zeiteinheit: " + rezept.getZubereitung().getKochBackzeit().getZeiteinheit()); 
			}		 
				 
			System.out.println("Beschreibung: " + rezept.getZubereitung().getBeschreibung()); 
				 	 
				 
				 
		// Kommentare
			if(rezept.getKommentare().getKommentar() != null){
					 
				System.out.println("Kommentare"); 
				System.out.println("----------"); 

					 
				List<Kommentar> kommentarList = rezept.getKommentare().getKommentar(); 
				for (int kcount = 0; kcount < kommentarList.size(); kcount++) {
					
					Kommentar kommentar = (Kommentar) kommentarList.get(kcount);
				
					//Ausgabe
					System.out.println("Kommentar von " + kommentar.getUsername());  
//					System.out.println("Zeitpunkt: " + kommentar.getZeitpunkt());  
					System.out.println("Nachricht: " + kommentar.getText()); 
					System.out.println();
				}
			}		
	} 
	
	
	
	/**
	 * Methode, die das Schreiben eines Kommentars ermöglicht  und der Kommentarliste hinzufügt.
	 * 
	 * @param kommentarList Übergabe der Kommentarliste des jeweiligen Rezeptes
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void kommentieren(List<Kommentar> kommentarList, List<Rezept> rezeptList, Marshaller marshaller, Rezepteseite rezepteseite) throws JAXBException, FileNotFoundException{
		String name, text;
		Kommentar comment = new Kommentar();
		
		in.nextLine();
		System.out.print("Username: ");
		name = in.nextLine();
		comment.setUsername(name);

		 System.out.print("Text: ");
		 text = in.nextLine();
		 comment.setText(text);
		 
		kommentarList.add(comment);
		
		schreiben(marshaller, rezepteseite);
		
		System.out.println();
		System.out.println("Eingabe erfolgreich. Zurück zum Hauptmenü");
		System.out.println();
		menueAusgabe(rezeptList, marshaller, rezepteseite);
	}
  
	
	
	/**
	 * Methode zum Aufbau eines Menüs, von dem aus die Funtkionen des Programms, wie Rezepte lesen oder kommentieren, gestartet wird. 
	 * 
	 * @param rezeptList Liste der vorhandenen Rezepte des XML Dokuments
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void menueAusgabe(List<Rezept> rezeptList, Marshaller marshaller, Rezepteseite rezepteseite) throws JAXBException, FileNotFoundException{
		int eingabe, weiter;
		  // Menueaufbau	
		  System.out.println("____Rezeptesammlung____");  
		  System.out.println(); 
		  System.out.println("Was moechten sie machen?");  
		  
		  System.out.println("1. Rezept ansehen"); 
		  System.out.println("2. Rezept kommentieren"); 
		  System.out.println("3. Beenden");
		  System.out.print("Auswahl: "); 
		  eingabe = in.nextInt();
		 
		  
		  switch(eingabe){
	      	case 1:
	      			int check;
	      			rezepteAusgeben(rezeptList);
		        	System.out.println();
	      			System.out.print("Rezeptauswahl: "); 
	      			check = in.nextInt();
	      			if(check <1 || check-1 > rezeptList.size()){
	      				System.out.println();
		      			System.out.println("Ungültige Auswahl. Zurück zum Hauptmenü."); 
		      			System.out.println();
		      			menueAusgabe(rezeptList, marshaller, rezepteseite);
	      			}
	      			
	      			rezeptInhaltAusgeben(rezeptList.get( check-1 ));
	      			
	      			System.out.println();
	      			System.out.println("Nächster Schritt?"); 	      			

	      			System.out.println("0 - Rezeptkommentieren"); 
	      			System.out.println("1 - zurück zur Auswahl"); 
	      			System.out.println("2 - Programm beenden");
	      			System.out.println();
	      			System.out.print("Auswahl: ");
	      			weiter = in.nextInt(); 
	      			
	      			
	      			switch(weiter){
	      			case 0:  List<Kommentar> komment2 = (List<Kommentar>) rezeptList.get(weiter).getKommentare().getKommentar();
				   	        kommentieren(komment2, rezeptList, marshaller, rezepteseite);
					   	    schreiben(marshaller, rezepteseite);
				
				   	        break;
				   	        
	      			case 1: menueAusgabe(rezeptList, marshaller, rezepteseite); break;
	      			case 2: break;
	      			default: 
	      				System.out.println();
	      				System.out.printf("Keine gültige Angabe. Das Programm wird beendet.");	      				
	      				break;
	      			}
	      			
	          break;
	        case 2:
	    	        rezeptAuswahlKommentar(rezeptList, marshaller, rezepteseite);
	          break;
	        case 3: break; 
	        default: 
	        	  System.out.println();
	  			  System.out.println("Ungültige Eingabe. Programm wird beendet.");
  				break; 
	      
		  }
		  
	}
	
	/**
	 * Auflistung der vorhandenen Rezepte, zur Übersicht der Rezeptenummern.
	 * 
	 * @param rezeptList vorhandene Rezepte des XML Dokuments
	 */
	public static void rezepteAusgeben( List<Rezept> rezeptList){
		 // Rezepte mit Namen anzeigen
			System.out.println();
			System.out.println("Vorhandene Rezepte"); 
			System.out.println("-------------------");

			for (int rezeptnr = 0; rezeptnr < rezeptList.size(); rezeptnr++) {
				Rezept rezept = (Rezept) rezeptList.get(rezeptnr);
		
				//Ausgabe
				System.out.println((rezeptnr+1) + " " + rezept.getRezeptname()); 
			} 
			
	}
	 
	
	
	/**
	 * Methode, die das Kommentaruntermenü aufruft, und gegebenfalls die Funktion startet.
	 * 
	 * @param rezeptList
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void rezeptAuswahlKommentar(List<Rezept> rezeptList, Marshaller marshaller , Rezepteseite rezepteseite) throws JAXBException, FileNotFoundException{
		int rnr;
		
		
	  		
		
		// Rezeptauswahl, anschliessend kommentieren starten 
		// Menüaufbau
	    System.out.println();
		System.out.println("Geben sie die Rezeptnummer an"); 
		System.out.println("------------------------------");
		System.out.println("Rezeptnummer: ");
	    System.out.println("0 - Übersicht der Rezepte anzeigen");
	    rnr = in.nextInt();
	    
	    while(rnr<0 || rnr-1 > rezeptList.size()){
				System.out.println();
				System.out.printf("Bitte geben sie eine gültige Rezeptnummer an: "); 
				rnr = in.nextInt();
	    }
	    
	  
	    switch(rnr){
	    case 0:  rezepteAusgeben(rezeptList);
	    		 System.out.println();
				 System.out.println("Rezeptnummer: ");
				 rnr = in.nextInt();
				 
				 while(rnr<0 || rnr-1 > rezeptList.size()){
					System.out.printf("Bitte gültige Rezeptnummer eingeben: ");	
				    rnr = in.nextInt();
				 }
	    
				  List<Kommentar> komment1 = (List<Kommentar>) rezeptList.get(rnr-1).getKommentare().getKommentar();
			   	  kommentieren(komment1, rezeptList, marshaller, rezepteseite);
			   	   schreiben(marshaller, rezepteseite);

			   	 
			   	  
			break;
		default:
			if(rnr-1> rezeptList.size()){
				System.out.printf("Keine gültige Angabe. Das Programm wird beendet.");	}
				List<Kommentar> komment = (List<Kommentar>) rezeptList.get(rnr-1).getKommentare().getKommentar();
		   	  	kommentieren(komment, rezeptList, marshaller, rezepteseite);
		   	    schreiben(marshaller, rezepteseite);
			
			break;
	    }
	 
	}
	
	public static void schreiben(Marshaller marshaller, Rezepteseite rezepteseite) throws JAXBException, FileNotFoundException{
		
		 marshaller.marshal(rezepteseite, new File("Aufgabe 3/Aufgabe3d.xml"));
		
		
	}
	
}
