package edu.ntudp.pzks.lab6.controller;

import edu.ntudp.pzks.lab6.model.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentCreator extends HumanCreator  {

    public static String generateRandomRecordBookNumber(){
        StringBuilder recordBookNumber = new StringBuilder("S");

        for (int i = 0; i < 7; i++) {
            int digit = random.nextInt(10);
            recordBookNumber.append(digit);
        }

        return recordBookNumber.toString();
    }

    public static List<Student> createStudentsList(int studentsNum){
        List<Student> students = new ArrayList<>();
        Set<String> usedRecordBookNumbers = new HashSet<>();

        for (int i = 0; i < studentsNum; i++) {
            Student student = createTypicalStudent();
            String recordBookNumber = student.getRecordBookNumber();

            while (usedRecordBookNumbers.contains(recordBookNumber)) {
                recordBookNumber = generateRandomRecordBookNumber();
                student.setRecordBookNumber(recordBookNumber);
            }

            usedRecordBookNumbers.add(recordBookNumber);
            students.add(student);
        }

        return students;
    }

    public static Student createTypicalStudent() {
        String[] names = generateRandomFullName();
        String recordBookNumber = generateRandomRecordBookNumber();
        Date birthDate = createValidBirthDate();

        return new Student(names[0], names[1], names[2], recordBookNumber, birthDate);
    }

    public static Student createStudent(String firstName, String middleName, String lastName, String recordBookNumber, Date birthDate) {
        return new Student (firstName, middleName, lastName, recordBookNumber, birthDate);
    }
}
