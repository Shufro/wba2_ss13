//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.09 um 12:29:11 PM CEST 
//


package jaxb.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute ref="{}zeiteinheit use="required""/>
 *       &lt;attribute ref="{}dauer use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Koch-Backzeit")
public class KochBackzeit {

    @XmlAttribute(name = "zeiteinheit", required = true)
    protected String zeiteinheit;
    @XmlAttribute(name = "dauer", required = true)
    protected int dauer;

    /**
     * Ruft den Wert der zeiteinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZeiteinheit() {
        return zeiteinheit;
    }

    /**
     * Legt den Wert der zeiteinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZeiteinheit(String value) {
        this.zeiteinheit = value;
    }

    /**
     * Ruft den Wert der dauer-Eigenschaft ab.
     * 
     */
    public int getDauer() {
        return dauer;
    }

    /**
     * Legt den Wert der dauer-Eigenschaft fest.
     * 
     */
    public void setDauer(int value) {
        this.dauer = value;
    }

}
