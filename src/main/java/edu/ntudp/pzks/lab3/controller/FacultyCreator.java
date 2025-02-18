package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Department;
import edu.ntudp.pzks.lab3.model.Faculty;
import edu.ntudp.pzks.lab3.model.Human;

import java.util.*;

public class FacultyCreator {
    private static final Random random = new Random();

    public static final Map<String, List<String>> faculties = Map.of(
            "Faculty of Information Technologies", Arrays.asList("Department of Software Engineering of Computer Systems", "Department of Information Technology and Computer Engineering", "Department of Systems Analysis and Management"),
            "Faculty of Finance and Economics", Arrays.asList("Department of Marketing"),
            "Faculty of Management", Arrays.asList("Department of Management"),
            "Faculty of Natural Sciences and Technologies", Arrays.asList("Department of Oil and Gas Engineering and Drilling")
    );

    private static Map.Entry<String, List<String>> getRandomFacultyName() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(faculties.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }

    public static Faculty createTypicalFaculty() {
        return createTypicalFaculty(getRandomFacultyName());
    }

    public static Faculty createTypicalFaculty(Map.Entry<String, List<String>> facultyData) {
        String facultyName = facultyData.getKey();
        List<String> departments = facultyData.getValue();
        Human head = HumanCreator.createTypicalHuman();
        Faculty faculty = new Faculty(facultyName, head);

        for (String departmentName : departments) {
            Map.Entry<String, List<String>> departmentData = DepartmentCreator.getDepartmentDataByName(departmentName);
            if (departmentData != null) {
                Department  department = DepartmentCreator.createTypicalDepartment(departmentData);
                faculty.addDepartment(department);
            }

        }
        return faculty;
    }

    public static Faculty createFaculty(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments);
    }

    public static Faculty createEmptyFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
