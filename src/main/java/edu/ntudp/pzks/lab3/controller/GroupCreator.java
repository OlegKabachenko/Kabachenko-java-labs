package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Group;
import edu.ntudp.pzks.lab3.model.Human;
import edu.ntudp.pzks.lab3.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupCreator{
    private static final Random random = new Random();

    private static String generateGroupName() {
        int facultyNumber = random.nextInt(293)+1;
        int admissionYear = random.nextInt(6) + 20;
        int groupNumber = random.nextInt(4)+1;

        return String.format("%d-%d-%d", facultyNumber, admissionYear, groupNumber);
    }

    public static Group createTypicalGroup() {
        return createTypicalGroup(generateGroupName());
    }

    public static Group createTypicalGroup(String groupName){
        int studentCount = random.nextInt(11) + 20;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            students.add(StudentCreator.createTypicalStudent());
        }

        Human head = HumanCreator.createTypicalHuman();

        return new Group(groupName, head, students);
    }

    public static Group createGroup(String name, Human head, List<Student> students) {
        return new Group(name, head, students);
    }

    public static Group createEmptyGroup(String name, Human head) {
        return new Group(name, head);
    }
}
