package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Group;
import edu.ntudp.pzks.lab4.model.Human;
import edu.ntudp.pzks.lab4.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupCreator{
    private final Random random = new Random();

    private String generateGroupName() {
        int facultyNumber = random.nextInt(293)+1;
        int admissionYear = random.nextInt(6) + 20;
        int groupNumber = random.nextInt(4)+1;

        return String.format("%d-%d-%d", facultyNumber, admissionYear, groupNumber);
    }

    public Group createTypicalGroup() {
        return createTypicalGroup(generateGroupName());
    }

    public Group createTypicalGroup(String groupName) {
        return createTypicalGroup(groupName, random.nextInt(11) + 20);
    }

    public Group createTypicalGroup(int studentsInGroup) {
        return createTypicalGroup(generateGroupName(), studentsInGroup);
    }

    public Group createTypicalGroup(String groupName, int studentCount){
        List<Student> students = new ArrayList<>();
        StudentCreator studentCreator = new StudentCreator();
        HumanCreator humanCreator = new HumanCreator();

        for (int i = 0; i < studentCount; i++) {
            students.add(studentCreator.createTypicalStudent());
        }

        Human head = humanCreator.createTypicalHuman();

        return new Group(groupName, head, students);
    }

    public Group createGroup(String name, Human head, List<Student> students) {
        return new Group(name, head, students);
    }

    public Group createEmptyGroup(String name, Human head) {
        return new Group(name, head);
    }
}
