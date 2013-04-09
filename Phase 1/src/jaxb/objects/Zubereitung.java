//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.09 um 12:29:11 PM CEST 
//


package jaxb.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}Arbeitszeit"/>
 *         &lt;element ref="{}Schwierigkeitsgrad"/>
 *         &lt;element ref="{}Brennwert"/>
 *         &lt;element ref="{}Ruhezeit" minOccurs="0"/>
 *         &lt;element ref="{}Koch-Backzeit" minOccurs="0"/>
 *         &lt;element ref="{}Beschreibung"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "arbeitszeit",
    "schwierigkeitsgrad",
    "brennwert",
    "ruhezeit",
    "kochBackzeit",
    "beschreibung"
})
@XmlRootElement(name = "Zubereitung")
public class Zubereitung {

    @XmlElement(name = "Arbeitszeit", required = true)
    protected Arbeitszeit arbeitszeit;
    @XmlElement(name = "Schwierigkeitsgrad", required = true)
    protected String schwierigkeitsgrad;
    @XmlElement(name = "Brennwert", required = true)
    protected Brennwert brennwert;
    @XmlElement(name = "Ruhezeit")
    protected Ruhezeit ruhezeit;
    @XmlElement(name = "Koch-Backzeit")
    protected KochBackzeit kochBackzeit;
    @XmlElement(name = "Beschreibung", required = true)
    protected String beschreibung;

    /**
     * Ruft den Wert der arbeitszeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Arbeitszeit }
     *     
     */
    public Arbeitszeit getArbeitszeit() {
        return arbeitszeit;
    }

    /**
     * Legt den Wert der arbeitszeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Arbeitszeit }
     *     
     */
    public void setArbeitszeit(Arbeitszeit value) {
        this.arbeitszeit = value;
    }

    /**
     * Ruft den Wert der schwierigkeitsgrad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    /**
     * Legt den Wert der schwierigkeitsgrad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchwierigkeitsgrad(String value) {
        this.schwierigkeitsgrad = value;
    }

    /**
     * Ruft den Wert der brennwert-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Brennwert }
     *     
     */
    public Brennwert getBrennwert() {
        return brennwert;
    }

    /**
     * Legt den Wert der brennwert-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Brennwert }
     *     
     */
    public void setBrennwert(Brennwert value) {
        this.brennwert = value;
    }

    /**
     * Ruft den Wert der ruhezeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ruhezeit }
     *     
     */
    public Ruhezeit getRuhezeit() {
        return ruhezeit;
    }

    /**
     * Legt den Wert der ruhezeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ruhezeit }
     *     
     */
    public void setRuhezeit(Ruhezeit value) {
        this.ruhezeit = value;
    }

    /**
     * Ruft den Wert der kochBackzeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KochBackzeit }
     *     
     */
    public KochBackzeit getKochBackzeit() {
        return kochBackzeit;
    }

    /**
     * Legt den Wert der kochBackzeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KochBackzeit }
     *     
     */
    public void setKochBackzeit(KochBackzeit value) {
        this.kochBackzeit = value;
    }

    /**
     * Ruft den Wert der beschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Legt den Wert der beschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeschreibung(String value) {
        this.beschreibung = value;
    }

}
