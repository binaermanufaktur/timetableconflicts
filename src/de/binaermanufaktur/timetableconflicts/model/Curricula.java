
package de.binaermanufaktur.timetableconflicts.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for curricula complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="curricula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="curriculum" type="{}curriculum" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "curricula", propOrder = {
    "curriculum"
})
public class Curricula {

    @XmlElement(required = true)
    protected List<Curriculum> curriculum;

    /**
     * Gets the value of the curriculum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the curriculum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurriculum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Curriculum }
     * 
     * 
     */
    public List<Curriculum> getCurriculum() {
        if (curriculum == null) {
            curriculum = new ArrayList<Curriculum>();
        }
        return this.curriculum;
    }

}
