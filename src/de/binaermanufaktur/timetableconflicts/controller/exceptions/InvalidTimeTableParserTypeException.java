package de.binaermanufaktur.timetableconflicts.controller.exceptions;

public class InvalidTimeTableParserTypeException extends Throwable {
    public InvalidTimeTableParserTypeException(String parserType) {
        super("Not a known parser type: "+parserType);
    }
}
