package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Student;
import edu.ntudp.pzks.lab4.model.Sex;

public class StudentCreator extends PersonCreator {
    public Student createTypicalStudent() {
        String[] names = generateRandomFullName();
        Sex gender = getRandomGender();
        String recordBookID = String.format("%06d", random.nextInt(1000000));

        return new Student (names[0], names[1], names[2], gender,recordBookID);
    }

    public Student createStudent(String firstName, String middleName, String lastName, Sex gender, String recordBookID) {
        return new Student (firstName, middleName, lastName, gender, recordBookID);
    }
}
