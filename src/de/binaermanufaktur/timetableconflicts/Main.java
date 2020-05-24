package de.binaermanufaktur.timetableconflicts;

import de.binaermanufaktur.timetableconflicts.controller.*;
import de.binaermanufaktur.timetableconflicts.controller.exceptions.CurricularConflictException;
import de.binaermanufaktur.timetableconflicts.controller.exceptions.InvalidTimeTableParserTypeException;
import de.binaermanufaktur.timetableconflicts.controller.exceptions.RoomConflictException;
import de.binaermanufaktur.timetableconflicts.model.University;

public class Main {

    public static void main(String[] args) {

        try {

            UniversityParserFactory universityParserFactory = new UniversityParserFactory();
            UniversityParser universityParser = universityParserFactory.create("XMLParser");
            University university = universityParser.parse("src/de/binaermanufaktur/timetableconflicts/assets/timetable.xml");

            TimeTableConflictChecker timeTableConflictChecker = new TimeTableConflictChecker();

            try {
                timeTableConflictChecker.checkRoomConflicts(university);
            }catch (RoomConflictException e) {
                System.out.println(e.getMessage());
            }

            try {
                timeTableConflictChecker.checkCurricularConflicts(university);
            }catch (CurricularConflictException e){
                System.out.println(e.getMessage());
            }


        } catch (InvalidTimeTableParserTypeException e) {
            e.printStackTrace();
        }

    }
}
