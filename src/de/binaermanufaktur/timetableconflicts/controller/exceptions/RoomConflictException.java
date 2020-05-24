package de.binaermanufaktur.timetableconflicts.controller.exceptions;

public class RoomConflictException extends Exception {
    public RoomConflictException(String conflict){ super(conflict);}
}
