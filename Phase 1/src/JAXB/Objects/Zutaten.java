//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.02 um 06:48:48 PM CEST 
//


package JAXB.Objects;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}Zutatengruppe" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}portionen use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zutatengruppe"
})
@XmlRootElement(name = "Zutaten")
public class Zutaten {

    @XmlElement(name = "Zutatengruppe", required = true)
    protected List<Zutatengruppe> zutatengruppe;
    @XmlAttribute(name = "portionen", required = true)
    protected int portionen;

    /**
     * Gets the value of the zutatengruppe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zutatengruppe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZutatengruppe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zutatengruppe }
     * 
     * 
     */
    public List<Zutatengruppe> getZutatengruppe() {
        if (zutatengruppe == null) {
            zutatengruppe = new ArrayList<Zutatengruppe>();
        }
        return this.zutatengruppe;
    }

    /**
     * Ruft den Wert der portionen-Eigenschaft ab.
     * 
     */
    public int getPortionen() {
        return portionen;
    }

    /**
     * Legt den Wert der portionen-Eigenschaft fest.
     * 
     */
    public void setPortionen(int value) {
        this.portionen = value;
    }

}
