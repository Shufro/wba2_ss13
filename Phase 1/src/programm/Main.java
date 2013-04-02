package programm;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



import JAXB.Objects.*;

public class Main {

	 private static final String Rezepte_XML = "/Phase 1/Aufgabe 3/Aufgabe3d.xml";

	  public static void main(String[] args) throws JAXBException, IOException {

	    ArrayList<Rezept> rezeptList = new ArrayList<Rezept>();
	  
	    // create rezepts
	    Rezept rezept1 = new Rezept();
	    rezept1.setRezeptname("978-0060554736");
	    rezept1.setKurzinfo("The Game");
	  

	    // create JAXB context and instantiate marshaller
	    JAXBContext context = JAXBContext.newInstance(Rezepteseite.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	 // get variables from our xml file, created before
	    System.out.println();
	    System.out.println("Output from our XML File: ");
	    Unmarshaller um = context.createUnmarshaller();
	    Rezepteseite rezepteseite = (Rezepteseite) um.unmarshal(new FileReader(Rezepte_XML));
	    List<Rezept> list = rezepteseite.getRezept();
	    for (Rezept rezept : list) {
	      System.out.println("Rezept: " + rezept.getRezeptname() );	
	  }
}}
