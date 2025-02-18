package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Department;
import edu.ntudp.pzks.lab3.model.Faculty;
import edu.ntudp.pzks.lab3.model.Human;

import java.util.*;

public class FacultyCreator {
    private static final Random random = new Random();

    public static final Map<String, List<String>> faculties = Map.of(
            "Faculty of Information Technologies", Arrays.asList("Department of Software Engineering of Computer Systems", "Department of Information Technology and Computer Engineering", "Department of Systems Analysis and Management"),
            "Faculty of Management", Arrays.asList("Department of Management", "Department of Applied Economics, Entrepreneurship, and Public Administration"),
            "Faculty of Natural Sciences and Technologies", Arrays.asList("Department of Oil and Gas Engineering and Drilling", "Department of Chemistry and Chemical Engineering")
    );

    private static Map.Entry<String, List<String>> getRandomFacultyName() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(faculties.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }

    public static Faculty createTypicalFaculty() {
        return createTypicalFaculty(getRandomFacultyName());
    }

    public static Faculty createTypicalFaculty(Map.Entry<String, List<String>> facultyData) {
        return createTypicalFaculty(facultyData, random.nextInt(3)+1, false);
    }

    public static Faculty createTypicalFaculty(int departmentsCount, boolean iscascadeSubdivisions) {
        return createTypicalFaculty(getRandomFacultyName(), departmentsCount, iscascadeSubdivisions);
    }

    public static Faculty createTypicalFaculty(Map.Entry<String, List<String>> facultyData, int departmentsCount, boolean iscascadeSubdivisions) {
        String facultyName = facultyData.getKey();
        List<String> departments = facultyData.getValue();
        Human head = HumanCreator.createTypicalHuman();
        Faculty faculty = new Faculty(facultyName, head);

        departmentsCount = Math.min(departments.size(), departmentsCount);

        Collections.shuffle(departments);
        for (int i = 0; i < departmentsCount; i++) {
            String departmentName = departments.get(i);

            Map.Entry<String, List<String>> departmentData = DepartmentCreator.getDepartmentDataByName(departmentName);
            if (departmentData != null) {
                Department  department = DepartmentCreator.createTypicalDepartment(departmentData);

                if (iscascadeSubdivisions) {
                    department = DepartmentCreator.createTypicalDepartment(departmentData, departmentsCount, iscascadeSubdivisions);
                }
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
