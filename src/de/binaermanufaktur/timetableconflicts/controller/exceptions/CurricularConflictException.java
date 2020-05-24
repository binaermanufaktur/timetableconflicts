package de.binaermanufaktur.timetableconflicts.controller.exceptions;

public class CurricularConflictException extends Throwable {
    public CurricularConflictException(String curriculumConflictMessage) {
        super(curriculumConflictMessage);
    }
}
