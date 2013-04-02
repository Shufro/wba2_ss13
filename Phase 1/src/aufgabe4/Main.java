package aufgabe4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jaxb.objects.*;

public class Main {

  private static final String Rezeptesammlung_XML = "./rezeptesammlung.xml";

  public static void main(String[] args) throws JAXBException, IOException {

    ArrayList<Rezept> rezeptList = new ArrayList<Rezept>();

 

    // create JAXB context and instantiate marshaller
    JAXBContext context = JAXBContext.newInstance(Rezepteseite.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

   
    // get variables from our xml file, created before
    System.out.println();
    System.out.println("Output from our XML File: ");
   
    }
  }
