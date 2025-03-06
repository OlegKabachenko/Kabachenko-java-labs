package edu.ntudp.pzks.lab6.model;

import java.sql.Date;
import java.util.Objects;

public class Student extends Human {
    private String recordBookNumber;
    private final int RECORD_BOOK_NUM_LENGTH = 8;

    public Student() {
    }

    public Student(String firstName, String middleName, String lastName,  String recordBookNumber, Date birthDate) {
        super(firstName, middleName, lastName, birthDate);
        setRecordBookNumber(recordBookNumber);
    }

    @Override
    public boolean isFilled() {
        return super.isFilled() && recordBookNumber != null;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        if (recordBookNumber.length() == RECORD_BOOK_NUM_LENGTH){
            this.recordBookNumber = recordBookNumber;
        }
        else {
            throw new IllegalArgumentException("Error: The record book number must be exactly " + RECORD_BOOK_NUM_LENGTH + " characters long.");
        }
    }

    public int getRECORD_BOOK_NUM_LENGTH() {
        return RECORD_BOOK_NUM_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordBookNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", recordBookNumber='" + recordBookNumber + '\'' +
                '}';
    }
}

