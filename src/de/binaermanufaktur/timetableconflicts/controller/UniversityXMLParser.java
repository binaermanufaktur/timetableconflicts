package de.binaermanufaktur.timetableconflicts.controller;

import de.binaermanufaktur.timetableconflicts.model.University;

import javax.xml.bind.*;
import java.io.File;

public class UniversityXMLParser implements UniversityParser {
    private File source;
    private University university;
    @Override
    public University parse(String filename) {
        this.source = new File(filename);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            this.university = (University) JAXBIntrospector.getValue(unmarshaller.unmarshal(this.source));
        } catch (JAXBException exception){
            exception.printStackTrace();
        }
        return this.university;
    }
}
