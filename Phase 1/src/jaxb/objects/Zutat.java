//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.03 um 02:44:52 PM CEST 
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
 *         &lt;element ref="{}Zutatname"/>
 *         &lt;element ref="{}Menge"/>
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
    "zutatname",
    "menge"
})
@XmlRootElement(name = "Zutat")
public class Zutat {

    @XmlElement(name = "Zutatname", required = true)
    protected String zutatname;
    @XmlElement(name = "Menge", required = true)
    protected Menge menge;

    /**
     * Ruft den Wert der zutatname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZutatname() {
        return zutatname;
    }

    /**
     * Legt den Wert der zutatname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZutatname(String value) {
        this.zutatname = value;
    }

    /**
     * Ruft den Wert der menge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Menge }
     *     
     */
    public Menge getMenge() {
        return menge;
    }

    /**
     * Legt den Wert der menge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Menge }
     *     
     */
    public void setMenge(Menge value) {
        this.menge = value;
    }

}
