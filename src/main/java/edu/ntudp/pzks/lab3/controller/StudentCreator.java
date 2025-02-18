package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Student;

public class StudentCreator extends PersonCreator {
    public static Student createTypicalStudent() {
        String[] names = generateRandomFullName();
        Student.Sex gender = getRandomGender();
        String recordBookID = String.format("%06d", random.nextInt(1000000));

        return new Student (names[0], names[1], names[2], gender,recordBookID);
    }

    public static Student createStudent(String firstName, String middleName, String lastName, Student.Sex gender, String recordBookID) {
        return new Student (firstName, middleName, lastName, gender, recordBookID);
    }
}
