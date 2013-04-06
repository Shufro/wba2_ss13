package aufgabe4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.*;

import jaxb.objects.*;

public class Main {


  public static void main(String[] args) throws JAXBException, IOException {
	   File xmlDocument = new File("rezepteseite.xml"); 
	   Main jaxbUnmarshaller = new Main(); 
	   jaxbUnmarshaller.unMarshaller(xmlDocument);
  } 

 
 @SuppressWarnings("deprecation")
public void unMarshaller(File xmlDocument) throws FileNotFoundException{
		 try{
			 // JAXB Context Object erstellen
			 JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.objects");
    
			 //Unmarshaller erstellen  
			 Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			 
			 // Validierung wird gesetzt
			 unMarshaller.setValidating(false);

			 // ein XML Dokument wird als Object des Typs "Rezeptseite" erstellt
			 Rezepteseite rezepteseite = (Rezepteseite) unMarshaller.unmarshal(new FileInputStream("Aufgabe3d.xml"));
    
    
			 // Ausgabe der Werte des XML Dokuments
			 List<Rezept> rezeptList = rezepteseite.getRezept();
			
			 for (int rezeptcount = 0; rezeptcount < rezeptList.size(); rezeptcount++) {
				 Rezept rezept = (Rezept) rezeptList.get(rezeptcount);
				 //Attribute ausgeben
				 System.out.println("Rezeptid: " + rezept.getRezeptid()); 
				 System.out.println("Kategorie: " + rezept.getKategorie()); 
				 System.out.println("URL: " + rezept.getUrl()); 
				 
				 //Elemente ausgeben
				 System.out.println("Rezeptname: " + rezept.getRezeptname()); 
				 System.out.println("Kurzinfo: " + rezept.getKurzinfo()); 
				 
				 // Bilderliste TODO Check ob leer
				 System.out.println("Bilder"); 
				 List<Bild> bilderList = rezept.getBilder().getBild(); 
				 for (int bildercount = 0; bildercount < bilderList.size(); bildercount++) {
					 Bild bild = (Bild) bilderList.get(bildercount);
					 //Ausgabe
					 System.out.println("Bildsrc: " + bild.getSrc());  //wie ist die "Slideshow beschreibbar"?
					 System.out.println("Bildbeschreibung: " + bild.getBildbeschreibung());  
				 }
				 
				 
				 // Zutatenliste
				 System.out.println("Zutaten "); 
				 System.out.println("Portionen: " + rezept.getZutaten().getPortionen()); 
				 List<Zutatengruppe> zgList = rezept.getZutaten().getZutatengruppe(); 
				 
				 //Zutatengruppe
				 for (int zgcount = 0; zgcount < zgList.size(); zgcount++) {
					 Zutatengruppe gruppe = (Zutatengruppe) zgList.get(zgcount);
					 //Ausgabe
					 System.out.println("Zutatengruppe: " + gruppe.getGruppenname() );
					
					 //Zutaten in Gruppe
					 List<Zutat> zList =  rezept.getZutaten().getZutatengruppe().getZutat();
					 for (int zcount = 0; zcount < zList.size(); zcount++) {
						 Zutat zutat = (Zutat) zList.get(zcount);
						 //Ausgabe
						 System.out.println("Zutatenname: " + zutat.getZutatenname()); 
						 System.out.println("Anzahl: " + zutat.getAnzahl()); 
						 System.out.println("Mengeneinheit: " + zutat.getMengeneinheit()); 
					 } 
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

				 // Ausgabe zusŠtzlicher Angaben TODO Check ob leer
				 System.out.println("Ruhezeit"); 
				 System.out.println("Dauer: " + rezept.getZubereitung().getRuhezeit().getDauer());
				 System.out.println("Zeiteinheit: " + rezept.getZubereitung().getRuhezeit().getZeiteinheit()); 
				 
				 System.out.println("Koch/Backzeit"); 
				 System.out.println("Dauer: " + rezept.getZubereitung().getKochBackzeit().getDauer());
				 System.out.println("Zeiteinheit: " + rezept.getZubereitung().getKochBackzeit().getZeiteinheit()); 
						 
				 
				 System.out.println("Beschreibung: " + rezept.getZubereitung().getBeschreibung()); 
				 
					 
				 
				 
			 }
		 } catch (JAXBException e) { System.out.println(e.toString());
}
			
	
   
}}