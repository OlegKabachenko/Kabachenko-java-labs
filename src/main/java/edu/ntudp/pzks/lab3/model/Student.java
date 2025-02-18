package edu.ntudp.pzks.lab3.model;

import java.util.Objects;

public class Student extends Human {
    private final String recordBookID;

    public Student(String firstName, String middleName, String lastName, Sex gender, String recordBookID) {
        super(firstName, lastName, middleName, gender);
        this.recordBookID = recordBookID;
    }

    public String getStudentID() {
        return recordBookID;
    }

    public String getRecordBookID() {
        return recordBookID;
    }

    @Override
    public String toString() {
        return super.toString() + " - Student, record book id: " + recordBookID;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student that = (Student) o;
        return  Objects.equals(recordBookID, that.recordBookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordBookID);
    }
}
