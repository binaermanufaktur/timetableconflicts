package de.binaermanufaktur.timetableconflicts.controller.exceptions;

public class BookingConflictException extends Exception {
    public BookingConflictException(String conflict) {
        super(conflict);
    }
}
