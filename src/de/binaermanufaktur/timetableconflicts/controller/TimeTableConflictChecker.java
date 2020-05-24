package de.binaermanufaktur.timetableconflicts.controller;

import de.binaermanufaktur.timetableconflicts.controller.exceptions.BookingConflictException;
import de.binaermanufaktur.timetableconflicts.controller.exceptions.CurricularConflictException;
import de.binaermanufaktur.timetableconflicts.controller.exceptions.RoomConflictException;
import de.binaermanufaktur.timetableconflicts.model.*;

import java.util.GregorianCalendar;
import java.util.List;

public class TimeTableConflictChecker {

    public void checkRoomConflicts(University university) throws RoomConflictException {
        String roomConflictMessage = "";

        Lectures lectures = university.getLectures();
        List<Lecture> lectureList = lectures.getLecture();

        for (int i = 0; i < lectureList.size(); i++) {
            Lecture lecture1 = lectureList.get(i);
            for (int j = i + 1; j < lectureList.size(); j++) {
                Lecture lecture2 = lectureList.get(j);
                try {
                    checkBookingConflicts(lecture1.getRoombookings().getBooking(), lecture2.getRoombookings().getBooking(), false);
                } catch (BookingConflictException e) {
                    String message = generateConflictMessage(lecture1, lecture2, e, "room");
                    roomConflictMessage = roomConflictMessage.concat(message);
                }

            }

        }
        if (!roomConflictMessage.isEmpty()) {
            throw new RoomConflictException(roomConflictMessage);
        }
    }

    public void checkCurricularConflicts(University university) throws CurricularConflictException {
        String curricularConflictMessage = "";

        List<Curriculum> curriculumList = university.getCurricula().getCurriculum();

        for (int i = 0; i < curriculumList.size(); i++) {
            Curriculum curriculum = curriculumList.get(i);
            List<Lecture> lecturesInCurriculum = curriculum.getLecture();
            for (int j = 0; j < lecturesInCurriculum.size(); j++) {
                Lecture lecture1 = lecturesInCurriculum.get(j);
                for (int k = j + 1; k < lecturesInCurriculum.size(); k++) {
                    Lecture lecture2 = lecturesInCurriculum.get(k);
                    try {
                        checkBookingConflicts(lecture1.getRoombookings().getBooking(), lecture2.getRoombookings().getBooking(), true);
                    } catch (BookingConflictException e) {
                        String message = generateConflictMessage(lecture1, lecture2, e, "curricular");
                        curricularConflictMessage = curricularConflictMessage.concat(message);
                    }
                }
            }
        }
        if (!curricularConflictMessage.isEmpty()) {
            throw new CurricularConflictException(curricularConflictMessage);
        }
    }


    private void checkBookingConflicts(List<Booking> roomBookingsLecture1, List<Booking> roomBookingsLecture2, boolean onlyTimes) throws BookingConflictException {

        for (int i = 0; i < roomBookingsLecture1.size(); i++) {
            Booking booking1 = roomBookingsLecture1.get(i);
            for (int j = 0; j < roomBookingsLecture2.size(); j++) {
                Booking booking2 = roomBookingsLecture2.get(j);

                if ((booking1.getRoom().equals(booking2.getRoom()) || onlyTimes)
                        && booking1.getWeekday().equals(booking2.getWeekday())
                        && bookingTimesCollide(booking1, booking2)
                ) {
                    String bookingConflictMessage = generateBookingConflictMessage(booking1, booking2, onlyTimes);
                    throw new BookingConflictException(bookingConflictMessage);
                }
            }
        }
    }

    private boolean bookingTimesCollide(Booking booking1, Booking booking2) {

        GregorianCalendar startTimeBooking1 = booking1.getStartTime().toGregorianCalendar();
        GregorianCalendar endTimeBooking1 = booking1.getEndTime().toGregorianCalendar();
        GregorianCalendar startTimeBooking2 = booking2.getStartTime().toGregorianCalendar();
        GregorianCalendar endTimeBooking2 = booking2.getEndTime().toGregorianCalendar();

        return (endTimeBooking2.compareTo(startTimeBooking1) > 0 && endTimeBooking1.compareTo(startTimeBooking2) > 0)
                || (endTimeBooking1.compareTo(startTimeBooking2) > 0 && endTimeBooking2.compareTo(startTimeBooking1) > 0);
    }

    private String generateBookingConflictMessage(Booking booking1, Booking booking2, boolean onlyTimes) {
        String conflict = "";
        if (!onlyTimes) {
            conflict = conflict.concat(booking1.getRoom()).concat(" - w");
        } else {
            conflict = conflict.concat("W");
        }
        conflict = conflict
                .concat("eekday: ").concat(booking1.getWeekday())
                .concat(" - time: ").concat(booking1.getStartTime().toString()).concat("-").concat(booking1.getEndTime().toString())
                .concat("\n");

        if (!onlyTimes) {
            conflict = conflict.concat(booking1.getRoom()).concat(" - w");
        } else {
            conflict = conflict.concat("W");
        }
        conflict = conflict
                .concat("eekday: ").concat(booking2.getWeekday())
                .concat(" - time: ").concat(booking2.getStartTime().toString()).concat("-").concat(booking2.getEndTime().toString()).concat("\n");
        return conflict;
    }


    private String generateConflictMessage(Lecture lecture1, Lecture lecture2, BookingConflictException e, String typeOfConflict) {
        return "Lectures "
                .concat(lecture1.getName())
                .concat(" and ")
                .concat(lecture2.getName())
                .concat(String.format(" have a %s conflict:", typeOfConflict)).concat("\n")
                .concat(e.getMessage());
    }
}
