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
 *       &lt;attribute ref="{}brennwerteinheit use="required""/>
 *       &lt;attribute ref="{}brennwertmenge use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Brennwert")
public class Brennwert {

    @XmlAttribute(name = "brennwerteinheit", required = true)
    protected String brennwerteinheit;
    @XmlAttribute(name = "brennwertmenge", required = true)
    protected String brennwertmenge;

    /**
     * Ruft den Wert der brennwerteinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrennwerteinheit() {
        if (brennwerteinheit == null) {
            return "kcal";
        } else {
            return brennwerteinheit;
        }
    }

    /**
     * Legt den Wert der brennwerteinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrennwerteinheit(String value) {
        this.brennwerteinheit = value;
    }

    /**
     * Ruft den Wert der brennwertmenge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrennwertmenge() {
        if (brennwertmenge == null) {
            return "keine Angabe";
        } else {
            return brennwertmenge;
        }
    }

    /**
     * Legt den Wert der brennwertmenge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrennwertmenge(String value) {
        this.brennwertmenge = value;
    }

}
