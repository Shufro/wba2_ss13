//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.05 um 10:20:42 PM CEST 
//


package jaxb.objects;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute ref="{}zutatenname use="required""/>
 *       &lt;attribute ref="{}mengeneinheit use="required""/>
 *       &lt;attribute ref="{}anzahl use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Zutat")
public class Zutat {

    @XmlAttribute(name = "zutatenname", required = true)
    protected String zutatenname;
    @XmlAttribute(name = "mengeneinheit", required = true)
    protected String mengeneinheit;
    @XmlAttribute(name = "anzahl", required = true)
    protected BigDecimal anzahl;

    /**
     * Ruft den Wert der zutatenname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZutatenname() {
        return zutatenname;
    }

    /**
     * Legt den Wert der zutatenname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZutatenname(String value) {
        this.zutatenname = value;
    }

    /**
     * Ruft den Wert der mengeneinheit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMengeneinheit() {
        if (mengeneinheit == null) {
            return "";
        } else {
            return mengeneinheit;
        }
    }

    /**
     * Legt den Wert der mengeneinheit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMengeneinheit(String value) {
        this.mengeneinheit = value;
    }

    /**
     * Ruft den Wert der anzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnzahl() {
        return anzahl;
    }

    /**
     * Legt den Wert der anzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnzahl(BigDecimal value) {
        this.anzahl = value;
    }

}
