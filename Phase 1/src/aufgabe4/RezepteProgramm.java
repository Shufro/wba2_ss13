package aufgabe4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.*;

import jaxb.objects.*;

/**
 * Rezepteprogramm
 * Liest Daten eines XML Schemas ein und gibt die vorhandenen Informationen aus.
 * Der User hat zusätzlich die Möglichkeit den jeweiligen Rezepten Kommentare hinzuzufügen.
 * @author dennismeyer
 *
 */
public class RezepteProgramm {
	
	private static Scanner in;
	 
	/**
	 * Hauptmethode, initialisiert die Marshaller zum Binding der XML Datei und startet den Aufruf des Menüs.
	 *
	 */
	public static void main(String[] args) throws JAXBException, IOException {
	 
		//Scanner
		in = new Scanner(System.in);
	  
		//JAXB Context Object erstellen
		JAXBContext jaxbContext = JAXBContext.newInstance(Rezepteseite.class);
	  
		//Unmarshaller erstellen fuer Ausgabe 
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
		// ein XML Dokument wird als Object des Typs "Rezeptseite" erstellt
		Rezepteseite rezepteseite = (Rezepteseite) unMarshaller.unmarshal(new FileInputStream("Aufgabe 3/Aufgabe3d.xml"));

		//Marshaller erstellen für Hinzufügen der neuen Kommentare zur XML Datei
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
		//Check ob Bilder vorhanden, wenn ja ausgabe
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
		//Ausgabe der Zutaten
		System.out.println();
		System.out.println("Zutaten - ausgelegt für " + rezept.getZutaten().getPortionen() + " Portionen"); 
		System.out.println("-------------------------------------");
	 
		List<Zutat> zList =  rezept.getZutaten().getZutat();
		
		for (int zcount = 0; zcount < zList.size(); zcount++) {
			Zutat zutat = (Zutat) zList.get(zcount);
				
			//Ausgabe
			//check ob Angabe vorhanden, wenn ja ausgabe
			if (zutat.getAnzahl() != null){ 
				System.out.println(zutat.getAnzahl() + " " + zutat.getMengeneinheit() + "\t" + zutat.getZutatenname() );
			}
				
			//falls Anzahl nicht gegeben (angelehnt an chefkoch.de), nur Ausgabe Name und Einheit
			else{
				System.out.println(zutat.getMengeneinheit() + " " + zutat.getZutatenname() );
				} 
		} 
		
		
		// Zubereitung
		System.out.println();
		System.out.println("Zubereitung"); 
		System.out.println("-----------");
			
		//Ausgabe der festen Elementen
		System.out.println("Arbeitszeit: " + rezept.getZubereitung().getArbeitszeit().getDauer() + " " + rezept.getZubereitung().getArbeitszeit().getZeiteinheit()); 
		System.out.println("Schwierigkeitsgrad: " + rezept.getZubereitung().getSchwierigkeitsgrad()); 
		System.out.println("Brennwert: " + rezept.getZubereitung().getBrennwert().getBrennwertmenge() + " " + rezept.getZubereitung().getBrennwert().getBrennwerteinheit()); 

				 
		// Ausgabe zusaetzlicher Angaben 
		// Ausgabe Ruhzeit
		// check ob Ruhezeit vorhanden, wenn ja Ausgabe
		if(rezept.getZubereitung().getRuhezeit() != null){  							
			System.out.println("Ruhezeit: " + rezept.getZubereitung().getRuhezeit().getDauer() + " "+ rezept.getZubereitung().getRuhezeit().getZeiteinheit() ); 
		}
				 
		//Ausgabe Koch/Backzeit
		//Check ob Koch/Backzeit vorhanden, wenn ja Ausgabe
		if(rezept.getZubereitung().getKochBackzeit() != null){  						
			System.out.println("Koch/Backzeit: " + rezept.getZubereitung().getKochBackzeit().getDauer() +" "+ rezept.getZubereitung().getKochBackzeit().getZeiteinheit()); 
		}		 
		
		// Beschreibung
		System.out.println("Beschreibung: " + rezept.getZubereitung().getBeschreibung()); 
				 	 
				 		 
		// Kommentare
		//Check ob Kommentare vorhanden
		if(rezept.getKommentare().getKommentar() != null){
			
			//Ausgabe
			System.out.println("Kommentare"); 
			System.out.println("----------"); 

			List<Kommentar> kommentarList = rezept.getKommentare().getKommentar(); 
			
			for (int kcount = 0; kcount < kommentarList.size(); kcount++) {
					
				Kommentar kommentar = (Kommentar) kommentarList.get(kcount);
				
				//Ausgabe
				System.out.println("Kommentar von " + kommentar.getUsername());  
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
		//Stings zum einlesen
		String name, text;
		
		//neuer Kommentar
		Kommentar comment = new Kommentar();
		
		//Einlesen Username + hinzufügen zum Kommentar
		in.nextLine();
		System.out.print("Username: ");
		name = in.nextLine();
		comment.setUsername(name);

		//Einlesen Kommentartextes und hinzufügen zum Kommentar
		System.out.print("Text: ");
		text = in.nextLine();
		comment.setText(text);
		 
		// neuen Kommentar der Liste hinzufügen
		kommentarList.add(comment);
		
		// in XML Datei schreiben durch Marshaller
		schreiben(marshaller, rezepteseite);
		
		//Ausgabe nach Eingabe
		System.out.println();
		System.out.println("Eingabe erfolgreich. Zurück zum Hauptmenü");
		System.out.println();
		
		//Zurück zum Menü
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
		//Eingabevariablen
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
		 
		// Eingabe unterscheiden  
		switch(eingabe){
	      	case 1:
	      			int check;
	      			// Ausgabe der Rezepteliste
	      			rezepteAusgeben(rezeptList);
	      			
	      			// Auswahlmöglichkeit
		        	System.out.println();
	      			System.out.print("Rezeptauswahl: "); 
	      			check = in.nextInt();
	      			
	      			//Check ob Eingabe korrekt, wenn nicht wird zurück zum Menü geführt
	      			if((check <1) || (check) > rezeptList.size()){
	      				System.out.println();
		      			System.out.println("Ungültige Auswahl. Zurück zum Hauptmenü."); 
		      			System.out.println();
		      			menueAusgabe(rezeptList, marshaller, rezepteseite);
	      			}
	      			
	      			// Nach Auswahl Rezept, Inhalt ausgeben
	      			rezeptInhaltAusgeben(rezeptList.get( check-1 ));
	      			
	      			// Nach Inhaltsausgabe nächsten Schritt anbieten
	      			System.out.println();
	      			System.out.println("Nächster Schritt?"); 	      			
	      			System.out.println("0 - Rezeptkommentieren"); 
	      			System.out.println("1 - zurück zur Auswahl"); 
	      			System.out.println("2 - Programm beenden");
	      			System.out.println();
	      			
	      			System.out.print("Auswahl: ");
	      			weiter = in.nextInt(); 
	      			
	      			// Auswahl des nächsten Schrittes
	      			switch(weiter){
	      				case 0: 
	      						//Zuvor gesehenes Rezept kommentieren
	      						List<Kommentar> komment = (List<Kommentar>) rezeptList.get(check-1).getKommentare().getKommentar();
	      						kommentieren(komment, rezeptList, marshaller, rezepteseite);
	      						schreiben(marshaller, rezepteseite);
				
				   	        break;
				   	        
	      				case 1: 
	      						// Zurück zur Auswahl
	      						menueAusgabe(rezeptList, marshaller, rezepteseite); break;
	      				case 2: 
	      					break;
	      			
	      				default: 
	      					
	      				//Check ob Eingabe korrekt, wenn nicht wird zurück zum Menü geführt
	    	      			if((check <0) || (check) > 2){
	    	      				System.out.println();
	    		      			System.out.println("Ungültige Auswahl. Zurück zum Hauptmenü."); 
	    		      			System.out.println();
	    		      			menueAusgabe(rezeptList, marshaller, rezepteseite);
	    	      			}
	      					      				
	    	      			break;
	      			}
	      			
	          break;
	          
	          
	        case 2: // Im Hauptmenü Auswahl 2, Kommentieren starten
	    	        rezeptAuswahlKommentar(rezeptList, marshaller, rezepteseite);
	    	    break;
	        case 3: 
	        	break; 
	        
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
		int rnr, rnr2;
		
		// Rezeptauswahl, anschliessend kommentieren starten 
		// Menüaufbau
	    System.out.println();
		System.out.println("Geben sie die Rezeptnummer an"); 
		System.out.println("------------------------------");
		System.out.println("Rezeptnummer: ");
	    System.out.println("0 - Übersicht der Rezepte anzeigen");
	    rnr = in.nextInt();
	    
	    // Eingabe Rezeptnummer, check ob gültig
	    while(rnr<0 || rnr > rezeptList.size()){
				System.out.println();
				System.out.printf("Bitte geben sie eine gültige Rezeptnummer an: "); 
				rnr = in.nextInt();
	    }
	    
	  
	    switch(rnr){
	    	case 0: // Möglichkeit Liste anzuzeigen, anschließende Auswahl
	    			rezepteAusgeben(rezeptList);
	    			System.out.println();
	    			System.out.println("Rezeptnummer: ");
	    			rnr2 = in.nextInt();
				 
	    			while(rnr2<0 || rnr2-1 > rezeptList.size()){
	    				System.out.printf("Bitte gültige Rezeptnummer eingeben: ");	
	    				rnr2 = in.nextInt();
	    			}
	    
	    			// Bei gültiger Nummer kommentieren starten und Marshaller starten
	    			List<Kommentar> komment1 = (List<Kommentar>) rezeptList.get(rnr2-1).getKommentare().getKommentar();
			   	  	kommentieren(komment1, rezeptList, marshaller, rezepteseite);
			   	  	schreiben(marshaller, rezepteseite);

			   	 break;
		
	    	default:
	    			if((rnr-1> rezeptList.size()) || (rnr < 1)){
	    				System.out.printf("Keine gültige Angabe. Das Programm wird beendet.");	
	    				}
	    			
	    			// Kommentieren
	    			List<Kommentar> komment = (List<Kommentar>) rezeptList.get(rnr-1).getKommentare().getKommentar();
		   	  		kommentieren(komment, rezeptList, marshaller, rezepteseite);
		   	  		schreiben(marshaller, rezepteseite);
		   	  		break;
	    }
	}
	
	/**
	 * Funktion die neuen Daten zur XML hinzufügt
	 * @param marshaller
	 * @param rezepteseite
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public static void schreiben(Marshaller marshaller, Rezepteseite rezepteseite) throws JAXBException, FileNotFoundException{
		 marshaller.marshal(rezepteseite, new File("Aufgabe 3/Aufgabe3d.xml"));
	}
	
}


