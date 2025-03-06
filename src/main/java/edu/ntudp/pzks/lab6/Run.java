package edu.ntudp.pzks.lab6;
import edu.ntudp.pzks.lab6.controller.StudentCreator;
import edu.ntudp.pzks.lab6.model.Student;
import edu.ntudp.pzks.lab6.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args){
        StudentRepository studentRepo = new StudentRepository();

        List<Student> allStudents = studentRepo.getAll();

        if(allStudents.isEmpty()) {
            List<Student> students = StudentCreator.createStudentsList(30);

            for (Student student : students) {
                studentRepo.save(student);
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = -1;

        while (month < 1 || month > 12) {
            System.out.print("Enter the month (1-12): ");
            if (scanner.hasNextInt()) {
                month = scanner.nextInt();

                if (month < 1 || month > 12) {
                    System.out.println("Invalid month! Please enter a month between 1 and 12.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 12.");
                scanner.next();
            }
        }

        List<Student> studentsByMonth = studentRepo.getByMonthOfBirthDate(month);
        for (Student student : studentsByMonth) {
            System.out.println(student);
        }
    }
}
