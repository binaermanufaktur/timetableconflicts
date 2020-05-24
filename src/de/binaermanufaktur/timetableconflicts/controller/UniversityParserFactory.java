package de.binaermanufaktur.timetableconflicts.controller;

import de.binaermanufaktur.timetableconflicts.controller.exceptions.InvalidTimeTableParserTypeException;

public class UniversityParserFactory {
    public UniversityParser create(String parserType) throws InvalidTimeTableParserTypeException {
        switch (parserType){
            case "XMLParser":
                return new UniversityXMLParser();
            default:
                throw new InvalidTimeTableParserTypeException(parserType);
        }

    }
}
