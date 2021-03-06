//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.09 um 12:29:11 PM CEST 
//


package jaxb.objects;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.objects package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Text_QNAME = new QName("", "Text");
    private final static QName _Rezeptname_QNAME = new QName("", "Rezeptname");
    private final static QName _Beschreibung_QNAME = new QName("", "Beschreibung");
    private final static QName _Kurzinfo_QNAME = new QName("", "Kurzinfo");
    private final static QName _Username_QNAME = new QName("", "Username");
    private final static QName _Schwierigkeitsgrad_QNAME = new QName("", "Schwierigkeitsgrad");
    private final static QName _Zeitpunkt_QNAME = new QName("", "Zeitpunkt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.objects
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Kommentar }
     * 
     */
    public Kommentar createKommentar() {
        return new Kommentar();
    }

    /**
     * Create an instance of {@link Arbeitszeit }
     * 
     */
    public Arbeitszeit createArbeitszeit() {
        return new Arbeitszeit();
    }

    /**
     * Create an instance of {@link Zutat }
     * 
     */
    public Zutat createZutat() {
        return new Zutat();
    }

    /**
     * Create an instance of {@link Zubereitung }
     * 
     */
    public Zubereitung createZubereitung() {
        return new Zubereitung();
    }

    /**
     * Create an instance of {@link Brennwert }
     * 
     */
    public Brennwert createBrennwert() {
        return new Brennwert();
    }

    /**
     * Create an instance of {@link Ruhezeit }
     * 
     */
    public Ruhezeit createRuhezeit() {
        return new Ruhezeit();
    }

    /**
     * Create an instance of {@link KochBackzeit }
     * 
     */
    public KochBackzeit createKochBackzeit() {
        return new KochBackzeit();
    }

    /**
     * Create an instance of {@link Bild }
     * 
     */
    public Bild createBild() {
        return new Bild();
    }

    /**
     * Create an instance of {@link Zutaten }
     * 
     */
    public Zutaten createZutaten() {
        return new Zutaten();
    }

    /**
     * Create an instance of {@link Bilder }
     * 
     */
    public Bilder createBilder() {
        return new Bilder();
    }

    /**
     * Create an instance of {@link Rezept }
     * 
     */
    public Rezept createRezept() {
        return new Rezept();
    }

    /**
     * Create an instance of {@link Kommentare }
     * 
     */
    public Kommentare createKommentare() {
        return new Kommentare();
    }

    /**
     * Create an instance of {@link Rezepteseite }
     * 
     */
    public Rezepteseite createRezepteseite() {
        return new Rezepteseite();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Rezeptname")
    public JAXBElement<String> createRezeptname(String value) {
        return new JAXBElement<String>(_Rezeptname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Beschreibung")
    public JAXBElement<String> createBeschreibung(String value) {
        return new JAXBElement<String>(_Beschreibung_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kurzinfo")
    public JAXBElement<String> createKurzinfo(String value) {
        return new JAXBElement<String>(_Kurzinfo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Schwierigkeitsgrad")
    public JAXBElement<String> createSchwierigkeitsgrad(String value) {
        return new JAXBElement<String>(_Schwierigkeitsgrad_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Zeitpunkt")
    public JAXBElement<XMLGregorianCalendar> createZeitpunkt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Zeitpunkt_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
