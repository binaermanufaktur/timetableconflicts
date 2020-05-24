
package de.binaermanufaktur.timetableconflicts.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for university complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="university">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lectures" type="{}lectures"/>
 *         &lt;element name="curricula" type="{}curricula"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "university", propOrder = {
    "lectures",
    "curricula"
})
public class University {

    @XmlElement(required = true)
    protected Lectures lectures;
    @XmlElement(required = true)
    protected Curricula curricula;

    /**
     * Gets the value of the lectures property.
     * 
     * @return
     *     possible object is
     *     {@link Lectures }
     *     
     */
    public Lectures getLectures() {
        return lectures;
    }

    /**
     * Sets the value of the lectures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lectures }
     *     
     */
    public void setLectures(Lectures value) {
        this.lectures = value;
    }

    /**
     * Gets the value of the curricula property.
     * 
     * @return
     *     possible object is
     *     {@link Curricula }
     *     
     */
    public Curricula getCurricula() {
        return curricula;
    }

    /**
     * Sets the value of the curricula property.
     * 
     * @param value
     *     allowed object is
     *     {@link Curricula }
     *     
     */
    public void setCurricula(Curricula value) {
        this.curricula = value;
    }

}
