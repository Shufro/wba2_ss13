//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.02 um 06:48:48 PM CEST 
//


package JAXB.Objects;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Rezeptname"/>
 *         &lt;element ref="{}Kurzinfo" minOccurs="0"/>
 *         &lt;element ref="{}Bilder" minOccurs="0"/>
 *         &lt;element ref="{}Zutaten"/>
 *         &lt;element ref="{}Zubereitung"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}rezeptid use="required""/>
 *       &lt;attribute ref="{}kategorie use="required""/>
 *       &lt;attribute ref="{}url"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rezeptname",
    "kurzinfo",
    "bilder",
    "zutaten",
    "zubereitung"
})
@XmlRootElement(name = "Rezept")
public class Rezept {

    @XmlElement(name = "Rezeptname", required = true)
    protected String rezeptname;
    @XmlElement(name = "Kurzinfo")
    protected String kurzinfo;
    @XmlElement(name = "Bilder")
    protected Bilder bilder;
    @XmlElement(name = "Zutaten", required = true)
    protected Zutaten zutaten;
    @XmlElement(name = "Zubereitung", required = true)
    protected Zubereitung zubereitung;
    @XmlAttribute(name = "rezeptid", required = true)
    protected BigInteger rezeptid;
    @XmlAttribute(name = "kategorie", required = true)
    protected String kategorie;
    @XmlAttribute(name = "url")
    protected String url;

    /**
     * Ruft den Wert der rezeptname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRezeptname() {
        return rezeptname;
    }

    /**
     * Legt den Wert der rezeptname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRezeptname(String value) {
        this.rezeptname = value;
    }

    /**
     * Ruft den Wert der kurzinfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurzinfo() {
        return kurzinfo;
    }

    /**
     * Legt den Wert der kurzinfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurzinfo(String value) {
        this.kurzinfo = value;
    }

    /**
     * Ruft den Wert der bilder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Bilder }
     *     
     */
    public Bilder getBilder() {
        return bilder;
    }

    /**
     * Legt den Wert der bilder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Bilder }
     *     
     */
    public void setBilder(Bilder value) {
        this.bilder = value;
    }

    /**
     * Ruft den Wert der zutaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Zutaten }
     *     
     */
    public Zutaten getZutaten() {
        return zutaten;
    }

    /**
     * Legt den Wert der zutaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Zutaten }
     *     
     */
    public void setZutaten(Zutaten value) {
        this.zutaten = value;
    }

    /**
     * Ruft den Wert der zubereitung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Zubereitung }
     *     
     */
    public Zubereitung getZubereitung() {
        return zubereitung;
    }

    /**
     * Legt den Wert der zubereitung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Zubereitung }
     *     
     */
    public void setZubereitung(Zubereitung value) {
        this.zubereitung = value;
    }

    /**
     * Ruft den Wert der rezeptid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRezeptid() {
        return rezeptid;
    }

    /**
     * Legt den Wert der rezeptid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRezeptid(BigInteger value) {
        this.rezeptid = value;
    }

    /**
     * Ruft den Wert der kategorie-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKategorie() {
        return kategorie;
    }

    /**
     * Legt den Wert der kategorie-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKategorie(String value) {
        this.kategorie = value;
    }

    /**
     * Ruft den Wert der url-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Legt den Wert der url-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}
